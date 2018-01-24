package sv.gob.mh.sitep.common;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.ManyToOne;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import lombok.Setter;
import lombok.Getter;

@Setter
@Getter
public class JqgridNativeTag extends SimpleTagSupport {

    private String urlgrid;
    private String caption;
    private String entity;
    private String urlexport;

    private String createField(Field field, Integer separator) {

        ResourceBundle bundle = ResourceBundle.getBundle(getEntity());
        StringBuilder fieldBuilder = new StringBuilder();
        String type = field.getType().getName().toString();
        String bfield = getEntity() + "." + field.getName();
        bfield = bfield.replace(field.getClass().getName(), "");

        if (type.equals("java.lang.Integer") || type.equals("java.lang.Float") || type.equals("java.lang.Long") || type.equals("java.lang.String") || type.equals("java.math.BigDecimal")) {
            if (separator == 1) {
                fieldBuilder.append("                                   ");
            } else {
                fieldBuilder.append("                                   ,");
            }

            fieldBuilder.append("{ label: '" + bundle.getString(getEntity() + "." + field.getName()).replaceAll("\"", "") + "', name: '" + field.getName() + "', width: 50 ,align:'center'}\n");
        } else if (type.equals("java.lang.Calendar") || type.equals("java.util.Date")) {
            if (separator == 1) {
                fieldBuilder.append("                                   ");
            } else {
                fieldBuilder.append("                                   ,");
            }

            fieldBuilder.append("{ label: '" + bundle.getString(getEntity() + "." + field.getName()).replaceAll("\"", "") + "', name: '" + field.getName() + "', width: 50 ,align:'center', searchoptions: {\n");
            fieldBuilder.append("                                           dataInit: function (el) {\n");
            fieldBuilder.append("                                               $(el).keydown(function (e) {\n");
            fieldBuilder.append("                                                   if ($(this).val() == \"__/__/____\") {\n");
            fieldBuilder.append("                                                       $(this).val(\"\");\n");
            fieldBuilder.append("                                                   }\n");
            fieldBuilder.append("                                               });\n");
            fieldBuilder.append("                                               $(el).mask(\"99/99/9999\");\n");
            fieldBuilder.append("                                               $(el).datepicker({dateFormat: 'dd/mm/yy',\n");
            fieldBuilder.append("                                                   onSelect: function (dateText, inst) {\n");
            fieldBuilder.append("                                                       ").append("jqGrid").append(entity).append("[0].triggerToolbar();\n");
            fieldBuilder.append("                                                   },\n");
            fieldBuilder.append("                                                   beforeShow: function (input, inst) {\n");
            fieldBuilder.append("                                                       setTimeout(function () {$(\".ui-datepicker\").css(\"z-index\", 2000);}, 10);\n");
            fieldBuilder.append("                                                   }\n");
            fieldBuilder.append("                                               });\n");
            fieldBuilder.append("                                           }\n");
            fieldBuilder.append("                                       }\n");
            fieldBuilder.append("                                   }\n");
        }

        return fieldBuilder.toString();
    }

    @Override
    public void doTag() throws JspException, IOException {
        PageContext pageContext = (PageContext) getJspContext();
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        ResourceBundle bundleApp = ResourceBundle.getBundle("application");
        StringBuilder scriptBuilder = new StringBuilder();
        StringBuilder colModelBuilder = new StringBuilder();
        try {

            Class<?> cls = Class.forName("sv.gob.mh.sitep.dto." + getEntity());
            String pkg = cls.getPackage().getName();
            Field[] fields = cls.getDeclaredFields();

            scriptBuilder.append("<script type=\"text/javascript\">\n");
            scriptBuilder.append("             (function(window, document, $, undefined){\n");
            scriptBuilder.append("                 $(function(){\n");
            scriptBuilder.append("                     var ").append("jqGrid").append(entity).append(" = $(\"#jqGrid").append(entity).append("\");\n");
            scriptBuilder.append("                     \n");

           

            scriptBuilder.append("                    ").append("jqGrid").append(entity).append(".jqGrid({\n");
            scriptBuilder.append("                         url: '").append(getUrlgrid()).append("',\n");
            scriptBuilder.append("                         datatype: \"json\",\n");
            scriptBuilder.append("                         colModel:[ \n");

            for (int i = 0; i < fields.length; i++) {
                colModelBuilder.append(createField(fields[i], i));
            }

            scriptBuilder.append(colModelBuilder.toString().substring(0, colModelBuilder.toString().length() - 1));
            scriptBuilder.append("                         ],\n");
            scriptBuilder.append("                         viewrecords: true,\n");
            scriptBuilder.append("                         autowidth: true,\n");
            scriptBuilder.append("                         shrinkToFit: true,\n");
            scriptBuilder.append("                         height: ").append(bundleApp.getString("jqgrid.height")).append(",\n");
            scriptBuilder.append("                         rowNum: ").append(bundleApp.getString("jqgrid.rownum")).append(",\n");
            scriptBuilder.append("                         rowList: ").append(bundleApp.getString("jqgrid.rowlist")).append(",\n");
            scriptBuilder.append("                         loadonce: false,\n");
            scriptBuilder.append("                         caption: \"").append(getCaption()).append("\",\n");
            scriptBuilder.append("                         hidegrid: false,\n");
            scriptBuilder.append("                         pager: \"#").append("jqGrid").append(entity).append("Pager\"\n");
            scriptBuilder.append("                    });\n");
            scriptBuilder.append("                     \n");

            scriptBuilder.append("                    ").append("jqGrid").append(entity).append(".jqGrid('filterToolbar', {stringResult: true, searchOnEnter: true, defaultSearch: \"cn\"});\n");
            scriptBuilder.append("                     \n");

            scriptBuilder.append("                     ").append("jqGrid").append(entity).append(".jqGrid('navGrid', '#").append("jqGrid").append(entity).append("Pager',\n");
            scriptBuilder.append("                         {edit: false, add: false, del: false, search: false},\n");
            scriptBuilder.append("                          {}, {}, {},\n");
            scriptBuilder.append("                          {// search\n");
            scriptBuilder.append("                              closeOnEscape: true,\n");
            scriptBuilder.append("                              multipleSearch: true,\n");
            scriptBuilder.append("                              closeAfterSearch: true\n");
            scriptBuilder.append("                      })\n");
            scriptBuilder.append("                     \n");

           

            if (urlexport != null) {
                scriptBuilder.append("                     ").append("jqGrid").append(entity).append(".jqGrid('navButtonAdd', '#").append("jqGrid").append(entity).append("Pager', {\n");
                scriptBuilder.append("                         id: 'pager_excel',\n");
                scriptBuilder.append("                         caption: '',\n");
                scriptBuilder.append("                         title: 'Export',\n");
                scriptBuilder.append("                         onClickButton: function (e) {\n");
                scriptBuilder.append("                              export").append(entity).append("Grid();\n");
                scriptBuilder.append("                         },\n");
                scriptBuilder.append("                         buttonicon: 'ui-icon-calculator'\n");
                scriptBuilder.append("                     });\n");
                scriptBuilder.append("                     \n");

                scriptBuilder.append("                     ").append(" function export").append(entity).append("Grid() \n{");
                scriptBuilder.append("                     ").append("     $('#filters').val(jqGrid").append(entity).append(".jqGrid('getGridParam', 'postData').filters);\n");
                scriptBuilder.append("                     ").append("     $('#jqGrid").append(entity).append("GridParameters').submit();\n");
                scriptBuilder.append("                                 }\n");
                scriptBuilder.append("                     \n");
            }

            scriptBuilder.append("                      $(window).on('resize', function () {\n");
            scriptBuilder.append("                          var width = $('.jqgrid-responsive').width();\n");
            scriptBuilder.append("                          ").append("jqGrid").append(entity).append(".setGridWidth(width);\n");
            scriptBuilder.append("                      }).resize();\n");
            scriptBuilder.append("                     \n");

            scriptBuilder.append("                  });\n");
            scriptBuilder.append("               })(window, document, window.jQuery);\n");
            scriptBuilder.append("               </script>\n");
            scriptBuilder.append("                     \n");
            scriptBuilder.append("               <table id=\"jqGrid").append(entity).append("\"></table>\n");
            scriptBuilder.append("               <table id=\"jqGrid").append(entity).append("Pager\"></table>\n");
            scriptBuilder.append("               \n");

            if (urlexport != null) {
                scriptBuilder.append("               <form method=\"post\" id=\"jqGrid").append(entity).append("GridParameters\" action=\"").append(getUrlexport()).append("\"  target=\"_blank\">\n");
                scriptBuilder.append("                  <input type=\"hidden\" name=\"filters\" id=\"filters\" value=\"\"/>\n");
                scriptBuilder.append("                  <input type=\"hidden\" id=\"jqgridExport\"/> \n");
                scriptBuilder.append("               </form>\n");
                scriptBuilder.append("               \n");
            }

            System.out.println(scriptBuilder.toString());
            getJspContext().getOut().write(scriptBuilder.toString());

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JqgridTag.class.getName()).log(Level.SEVERE, null, ex);
            getJspContext().getOut().write("errorgrid");
        } catch (Exception ex) {
            Logger.getLogger(JqgridTag.class.getName()).log(Level.SEVERE, null, ex);
            getJspContext().getOut().write("errorgrid");
        }
    }

}


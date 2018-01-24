package sv.gob.mh.sitep.common;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import lombok.Setter;
import lombok.Getter;

@Setter
@Getter
public class DateTag extends SimpleTagSupport {

    private String id;
    private String name;
    private String tabindex;
    private String required;
    private String readonly;

    @Override
    public void doTag() throws JspException, IOException {
        StringBuilder scriptBuilder = new StringBuilder();
        try {
           
            
            scriptBuilder.append("<div  class=\"input-group date\">\n");
                        scriptBuilder.append(" <input type=\"text\" ");
                        
            if (id != null && !id.trim().equals("")) {
                scriptBuilder.append("id=\"").append(id).append("\" ");
            }

            if (name != null && !name.trim().equals("")) {
                scriptBuilder.append(" name=\"").append(name).append("\"");
            }

            if (required != null && required.trim().equals("true")) {
                scriptBuilder.append(" required=\"").append(required).append("\" ");
            }

            
            if (tabindex != null && !tabindex.trim().equals("")) {
                scriptBuilder.append(" tabindex=\"").append(tabindex).append("\" ");
            }

            if (readonly != null && readonly.trim().equals("true")) {
                scriptBuilder.append(" readonly=\"true\" ");
            }

            scriptBuilder.append(" class=\"form-control\" >\n");
            scriptBuilder.append("  <span class=\"input-group-addon\">\n");
            scriptBuilder.append("      <span class=\"fa fa-calendar\"></span>\n");
            scriptBuilder.append("  </span>\n");
            scriptBuilder.append("</div>\n");
            
            scriptBuilder.append("<script>\n");
            scriptBuilder.append("  $(document).ready(function () {\n");
            scriptBuilder.append("      $('#").append(id).append("').datetimepicker({\n");
            scriptBuilder.append("          format: 'DD/MM/YYYY'\n");
            scriptBuilder.append("      });\n");
            scriptBuilder.append("  });\n");
            scriptBuilder.append("</script>\n");
            
            getJspContext().getOut().write(scriptBuilder.toString());

        } catch (Exception ex) {
            Logger.getLogger(JqgridTag.class.getName()).log(Level.SEVERE, null, ex);
            getJspContext().getOut().write("error textbox");
        }
    }
}



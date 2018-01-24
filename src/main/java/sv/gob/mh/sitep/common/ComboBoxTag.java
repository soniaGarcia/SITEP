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
public class ComboBoxTag extends SimpleTagSupport {

    private String id;
    private String url;
    private String name;
    private String tabindex;
    private String required;
    private String readonly;
    private String placeholder;
    private String value;

    @Override
    public void doTag() throws JspException, IOException {
        StringBuilder scriptBuilder = new StringBuilder();
        try {
            scriptBuilder.append(" <select ");

            if (id != null && !id.trim().equals("")) {
                scriptBuilder.append("id=\"").append(id).append("\" ");
            }

            if (name != null && !name.trim().equals("")) {
                scriptBuilder.append(" name=\"").append(name).append("\"");
            }

            if (required != null && required.trim().equals("true")) {
                scriptBuilder.append(" required=\"").append(required).append("\" ");
            }

            if (placeholder != null && !placeholder.trim().equals("")) {
                scriptBuilder.append(" data-placeholder=\"").append(placeholder).append("\" ");
            }

            if (tabindex != null && !tabindex.trim().equals("")) {
                scriptBuilder.append(" tabindex=\"").append(tabindex).append("\" ");
            }

            if (readonly != null && readonly.trim().equals("true")) {
                scriptBuilder.append(" readonly=\"true\" ");
            }

            scriptBuilder.append(" class=\"chosen-select input-md form-control\"  >\n");
            scriptBuilder.append(" </select> \n");
            scriptBuilder.append("<script>\n");
            scriptBuilder.append("  $(document).ready(function () {\n");
            scriptBuilder.append("      $.getJSON(\"").append(url).append("\", function (result) {\n");
            scriptBuilder.append("          $.each(result, function () {\n");
            scriptBuilder.append("              $(\"#").append(id).append("\").append(new Option(this.description, this.value));\n");
            scriptBuilder.append("          });\n");
            scriptBuilder.append("          $('#").append(id).append("').chosen();\n");

            if (readonly != null && readonly.trim().equals("true")) {
                scriptBuilder.append("  $(\"#" + id + "\").attr(\"disabled\", true); ");
            }
            scriptBuilder.append("\n");

            if (value != null && !value.trim().equals("")) {
                scriptBuilder.append("$(\"#" + id + "\").val(\"" + value + "\");\n");
                
            }
            scriptBuilder.append("$(\"#" + id + "\").trigger(\"chosen:updated\");\n");
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



package org.apache.jsp.jspSivut;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Tietovarastopakkaus.Aloite;
import Tietovarastopakkaus.Tietovarasto;

public final class muokkaaAloitetta_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Muokkaa aloitetta</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"../assets/bootstrap/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../assets/css/styles.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../assets/css/untitled.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-default\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"navbar-header\"><a class=\"navbar-brand navbar-link\" href=\"../index.html\">Aloitelaatikko </a>\n");
      out.write("                    <button class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navcol-1\"><span class=\"sr-only\">Toggle navigation</span><span class=\"icon-bar\"></span><span class=\"icon-bar\"></span><span class=\"icon-bar\"></span></button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"navcol-1\">\n");
      out.write("                    <ul class=\"nav navbar-nav\"></ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-6\">\n");
      out.write("                    ");
 
                        int aloiteID = Integer.parseInt(request.getParameter("id"));
                        Tietovarasto varasto = new Tietovarasto(); 
                        Aloite aloite = varasto.haeAloite(aloiteID);
                    
      out.write("\n");
      out.write("                    <h1>Vanhan aloitteen muokkaus</h1>\n");
      out.write("                   \n");
      out.write("                    <p>Tästä voit muokata aloittetta.</p>\n");
      out.write("                    <p>Käyttäjän ID ");
 
      out.write("</p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-6 col-md-offset-0\">\n");
      out.write("                    <form action=\"../../Aloitelaatikko/lisaaAloite\" method=\"post\">\n");
      out.write("                       \n");
      out.write("                        <input type=\"text\" name=\"aloitenimi\" placeholder=\"Aloitteen nimi\"><br>\n");
      out.write("                        <textarea type=\"text\" name=\"aloitekuvaus\" rows=\"5\" cols=\"50\" placeholder=\"Aloitteen kuvaus\"></textarea><br>\n");
      out.write("                       \n");
      out.write("                        <button class=\"btn btn-default btn-sm\" type=\"reset\" >Tyhjennä</button>\n");
      out.write("                        <button class=\"btn btn-default btn-sm\" type=\"submit\" >Tallenna aloite</button>            \n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <footer>\n");
      out.write("           \n");
      out.write("        </footer>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

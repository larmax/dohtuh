package org.apache.jsp.jspSivut;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class lisaaAloite_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Uusi aloite</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../assets/bootstrap/css/bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../assets/css/styles.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../assets/css/untitled.css\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <nav class=\"navbar navbar-default\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"navbar-header\"><a class=\"navbar-brand navbar-link\" href=\"../index.html\">Aloitelaatikko </a>\r\n");
      out.write("                    <button class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navcol-1\"><span class=\"sr-only\">Toggle navigation</span><span class=\"icon-bar\"></span><span class=\"icon-bar\"></span><span class=\"icon-bar\"></span></button>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"navcol-1\">\r\n");
      out.write("                    <ul class=\"nav navbar-nav\"></ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-md-6\">\r\n");
      out.write("                    <h1>Uuden aloitteen lisäys</h1>\r\n");
      out.write("                    <p>Tästä voit lisätä uuden aloitteen tietokantaan.</p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-6 col-md-offset-0\">\r\n");
      out.write("                    <form action=\"lisaaaloite\" method=\"post\">\r\n");
      out.write("                        <input type=\"text\" name=\"kayttajaID\" placeholder=\"Käyttäjän ID\"><br>\r\n");
      out.write("                        <input type=\"text\" name=\"aloitenimi\" placeholder=\"Aloitteen nimi\"><br>\r\n");
      out.write("                        <textarea type=\"text\" name=\"aloitekuvaus\" rows=\"5\" cols=\"50\" placeholder=\"Aloitteen kuvaus\"></textarea><br>\r\n");
      out.write("                        \r\n");
      out.write("                        <button class=\"btn btn-default btn-sm\" type=\"reset\" >Tyhjennä</button>\r\n");
      out.write("                        <button class=\"btn btn-default btn-sm\" type=\"submit\" >Talleta aloite</button>            \r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <footer>\r\n");
      out.write("           \r\n");
      out.write("        </footer>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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

package org.apache.jsp.jspSivut;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class lisaaKayttaja_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Käyttäjän lisääminen</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Uuden käyttäjän lisäys</h1>\n");
      out.write("        <form name=\"lisays\" action=\"../../Aloitelaatikko_ver2/lisaaKayttaja\" method=\"post\">\n");
      out.write("            <input type=\"text\" name=\"etunimi\" placeholder=\"Etunimi\"><br>\n");
      out.write("            <input type=\"text\" name=\"sukunimi\" placeholder=\"Sukunimmi\"><br>\n");
      out.write("            <input type=\"email\" name=\"email\" placeholder=\"Email\"><br>\n");
      out.write("            <input type=\"text\" name=\"kayttajatunnus\" placeholder=\"Käyttäjätunnus\"><br>\n");
      out.write("            <input type=\"password\" name=\"salasana\" placeholder=\"Salasana\"><br>\n");
      out.write("            <input type=\"text\" name=\"puhelin\" placeholder=\"Puhelin\"><br>\n");
      out.write("            <!-- Ei KÄYTÖSSÄ: <input type=\"date\" name=\"luontipaivays\"><br> -->\n");
      out.write("            \n");
      out.write("            <input type=\"reset\" value=\"Tyhjennä\" name=\"reset\" />\n");
      out.write("            <input type=\"submit\" value=\"Talleta\" name=\"talleta\" />            \n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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

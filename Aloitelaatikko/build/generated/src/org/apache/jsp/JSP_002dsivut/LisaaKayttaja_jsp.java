package org.apache.jsp.JSP_002dsivut;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class LisaaKayttaja_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Uuden tekijän lisäys</h1>\n");
      out.write("        <form name=\"lasays\" action=\"../../Aloitelaatikko/LisaaKayttaja\" method=\"post\">\n");
      out.write("            Tekijan etunimi: <input type=\"text\" name=\"etunimi\" placeholder=\"etunimi\"><br>\n");
      out.write("            Tekijan sukunimi: <input type=\"text\" name=\"sukunimi\"><br>\n");
      out.write("            Tekijan sposti: <input type=\"email\" name=\"email\"><br>\n");
      out.write("            Tekijan käyttäjätunnus: <input type=\"text\" name=\"tunnus\"><br>\n");
      out.write("            Tekijan salasana: <input type=\"password\" name=\"salis\"><br>\n");
      out.write("             Tekijan puhelin: <input type=\"text\" name=\"puh\" ><br>\n");
      out.write("<!--             Tekijan syntymäaika: <input type=\"date\" name=\"syntymäaika\" ><br>-->\n");
      out.write("             Luontiaika <input type=\"date\" name=\"luontipv\" ><br>\n");
      out.write("                                    \n");
      out.write("             <input type=\"reset\" value=\"Tyhjennä\" name=\"reset\" />\n");
      out.write("            <input type=\"submit\" value=\"Talleta\" name=\"talleta\" />\n");
      out.write("             </body>\n");
      out.write("            </html>\n");
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
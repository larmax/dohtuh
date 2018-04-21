package org.apache.jsp.jspSivut;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Tietovarastopakkaus.*;

public final class tulostaAloitteet_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Aloitteen tulostus</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
 
            Tietovarasto tietovarasto = new Tietovarasto();
        
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        <h1>Kaikki aloitteet</h1>\r\n");
      out.write("        <table>\r\n");
      out.write("            <thead>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <th>AloiteID</th>\r\n");
      out.write("                    <th>Nimi</th>\r\n");
      out.write("                    <th>Kuvaus</th>\r\n");
      out.write("                    <th>pvm</th>\r\n");
      out.write("                    <th>KayttajaID</th>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </thead>\r\n");
      out.write("            <tbody>\r\n");
      out.write("                \r\n");
      out.write("                ");
 for (Aloite aloite : tietovarasto.haeKaikkiAloitteet()) {
                
      out.write("\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>");
      out.print(aloite.getAloiteID() );
      out.write("</td>\r\n");
      out.write("                    <!--Lähetetään aloitenimen lisäksi aloiteID ja aloitekuvaus servletille-->\r\n");
      out.write("                   <p herf='lisaaToimenpide.jsp?aloiteID=");
      out.print( aloite.getAloiteID() );
      out.write("\r\n");
      out.write("                           &aloitekuvaus=");
      out.print( aloite.getAloitekuvaus() );
      out.write("'></a> \r\n");
      out.write("                       \r\n");
      out.write("                   <td>   <a href=muokkaaAloitetta.jsp?id=");
      out.print(aloite.getAloiteID() );
      out.write('>');
      out.print(aloite.getAloitenimi());
      out.write("</a>  </td>\r\n");
      out.write("                           <td>");
      out.print( aloite.getAloitekuvaus() );
      out.write("</td>\r\n");
      out.write("                           <td>");
      out.print( aloite.getPvm() );
      out.write("</td>\r\n");
      out.write("                           <td>");
      out.print( aloite.getKayttajaID() );
      out.write("</td>\r\n");
      out.write("                    \r\n");
      out.write("                </tr>\r\n");
      out.write("                \r\n");
      out.write("                ");
 } 
      out.write("\r\n");
      out.write("            </tbody>\r\n");
      out.write("        </table>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
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

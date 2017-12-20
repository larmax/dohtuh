

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*;" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
      <h1>kaikki parametrit</h1>
      
        <p> username: <% String uname = request.getParameter("kayttajanimi");out.print(uname);%></p>
        <p> salasana: <% String pword = request.getParameter("salasana");out.print(pword); %></p>
    
      
        <h1>HTTP-headers</h1>
        <table border="1" cellpadding="4" cellspacing="0">
            <th>Avain </th><th>Arvo</th> 
      <%
          String iD;
          String knimi = session.getAttribute(uname).toString();
          String ssana = session.getAttribute(pword).toString();
            if(!knimi.isEmpty()||!ssana.isEmpty()){
     iD =session.getId(); 
            String loggedin = uname;
            }
         Enumeration eNames = request.getHeaderNames();
         while (eNames.hasMoreElements()) {
            String name = (String) eNames.nextElement();
            String value = normalize(request.getHeader(name));
            iD = (String) eNames.nextElement();
            
            
      %>
         
         <tr><td><%= name %></td><td><%= value %></td></tr>
      <%
         }
      %>
      </table>
      
        
       
    </body>
</html>
<%!
   private String normalize(String value)
   {
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < value.length(); i++) {
         char c = value.charAt(i);
         sb.append(c);
         if (c == ';')
            sb.append("<br>");
      }
      return sb.toString();
   }
%>
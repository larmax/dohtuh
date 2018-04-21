<%-- 
    Document   : tulostaAloitteet
    Created on : Nov 24, 2017, 1:51:00 PM
    Author     : s1601379
--%>

<%@page import="Tietovarastopakkaus.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aloitteen tulostus</title>
    </head>
    <body>
        <% 
            Tietovarasto tietovarasto = new Tietovarasto();
        %>
        
        <h1>Kaikki aloitteet</h1>
        <table>
            <thead>
                <tr>
                    <th>AloiteID</th>
                    <th>Nimi</th>
                    <th>Kuvaus</th>
                    <th>pvm</th>
                    <th>KayttajaID</th>
                </tr>
            </thead>
            <tbody>
                
                <% for (Aloite aloite : tietovarasto.haeKaikkiAloitteet()) {
                %>
                <tr>
                    <td><%=aloite.getAloiteID() %></td>
                    <!--Lähetetään aloitenimen lisäksi aloiteID ja aloitekuvaus servletille-->
                   <p herf='lisaaToimenpide.jsp?aloiteID=<%= aloite.getAloiteID() %>
                           &aloitekuvaus=<%= aloite.getAloitekuvaus() %>'></a> 
                       
                   <td>   <a href=muokkaaAloitetta.jsp?id=<%=aloite.getAloiteID() %>><%=aloite.getAloitenimi()%></a>  </td>
                           <td><%= aloite.getAloitekuvaus() %></td>
                           <td><%= aloite.getPvm() %></td>
                           <td><%= aloite.getKayttajaID() %></td>
                    
                </tr>
                
                <% } %>
            </tbody>
        </table>
        
        
        
        
        
        
        
    </body>
</html>

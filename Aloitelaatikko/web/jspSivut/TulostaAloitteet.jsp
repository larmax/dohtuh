<%-- 
    Document   : TulostaAloitteet
    Created on : Nov 24, 2017, 1:51:32 PM
    Author     : s1601385
--%>
<%@page import ="Tietovarastopakkaus.*;" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<table>
            <thead>
                <tr>
                    <th>Aloitetunnus</th>
                    <th>Nimi</th>
                    <th>Kuvaus</th>
                    <th>pvm</th>
                    <th>Tekijätunnus</th>
                </tr>
            </thead>
            <tbody>
                <% for (Aloite aloite : Tietovarasto.haeKaikkiAloitteet()) {
                %>
                <tr>
                    <td><%=aloite.getAloiteID() %></td>
                    <!— Lähetetään aloitenimen lisäksi aloiteID ja aloitekuvaus servletille-->
                    <td><a herf='lisaaToimenpide.jsp?aloiteID=<%= aloite.getAloiteID() %>
                           &aloitekuvaus=<%= aloite.getAloitekuvaus() %>'><%= 
                           aloite.getAloitenimi() %></a></td>
                </tr>
                <% } %>
            </tbody>
        </table>

</html>

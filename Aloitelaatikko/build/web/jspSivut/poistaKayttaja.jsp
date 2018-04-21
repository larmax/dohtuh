<%-- 
    Document   : poistaKayttaja
    Created on : Mar 1, 2018, 1:51:26 PM
    Author     : s1601385
--%>

<%@page import="Tietovarastopakkaus.Kayttaja"%>
<%@page import="Tietovarastopakkaus.Tietovarasto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Poista käyttäjä</h1>

        <p>
        <form name="poisto" method="POST">
            <label>
                Anna poistettavan käyttäjän numero:
                <input name="kayttajaID" size="6" >

            </label>

            <input name="poista" type="submit" value ="Poista"/>
        </form>
        <table>
       
        
        <tr>
            <th>KayttajaID</th>
            <th>KayttajaTunnus</th>
            <th>Etunimi</th>
            <th>Salasana</th>
            <th>Email</th>
            <th>Sukunimi</th>
            <th>Luontipaivays</th>
            <th>RyhmaID</th>
             <th>Aktiivinen</th>
            
            
        </tr>
         <p><% Tietovarasto varasto = new Tietovarasto();
        
            for (Kayttaja kayttaja : varasto.haeKaikkiKayttajat()) {
               
            
            %>  </p>
        <tr>
            
                            <td><%= kayttaja.getKayttajaID() %></td>
<!--                            <!— Lähetetään aloitenimien lisäksi aloiteID ja aloitekuvaus jsp-sivulle-->
                           
                            <td><%= kayttaja.getKayttajaTunnus()%></td>
                              <td><%= kayttaja.getEtunimi()%></td>
                              
                             <td><%= kayttaja.getSalasana()%></td>
                            <td><%= kayttaja.getEmail()%></td>
                              <td><%= kayttaja.getSukunimi()%></td>
                            <td><%= kayttaja.getLuontipaivays()%></td>
                            <td><%= kayttaja.getRyhmaID()%></td>
                            <td><%= kayttaja.getAktiivinen()%></td>
                            
                        
                        <%}%>
        </tr>
 </table>
        <a><% String poistettava = request.getParameter("kayttajaID");
            System.out.println(poistettava);
            try {

                varasto.poistaKayttaja(Integer.parseInt(poistettava));

            } catch (Exception e) {
               
              System.out.println("GET, ei lomaketta");
              
            
            }

            %>
        
        </a>
    </body>

</html>

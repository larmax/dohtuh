<%-- 
    Document   : lisaaKayttaja
    Created on : Oct 30, 2017, 6:56:19 PM
    Author     : haaar

    Muutos 3.11.2015: Tekijä sana korvattu sanalla Käyttäjä
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Käyttäjän lisääminen</title>
    </head>
    <body>
        <h1>Uuden käyttäjän lisäys</h1>
        <form name="lisays" action="../../Aloitelaatikko_ver2/lisaaKayttaja" method="post">
            <input type="text" name="etunimi" placeholder="Etunimi"><br>
            <input type="text" name="sukunimi" placeholder="Sukunimmi"><br>
            <input type="email" name="email" placeholder="Email"><br>
            <input type="text" name="kayttajatunnus" placeholder="Käyttäjätunnus"><br>
            <input type="password" name="salasana" placeholder="Salasana"><br>
            <input type="text" name="puhelin" placeholder="Puhelin"><br>
            <!-- Ei KÄYTÖSSÄ: <input type="date" name="luontipaivays"><br> -->
            
            <input type="reset" value="Tyhjennä" name="reset" />
            <input type="submit" value="Talleta" name="talleta" />            
        </form>
    </body>
</html>

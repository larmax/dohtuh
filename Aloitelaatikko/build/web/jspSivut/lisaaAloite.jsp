

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Uusi aloite</title>
    </head>
    <body>
        <h1>Uuden aloitteen lisäys</h1>
        <form name="lisays" action="../../Aloitelaatikko_ver2/lisaaAloite" method="post">
            <input type="text" name="kayttajaID" placeholder="Käyttäjän ID"><br><br>
            <input type="text" name="aloitenimi" placeholder="Aloitteen nimi"><br><br>
            <textarea type="text" name="aloitekuvaus" rows="10" cols="30" placeholder="Aloitteen kuvaus"></textarea><br>
            
            <input type="reset" value="Tyhjennä" name="reset" />
            <input type="submit" value="Talleta aloite" name="talleta" />            
        </form>
    </body>
</html>

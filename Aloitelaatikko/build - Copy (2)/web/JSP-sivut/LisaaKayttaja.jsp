<%-- 
    Document   : LisaaKayttaja
    Created on : Oct 31, 2017, 2:54:11 PM
    Author     : s1601385
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Uuden tekijän lisäys</h1>
        <form name="lasays" action="../../Aloitelaatikko/LisaaKayttaja" method="post">
            Tekijan etunimi: <input type="text" name="etunimi" placeholder="etunimi"><br>
            Tekijan sukunimi: <input type="text" name="sukunimi"><br>
            Tekijan sposti: <input type="email" name="email"><br>
            Tekijan käyttäjätunnus: <input type="text" name="tunnus"><br>
            Tekijan salasana: <input type="password" name="salis"><br>
             Tekijan puhelin: <input type="text" name="puh" ><br>
<!--             Tekijan syntymäaika: <input type="date" name="syntymäaika" ><br>-->
             Luontiaika <input type="date" name="luontipv" ><br>
                                    
             <input type="reset" value="Tyhjennä" name="reset" />
            <input type="submit" value="Talleta" name="talleta" />
             </body>
            </html>

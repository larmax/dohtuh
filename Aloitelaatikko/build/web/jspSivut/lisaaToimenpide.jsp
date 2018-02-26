<%-- 
    Document   : lisaaToimenpide
    Created on : Nov 28, 2017, 2:07:48 PM
    Author     : s1601385
--%>
<%@page import="Tietovarastopakkaus.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Toimeenpiteen kirjaus</title>
        
            </head>
    <body>
        <%
            Tietovarasto tietovarasto = new Tietovarasto();
            %>
            <h2>Toimeenpiteen kirjaus</h2>
            <% request.setCharacterEncoding("UTF-8");
            String aloiteID = request.getParameter("aloiteID");
            String aloitekuvaus = request.getParameter("aloitetpakkaus");
           %>
           <p>Aloitteen kuvaus <%= aloitekuvaus %> </p>
           <form action= "../../Aloitelaatikko/lisaaToimenpide" method="post">
                 Toimenpide:<br>
                 <textarea name ="kuvaus" rows="4" cols="30"> </textarea><br>
                 Toimeenpiteen kirjasi: <br>
                 <textarea name="kuvaus" rows="4" cols="30"> </textarea> <br>
                 <input type ="submit" value="Tallenna toimenpide">
                        <input type="reset" value="Tyhjennä kentät">
                        <input type="hidden" name="aloiteID" value='<%=aloiteID %>'>
                        
                 
               
                 
               
           </form>
    </body>
        

    
</html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Uusi toimenpide</title>
        <link rel="stylesheet" href="../assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="../assets/css/styles.css">
        <link rel="stylesheet" href="../assets/css/untitled.css">
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header"><a class="navbar-brand navbar-link" href="../index.html">Aloitelaatikko </a>
                    <button class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
                </div>
                <div class="collapse navbar-collapse" id="navcol-1">
                    <ul class="nav navbar-nav"></ul>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <h1>Uuden toimenpiteen lisäys</h1>
                    <p>Tästä voit lisätä uuden toimenpiteen tietokantaan.</p>
                </div>
                <div class="col-md-6 col-md-offset-0">
                    <form action="../../Aloitelaatikko/lisaaToimenpide" method="post">
                        <input type="text" name="kayttajaID" placeholder="Käyttäjän ID"><br>
                        <input type="text" name="aloiteID" placeholder="Aloitteen ID"><br>
                        <textarea type="text" name="kuvaus" rows="3" cols="50" placeholder="Toimenpiteen kuvaus"></textarea><br>
                        
                        <button class="btn btn-default btn-sm" type="reset" >Tyhjennä</button>
                        <button class="btn btn-default btn-sm" type="submit" >Talleta toimenpide</button>            
                    </form>
                </div>
            </div>
        </div>
        <footer>
            <p>kys</p>
        </footer>
    </body>
</html>

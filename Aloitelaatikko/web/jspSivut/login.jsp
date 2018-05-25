<%-- 
    Document   : login
    Created on : Apr 20, 2018, 10:15:33 AM
    Author     : s1601385
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Aloitelaatikko</title>
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/styles.css">
        <link rel="stylesheet" href="assets/css/untitled.css">
    </head>

    <body>
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header"><a class="navbar-brand navbar-link" href="#">Aloitelaatikko </a>
                    <button class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
                </div>
                <div class="collapse navbar-collapse" id="navcol-1">
                    <ul class="nav navbar-nav"></ul>
                </div>
            </div>
        </nav>
        <div>
            <div class="container">
                <div class="row">
                    <div class="col-md-8">
                     
                    </div>
                    <div class="col-md-4 col-md-offset-0">
                        <h2>Kirjaudu sisään </h2>
                        <form name="kirjautuminen" action="login" method="post">
                            <input type="text" name="kayttajatunnus" placeholder="kayttajatunnus"><br>
                            <input type="password" name="salasana" placeholder="salasana"><br>
                            <button class="btn btn-default btn-sm" type="submit">Kirjaudu sisään</button>
                            
                        </form>
                        


                    </div>
                </div>
            </div>
        </div>
        <footer>
            <p>Sleon Smiller│ 2018</p>
        </footer>
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    </body>

</html>
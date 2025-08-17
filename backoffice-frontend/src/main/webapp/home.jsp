<%@page pageEncoding="UTF-8" contentType="text/html" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Backoffice home</title>
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/application.js"></script>
    </head>
    <body>
        <h1>OnlineStore (backoffice - jsp)</h1>
        <div>Bonjour ${userId} (<a href="logout">Déconnexion</a>)</div>
        <div>
            <nav>
                <ul>
                    <li><a href="catalogue">Afficher le catalogue des oeuvres</a></li>
                    <li><a href="add-work-form.html">Ajouter une oeuvre au catalogue</a></li>
                </ul>
            </nav>
        </div>
    </body>
</html>

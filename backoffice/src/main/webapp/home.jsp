<%@page pageEncoding="UTF-8" contentType="text/html" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Backoffice home</title>
    </head>
    <body>
        <h1>OnlineStore (backoffice - jsp)</h1>
        <div>Bonjour ${userId} (<a href="logout">Déconnexion</a>)</div>
        <div>
            <nav>
                <ul>
                    <li><a href="catalogue">Accès au catalogue des oeuvres</a></li>
                    <li><a href="add-work-form.html">Ajouter une oeuvre au catalogue</a></li>
                </ul>
            </nav>
        </div>
    </body>
</html>

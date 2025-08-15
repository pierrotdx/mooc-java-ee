<%@ page isELIgnored="false" %>
<%@ page pageEncoding="UTF-8" contentType="text/html" %>

<!DOCTYPE html>
<html>
    <head>
        <title>${work.title}</title>
    </head>
    <body>
        <article>
            <h2>${work.title}</h2>
            <ul>
                <li>De : ${work.mainArtist.name}</li>
                <li>Année de sortie : ${work.release}</li>
                <li>Résumé : ${work.summary}</li>
            </ul>
        </article>
        <form action="addToCart" method="post">
            <input name="workId" type="hidden" value="${work.id}">
            <input type="submit" value="Ajouter au caddie">
        </form>
    </body>
</html>

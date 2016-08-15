<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Table_RU</title>
    <link rel="stylesheet" href=
    <c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
            integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <link rel="stylesheet" href=<c:url value="/resourses/css/style.css"/> />

</head>
<body>

<h1>Набор данных про Андорру (RU)</h1>

<div class="container">
    <div class="row panel panel-default">
        <div class="table-responsive">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th class="success">ID</th>
                    <th class="success">Region1</th>
                    <th class="success">Locality</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="entity" items="${entities}">
                    <tr>
                        <td>${entity.id}</td>
                        <td>${entity.region}</td>
                        <td>${entity.locality}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
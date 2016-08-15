<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Table_EN</title>
    <link rel="stylesheet" href=<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <link rel="stylesheet" href=<c:url value="/resourses/css/style.css"/> />

</head>
<body>

<h1>Dataset Andorra (EN)</h1>

<div class="container">
    <div class="row">
        <div id="mywarning" class="alert alert-danger">
            <strong>Attention!</strong> Select item...
        </div>
    </div>
</div>

<div class="container">
    <div class="row panel panel-default">
        <div class="table-responsive">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th class="warning">ID</th>
                    <th class="warning">
                        <button class="btn btn-xs btn-primary" id="checkAll">Select All</button>
                    </th>
                    <th class="warning">Region1</th>
                    <th class="warning">Locality</th>
                </tr>
                </thead>
                <tbody id="sites">
                <form:form id="myForm" action="/tableru" >
                <c:forEach var="entity" items="${entities}">
                <tr>
                    <td>${entity.id}</td>
                    <td>
                        <label>
                            <input class="checkbox" type="checkbox" name="checkbox-data" value="${entity.id}">
                            <span class="checkbox-custom"></span>
                        </label>
                    </td>
                    <td>${entity.region}</td>
                    <td>${entity.locality}</td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="centering">
                <input class="btn btn-md btn-primary" value="Translate" onclick="myFunction()"/>
        </div>
    </div>
</div>
</form:form>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script type="text/javascript" src="resourses/js/common.js"></script>
</body>
</html>

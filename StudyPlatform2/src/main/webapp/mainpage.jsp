<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Main Page</title>
    <style>
            a{
                text-decoration: none;
            }

            .title{
                color: #000;
                font-family: Inter;
                font-size: 60px;
                font-style: normal;
                font-weight: 700;
            }

            .text{
                color: #000;
                text-align: center;
                font-family: Inter;
                font-size: 24px;
                font-style: normal;
                font-weight: 400;
            }

            .btn{
                border-radius: 8px;
                background: #000;
                color: #fff;
                text-align: center;
                font-family: Inter;
                font-size: 20px;
                font-style: normal;
                font-weight: 400;
                width: 200px;
                height: 60px;
            }

            .center{
                text-align: center;
            }

            .centerform{
                display: block;
                margin-left: auto;
                margin-right: auto;
            }

            .btn:hover{
                background: #fff;
                color: #000;
                border: 1px solid #000;
                transition: 0.2s;
            }

            .table {
            	width: 100%;
            	margin-bottom: 20px;
            	border: 1px solid #dddddd;
            	border-collapse: collapse;
            }
            .table th {
            	font-weight: bold;
            	padding: 5px;
            	background: #efefef;
            	border: 1px solid #dddddd;
            }
            .table td {
            	border: 1px solid #dddddd;
            	padding: 5px;
            }
        </style>
</head>
<body>
    <c:url value="/publishMaterial" var="publishMaterialUrl"/>
    <c:url value="/deleteMaterial" var="deleteMaterialUrl"/>
    <c:url value="/profile" var="profileUrl"/>
    <c:choose>
        <c:when test="${isTeacher eq true}">
            <a href="${publishMaterialUrl}"><button class="btn" style="margin-right: 32px; cursor: pointer;">Опубликовать материал</button></a>
            <form action="${deleteMaterialUrl}" method="post" style="display: inline-block;">
                <button class="btn" style="cursor: pointer;">Удалить выбранные материалы</button>
                <input type="hidden" name="action" value="deleteSelected">
            </form>
        </c:when>
    </c:choose>

    <a href="${profileUrl}"><button class="btn" style="cursor: pointer;">Войти в профиль</button></a>
    <br>
    <h2 class="title">Материалы на сайте:</h2>
    <table class="table" border="1">
        <tr>
            <th>Название</th>
            <th>Описание</th>
            <th>Файл</th>
            <th>Дата загрузки</th>
            <th>Имя преподавателя</th>
        </tr>
        <c:forEach var="material" items="${materials}">
            <tr>
                <td><a href="/StudyPlatform2/material?materialId=${material.materialId}">${material.title}</a></td>
                <td>${material.description}</td>
                <td><a href="downloadMaterial?materialId=${material.materialId}">Скачать</a></td>
                <td>${material.uploadDate}</td>
                <td><a href="teacher_profile?userId=${material.userId}">${material.uploaderName}</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
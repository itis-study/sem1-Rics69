<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Материал</title>
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
                width: 250px;
                height: 70px;
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
        </style>
</head>
<body>
    <h1>${material.title}</h1>
    <p>${material.description}</p>
    <p>Файл: <td><a href="downloadMaterial?materialId=${material.materialId}">Скачать</a></td></a></p>
    <p>Дата загрузки: ${material.uploadDate}</p>
    <p>Имя преподавателя: <a href="teacher_profile?userId=${material.userId}">${material.uploaderName}</a></p>

    <div id="commentsContainer">
        <c:forEach var="comment" items="${comments}">
            <p>${comment.text}</p>
        </c:forEach>
    </div>

    <form id="commentForm">
        <textarea id="commentText" name="commentText" rows="4" cols="50"></textarea>
        <input type="hidden" id="materialId" name="materialId" value="${material.materialId}">
        <button type="button" onclick="addComment()">Добавить комментарий</button>
    </form>

    <script>
        function addComment() {
            var commentText = document.getElementById("commentText").value;
            var materialId = document.getElementById("materialId").value;

            var xhr = new XMLHttpRequest();
            xhr.open("POST", "${pageContext.request.contextPath}/material", true);
            xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    document.getElementById("commentsContainer").innerHTML = xhr.responseText;
                    document.getElementById("commentText").value = "";
                }
            };

            xhr.send("materialId=" + materialId + "&commentText=" + commentText);
        }
    </script>

</body>
</html>
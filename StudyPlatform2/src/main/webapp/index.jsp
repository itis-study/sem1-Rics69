<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Главная страница</title>
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
    <h1 class="title center">Привет</h1>
    <p class="text">Данная платформа позволяет вам делиться материалами, если вы учитель. Если вы являетесь студентом, то вы можете просматривать и скачивать материалы своих преподавателей.</p>
    <c:url value="/mainpage" var="mainpageUrl"/>
    <c:url value="/register" var="registerUrl"/>
    <c:url value="/login" var="loginUrl"/>

    <a href="<c:url value="mainpage"></c:url> "><button class="btn centerform" style="margin-bottom: 32px; cursor: pointer;">Все материалы</button></a>
    <div>
        <a href="${registerUrl}"><button class="btn centerform" style="margin-bottom: 32px; cursor: pointer;">Регистрация</button></a>
        <a href="${loginUrl}"><button class="btn centerform" style="cursor: pointer;">Авторизация</button></a>
    </div>

    <script>

    </script>
</body>
</html>

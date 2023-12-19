<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Teacher Profile</title>
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

            .text3{
                color: #000;
                font-family: Inter;
                font-size: 32px;
                font-style: normal;
                font-weight: 500;
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
    <h2 class="title">Профиль преподавателя</h2>
    <p class="text3">Имя: ${teacher.firstName}</p>
    <p class="text3">Фамилия: ${teacher.lastName}</p>
    <p class="text3">Описание: ${teacherProfile.bio}</p>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Profile</title>
        <style>
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
                font-size: 20px;
                font-style: normal;
                font-weight: 400;
            }

            .btn{
                border-radius: 8px;
                background: #000;
                color: #fff;
                text-align: center;
                font-family: Inter;
                font-size: 24px;
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


        </style>
</head>
<body>
    <c:url value="/updateUserProfile" var="updateUserProfileUrl"/>
    <h2 class="title">Профиль пользователя</h2>
    <p class="text3">Имя: ${user.firstName}</p>
    <p class="text3">Фамилия: ${user.lastName}</p>
    <p class="text3">Тип пользователя: ${user.userType}</p>
    <p class="text3">Описание: ${profile.bio}</p>
    <a class="btn" href="${updateUserProfileUrl}">Обновить профиль</a>
</body>
</html>
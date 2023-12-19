<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Publish Material</title>
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

            .text3{
                color: #000;
                font-family: Inter;
                font-size: 32px;
                font-style: normal;
                font-weight: 500;
            }

            .inp{
                background: transparent;
                border: 1px solid #000;
                border-radius: 4px;
                color: #000;
                width: 200px;
                height: 30px;
            }
        </style>
</head>
<body>
    <form action="publishMaterial" method="post" enctype="multipart/form-data">
        <p class="text3">Название:</p> <input class="inp" type="text" name="title"><br>
        <p class="text3">Описание:</p> <textarea class="inp" name="description"></textarea><br>
        <p class="text3">Файл:</p> <input class="inp" type="file" name="file"><br>
        <input class="btn" type="submit" value="Опубликовать материал">
    </form>
</body>
</html>

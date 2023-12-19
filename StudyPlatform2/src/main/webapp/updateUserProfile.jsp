<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update User Profile</title>
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

            .confirmation-popup {
                display: none;
                position: fixed;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                padding: 20px;
                background-color: #fff;
                border: 1px solid #000;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                z-index: 1000;
            }

            .confirmation-popup p {
                margin: 0;
            }

            .confirmation-popup button {
                margin-top: 10px;
                padding: 5px 10px;
                cursor: pointer;
            }
        </style>
</head>
<body>
    <h2 class="title">Обновление профиля пользователя</h2>
    <form action="updateUserProfile" method="post">
        <label class="text3">Имя:</label>
        <input class="inp" type="text" name="firstName" value="${user.firstName}" required><br><br>

        <label class="text3">Фамилия:</label>
        <input class="inp" type="text" name="lastName" value="${user.lastName}" required><br><br>

        <label class="text3">Описание:</label>
        <input class="inp" type="text" name="bio" value="${profile.bio}"><br><br>

        <input class="btn" type="submit" value="Обновить профиль">
    </form>

     <div id="confirmationPopup" class="confirmation-popup">
            <p>Вы уверены, что хотите обновить профиль?</p>
            <button onclick="confirmUpdate()">Да</button>
            <button onclick="cancelUpdate()">Нет</button>
     </div>

     <script>
             function showConfirmationPopup() {
                 document.getElementById('confirmationPopup').style.display = 'block';
             }

             function confirmUpdate() {
                 document.getElementById('updateForm').submit();
             }

             function cancelUpdate() {
                 document.getElementById('confirmationPopup').style.display = 'none';
             }
     </script>
</body>
</html>
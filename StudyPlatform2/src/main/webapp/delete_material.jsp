<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Material</title>
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
    <h2>Delete Material</h2>

    <c:if test="${empty materials}">
        <p>No materials to delete.</p>
    </c:if>

    <c:if test="${not empty materials}">
        <form action="deleteMaterial" method="post">
            <table border="1">
                <tr>
                    <th>Material ID</th>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Delete</th>
                </tr>
                <c:forEach var="material" items="${materials}">
                    <tr>
                        <td>${material.materialId}</td>
                        <td>${material.title}</td>
                        <td>${material.description}</td>
                        <td>
                            <input type="checkbox" name="materialIds" value="${material.materialId}">
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <br>
            <input type="submit" value="Delete Selected Materials">
        </form>
    </c:if>
</body>
</html>

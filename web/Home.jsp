<%-- 
    Document   : main
    Created on : Jul 5, 2024, 5:07:37 PM
    Author     : MyPC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Healthy Meals</title>
        <style><%@include file="WEB-INF/css/stylesheet.css"%></style>
        <script><%@include file="WEB-INF/js/js.js" %></script>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body id="body">
        <!--Check is logged in ?-->
        <c:set var="IsLogged" value="${sessionScope.Login_user}" />
        <!--Notifications-->
        <c:if test="${not empty IsLogged}">
            <!-- Log In Success -->
            <div id="erro_msg">
                <div class="notification" id="notifi_welcome">
                    <i class="fi fi-br-check"></i>
                    <span>Welcome ${IsLogged.email}</span>
                </div>
            </div>
        </c:if>
        <c:if test="${not empty sessionScope.ERROR_AUTHENTY}">
            <!-- Not Logged In -->
            <div id="erro_msg">
                <div class="notification" id="notifi_welcome">
                    <i class="fi fi-br-check"></i>
                    <span>Have to login first!!!</span>
                </div>
            </div>
            <c:remove var="ERROR_AUTHENTY" scope="session"/>
        </c:if>



        <!--navigate bar-->
        <div id="nav">
            <nav id="navbar">

                <ul class="nav-items-left">
                    <li class="nav-item">
                        <a href="Home.jsp">Home</a>
                    </li>

                    <li class="nav-item">
                        <a href="#">Action</a>
                    </li>
                </ul>

                <li class="nav-item search-container">
                    <form class="search-form">
                        <input type="search" id="search_bar" placeholder="Find your ideal menus">
                        <button type="submit" id="search_button">Search</button>
                    </form>
                </li>

                <ul class="nav-items-right">
                    <!-- Icon for cart -->
                    <li class="nav-item">
                        <a href="#">
                            <img src="icons/shopping-cart.png" alt="Shopping Cart">
                        </a>
                    </li>

                    <!-- Icon for user -->
                    <li class="nav-item">
                        <div class="dropdow_form">
                            <a href="#">
                                <img src="icons/user.png" alt="user">
                            </a>
                            <div class="opts">
                                <ul class="opts_dt">
                                    <c:choose>
                                        <c:when test="${not empty IsLogged}">
                                            <!-- Logged in user options -->
                                            <li class="logged-in-only"><a href="Account.jsp">Account</a></li>
                                            <li class="logged-in-only"><a href="#">Settings</a></li>
                                            <li class="logged-in-only"><a href="#">Order History</a></li>
                                            <li class="logged-in-only"><a href="MainController?action=logout">Log Out</a></li>
                                            </c:when>
                                            <c:when test="${IsLoggedd == null}">
                                            <!-- Logged out user options -->
                                            <li class="logged-out-only"><a href="LoginForm.jsp">Login</a></li>
                                            <li class="logged-out-only"><a href="RegisterForm.jsp">Register</a></li>
                                            </c:when>
                                        </c:choose>
                                </ul>
                            </div>
                        </div>
                    </li>
                </ul>
            </nav>
        </div>

        <div class="container mt-5">
            <!--Menu cards-->
            <c:choose>
                <c:when test="${not empty cardList}">
                    <c:forEach var="card" items="${cardList}" varStatus="status">
                        <c:if test="${status.index % 6 == 0}">
                            <div class="row card-page ${status.index == 0 ? 'active' : ''}" id="page${(status.index / 6) + 1}">
                            </c:if>
                            <div class="col-md-4 mb-4">
                                <div class="card text-dark">
                                    <img src="${card.imageUrl}" class="card-img-top" alt="${card.title}">
                                    <div class="card-body">
                                        <h5 class="card-title">${card.title}</h5>
                                        <p class="card-text">${card.description}</p>
                                        <p class="card-text"><small>Last updated ${card.lastUpdated}</small></p>
                                    </div>
                                </div>
                            </div>
                            <c:if test="${status.index % 6 == 5 || status.last}">
                            </div>
                        </c:if>
                    </c:forEach>

                    <!-- Pagination -->
                    <nav aria-label="Page navigation example">
                        <ul class="pagination justify-content-center">
                            <c:forEach var="i" begin="1" end="">
                                <li class="page-item"><a class="page-link" href="#" onclick="showPage(${i})">${i}</a></li>
                                </c:forEach>
                        </ul>
                    </nav>
                </c:when>
                <c:otherwise>
                    <p>No cards available.</p>
                </c:otherwise>
            </c:choose>
        </div>

        <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
    </body>
</html>

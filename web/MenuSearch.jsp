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
                        <a href="MainController?action=home" value>Home</a>
                    </li>

                    <li class="nav-item">
                        <a href="#">Meal</a>
                    </li>
                </ul>

                <li class="nav-item search-container">
                    <form class="search-form" action="MainController">
                        <input type="search" name="search" id="search_bar" placeholder="Find your ideal menu">
                        <button type="submit" name="action" value="search" id="search_button">Search</button>
                    </form>
                </li>

                <ul class="nav-items-right">
                    <!-- Icon for cart -->
                    <li class="nav-item">
                        <a href="MainController?action=vieworder">
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
        
        <c:choose>
            <c:when test="${empty searchlist}">
                <p>There no menu with this name.</p>
            </c:when>
            <c:otherwise>
                <div class="menu-wrapper">
                    <button class="scroll-btn left">&lt;</button>
                    <div class="menu-container">
                        <c:forEach var="menu" items="${searchlist}">
                            <div class="menu-item">
                                <a href="MainController?action=menu&menuid=${menu.menuID}" >
                                    <img src="${menu.imgUrl}" width="100%" alt="${menu.menuName}">
                                </a>
                            </div>
                        </c:forEach>
                    </div>
                    <button class="scroll-btn right">&gt;</button>
                </div>
            </c:otherwise>
        </c:choose>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
    </body>
</html>

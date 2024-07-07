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
    </head>
    <body>
        <!--Check is logged in ?-->
        <c:set var="IsLogged" value="${sessionScope.Login_user}" />
        <!--navigate bar-->
        <div class="nav">
            <nav class="navbar">

                <ul class="nav-items-left">
                    <li class="nav-item">
                        <a href="#">Home</a>
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
                                            <li class="logged-in-only"><a href="#">Account</a></li>
                                            <li class="logged-in-only"><a href="#">Settings</a></li>
                                            <li class="logged-in-only"><a href="#">Order History</a></li>
                                            <li class="logged-in-only"><a href="MainController?action=logout">Log Out</a></li>
                                        </c:when>
                                        <c:otherwise>
                                            <!-- Logged out user options -->
                                            <li class="logged-out-only"><a href="MainController?action=login" values="login">
                                                    Login</a></li>
                                            <li class="logged-out-only"><a href="MainController?action=register">
                                                    Register</a></li>
                                        </c:otherwise>
                                    </c:choose>
                                </ul>
                            </div>
                        </div>
                    </li>
                </ul>
            </nav>
        </div>



    </body>
</html>

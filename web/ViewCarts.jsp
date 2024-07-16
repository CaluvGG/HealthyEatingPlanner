<%-- 
    Document   : ViewCarts
    Created on : Jul 15, 2024, 9:21:00 AM
    Author     : MyPC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style><%@include file="WEB-INF/css/stylesheet.css"%></style>
        <script><%@include file="WEB-INF/js/js.js" %></script>
        <title>View Carts</title>
        <!--Bootstrap-->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            />
        <link
            href="https://getbootstrap.com/docs/5.3/assets/css/docs.css"
            rel="stylesheet"
            />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body id="body" class="container-fluid">
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
        <!--navigate bar-->
        <div id="nav">
            <nav id="navbar">

                <ul class="nav-items-left">
                    <li class="nav-item">
                        <a href="MainController?action=home">Home</a>
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
                                    <!-- Logged in user options -->
                                    <li class="logged-in-only"><a href="Account.jsp">Account</a></li>
                                    <li class="logged-in-only"><a href="#">Settings</a></li>
                                    <li class="logged-in-only"><a href="#">Order History</a></li>
                                    <li class="logged-in-only"><a href="MainController?action=logout">Log Out</a></li>
                                </ul>
                            </div>
                        </div>
                    </li>
                </ul>
            </nav>
        </div>
        
    </body>
</html>

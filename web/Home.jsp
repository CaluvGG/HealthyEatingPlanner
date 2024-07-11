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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <!--Check is logged in ?-->
        <c:set var="IsLogged" value="${sessionScope.Login_user}" />
        <!--Regist Succed-->
        <c:if test="${not empty requestScope.Succed_regis}">
            <div class="alert alert-danger alert-dismissible fade show" role="alert" style="position: absolute; top: 10px; left: 50%; transform: translateX(-50%); z-index: 9999;"
                  id="erro_msg">
                ${requestScope.Succed_regis}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <c:remove var="Succed_regis" scope="request"/>
        </c:if>

        <!--navigate bar-->
        <div id="nav">
            <nav id="navbar">

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
                                            <c:when test="${IsLoggedd == null}">
                                            <!-- Logged out user options -->
                                            <li class="logged-out-only"><a href="LoginForm.jsp"> Login</a></li>
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
        <br><br><br><br>

        <div class="container">
            <div class="row">
                <div id="carouselExampleIndicators" class="carousel slide">
                    <div class="carousel-indicators">
                        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
                        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
                    </div>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="..." class="d-block w-100" alt="...">
                        </div>
                        <div class="carousel-item">
                            <img src="..." class="d-block w-100" alt="...">
                        </div>
                        <div class="carousel-item">
                            <img src="..." class="d-block w-100" alt="...">
                        </div>
                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>

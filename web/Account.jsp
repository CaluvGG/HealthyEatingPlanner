<%-- 
    Document   : Account
    Created on : Jul 15, 2024, 12:57:36 AM
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
        <title>Account</title>
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
        <div id="nav row">
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
        <div class="row container">
            <div class="row" style="background-color: rgb(224, 167, 94);">
                <div class="Card_container" style="margin-top: 2em">
                    <form action="MainController" method="POST" class="form_card">
                        <c:if test="${not empty IsLogged}">
                            <input type="hidden" name="text_id" required value="${IsLogged.userID}" >
                            <div class="box_text">
                                <label>First name:</label>
                                <input type="text" name="text_firstname" required value="${IsLogged.firstName}" placeholder="First name">
                            </div>
                            <div class="box_text">
                                <label>Last name:</label>
                                <input type="text" name="text_lastname" required value="${IsLogged.lastName}"placeholder="Last name">
                            </div>

                            <div class="box_text">
                                <label>Email: </label>
                                <input type="email" name="text_email" required value="${IsLogged.email}" placeholder="Email">
                            </div>

                            <div class="box_text">
                                <label>Phone: </label>
                                <input type="text" name="text_phone" required value="${IsLogged.phone}" placeholder="Phone number">
                            </div>

                            <div class="box_text">
                                <label>Address: </label>
                                <input type="text" name="text_address" required value="${IsLogged.address}" placeholder="Address details">
                            </div>

                            <div class="box_text">
                                <label>Password: </label>
                                <input type="password" id="password" class="pass_key" disabled value="${IsLogged.password}" placeholder="Password">
<!--                                <span class="show" onclick="togglePassword()">
                                    <img src="icons/eye.png" alt="SHOW">
                                </span>-->
                            </div>

                            <!--Set role for use-->
                            <input type="hidden" name="text_role" value="1" />

                        </c:if>
                        <div class="field">
                            <input type="hidden" name="action" value="update_acc" />
                            <input type="submit" name="" value="Update" />
                        </div>
                        <div class="field">
                            <input type="hidden" name="action" value="logout" />
                            <input type="submit" name="" value="Log Out" />
                        </div>
                        <div class="field" style="background-color: #ff6668; border-radius: 10%;">
                            <input type="hidden" name="action" value="delete_acc" />
                            <input type="submit" value="Delete account" />
                        </div>
                        <!--Error Email dublicate-->
                        <c:if test="${not empty requestScope.DUBLICATE}">
                            <div style="color: red; position: absolute; bottom: 4.3em;left: 7.5em;" id="erro_msg">
                                ${requestScope.DUBLICATE}
                            </div>
                            <c:remove var="DUBLICATE" scope="request"/>
                        </c:if>
                    </form>
                </div>

            </div>
        </div>
    </body>
</html>

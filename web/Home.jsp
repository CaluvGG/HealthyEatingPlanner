<%-- 
    Document   : main
    Created on : Jul 5, 2024, 5:07:37 PM
    Author     : MyPC
--%>

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
                                    <!-- Logged in user options -->
                                    <li class="logged-in-only"><a href="#">Account</a></li>
                                    <li class="logged-in-only"><a href="#">Settings</a></li>
                                    <li class="logged-in-only"><a href="#">Order History</a></li>
                                    <!-- Logged out user options -->
                                    <li class="logged-out-only"><a href="LoginForm.jsp">Login</a></li>
                                    <li class="logged-out-only"><a href="">Register</a></li>
                                </ul>
                            </div>
                        </div>
                    </li>
                </ul>
            </nav>
        </div>


        
    </body>
</html>

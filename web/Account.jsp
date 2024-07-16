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
                    <!-- Icon for OrderHistory -->
                    <li class="nav-item">
                        <a href="MainController?action=vieworder&userid=${IsLogged.userID}">
                            <img src="icons/order-history.png" alt="Order history">
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

                    <!--Set role for use-->
                    <input type="hidden" name="text_role" value="1" />

                </c:if>
                <div class="field">
                    <input type="button"
                           data-bs-toggle="modal"
                           data-bs-target="#exampleModal" 
                           value="Edit">
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
                <!--Error confirm pass-->
                <c:if test="${not empty requestScope.NoAble}">
                    <div style="color: red; position: absolute; bottom: 12.5em;" id="erro_msg">
                        ${requestScope.NoAble}
                    </div>
                    <c:remove var="NoAble" scope="request"/>
                </c:if>
            </form>
        </div>

        <!-- Modal -->
        <form action="MainController" method="POST">
            <div
                class="modal fade"
                id="exampleModal"
                tabindex="-1"
                aria-labelledby="exampleModalLabel"
                aria-hidden="true"
                >
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="exampleModalLabel">Confirm your password</h1>
                            <button
                                type="button"
                                class="btn-close"
                                data-bs-dismiss="modal"
                                aria-label="Close"
                                ></button>
                        </div>

                        <div class="modal-body" 
                             style="display: flex;
                             justify-content: center;
                             flex-wrap: wrap;">
                            <input type="hidden" name="email" value="${IsLogged.email}" >
                            <div class="box_text">
                                <label>Confirm password: </label>
                                <input type="password" name="confirm" class="pass_key" placeholder="Password">
                                <span class="show" onclick="togglePassword(this)">
                                    <img src="icons/eye.png" alt="SHOW">
                                </span>
                            </div>
                        </div>

                        <div class="modal-footer">
                            <div class="field" style="width: 20%;">
                                <input type="hidden" name="action" value="givePermissionEdit" />
                                <input type="submit" name="" value="Confirm" />
                            </div>
                        </div>
                    </div>
                </div>
            </div>  
        </form>

    </body>
</html>

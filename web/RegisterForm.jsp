<%-- 
    Document   : RegisterForm
    Created on : Jul 6, 2024, 3:25:45 PM
    Author     : MyPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Form</title>
        <style><%@include file="WEB-INF/css/stylesheet.css"%></style>
        <script><%@include file="WEB-INF/js/js.js" %></script>
    </head>
    <body>
        <div class="Card_container">
            <form action="MainController" method="post" class="form_card" id="Reg_form">
                <h1>Register</h1>
                <!--gửi kiểu hành động-->
                <input type="hidden" name="action" value="register">

                <div class="box_text">
                    <input id="_1st" type="text" name="text_firstname" required placeholder="First name">
                    <input id="_2nd" type="text" name="text_lastname" required placeholder="Last name">
                </div>

                <div class="box_text">
                    <input type="text" name="text_email" required placeholder="Email">
                </div>

                <div class="box_text">
                    <input type="password" id="password" class="pass_key" required placeholder="Password">
                    <span class="show" onclick="togglePassword()">
                        <img src="icons/eye.png" alt="SHOW">
                    </span>
                </div>
                <div class="box_text">
                    <input type="password" id="confirmPassword" placeholder="Confirm Password">
                </div>

                <div id="passwordError" style="color: red;display: none;"></div> <!-- Thông báo lỗi -->

                <div class="field">
                    <input type="submit" value="REGISTER">
                </div>
            </form>
        </div>
    </body>
</html>

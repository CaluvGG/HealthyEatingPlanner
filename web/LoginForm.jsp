<%-- 
    Document   : LoginForm
    Created on : Jul 5, 2024, 4:18:37 PM
    Author     : MyPC
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LoginForm</title>
        <style><%@include file="WEB-INF/css/stylesheet.css"%></style>
        <script><%@include file="WEB-INF/js/js.js" %></script>
    </head>
    <body>

        <div class="Card_container">
            <form action="MainController" method="post" class="form_card">
                <h1>Login</h1>
                <!--gửi kiểu hành động-->
                <input type="hidden" name="action" value="login">

                <div class="box_text">
                    <input type="text" name="text_user" required placeholder="Email or Phone">
                </div>

                <div class="box_text">
                    <input type="password" name="text_pass" class="pass_key" required placeholder="Password">
                    <span class="show" onclick="togglePassword()">
                        <img src="icons/eye.png" alt="SHOW">
                    </span>
                </div>

                <div class="field">
                    <input type="submit" value="LOGIN">
                </div>
            </form>
        </div>

    </body>
</html>

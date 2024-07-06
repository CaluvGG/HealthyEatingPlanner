<%-- 
    Document   : LoginForm
    Created on : Jul 5, 2024, 4:18:37 PM
    Author     : MyPC
--%>

<%@page import="dbo.Users"%>
<%@page import="dao.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LoginForm</title>
    </head>
    <body>
        
        <div class="container">
            <form action="login" method="post" class="Login_card">
                <div>
                    <input type="text" name="text_user" required placeholder="Email or Phone">
                </div>
                <div>
                    <input type="password" name="text_pass" class="pass-key" required placeholder="Password">
                    <span class="show" onclick="togglePassword()">
                        <img src="icons/crossed-eye.png" alt="SHOW">
                    </span>
                </div>
                <div class="pass">
                    <a href="#">Forgot Password?</a>
                </div>
                <div class="field">
                    <input type="submit" value="LOGIN">
                </div>
            </form>
        </div>

    </body>
</html>

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
            <form action="MainController?action=register" method="post" class="form_card" id="Reg_form">
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
                    <input type="text" name="text_phone" required placeholder="Phone number">
                </div>

                <!--City and District dropdowns-->
                <div class="box_text">
                    <select name="text_city" id="citySelect" required onchange="updateDistrictOptions()">
                        <option value="" disabled selected>Select your city</option>
                        <option value="Ho Chi Minh">Ho Chi Minh</option>
                    </select>
                    <select name="text_district" id="districtSelect" required>
                        <option value="" disabled selected>Select your district</option>
                        <option value="District 1">District 1</option>
                        <option value="District 2">District 2</option>
                        <option value="District 3">District 3</option>
                        <option value="District 4">District 4</option>
                    </select>

                </div>

                <div class="box_text">
                    <input type="text" name="text_address" required placeholder="Address details">
                </div>

                <!--Set role for use-->
                <input type="hidden" name="text_role" value="1" /> 

                <div class="box_text">
                    <input type="password" id="password" class="pass_key" required placeholder="Password">
                    <span class="show" onclick="togglePassword()">
                        <img src="icons/eye.png" alt="SHOW">
                    </span>
                </div>
                <div class="box_text">
                    <input type="password" id="confirmPassword" name="text_password" placeholder="Confirm Password">
                </div>

                <div id="passwordError" style="color: red;display: none;"></div> <!-- Thông báo lỗi -->

                <c:if test="${not empty requestScope.DUBLICATE}">
                    <div style="color: red; position: absolute; bottom: 4.3em;left: 7.5em;" id="erro_msg">
                        ${requestScope.DUBLICATE}
                    </div>
                    <c:remove var="DUBLICATE" scope="request"/>
                </c:if>

                <div class="field">
                    <input type="submit" value="REGISTER">
                </div>
            </form>
        </div>
    </body>
</html>

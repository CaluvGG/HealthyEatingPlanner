/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import dbo.Users;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MyPC
 */
public class RegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String SUCCESS = "Home.jsp";
    private static final String FAIL = "RegisterForm.jsp";
    private static final String ERROR = "accessDenied.html";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String url = ERROR;
            try {
            String fname_user = request.getParameter("text_firstname");
            String lname_user = request.getParameter("text_lastname");
            String email_user = request.getParameter("text_email");
            String phone_user = request.getParameter("text_phone");
            /*for shipping*/
            String city_user = request.getParameter("text_city");
            String district_user = request.getParameter("text_district");

            String address_user = request.getParameter("text_address");
            String role_user = request.getParameter("text_role");
            String pass_user = request.getParameter("text_password");

            UserDAO d = new UserDAO();
            Users acc = d.getUserEmail(email_user);
            if (acc == null) {
                int result = d.addUser(fname_user, lname_user, email_user, phone_user, address_user, Integer.parseInt(role_user), pass_user);
                if (result > 0) {
                    url=SUCCESS;
                } else {
                    url=ERROR;
                }
            } else {
                String msg = "Duplicate Emails";
                request.setAttribute("DUBLICATE", msg);
               url=FAIL;
            } 
            } catch (Exception e) {
                log("Error at:" + e.toString());
            } finally {
                request.getRequestDispatcher(url).forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

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
import javax.servlet.http.HttpSession;

/**
 *
 * @author MyPC
 */
public class UpdateAccServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String SUCCESS = "Account.jsp";
    private static final String ERROR = "EditingAcc.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String url = ERROR;
            try {
                
            int id_user = Integer.parseInt(request.getParameter("text_id"));
            String fname_user = request.getParameter("text_firstname");
            String lname_user = request.getParameter("text_lastname");
            String email_user = request.getParameter("text_email");
            String phone_user = request.getParameter("text_phone");
            String address_user = request.getParameter("text_address");
            int role_user = Integer.parseInt(request.getParameter("text_role"));
            String newPass = request.getParameter("text_password");

            UserDAO d = new UserDAO();
            Users acc_sample = d.getUserEmail(email_user);
            
            if (acc_sample.getEmail().equalsIgnoreCase(email_user)) {
                int result = d.UpdateUser(fname_user, lname_user, acc_sample.getEmail(), phone_user, address_user, role_user, id_user,newPass);
                if (result > 0) {
                    HttpSession session=request.getSession(false);
                    session.setAttribute("Login_user", d.getUser(id_user));
                    url=SUCCESS;
                } else {
                    response.sendRedirect("accessDenied.html");
                }
            } else {
                Users acc = d.getUserEmail(email_user);
                if (acc == null) {
                    int result = d.UpdateUser(fname_user, lname_user, email_user, phone_user, address_user, role_user, id_user,newPass);
                    if (result > 0) {
                        url=SUCCESS;
                    } else {
                        response.sendRedirect("accessDenied.html");
                    }
                } else {
                    String msg = "Duplicate Emails";
                    request.setAttribute("DUBLICATE", msg);
                    url=ERROR;
                }
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

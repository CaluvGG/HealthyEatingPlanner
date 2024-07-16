/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MyPC
 */
public class MainController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String ERROR = "accessDenied.html";
    private static final String HOME = "home";
    private static final String HOMEPAGE = "Home.jsp";
    
    private static final String LOGIN = "login";
    private static final String LOGIN_SERV = "LoginServlet";
    
    private static final String REGISTER = "register";
    private static final String REGISTER_SERV = "RegisterServlet";
    
    private static final String LOGOUT = "logout";
    private static final String LOGOUT_SERV = "LogoutServlet";
    
    private static final String UPDATE_ACC = "update_acc";
    private static final String UPDATE_ACC_SERV = "UpdateAccServlet";
    
    private static final String CONFIRMPASS = "givePermissionEdit";
    private static final String CONFIRMPASS_SERV = "ConfirmUserServlet";
    
    private static final String DELETE_ACC = "delete_acct";
    private static final String DELETE_ACC_SERV = "DeleteServlet";
    
    private static final String MENU = "menu";
    private static final String MENU_SERV = "GetMealFromMenuServlet";
    
    private static final String SEARCH = "search";
    private static final String SEARCH_SERV = "SearchMenuServlet";
    
    private static final String VIEWORDER = "vieworder";
    private static final String VIEWORDER_SERV = "ViewOrderServlet";
  

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            if(action==null||action.isEmpty()||HOME.equalsIgnoreCase(action)) url = HOMEPAGE;
            else if (LOGIN.equalsIgnoreCase(action))url = LOGIN_SERV;
            else if (LOGOUT.equalsIgnoreCase(action))url = LOGOUT_SERV;
            else if (REGISTER.equalsIgnoreCase(action))url = REGISTER_SERV;
            else if (DELETE_ACC.equalsIgnoreCase(action))url = DELETE_ACC_SERV; 
            else if (UPDATE_ACC.equalsIgnoreCase(action))url = UPDATE_ACC_SERV;
            else if (MENU.equalsIgnoreCase(action))url = MENU_SERV + "?menuid=" + request.getParameter("menuid");
            else if (CONFIRMPASS.equalsIgnoreCase(action)) url=CONFIRMPASS_SERV;
            else if (SEARCH.equalsIgnoreCase(action))url = SEARCH_SERV;
            else if (VIEWORDER.equalsIgnoreCase(action))url = VIEWORDER_SERV+ "?userid=" + request.getParameter("userid");

        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
        } finally {
            if(url.equalsIgnoreCase(HOMEPAGE))response.sendRedirect(HOMEPAGE);
            else request.getRequestDispatcher(url).forward(request, response);
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

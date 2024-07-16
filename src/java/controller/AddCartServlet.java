/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MealDAO;
import dbo.Meals;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MyPC
 */
public class AddCartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String SUCCESS = "Menu.jsp";
    private static final String ERROR = "accessDenied.html";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String url = ERROR;
            try {
                int id = Integer.parseInt(request.getParameter("mealID"));
                MealDAO d = new MealDAO();
                Meals meal = d.getMeal(id);
//                Lay gio hang trong session
                HttpSession session = request.getSession();
                HashMap<Meals, Integer> List_cart = (HashMap<Meals, Integer>) session.getAttribute("CartUser");

                if (List_cart == null) {
                    List_cart = new HashMap<>();
                    List_cart.put(meal, 1);
                } else {
                    Meals find = null;
                    for (Meals tmp : List_cart.keySet()) {
                        if (tmp.getMealID() == id) {
                            find = tmp;
                            //find -> trỏ về địa chỉ lưu
                            //   id của t; 
                            //có quantity của t
                            break;
                            //find đang giữ thông tin của t
                            //t_ID là find_ID; Quan_find là Quan_t 
                        }
                    }
                    if (find != null) {
                        // Dòng này lấy số lượng của sản phẩm 'find' từ giỏ hàng
                        int quantity = List_cart.get(find);
                        quantity++;
                        List_cart.put(find, quantity);
                    } else {
                        List_cart.put(meal, 1);
                    }
                }
                session.setAttribute("CartUser", List_cart);

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

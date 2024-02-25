/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Cart;
import model.Item;
import model.SanPham;
import model.TaiKhoan;

/**
 *
 * @author Admin
 */
public class AddAmountCartControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        TaiKhoan a = (TaiKhoan) session.getAttribute("acc");
        if (a == null) {
            DAO dao = new DAO();
            List<SanPham> list = dao.getAllProduct();
            Cookie[] arr = request.getCookies();
            String txt = "";
            if (arr != null) {
                for (Cookie o : arr) {
                    if (o.getName().equals("cart")) {
                        txt += o.getValue();
                        o.setMaxAge(0);
                        response.addCookie(o);
                    }
                }
            }
            Cart cart = new Cart(txt, list);
            int productID = Integer.parseInt(request.getParameter("productID"));
            int amount = Integer.parseInt(request.getParameter("amount"));
            amount += 1;
            int quantity = dao.getQuantityByProductID(productID);
            if (amount > quantity) {
                Cookie c = new Cookie("cart", txt);
                c.setMaxAge(2 * 24 * 60 * 60);
                response.addCookie(c);
            } else {
                SanPham p = dao.getProductByID(request.getParameter("productID"));
                double price = p.getPrice();
                String size = cart.getItemById(productID).getSize();
                Item t = new Item(p, 1, price, size);
                cart.addItem(t);

                List<Item> items = cart.getItems();
                txt = "";
                if (items.size() > 0) {
                    txt = items.get(0).getProduct().getId() + ":"
                            + items.get(0).getQuantity() + ":"
                            + items.get(0).getSize();
                    for (int i = 1; i < items.size(); i++) {
                        txt += "&&" + items.get(i).getProduct().getId() + ":"
                                + items.get(i).getQuantity() + ":"
                                + items.get(i).getSize();
                    }
                }
                Cookie c = new Cookie("cart", txt);
                c.setMaxAge(2 * 24 * 60 * 60);
                response.addCookie(c);
            }
            response.sendRedirect("managerCart");
            return;
        }
        int accountID = a.getId();
        int productID = Integer.parseInt(request.getParameter("productID"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        amount += 1;
        DAO dao = new DAO();
        int quantity = dao.getQuantityByProductID(productID);
        if (amount > quantity) {
            request.setAttribute("mess", "Da het hang!");
        } else {
            dao.editAmountCart(accountID, productID, amount);
            request.setAttribute("mess", "Da tang so luong!");
        }
        request.getRequestDispatcher("managerCart").forward(request, response);
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

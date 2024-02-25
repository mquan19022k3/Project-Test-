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
import model.GioHang;
import model.SanPham;
import model.TaiKhoan;

/**
 *
 * @author Admin
 */
public class AddCartControl extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String num=request.getParameter("quantity");
        String id=request.getParameter("pid");
        int productID = Integer.parseInt(request.getParameter("pid"));
        int amount = Integer.parseInt(request.getParameter("quantity"));
        String size = request.getParameter("size");
        HttpSession session = request.getSession();
        TaiKhoan a = (TaiKhoan) session.getAttribute("acc");
        if(a == null) {
            DAO dao = new DAO();
            List<SanPham> list = dao.getAllProduct();
            Cookie[] arr = request.getCookies();
            String txt = "";
            if(arr!=null){
                for(Cookie o:arr){
                    if(o.getName().equals("cart")){
                        txt+=o.getValue();
                        o.setMaxAge(0);
                        response.addCookie(o);
                    }
                }
            }
            if(txt.isEmpty()){
                txt=id+":"+num+":"+size;
            }else{
                txt=txt+"&&"+id+":"+num+":"+size;
            }
            Cookie c=new Cookie("cart",txt);
            c.setMaxAge(2*24*60*60);
            response.addCookie(c);
            
            request.setAttribute("mess", "Da tang so luong san pham!");
            request.getRequestDispatcher("shop").forward(request, response);
            return;
        }
        int accountID = a.getId();
        
        
        DAO dao = new DAO();
        GioHang cartExisted = dao.checkCartExist(accountID,productID);
        int amountExisted;
        String sizeExisted;
        if(cartExisted != null) {
        	 amountExisted = cartExisted.getAmount();
        	 dao.editAmountAndSizeCart(accountID,productID, (amountExisted+amount), size);
        	 request.setAttribute("mess", "Da tang so luong san pham!");
        	 request.getRequestDispatcher("shop").forward(request, response);
        }
        else {
        	  dao.insertCart(accountID, productID, amount, size);
        	  request.setAttribute("mess", "Da them san pham vao gio hang!");
        	  request.getRequestDispatcher("shop").forward(request, response);
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

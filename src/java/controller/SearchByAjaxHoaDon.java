/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.HoaDon;
import model.TaiKhoan;

/**
 *
 * @author Admin
 */
public class SearchByAjaxHoaDon extends HttpServlet {
   
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
        HttpSession session = request.getSession();
        TaiKhoan b = (TaiKhoan) session.getAttribute("acc");
        if(b==null){
            request.getRequestDispatcher("login").forward(request, response);
            return;
        }
        String ngayXuat = request.getParameter("ngayXuat");
        DAO dao = new DAO();
        List<HoaDon> listInvoiceByDate = dao.searchByNgayXuat(ngayXuat);
        List<TaiKhoan> listAllAccount = dao.getAllAccount();
        PrintWriter out = response.getWriter(); 
        double tongGia;
        for (HoaDon o : listInvoiceByDate) {
        	for (TaiKhoan a : listAllAccount) {
        		if(o.getAccountID() == a.getId()) {	
        			tongGia=Math.round((o.getTongGia()) * 100.0) / 100.0;
        	out.println("<tr>\r\n"
        			+ "                  <th scope=\"row\"></th>\r\n"
        			+ "                  <td>"+o.getMaHD()+"</td>\r\n"
        			+ "                  <td>"+a.getUser()+"</td>\r\n"
        			+ "                  <td>"+tongGia+"</td>\r\n"
        			+ "                  <td>"+o.getNgayXuat()+"</td> \r\n"
                                + "                  <td ><a href=\"detailInvoice?invoiceID="+o.getMaHD()+"\" class=\"btn btn-success\">Chi tiết</a></td> \r\n"
        			+ "                </tr>");
        		}
        		}
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

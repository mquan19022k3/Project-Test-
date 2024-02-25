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
import java.util.List;
import model.SanPham;

/**
 *
 * @author Admin
 */
public class SearchAjaxColorBlueControl extends HttpServlet {
   
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
      
        DAO dao = new DAO();
        List<SanPham> list = dao.searchColorBlue();
        PrintWriter out = response.getWriter();
        for (SanPham o : list) {
        	out.println("              <div class=\"col-md-4 mb-5\"> "
        			+ "                <div class=\"\"> "
        			+ "                  <div class=\"view zoom overlay rounded z-depth-2\"> "
        			+ "                    <img class=\"img-fluid w-100\" "
        			+ "                      src=\""+o.getImage()+"\" alt=\"Sample\"> "
        			+ "                    <a href=\"detail?pid="+o.getId()+"\"> "
        			+ "                      <div class=\"mask\"> "
        			+ "                        <img class=\"img-fluid w-100\" "
        			+ "                          src=\""+o.getImage()+"\"> "
        			+ "                        <div class=\"mask rgba-black-slight\"></div> "
        			+ "                      </div> "
        			+ "                    </a> "
        			+ "                  </div> "
        			+ "                  <div class=\"text-center pt-4\"> "
        			+ "                    <h5>"+o.getTitle()+"</h5> "
        			+ "                    <p><span class=\"mr-1\"><strong>"+o.getPrice()+"VNĐ</strong></span></p> "
        			+ "                  </div> "
        			+ "                </div> "
        			+ "              </div>");
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

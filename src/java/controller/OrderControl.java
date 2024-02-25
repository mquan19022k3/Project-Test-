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
import java.util.Random;
import model.Cart;
import model.GioHang;
import model.Item;
import model.SanPham;
import model.SoLuongBan;
import model.TaiKhoan;
import model.TongChiTieu;

/**
 *
 * @author Admin
 */
public class OrderControl extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OrderControl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderControl at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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

        response.sendRedirect("DatHang.jsp");
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
        try {
            String emailAddress = request.getParameter("email");
            String name = request.getParameter("name");
            String phoneNumber = request.getParameter("phoneNumber");
            String deliveryAddress = request.getParameter("deliveryAddress");

            HttpSession session = request.getSession();
            TaiKhoan a = (TaiKhoan) session.getAttribute("acc");
            if (a == null) {
                DAO dao = new DAO();
                List<SanPham> list2 = dao.getAllProduct();
                Cookie[] arr = request.getCookies();
                String txt = "";
                if (arr != null) {
                    for (Cookie o : arr) {
                        if (o.getName().equals("cart")) {
                            txt += o.getValue();
                        }
                    }
                }

                Cart cart = new Cart(txt, list2);
                List<Item> list = cart.getItems();
                double totalMoney = 0;
                for (Item c : list) {
                    for (SanPham p : list2) {
                        if (c.getProduct().getId() == p.getId()) {
                            totalMoney = totalMoney + (p.getPrice() * c.getQuantity());
                        }
                    }
                }
                double totalMoneyVAT = totalMoney*0.93;

                double tongTienBanHangThem = 0;
                int sell_ID;
                for (Item c : list) {
                    for (SanPham p : list2) {
                        if (c.getProduct().getId() == p.getId()) {
                            tongTienBanHangThem = 0;
                            sell_ID = dao.getSellIDByProductID(p.getId());
                            tongTienBanHangThem = tongTienBanHangThem + (p.getPrice()*0.9 * c.getQuantity());
                            TongChiTieu t2 = dao.checkTongChiTieuBanHangExist(sell_ID);
                            if (t2 == null) {
                                dao.insertTongChiTieuBanHang(sell_ID, 0, tongTienBanHangThem);
                            } else {
                                dao.editTongBanHang(sell_ID, tongTienBanHangThem);
                            }
                        }
                    }
                }

                for (Item c : list) {
                    for (SanPham p : list2) {
                        if (c.getProduct().getId() == p.getId()) {
                            SoLuongBan s = dao.checkSoLuongDaBanExist(p.getId());
                            if (s == null) {
                                dao.insertSoLuongDaBan(p.getId(), c.getQuantity());
                            } else {
                                dao.editSoLuongDaBan(p.getId(), c.getQuantity());
                            }
                        }
                    }
                }
                String userRan= generateRandomString(6);
                while(dao.checkAccountExist1(userRan)){
                    userRan= generateRandomString(6);
                }
                
                for (Item c : list) {
                    for (SanPham p : list2) {
                        if (c.getProduct().getId() == p.getId()) {
                            int oldQuantity=dao.getQuantityByProductID(p.getId());
                            int newQuantity= oldQuantity-c.getQuantity();
                            
                            dao.editProductQuantity(p.getId(),newQuantity);
                        }
                    }
                }
                dao.insertAccountClient(userRan);
                int accountID= dao.getAccountIDByUser(userRan);
                dao.insertInvoice(accountID, totalMoneyVAT);
                int invoiceID = dao.getInvoiceIDByAccountID(accountID);
                for (Item c : list) {
                    for (SanPham p : list2) {
                        if (c.getProduct().getId() == p.getId()) {
                            dao.insertOrderLine(invoiceID, c.getProduct().getId(),totalMoneyVAT, c.getQuantity());
                        }
                    }
                }

                dao.insertInfoLine(invoiceID, name, emailAddress, deliveryAddress, phoneNumber);
                TongChiTieu t = dao.checkTongChiTieuBanHangExist(accountID);
                if (t == null) {
                    dao.insertTongChiTieuBanHang(accountID, totalMoneyVAT, 0);
                } else {
                    dao.editTongChiTieu(accountID, totalMoneyVAT);
                }

                
                request.setAttribute("mess", "Dat hang thanh cong!");
                
                if(arr!=null){
                for(Cookie o:arr){
                    if(o.getName().equals("cart")){                 
                        o.setMaxAge(0);
                        response.addCookie(o);
                    }
                }
            }

            } else {
                int accountID = a.getId();
                DAO dao = new DAO();
                List<GioHang> list = dao.getCartByAccountID(accountID);
                List<SanPham> list2 = dao.getAllProduct();

                double totalMoney = 0;
                for (GioHang c : list) {
                    for (SanPham p : list2) {
                        if (c.getProductID() == p.getId()) {
                            totalMoney = totalMoney + (p.getPrice() * c.getAmount());
                        }
                    }
                }
                double totalMoneyVAT = totalMoney*0.93;

                double tongTienBanHangThem = 0;
                int sell_ID;
                for (GioHang c : list) {
                    for (SanPham p : list2) {
                        if (c.getProductID() == p.getId()) {
                            tongTienBanHangThem = 0;
                            sell_ID = dao.getSellIDByProductID(p.getId());
                            tongTienBanHangThem = tongTienBanHangThem + (p.getPrice()*0.9* c.getAmount());
                            TongChiTieu t2 = dao.checkTongChiTieuBanHangExist(sell_ID);
                            if (t2 == null) {
                                dao.insertTongChiTieuBanHang(sell_ID, 0, tongTienBanHangThem);
                            } else {
                                dao.editTongBanHang(sell_ID, tongTienBanHangThem);
                            }
                        }
                    }
                }

                for (GioHang c : list) {
                    for (SanPham p : list2) {
                        if (c.getProductID() == p.getId()) {
                            SoLuongBan s = dao.checkSoLuongDaBanExist(p.getId());
                            if (s == null) {
                                dao.insertSoLuongDaBan(p.getId(), c.getAmount());
                            } else {
                                dao.editSoLuongDaBan(p.getId(), c.getAmount());
                            }
                        }
                    }
                }
               
                for (GioHang c : list) {
                    for (SanPham p : list2) {
                        if (c.getProductID() == p.getId()) {
                            int oldQuantity=dao.getQuantityByProductID(p.getId());
                            int newQuantity= oldQuantity-c.getAmount();
                            
                            dao.editProductQuantity(p.getId(),newQuantity);
                        }
                    }
                }

                dao.insertInvoice(accountID, totalMoneyVAT);
                int invoiceID = dao.getInvoiceIDByAccountID(accountID);
                for (GioHang c : list) {
                    for (SanPham p : list2) {
                        if (c.getProductID() == p.getId()) {
                            dao.insertOrderLine(invoiceID, c.getProductID(), totalMoneyVAT, c.getAmount());
                        }
                    }
                }

                dao.insertInfoLine(invoiceID, name, emailAddress, deliveryAddress, phoneNumber);
                TongChiTieu t = dao.checkTongChiTieuBanHangExist(accountID);
                if (t == null) {
                    dao.insertTongChiTieuBanHang(accountID, totalMoneyVAT, 0);
                } else {
                    dao.editTongChiTieu(accountID, totalMoneyVAT);
                }

               
                request.setAttribute("mess", "Dat hang thanh cong!");

                dao.deleteCartByAccountID(accountID);
            }

        } catch (Exception e) {
            request.setAttribute("error", "Dat hang that bai!");
            e.printStackTrace();
        }

        request.getRequestDispatcher("DatHang.jsp").forward(request, response);
    }
    
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    public static String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }

        return sb.toString();
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

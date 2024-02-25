/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Brand;
import model.GioHang;
import model.HoaDon;
import model.InfoLine;
import model.NhanXet;
import model.OrderLine;
import model.PhanLoai;
import model.SanPham;
import model.SoLuongBan;
import model.TaiKhoan;
import model.TongChiTieu;

/**
 *
 * @author Admin
 */
public class DAO extends DBContext {

    PreparedStatement ps = null;
    ResultSet rs = null;

    //1
    public List<SanPham> get8Last() {
        List<SanPham> list = new ArrayList<>();
        String query = "select top 8 * from SanPham order by id desc";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //2
    public List<SanPham> get4UniqloLast() {
        List<SanPham> list = new ArrayList<>();
        String query = "select top 4 * from SanPham where branID = 1 order by id desc";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //3
    public List<SanPham> get4BooLast() {
        List<SanPham> list = new ArrayList<>();
        String query = "select top 4 * from SanPham where branID = 4 order by id desc";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //4
    public List<SanPham> getNext4UniqloProduct(int amount) {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where branID=1 order by id desc offset ? rows fetch next 4 rows only";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, amount);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //5
    public List<SanPham> getNext4BooProduct(int amount) {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where branID=5 order by id desc offset ? rows fetch next 4 rows only";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, amount);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //6
    public List<SanPham> getAllProduct() {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //7
    public List<GioHang> getCartByAccountID(int accountID) {
        List<GioHang> list = new ArrayList<>();
        String query = "select * from GioHang where accountID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, accountID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new GioHang(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //8
    public List<PhanLoai> getAllPhanLoai() {
        List<PhanLoai> list = new ArrayList<>();
        String query = "select * from PhanLoai";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new PhanLoai(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //9
    public List<Brand> getAllBrand() {
        List<Brand> list = new ArrayList<>();
        String query = "select * from Brand";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Brand(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //10
    public List<SanPham> getProductByIndex(int indexPage) {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham order by [id] offset ? rows fetch next 9 rows only";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, (indexPage - 1) * 9);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //11
    public int countAllProduct() {
        String query = "select count(*) from SanPham";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    //12
    public List<SanPham> getProductByCID(String cid) {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where cateID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //13
    public List<SanPham> getProductByBID(String bid) {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where branID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, bid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //14
    public List<SanPham> searchByName(String txtSearch) {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where [name] like ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //15
    public List<SanPham> searchByPriceMinToMax(String priceMin, String priceMax) {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where [price] >=? and [price]<=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, priceMin);
            ps.setString(2, priceMax);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //16
    public List<SanPham> searchPriceUnder100() {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where [price] < 1000000";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //17
    public List<SanPham> searchPrice100To200() {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where [price] >= 1000000 and [price]<=2000000";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //18
    public List<SanPham> searchPriceAbove200() {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where [price] > 2000000";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //19
    public List<SanPham> searchColorWhite() {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where color = 'White'";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //20
    public List<SanPham> searchColorGray() {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where color = 'Gray'";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //21
    public List<SanPham> searchColorBlack() {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where color = 'Black'";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //22
    public List<SanPham> searchColorYellow() {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where color = 'Yellow'";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //23
    public List<SanPham> searchColorBlue() {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where color = 'Blue'";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //24
    public List<SanPham> searchColorGreen() {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where color = 'Green'";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //25
    public List<SanPham> searchColorBrown() {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where color = 'Brown'";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //26
    public List<SanPham> searchColorBeige() {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where color = 'Beige'";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //27
    public List<HoaDon> getAllInvoice() {
        List<HoaDon> list = new ArrayList<>();
        String query = "select * from HoaDon";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new HoaDon(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDouble(3),
                        rs.getDate(4)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //28
    public SanPham getProductByID(String id) {
        String query = "select * from SanPham where id = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new SanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16));
            }
        } catch (Exception e) {
        }
        return null;
    }

    //29
    public int getCateIDByProductID(String id) {
        String query = "select [cateID] from SanPham where [id] =?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    //30
    public List<SanPham> getRelatedProduct(int cateIDProductDetail) {
        List<SanPham> list = new ArrayList<>();
        String query = "select top 4 * from SanPham where [cateID] =? order by id desc";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, cateIDProductDetail);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //31
    public List<NhanXet> getAllReviewByProductID(String productId) {
        List<NhanXet> list = new ArrayList<>();
        String query = "select * from NhanXet where [productID] =?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, productId);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new NhanXet(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getInt(5)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //32
    public List<TaiKhoan> getAllAccount() {
        List<TaiKhoan> list = new ArrayList<>();
        String query = "select * from TaiKhoan";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TaiKhoan(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //33
    public SanPham getLast() {
        String query = "select top 1 * from SanPham order by id desc";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new SanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16));
            }
        } catch (Exception e) {
        }
        return null;
    }

    //34
    public void insertReview(int accountID, int productID, String contentReview) {
        String query = "insert NhanXet(accountID, productID, contentReview, dateReview) values(?,?,?,?)";

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, accountID);
            ps.setInt(2, productID);
            ps.setString(3, contentReview);
            ps.setDate(4, getCurrentDate());
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    //35
    public NhanXet getNewReview(int accountID, int productID) {
        String query = "select top 1 * from NhanXet where accountID = ? and productID = ? order by maReview desc";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, accountID);
            ps.setInt(2, productID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new NhanXet(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;
    }

    //36
    public TaiKhoan login(String user, String pass) {
        String query = "select * from TaiKhoan where [user] = ? and pass = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new TaiKhoan(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    //37
    public TaiKhoan checkAccountExist(String user) {
        String query = "select * from TaiKhoan where [user] = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new TaiKhoan(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    //38
    public void signup(String user, String pass, String email) {
        String query = "insert into TaiKhoan values(?,?,0,0,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, email);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //39
    public TaiKhoan checkAccountExistByUsernameAndEmail(String username, String email) {
        String query = "select * from TaiKhoan where [user]=? and [email]=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new TaiKhoan(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    //40
    public void editProfile(String username, String password, String email, int uID) {
        String query = "update TaiKhoan set [user]=?, [pass]=?, [email]=? where [uID] = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setInt(4, uID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //41
    public List<SanPham> getProductBySellIDAndIndex(int id, int indexPage) {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where sell_ID = ? order by [id] offset ? rows fetch next 5 rows only";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.setInt(2, (indexPage - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //42 
    public int countAllProductBySellID(int sell_ID) {
        String query = "select count(*) from SanPham where sell_ID=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, sell_ID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    //43
    public void editProduct(String pname, String pimage, String pprice, String pquantity, String ptitle, String pdescription, String pcategory, String pbrand,
            String pmodel, String pcolor,
            String pdelivery, String pimage2, String pimage3, String pimage4, String pid) {
        String query = "update SanPham set [name] = ?, [image] = ?, price = ?, quantity = ?, title = ?, [description] = ?, cateID = ?, branID = ?, model= ?, "
                + "color= ?, delivery=?, image2=?, image3=?, image4=? where [id] = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, pname);
            ps.setString(2, pimage);
            ps.setString(3, pprice);
            ps.setString(4, pquantity);
            ps.setString(5, ptitle);
            ps.setString(6, pdescription);
            ps.setString(7, pcategory);
            ps.setString(8, pbrand);
            ps.setString(9, pmodel);
            ps.setString(10, pcolor);
            ps.setString(11, pdelivery);
            ps.setString(12, pimage2);
            ps.setString(13, pimage3);
            ps.setString(14, pimage4);
            ps.setString(15, pid);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Loi:"+e.getMessage());

        }
    }

    //44
    public void insertProduct(String name, String image, String price,String quantity,
            String title, String description, String category, String brand, String sellID, String model, String color, String delivery, String image2, String image3, String image4) {
        String query = "insert SanPham([name],[image],[price],[quantity],[title], "
                + "[description],[cateID],[branID],[sell_ID],[model], "
                + "[color],[delivery],[image2],[image3],[image4]) "
                + "values(N'" + name + "','" + image + "','" + price + "','" + quantity + "',N'" + title + "',N'" + description + "','" + category + "','" + brand + "','" + sellID + "',N'" + model + "',N'" + color + "',N'" + delivery + "','" + image2 + "','" + image3 + "','" + image4 + "')";
        try {
            ps = connection.prepareStatement(query);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi:"+e.getMessage());

        }
    }

    //45
    public void deleteCartByProductID(String productID) {
        String query = "delete from GioHang where [productID]=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, productID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //46
    public void deleteReviewByProductID(String productID) {
        String query = "delete from NhanXet where [productID] = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, productID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //47
    public void deleteSoLuongDaBanByProductID(String productID) {
        String query = "delete from SoLuongBan where [productID]=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, productID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //48
    public void deleteProduct(String pid) {
        String query = "delete from SanPham where [id] = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //49
    public int checkAccountAdmin(int userID) {

        String query = "select isAdmin from TaiKhoan where [uID]=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, userID);

            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {

        }
        return 0;
    }

    //50
    public double totalMoneyDay(int day) {
        String query = "select SUM(tongGia) from HoaDon where DATEPART(dw,[ngayXuat]) = ? Group by ngayXuat ";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, day);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    //51
    public double totalMoneyMonth(int month) {
        String query = "select SUM(tongGia) from HoaDon where MONTH(ngayXuat)=? Group by MONTH(ngayXuat)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, month);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    //52
    public int countAllReview() {
        String query = "select count(*) from NhanXet";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    //53
    public double sumAllInvoice() {
        String query = "select SUM(tongGia) from HoaDon";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    //54
    public void insertAccount(String user, String pass, String isSell,
            String isAdmin, String email) {
        String query = "insert TaiKhoan([user], pass, isSell, isAdmin, email) values(?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, isSell);
            ps.setString(4, isAdmin);
            ps.setString(5, email);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //55
    public void deleteCartByAccountID(int accountID) {
        String query = "delete from GioHang where [accountID]=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, accountID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //56
    public void deleteProductBySellID(String id) {
        String query = "delete from SanPham where [sell_ID] = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //57
    public void deleteReviewByAccountID(String id) {
        String query = "delete from NhanXet where [accountID] = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //58
    public void deleteInvoiceByAccountId(String id) {
        String query = "delete from HoaDon where [accountID] = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //59
    public void deleteTongChiTieuBanHangByUserID(String id) {
        String query = "delete from TongChiTieu where [userID] = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //60
    public void deleteAccount(String id) {
        String query = "delete from TaiKhoan where uID= ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //61
    public List<SoLuongBan> getTop10SanPhamBanChay() {
        List<SoLuongBan> list = new ArrayList<>();
        String query = "select top(10) * from SoLuongBan order by soLuongDaBan desc";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SoLuongBan(rs.getInt(1),
                        rs.getInt(2)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //62
    public List<TongChiTieu> getTop5KhachHang() {
        List<TongChiTieu> list = new ArrayList<>();
        String query = "select top(5) * from TongChiTieu order by TongChiTieu desc";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TongChiTieu(rs.getInt(1),
                        rs.getDouble(2),
                        rs.getDouble(3)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //63
    public List<TongChiTieu> getTop5NhanVien() {
        List<TongChiTieu> list = new ArrayList<>();
        String query = "select top(5) * from TongChiTieu order by TongBanHang desc";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TongChiTieu(rs.getInt(1),
                        rs.getDouble(2),
                        rs.getDouble(3)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //64
    public int getQuantityByProductID(int ProductID) {
        String query = "select [quantity] from SanPham where [id] =?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, ProductID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    //65
    public void editAmountCart(int accountID, int productID, int amount) {
        String query = "update GioHang set [amount]=? where [accountID]=? and [productID]=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, amount);
            ps.setInt(2, accountID);
            ps.setInt(3, productID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //66
    public GioHang checkCartExist(int accountID, int productID) {

        String query = "select * from GioHang where [accountID] = ? and [productID] = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, accountID);
            ps.setInt(2, productID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new GioHang(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5));
            }
        } catch (Exception e) {
        }
        return null;
    }

    //67
    public void editAmountAndSizeCart(int accountID, int productID, int amount, String size) {
        String query = "update GioHang set [amount]=?, [size]=? where [accountID]=? and [productID]=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, amount);
            ps.setString(2, size);
            ps.setInt(3, accountID);
            ps.setInt(4, productID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //68
    public void insertCart(int accountID, int productID, int amount, String size) {
        String query = "insert GioHang(accountID, productID, amount,size) values(?,?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, accountID);
            ps.setInt(2, productID);
            ps.setInt(3, amount);
            ps.setString(4, size);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //69
    public void deleteCart(int productID) {
        String query = "delete from GioHang where productID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, productID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //70
    public void deleteCartByAccountIDAndProductID(int accountID, int productID) {
        String query = "delete from GioHang where [accountID]=? and [productID]=? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, accountID);
            ps.setInt(2, productID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //71   
    public int getSellIDByProductID(int productID) {
        String query = "select sell_ID from SanPham where [id]=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, productID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    //72
    public TongChiTieu checkTongChiTieuBanHangExist(int userID) {

        String query = "select * from TongChiTieu where [userID]=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, userID);

            rs = ps.executeQuery();
            while (rs.next()) {
                return new TongChiTieu(rs.getInt(1),
                        rs.getDouble(2),
                        rs.getDouble(3)
                );
            }
        } catch (Exception e) {
        }
        return null;
    }

    //73
    public void insertTongChiTieuBanHang(int userID, double tongChiTieu, double tongBanHang) {
        String query = "insert TongChiTieu(userID,TongChiTieu,TongBanHang) values(?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, userID);
            ps.setDouble(2, tongChiTieu);
            ps.setDouble(3, tongBanHang);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //74
    public void editTongBanHang(int sell_ID, double tongTienBanHangThem) {
        String query = "exec dbo.proc_CapNhatTongBanHang ?,?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, sell_ID);
            ps.setDouble(2, tongTienBanHangThem);

            ps.executeUpdate();

        } catch (Exception e) {

        }
    }

    //75
    public SoLuongBan checkSoLuongDaBanExist(int productID) {

        String query = "select * from SoLuongBan where productID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, productID);

            rs = ps.executeQuery();
            while (rs.next()) {
                return new SoLuongBan(rs.getInt(1),
                        rs.getInt(2)
                );
            }
        } catch (Exception e) {
        }
        return null;
    }

    //76
    public void insertSoLuongDaBan(int productID, int soLuongDaBan) {
        String query = "insert SoLuongBan(productID,soLuongDaBan) values(?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, productID);
            ps.setInt(2, soLuongDaBan);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //77
    public void editSoLuongDaBan(int productID, int soLuongBanThem) {
        String query = "exec dbo.proc_CapNhatSoLuongDaBan ?,?";
        try {
            ps = connection.prepareStatement(query);;
            ps.setInt(1, productID);
            ps.setInt(2, soLuongBanThem);

            ps.executeUpdate();

        } catch (Exception e) {

        }
    }

    //78
    public boolean checkAccountExist1(String user) {
        String query = "select * from TaiKhoan where [user] = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    //79
    public void editProductQuantity(int id, int quantity) {
        String query = "update SanPham set [quantity]=? where [id] = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, quantity);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //80
    public void insertAccountClient(String user) {
        String query = "insert into TaiKhoan values(?,'',0,0,'')";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //81   
    public int getAccountIDByUser(String user) {
        String query = "select [uID] from TaiKhoan where [user] =?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    //82
    public void insertInvoice(int accountID, double tongGia) {
        String query = "insert HoaDon(accountID,tongGia,ngayXuat) values(?,?,?)";

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, accountID);
            ps.setDouble(2, tongGia);
            ps.setDate(3, getCurrentDate());
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }

    //83
    public int getInvoiceIDByAccountID(int accountID) {
        String query = "select top 1 maHD from HoaDon where [accountID]=? order by maHD desc";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, accountID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {

        }
        return 0;
    }

    //84
    public void insertOrderLine(int invoiceID, int productID, double price, int quantity) {
        String query = "insert OrderLine(invoiceID, productID, price, quantity) values(?,?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, invoiceID);
            ps.setInt(2, productID);
            ps.setDouble(3, price);
            ps.setInt(4, quantity);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //85
    public void insertInfoLine(int invoiceID, String name, String email, String address, String phoneNumber) {
        String query = "insert InfoLine(invoiceID, name, email, address, phonenumber) values(?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, invoiceID);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setString(4, address);
            ps.setString(5, phoneNumber);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //86
    public void editTongChiTieu(int accountID, double totalMoneyVAT) {
        String query = "exec dbo.proc_CapNhatTongChiTieu ?,?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, accountID);
            ps.setDouble(2, totalMoneyVAT);

            ps.executeUpdate();

        } catch (Exception e) {

        }
    }

    //87
    public List<HoaDon> searchByNgayXuat(String ngayXuat) {
        List<HoaDon> list = new ArrayList<>();
        String query = "select * from HoaDon where [ngayXuat] ='" + ngayXuat + "'";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new HoaDon(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDouble(3),
                        rs.getDate(4)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //88
    public List<InfoLine> getInfoLineByInvoiceID(String invoiceID) {
        List<InfoLine> list = new ArrayList<>();
        String query = "select * from InfoLine where invoiceID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, invoiceID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new InfoLine(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //89
    public List<OrderLine> getOrderLineByInvoiceID(String invoiceID) {
        List<OrderLine> list = new ArrayList<>();
        String query = "select * from OrderLine where invoiceID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, invoiceID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderLine(rs.getInt(1),
                        rs.getInt(2),
                        rs.getFloat(3),
                        rs.getInt(4)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //90
    public List<HoaDon> getInvoiceByAccountID(int accountID) {
        List<HoaDon> list = new ArrayList<>();
        String query = "select * from HoaDon where accountID=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, accountID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new HoaDon(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDouble(3),
                        rs.getDate(4)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    //91   
    public TaiKhoan getAccountByuID(String uID) {
        String query = "select * from TaiKhoan where [uID] =?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, uID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new TaiKhoan(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    //Thêm
    //1
    public List<SanPham> getTop3() {
        List<SanPham> list = new ArrayList<>();
        String query = "select top 3 * from SanPham";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //2
    public List<SanPham> getNext3Product(int amount) {
        List<SanPham> list = new ArrayList<>();
        String query = "SELECT * FROM Product ORDER BY id OFFSET ? ROWS FETCH NEXT 3 ROWS ONLY";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, amount);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    private static java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class TongChiTieu {
	 private int userID;
	 private double tongChiTieu;
	 private double tongBanHang;
	public TongChiTieu(int userID, double tongChiTieu, double tongBanHang) {
		
		this.userID = userID;
		this.tongChiTieu = tongChiTieu;
		this.tongBanHang = tongBanHang;
	}
	public TongChiTieu() {
		
	}
	@Override
	public String toString() {
		return "TongChiTieuBanHang [userID=" + userID + ", tongChiTieu=" + tongChiTieu + ", tongBanHang=" + tongBanHang
				+ "]";
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public double getTongChiTieu() {
		return tongChiTieu;
	}
	public void setTongChiTieu(double tongChiTieu) {
		this.tongChiTieu = tongChiTieu;
	}
	public double getTongBanHang() {
		return tongBanHang;
	}
	public void setTongBanHang(double tongBanHang) {
		this.tongBanHang = tongBanHang;
	}
	
}

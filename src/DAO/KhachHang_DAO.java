package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.KhachHang;

public class KhachHang_DAO {
    public KhachHang_DAO() {    }

    public ArrayList<KhachHang> layTayCaKhachHang() {
		ArrayList<KhachHang> danhSachKhachHang = new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT * FROM KhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maNhanVien = rs.getString("maKhachHang");
				java.sql.Date ngaySinh = rs.getDate("ngaySinh");
				String hoTen = rs.getString("hoTen");
				Boolean gioiTinh = rs.getBoolean("gioiTinh");
				String SoDienThoai = rs.getString("soDienThoai");
				String diaChi = rs.getString("diaChi");
                int diemThuong = rs.getInt("diemThuong");
				String anhThe = rs.getString("ghiChu");
				KhachHang kh = new KhachHang(maNhanVien, hoTen, gioiTinh, ngaySinh, diaChi, SoDienThoai, diemThuong, anhThe);
				danhSachKhachHang.add(kh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachKhachHang;
	}
}

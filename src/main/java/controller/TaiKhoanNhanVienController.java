/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import model.TaiKhoanNhanVien;
import java.util.List;
import DBConnection.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TaiKhoanNhanVIenFull;

/**
 *
 * @author Nong_Tien_Son
 */
public class TaiKhoanNhanVienController {

    public TaiKhoanNhanVien selectByModel(TaiKhoanNhanVien model) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        TaiKhoanNhanVien tknv = null;

        try {
            connection = DatabaseConnection.getConnection();
            StringBuilder selectQuery = new StringBuilder("SELECT Ma_NhanVien, SoDienThoai, MatKhau FROM TaiKhoanNhanVien WHERE SoDienThoai = ? AND MatKhau = ?");

            statement = connection.prepareStatement(selectQuery.toString());
            statement.setString(1, model.getSoDienThoai());
            statement.setString(2, model.getMatKhau());

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                tknv = new TaiKhoanNhanVien();
                tknv.setMa_NhanVien(resultSet.getString("Ma_NhanVien"));
                tknv.setSoDienThoai(resultSet.getString("SoDienThoai"));
                tknv.setMatKhau(resultSet.getString("MatKhau"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return tknv;
    }

    public List<TaiKhoanNhanVIenFull> selectNhanVienFull(String ID_Key) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<TaiKhoanNhanVIenFull> tknvifs = new ArrayList<>();
        try {
            connection = DatabaseConnection.getConnection();
//            StringBuilder selectQuery = null;
//            if(ID_Key.equalsIgnoreCase("KhongCoGiCa")){
//                selectQuery = new StringBuilder("SELECT * FROM TaiKhoanNhanVien\n "
//                    + "INNER JOIN ChucVuNhanVien ON ChucVuNhanVien.Ma_NhanVien = TaiKhoanNhanVien.Ma_NhanVien\n"
//                    + "INNER JOIN ThongTinNhanVien ON ThongTinNhanVien.Ma_NhanVien = TaiKhoanNhanVien.Ma_NhanVien\n");
//                  
//            }else{
//                selectQuery = new StringBuilder("SELECT * FROM TaiKhoanNhanVien \n"
//                    + "INNER JOIN ChucVuNhanVien ON ChucVuNhanVien.Ma_NhanVien = TaiKhoanNhanVien.Ma_NhanVien\n"
//                    + "INNER JOIN ThongTinNhanVien ON ThongTinNhanVien.Ma_NhanVien = TaiKhoanNhanVien.Ma_NhanVien\n"
//                    + "WHERE TaiKhoanNhanVien.Ma_NhanVien = ?");
//            }
            StringBuilder selectQuery = new StringBuilder("SELECT * FROM TaiKhoanNhanVien\n" +
"                    INNER JOIN ChucVuNhanVien ON ChucVuNhanVien.SoDienThoai= TaiKhoanNhanVien.SoDienThoai\n" +
"                    INNER JOIN ThongTinNhanVien ON ThongTinNhanVien.SoDienThoai = TaiKhoanNhanVien.SoDienThoai");

            if (!ID_Key.equalsIgnoreCase("KhongCoGiCa")) {
                selectQuery.append("\nWHERE TaiKhoanNhanVien.Ma_NhanVien = ?");
            }

            statement = connection.prepareStatement(selectQuery.toString());
            if (ID_Key.equalsIgnoreCase("KhongCoGiCa")) {

            } else {
                statement.setString(1, ID_Key);
            }

            resultSet = statement.executeQuery();
            TaiKhoanNhanVIenFull tknv = null;
            while (resultSet.next()) {
                tknv = new TaiKhoanNhanVIenFull();
                tknv.setMa_NhanVien(resultSet.getString("Ma_NhanVien"));
                tknv.setSoDienThoai(resultSet.getString("SoDienThoai"));
                tknv.setMatKhau(resultSet.getString("MatKhau"));
                tknv.setVaiTro(resultSet.getBoolean("VaiTro"));
                tknv.setNgayTao(resultSet.getDate("NgayTao"));
                tknv.setNgaySua(resultSet.getDate("NgaySua"));
                tknv.setTrangThai(resultSet.getBoolean("TrangThai"));
                tknv.setHoTen(resultSet.getString("HoTen"));
                tknv.setGioiTinh(resultSet.getBoolean("GioiTinh"));
                tknv.setNgaySinh(resultSet.getDate("NgaySinh"));
                tknv.setDiaChi(resultSet.getString("DiaChi"));
                tknv.setEmail(resultSet.getString("Email"));
                tknvifs.add(tknv);
            }
            return tknvifs;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return null;
    }

}

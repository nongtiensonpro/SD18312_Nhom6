/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DBConnection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.DoiMatKhau;
import model.MaXacNhanTaiKhoan;
import model.TaiKhoanNhanVien;

/**
 *
 * @author Nong_Tien_Son
 */
public class QuenMatKhauController {

    public MaXacNhanTaiKhoan timMaXacNhan(String maXacNhanInput) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        MaXacNhanTaiKhoan mxntk = new MaXacNhanTaiKhoan();

        try {
            connection = DatabaseConnection.getConnection();
            StringBuffer selectQuery = new StringBuffer("SELECT Ma_MaXacNhan,"
                    + "TrangThai FROM MaXacNhanTaiKhoan WHERE Ma_MaXacNhan = ?");
            statement = connection.prepareCall(selectQuery.toString());
            statement.setString(1, maXacNhanInput);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                mxntk.setMaMaXacNhan(resultSet.getString("Ma_MaXacNhan"));
                mxntk.setTrangThai(resultSet.getBoolean("TrangThai"));
            }
            return mxntk;
        } catch (Exception e) {
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

    public boolean capNhatMatKhau(DoiMatKhau doiMatKhau) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.getConnection();

            // Tạo câu lệnh SQL
            String sql = "UPDATE MaXacNhanTaiKhoan "
                    + "SET TrangThai = 0, "
                    + "    SoDienThoai = ?, "
                    + "    NgaySuDung = GETDATE() "
                    + "WHERE Ma_MaXacNhan = ?; "
                    + "UPDATE TaiKhoanNhanVien "
                    + "SET MatKhau = ? "
                    + "WHERE SoDienThoai = ?";

            // Chuẩn bị câu lệnh
            statement = connection.prepareStatement(sql);

            // Thiết lập tham số cho câu lệnh SQL
            statement.setString(1, doiMatKhau.getSoDienThoai());
            statement.setString(2, doiMatKhau.getMaXacNhan());
            statement.setString(3, doiMatKhau.getMatKhauNew());
            statement.setString(4, doiMatKhau.getSoDienThoai());

            // Thực thi câu lệnh
            int rowsAffected = statement.executeUpdate();

            // Kiểm tra xem có dòng nào bị ảnh hưởng hay không
            if (rowsAffected > 0) {
                return true; // Trả về true nếu có dòng bị ảnh hưởng
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối và giải phóng tài nguyên
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false; // Trả về false nếu không có dòng nào bị ảnh hưởng
    }

}

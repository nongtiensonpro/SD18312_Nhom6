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

/**
 *
 * @author Nong_Tien_Son
 */
public class TaiKhoanNhanVienController extends YellowCatDAO<TaiKhoanNhanVien, String> {

    @Override
    public void insert(TaiKhoanNhanVien model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(TaiKhoanNhanVien model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String ID_Key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
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

    @Override
    public String selectByID(String ID_Key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

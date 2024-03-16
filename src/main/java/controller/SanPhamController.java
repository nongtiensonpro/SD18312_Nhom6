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
import java.util.ArrayList;
import java.util.List;
import model.SanPhamModel;

/**
 *
 * @author LENHATLINH
 */
public class SanPhamController {
    public List<SanPhamModel> timkiemSanPham() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        SanPhamModel sp = null;

        List<SanPhamModel> danhsachTenSanPham = new ArrayList<>();
        try {
            connection = DatabaseConnection.getConnection();
            String caulenhtruyvan = new String("select * from SanPham");
             statement = connection.prepareStatement(caulenhtruyvan);
             
             resultSet = statement.executeQuery();
             while(resultSet.next()){
                 sp = new SanPhamModel();
                 sp.setMaSanPham(resultSet.getString("MaSanPham"));
                 sp.setTen(resultSet.getString("Ten"));
                 sp.setMoTa(resultSet.getString("MoTa"));
                 sp.setNgayTao(resultSet.getDate("NgayTao"));
                 sp.setNgaySua(resultSet.getDate("NgaySua"));
                 sp.setTrangThai(resultSet.getBoolean("TrangThai"));
                 danhsachTenSanPham.add(sp);
             }
             return danhsachTenSanPham;
        } catch (Exception e) {
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
    public Boolean themTenSanPham(SanPhamModel sanPhamtruyenvao){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
             connection = DatabaseConnection.getConnection();
             String caulenhthem = new String("INSERT INTO [dbo].[SanPham]\n" +
"           ([MaSanPham]\n" +
"           ,[Ten]\n" +
"           ,[MoTa]\n" +
"           ,[NgayTao]\n" +
"           ,[NgaySua]\n" +
"           ,[TrangThai])\n" +
"     VALUES\n" +
"           (?,\n" +
"           ?,\n" +
"           ?,\n" +
"           ?,\n" +
"           ?,\n" +
"           ?)");
             statement = connection.prepareStatement(caulenhthem);
             statement.setString(1, sanPhamtruyenvao.getMaSanPham());
             statement.setString(2, sanPhamtruyenvao.getTen());
             statement.setString(3, sanPhamtruyenvao.getMoTa());            
             statement.setDate(4, sanPhamtruyenvao.getNgayTao());
             statement.setDate(5, sanPhamtruyenvao.getNgaySua());
             statement.setBoolean(6, sanPhamtruyenvao.getTrangThai());
             statement.executeUpdate();
             return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
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
        
    }
    public Boolean suaTenSanPham(SanPhamModel spModel){
         Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = DatabaseConnection.getConnection();
            String caulenhUpdate = new String("UPDATE [dbo].[SanPham]\n" +
"   SET [MaSanPham] = <MaSanPham>\n" +
"      [Ten]=?\n" +
"      ,[MoTa]=?\n" +
"      ,[NgayTao]=?\n" +
"      ,[NgaySua]=?\n" +
"      ,[TrangThai]=?\n" +
"      WHERE=?"
            );
             statement = connection.prepareStatement(caulenhUpdate);
//             statement.setString(1, spModel.getMaHang());
             statement.setString(1, spModel.getMaSanPham());
             statement.setString(2, spModel.getTen());
             statement.setString(3, spModel.getMoTa());
             statement.setDate(4, spModel.getNgayTao());
             statement.setDate(5, spModel.getNgaySua());
             statement.setBoolean(6, spModel.getTrangThai());
             statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
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
    }
}

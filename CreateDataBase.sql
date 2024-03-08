/**
 *
 * @author Nong_Tien_Son
 */
USE MASTER

GO

CREATE DATABASE SD18312_TEAM_6

GO

CREATE TABLE TaiKhoanNhanVien (
    Ma_NhanVien VARCHAR(36) PRIMARY KEY DEFAULT NEWID(),
    SoDienThoai VARCHAR(20) UNIQUE,
    MatKhau VARCHAR(50)
)
-- SELECT Ma_NhanVien,SoDienThoai,MatKhau FROM TaiKhoanNhanVien WHERE SoDienThoai = '0987654321' AND MatKhau = 'hashedpassword1'
GO
CREATE TABLE ThongTinNhanVien(
    Ma_NhanVien VARCHAR(36) PRIMARY KEY,
    HoTen NVARCHAR(35),
    GioiTinh BIT,
    NgaySinh DATE,
    DiaChi NVARCHAR(255),
    Email VARCHAR(35)
)
GO
SELECT * FROM ThongTinNhanVien
INSERT INTO ThongTinNhanVien (Ma_NhanVien,HoTen,GioiTinh,NgaySinh,DiaChi,Email)
VALUES 
('B95EFBB9-26DA-452A-8131-3FF08A96FEEC', N'Nông Tiến Sơn',1,GETDATE(),N'Hà Nội','nongtiensonpro@gmail.com')
GO
CREATE TABLE ChucVuNhanVien(
    Ma_NhanVien VARCHAR(36) PRIMARY KEY,
    VaiTro BIT,
    NgayTao DATE,
    NgaySua DATE,
    TrangThai BIT
)
SELECT * FROM TaiKhoanNhanVien 
INNER JOIN ChucVuNhanVien ON ChucVuNhanVien.Ma_NhanVien = TaiKhoanNhanVien.Ma_NhanVien
INNER JOIN ThongTinNhanVien ON ThongTinNhanVien.Ma_NhanVien = TaiKhoanNhanVien.Ma_NhanVien
WHERE TaiKhoanNhanVien.Ma_NhanVien = 'B95EFBB9-26DA-452A-8131-3FF08A96FEEC'
-- Dữ liệu cho bảng TaiKhoanNhanVien
INSERT INTO TaiKhoanNhanVien (SoDienThoai, MatKhau)
VALUES 
('0987654321', 'hashedpassword1'),
('0123456789', 'hashedpassword2'),
('0369852147', 'hashedpassword3'),
('0901234567', 'hashedpassword4'),
('0912345678', 'hashedpassword5');

INSERT INTO TaiKhoanNhanVien (SoDienThoai, MatKhau)
VALUES 
('123456789', '123456789')
SELECT * FROM [dbo].[TaiKhoanNhanVien]
SELECT Ma_NhanVien, SoDienThoai, MatKhau FROM TaiKhoanNhanVien WHERE SoDienThoai = '123456789' AND MatKhau = '123456789'
INSERT INTO ChucVuNhanVien (Ma_NhanVien, VaiTro,NgayTao,NgaySua,TrangThai)
VALUES 
('B95EFBB9-26DA-452A-8131-3FF08A96FEEC', 1,GETDATE(),GETDATE(),1)
SELECT * FROM ChucVuNhanVien
in
-- -- Dữ liệu cho bảng ThongTinNhanVien
-- INSERT INTO ThongTinNhanVien (Ma_NhanVien, HoTen, GioiTinh, NgaySinh, DiaChi, Email)
-- VALUES 
-- ('NV001', N'Nguyễn Văn A', 1, '1990-05-15', N'Hà Nội', 'nva@example.com'),
-- ('NV002', N'Trần Thị B', 0, '1985-10-20', N'Hồ Chí Minh', 'ttb@example.com'),
-- ('NV003', N'Lê Văn C', 1, '1988-03-25', N'Đà Nẵng', 'lvc@example.com'),
-- ('NV004', N'Phạm Thị D', 0, '1995-12-10', N'Hải Phòng', 'ptd@example.com'),
-- ('NV005', N'Huỳnh Văn E', 1, '1992-07-05', N'Cần Thơ', 'hve@example.com');

-- -- Dữ liệu cho bảng ChucVuNhanVien
-- INSERT INTO ChucVuNhanVien (Ma_NhanVien, VaiTro, NgayTao, NgaySua, TrangThai)
-- VALUES 
-- ('NV001', 1, '2023-01-01', '2023-05-10', 1),
-- ('NV002', 0, '2023-02-15', '2023-06-20', 1),
-- ('NV003', 1, '2023-03-20', '2023-07-30', 1),
-- ('NV004', 0, '2023-04-05', '2023-08-12', 0),
-- ('NV005', 1, '2023-05-08', '2023-09-25', 1);

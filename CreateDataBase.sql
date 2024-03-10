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
SELECT * FROM TaiKhoanNhanVien
GO
CREATE TABLE ThongTinNhanVien(
    SoDienThoai VARCHAR(20)  PRIMARY KEY,
    HoTen NVARCHAR(35),
    GioiTinh BIT,
    NgaySinh DATE,
    DiaChi NVARCHAR(255),
    Email VARCHAR(35)
)
GO
CREATE TABLE ChucVuNhanVien(
    SoDienThoai VARCHAR(20) PRIMARY KEY,
    VaiTro BIT,
    NgayTao DATE,
    NgaySua DATE,
    TrangThai BIT
)
CREATE TABLE MaXacNhanTaiKhoan(
    Ma_MaXacNhan VARCHAR(36) PRIMARY KEY DEFAULT NEWID(),
    SoDienThoai VARCHAR(20),
    NgaySuDung DATE,
    TrangThai BIT
)

INSERT INTO MaXacNhanTaiKhoan(TrangThai)
VALUES(1)
SELECT * FROM MaXacNhanTaiKhoan


UPDATE MaXacNhanTaiKhoan 
SET TrangThai = 0,
SET SoDienThoai = '123456789',
SET NgaySuDung = getDate();
WHERE Ma_MaXacNhan='D329F69E-3806-406D-B42F-94F1C78A137B'

UPDATE TaiKhoanNhanVien
SET MatKhau = '1234'
WHERE SoDienThoai = '123456789'

UPDATE MaXacNhanTaiKhoan 
SET TrangThai = 0,
    SoDienThoai = '123456789',
    NgaySuDung = GETDATE()
WHERE Ma_MaXacNhan = 'B06481B1-4752-483D-845B-991D0C6EE8EF'
UPDATE TaiKhoanNhanVien
SET MatKhau = '1234'
WHERE SoDienThoai = '123456789'




INSERT INTO TaiKhoanNhanVien (SoDienThoai, MatKhau)
VALUES 
('123456789', '123456789')
INSERT INTO ChucVuNhanVien (SoDienThoai, VaiTro,NgayTao,NgaySua,TrangThai)
VALUES 
('123456789', 1,GETDATE(),GETDATE(),1)

INSERT INTO ThongTinNhanVien (SoDienThoai,HoTen,GioiTinh,NgaySinh,DiaChi,Email)
VALUES 
('123456789', N'Nông Tiến Sơn',1,GETDATE(),N'Hà Nội','nongtiensonpro@gmail.com')
INSERT INTO ChucVuNhanVien (SoDienThoai, VaiTro,NgayTao,NgaySua,TrangThai)
VALUES 
('123456789', 1,GETDATE(),GETDATE(),1)
SELECT Ma_NhanVien, SoDienThoai, MatKhau FROM TaiKhoanNhanVien
SELECT * FROM ChucVuNhanVien
SELECT * FROM ThongTinNhanVien

SELECT * FROM TaiKhoanNhanVien
                    INNER JOIN ChucVuNhanVien ON ChucVuNhanVien.SoDienThoai= TaiKhoanNhanVien.SoDienThoai
                    INNER JOIN ThongTinNhanVien ON ThongTinNhanVien.SoDienThoai = TaiKhoanNhanVien.SoDienThoai
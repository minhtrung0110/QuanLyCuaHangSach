-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 30, 2021 at 10:57 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bookstore`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (
  `MaHD` varchar(5) COLLATE utf32_unicode_ci NOT NULL,
  `MaSach` varchar(5) COLLATE utf32_unicode_ci NOT NULL,
  `TenSach` varchar(50) COLLATE utf32_unicode_ci NOT NULL,
  `SoLuong` int(20) NOT NULL,
  `DonGia` float NOT NULL,
  `GiamGia` int(3) NOT NULL,
  `ThanhTien` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `MaCTPN` varchar(5) CHARACTER SET utf32 COLLATE utf32_unicode_ci NOT NULL,
  `MaPN` varchar(5) CHARACTER SET utf32 COLLATE utf32_unicode_ci NOT NULL,
  `MaSach` varchar(5) CHARACTER SET utf32 COLLATE utf32_unicode_ci NOT NULL,
  `DonGia` int(10) NOT NULL,
  `SoLuong` int(10) NOT NULL,
  `ThanhTien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `chitietphieunhap`
--

INSERT INTO `chitietphieunhap` (`MaCTPN`, `MaPN`, `MaSach`, `DonGia`, `SoLuong`, `ThanhTien`) VALUES
('CT01', 'A01', 'KD03', 95000, 2, 190000),
('CT02', 'A02', 'KD01', 125000, 1, 125000);

-- --------------------------------------------------------

--
-- Table structure for table `chuongtrinhgiamgia`
--

CREATE TABLE `chuongtrinhgiamgia` (
  `MaGG` varchar(5) COLLATE utf32_unicode_ci NOT NULL,
  `TenChuongTrinh` varchar(50) COLLATE utf32_unicode_ci NOT NULL,
  `LoaiChuongTrinh` varchar(50) COLLATE utf32_unicode_ci NOT NULL,
  `NgayBD` date NOT NULL,
  `NgayKT` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

--
-- Dumping data for table `chuongtrinhgiamgia`
--

INSERT INTO `chuongtrinhgiamgia` (`MaGG`, `TenChuongTrinh`, `LoaiChuongTrinh`, `NgayBD`, `NgayKT`) VALUES
('A01', 'Săn Sale 4-4', 'Giảm 25% trên mỗi hóa đơn trên 300000', '2021-03-28', '2021-04-10');

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `MaHD` varchar(5) COLLATE utf32_unicode_ci NOT NULL,
  `MaKH` varchar(5) COLLATE utf32_unicode_ci NOT NULL,
  `MaNV` varchar(5) COLLATE utf32_unicode_ci NOT NULL,
  `MaGG` varchar(5) COLLATE utf32_unicode_ci NOT NULL,
  `NgayLapHD` date NOT NULL,
  `TongTien` float NOT NULL,
  `GiamGia` float NOT NULL,
  `ThanhTien` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `MaKH` varchar(5) COLLATE utf32_unicode_ci NOT NULL,
  `Ho` varchar(30) COLLATE utf32_unicode_ci NOT NULL,
  `Ten` varchar(30) COLLATE utf32_unicode_ci NOT NULL,
  `SDT` varchar(10) COLLATE utf32_unicode_ci NOT NULL,
  `Email` varchar(30) COLLATE utf32_unicode_ci NOT NULL,
  `Phai` tinyint(1) NOT NULL,
  `NgaySinh` date DEFAULT NULL,
  `TCT` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`MaKH`, `Ho`, `Ten`, `SDT`, `Email`, `Phai`, `NgaySinh`, `TCT`) VALUES
('K01', 'Nguyễn Trần Văn', 'Vũ', '0902638361', 'vanvu21@gmail.com', 1, '2001-04-16', 1000),
('K02', 'Phạm Thiên', 'Phúc', '0363691591', 'phuc@gmail.com', 0, '2001-03-18', 1000),
('K03', 'thanh ', 'huy', '0121455123', 'truc@gmail.com', 1, '1996-06-23', 1000),
('K04', 'Trần Thanh', 'Tùng', '9999999999', 'tung@gmail.com', 1, '1980-04-17', 2000),
('K05', 'Nguyễn Trần Văn', 'Bưởi', '0363691591', 'daubuoi111@gmail.com', 1, '2000-08-19', 0),
('K06', 'Trần Thanh', 'Tèo', '0363691591', 'teo21@gmail.com', 0, '2000-06-19', 50000);

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `MaNCC` varchar(5) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `TenNCC` varchar(255) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `DiaChi` varchar(255) COLLATE utf8mb4_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`MaNCC`, `TenNCC`, `DiaChi`) VALUES
('KĐ', 'Kim Đồng', 'TP.HCM'),
('NN', 'Nhã Nam', 'TP.HCM'),
('NVC', 'Nguyễn Văn Cừ', 'TP.HCM'),
('PĐ', 'Phương Đông', 'Hà Nội'),
('PN', 'Phương Nam', 'TP.HCM');

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNV` varchar(5) COLLATE utf32_unicode_ci NOT NULL,
  `Ho` varchar(30) COLLATE utf32_unicode_ci NOT NULL,
  `Ten` varchar(30) COLLATE utf32_unicode_ci NOT NULL,
  `SDT` char(10) COLLATE utf32_unicode_ci NOT NULL,
  `Email` varchar(35) COLLATE utf32_unicode_ci NOT NULL,
  `Phai` tinyint(1) NOT NULL,
  `NgaySinh` date NOT NULL DEFAULT current_timestamp(),
  `ChucVu` varchar(25) COLLATE utf32_unicode_ci NOT NULL,
  `Luong` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`MaNV`, `Ho`, `Ten`, `SDT`, `Email`, `Phai`, `NgaySinh`, `ChucVu`, `Luong`) VALUES
('MT', 'Nguyễn Đức Minh', 'Trung', '0707624367', 'minhtrung4367@gmail.com', 1, '2001-10-01', 'Tổng Giám Đốc', 10000000),
('PK', 'Phạm Trần', 'Khôi', '0113114115', '', 0, '2021-04-25', '', 10000000),
('TT', 'Trần Thanh', 'Tùng', '0988364523', '', 0, '2021-04-25', '', 10000000),
('VV', 'Nguyễn Trần Văn', 'Vũ', '0903368547', '', 0, '2021-04-25', '', 10000000);

-- --------------------------------------------------------

--
-- Table structure for table `nhaxuatban`
--

CREATE TABLE `nhaxuatban` (
  `MaNXB` varchar(50) COLLATE utf32_unicode_ci NOT NULL,
  `TenNXB` varchar(30) COLLATE utf32_unicode_ci NOT NULL,
  `DiaChiNXB` varchar(70) COLLATE utf32_unicode_ci NOT NULL,
  `SDT` varchar(10) COLLATE utf32_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

--
-- Dumping data for table `nhaxuatban`
--

INSERT INTO `nhaxuatban` (`MaNXB`, `TenNXB`, `DiaChiNXB`, `SDT`) VALUES
('GD', 'Nhà xuất Bản Giáo Dục', 'Hà Nội', '0235456987'),
('NXB_Đại_Học_Quốc_Gia', 'Nhà Xuất Đại Học Quốc Gia', 'Hà Nội', '0899131345'),
('NXB_Hội_Nhà_Văn', 'Nhà Xuất Bản Hội Nhà Văn', 'TP.HCM', '0235872347'),
('NXB_Lao_Động', 'Nhà xuất Bản lao Động', 'TP.HCM', '0535878987'),
('NXB_Tổng_Hợp_HCM', 'Nhà Xuất Bản Tổng Hợp Hồ Chí M', 'TP.HCM', '0755878987'),
('NXB_Trẻ', 'Nhà Xuất Bản Trẻ', 'TP.HCM', '0235878987');

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

CREATE TABLE `phieunhap` (
  `MaPN` varchar(5) COLLATE utf32_unicode_ci NOT NULL,
  `MaNV` varchar(5) COLLATE utf32_unicode_ci NOT NULL,
  `MaNCC` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `TrangThai` tinyint(1) NOT NULL,
  `TongTien` float NOT NULL,
  `NgayNhap` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

--
-- Dumping data for table `phieunhap`
--

INSERT INTO `phieunhap` (`MaPN`, `MaNV`, `MaNCC`, `TrangThai`, `TongTien`, `NgayNhap`) VALUES
('A01', 'MT', 'KĐ', 0, 25000000, '2020-10-02'),
('A02', 'VV', 'NVC', 1, 4500000, '2021-04-29');

-- --------------------------------------------------------

--
-- Table structure for table `sach`
--

CREATE TABLE `sach` (
  `MaSach` varchar(5) COLLATE utf32_unicode_ci NOT NULL,
  `MaNXB` varchar(50) COLLATE utf32_unicode_ci NOT NULL,
  `MaTG` varchar(50) COLLATE utf32_unicode_ci NOT NULL,
  `MaTL` varchar(50) COLLATE utf32_unicode_ci NOT NULL,
  `TenSach` varchar(50) COLLATE utf32_unicode_ci NOT NULL,
  `NamXuatBan` int(11) NOT NULL,
  `SoLuong` int(20) NOT NULL,
  `DonGia` int(50) NOT NULL,
  `imgName` varchar(20) COLLATE utf32_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

--
-- Dumping data for table `sach`
--

INSERT INTO `sach` (`MaSach`, `MaNXB`, `MaTG`, `MaTL`, `TenSach`, `NamXuatBan`, `SoLuong`, `DonGia`, `imgName`) VALUES
('KD01', 'NXB_Hội_Nhà_Văn', 'H.Trương', 'Tôn_Giáo&Tâm_Lý', 'Nhớ Em Cô Gái Ngày Hôm QUa', 2019, 2000, 125000, 'KD01.jpg'),
('KD02', 'NXB_Tổng_Hợp_HCM', 'Nguyễn Du', 'Truyện', 'Kiều Nguyệt Nga', 1980, 5000, 95000, 'KD02.jpg'),
('KD03', 'NXB_Hội_Nhà_Văn', 'D.N.Nam', 'Thiếu_Nhi', 'Chiều Hôm', 2005, 245, 450000, 'KD03.jpg'),
('KD05', 'NXB_Hội_Nhà_Văn', 'H.Trương', 'Tôn_Giáo&Tâm_Lý', 'asaad', 2346, 12, 25000, 'null');

-- --------------------------------------------------------

--
-- Table structure for table `tacgia`
--

CREATE TABLE `tacgia` (
  `MaTG` varchar(50) COLLATE utf32_unicode_ci NOT NULL,
  `TenTG` varchar(50) COLLATE utf32_unicode_ci NOT NULL,
  `DiaChi` varchar(70) COLLATE utf32_unicode_ci NOT NULL,
  `SDT` char(10) COLLATE utf32_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

--
-- Dumping data for table `tacgia`
--

INSERT INTO `tacgia` (`MaTG`, `TenTG`, `DiaChi`, `SDT`) VALUES
('D.N.Nam', 'Đỗ Nhật Nam', 'An Giang', '0907365481'),
('H.Trang', 'Trang Hạ', 'TP.HCM', '0803365421'),
('H.Trương', 'Hamlet Trương', 'TP.HCM', '0803365421'),
('J.K.R', 'J.K.Rowling', 'U.K', '02-036-798'),
('N.T.Tố', 'Ngô Tất Tố', 'TP.HCM', '0809995472'),
('Nguyễn Du', 'Nguyễn Du', 'VietNam', '0803999999'),
('P.Việt', 'Nguyễn Phong Việt', 'Phú Yên', '0803365421'),
('V.T.Phụng', 'Vũ Trọng Phụng', 'Nam Viet Nam', '0589365429');

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE `taikhoan` (
  `MaTK` varchar(5) CHARACTER SET utf32 COLLATE utf32_unicode_ci NOT NULL,
  `TenTaiKhoan` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `MatKhau` varchar(255) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `Quyen` varchar(255) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `TrangThai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`MaTK`, `TenTaiKhoan`, `MatKhau`, `Quyen`, `TrangThai`) VALUES
('001', 'admin', 'admin', 'Admin', 1),
('002', 'sale', 'sale', 'Sale', 1);

-- --------------------------------------------------------

--
-- Table structure for table `theloai`
--

CREATE TABLE `theloai` (
  `MaTL` varchar(50) COLLATE utf32_unicode_ci NOT NULL,
  `TenTL` varchar(30) COLLATE utf32_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

--
-- Dumping data for table `theloai`
--

INSERT INTO `theloai` (`MaTL`, `TenTL`) VALUES
('Chính_Trị', 'Chính Trị'),
('Pháp _Luật', 'Pháp Luật'),
('Thiếu_Nhi', 'Sách Thiếu Nhi'),
('Tiểu_Thuyết', 'Tiểu Thuyết'),
('Tôn_Giáo&Tâm_Lý', 'Tâm Lý-Tôn Giáo'),
('Trinh_Thám', 'Thám Hiểm & Trinh Thám'),
('Truyện', 'Truyện'),
('Văn_Học_Nghệ_Thuật', 'Văn Học Nghệ Thuật');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD KEY `MaHD` (`MaHD`),
  ADD KEY `MaSach` (`MaSach`);

--
-- Indexes for table `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD PRIMARY KEY (`MaCTPN`),
  ADD KEY `MaPN` (`MaPN`),
  ADD KEY `MaSach` (`MaSach`);

--
-- Indexes for table `chuongtrinhgiamgia`
--
ALTER TABLE `chuongtrinhgiamgia`
  ADD PRIMARY KEY (`MaGG`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MaHD`),
  ADD KEY `FK_MaKH` (`MaKH`),
  ADD KEY `MaGG` (`MaGG`),
  ADD KEY `MaNV` (`MaNV`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`MaKH`);

--
-- Indexes for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`MaNCC`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MaNV`);

--
-- Indexes for table `nhaxuatban`
--
ALTER TABLE `nhaxuatban`
  ADD PRIMARY KEY (`MaNXB`);

--
-- Indexes for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`MaPN`),
  ADD KEY `MaNV` (`MaNV`),
  ADD KEY `MaNCC` (`MaNCC`);

--
-- Indexes for table `sach`
--
ALTER TABLE `sach`
  ADD PRIMARY KEY (`MaSach`),
  ADD KEY `FK_MaNXB` (`MaNXB`),
  ADD KEY `FK_MaTL` (`MaTL`),
  ADD KEY `FK_MaTG` (`MaTG`);

--
-- Indexes for table `tacgia`
--
ALTER TABLE `tacgia`
  ADD PRIMARY KEY (`MaTG`);

--
-- Indexes for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`MaTK`,`TenTaiKhoan`);

--
-- Indexes for table `theloai`
--
ALTER TABLE `theloai`
  ADD PRIMARY KEY (`MaTL`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD CONSTRAINT `chitiethoadon_ibfk_1` FOREIGN KEY (`MaHD`) REFERENCES `hoadon` (`MaHD`),
  ADD CONSTRAINT `chitiethoadon_ibfk_2` FOREIGN KEY (`MaSach`) REFERENCES `sach` (`MaSach`);

--
-- Constraints for table `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD CONSTRAINT `chitietphieunhap_ibfk_1` FOREIGN KEY (`MaPN`) REFERENCES `phieunhap` (`MaPN`),
  ADD CONSTRAINT `chitietphieunhap_ibfk_2` FOREIGN KEY (`MaSach`) REFERENCES `sach` (`MaSach`);

--
-- Constraints for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `FK_MaKH` FOREIGN KEY (`MaKH`) REFERENCES `khachhang` (`MaKH`),
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`MaGG`) REFERENCES `chuongtrinhgiamgia` (`MaGG`),
  ADD CONSTRAINT `hoadon_ibfk_2` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`);

--
-- Constraints for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `phieunhap_ibfk_1` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`),
  ADD CONSTRAINT `phieunhap_ibfk_2` FOREIGN KEY (`MaNCC`) REFERENCES `nhacungcap` (`MaNCC`);

--
-- Constraints for table `sach`
--
ALTER TABLE `sach`
  ADD CONSTRAINT `sach_ibfk_1` FOREIGN KEY (`MaNXB`) REFERENCES `nhaxuatban` (`MaNXB`),
  ADD CONSTRAINT `sach_ibfk_2` FOREIGN KEY (`MaTG`) REFERENCES `tacgia` (`MaTG`),
  ADD CONSTRAINT `sach_ibfk_3` FOREIGN KEY (`MaTL`) REFERENCES `theloai` (`MaTL`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

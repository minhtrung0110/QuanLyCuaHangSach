-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 05, 2021 at 10:18 AM
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
-- Table structure for table `chitietchuongtrinhgiamgia`
--

CREATE TABLE `chitietchuongtrinhgiamgia` (
  `MaGG` varchar(5) CHARACTER SET utf32 COLLATE utf32_unicode_ci NOT NULL,
  `phanTramGiam` float NOT NULL,
  `MaSach` varchar(5) CHARACTER SET utf32 COLLATE utf32_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `chitietchuongtrinhgiamgia`
--

INSERT INTO `chitietchuongtrinhgiamgia` (`MaGG`, `phanTramGiam`, `MaSach`) VALUES
('A02', 14, 'KD04'),
('A02', 30, 'KD05'),
('A04', 15, 'KD04');

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

--
-- Dumping data for table `chitiethoadon`
--

INSERT INTO `chitiethoadon` (`MaHD`, `MaSach`, `TenSach`, `SoLuong`, `DonGia`, `GiamGia`, `ThanhTien`) VALUES
('1', 'KD06', 'Đắc Nhân Tâm', 1, 110000, 0, 110000),
('2', 'KD03', 'Cho tôi 1 vé Về tuổi thơ', 1, 75000, 0, 75000),
('3', 'KD10', 'Luật Bảo Vệ Môi Trường', 1, 45000, 0, 45000),
('4', 'KD03', 'Cho tôi 1 vé Về tuổi thơ', 2, 75000, 0, 150000),
('4', 'KD01', '7 Thói Quen Hiệu Quả', 1, 11000, 0, 11000),
('5', 'KD01', '7 Thói Quen Hiệu Quả', 49, 11000, 0, 539000),
('5', 'KD02', 'Chúng Ta Đã Sai', 50, 75000, 0, 3750000),
('6', 'KD03', 'Cho tôi 1 vé Về tuổi thơ', 2, 75000, 0, 150000),
('7', 'KD03', 'Cho tôi 1 vé Về tuổi thơ', 3, 75000, 0, 225000);

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
('CT01', 'A01', 'KD01', 110000, 10, 1100000),
('CT02', 'A01', 'KD03', 75000, 10, 750000),
('CT03', 'A02', 'KD04', 100000, 15, 1500000),
('CT04', 'A03', 'KD10', 45000, 10, 450000),
('CT05', 'A03', 'KD09', 55000, 10, 550000),
('CT06', 'A04', 'KD07', 75000, 5, 375000),
('CT07', 'A04', 'KD01', 65000, 50, 3250000),
('CT08', 'A05', 'KD03', 70000, 13, 910000),
('CT09', 'A05', 'KD10', 50000, 15, 750000);

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
('A02', 'Khai Trương Cưa Hàng Sách', 'Khuyến Mãi 30% - 40%', '2021-05-01', '2021-05-08'),
('A04', 'Lễ Quốc Tế Lao Động', 'Khuyến Mãi', '2021-05-01', '2021-05-02');

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `MaHD` varchar(5) COLLATE utf32_unicode_ci NOT NULL,
  `MaKH` varchar(5) COLLATE utf32_unicode_ci NOT NULL,
  `MaNV` varchar(5) COLLATE utf32_unicode_ci NOT NULL,
  `MaGG` varchar(5) COLLATE utf32_unicode_ci DEFAULT NULL,
  `NgayLapHD` date NOT NULL,
  `TongTien` float NOT NULL,
  `GiamGia` float NOT NULL,
  `ThanhTien` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

--
-- Dumping data for table `hoadon`
--

INSERT INTO `hoadon` (`MaHD`, `MaKH`, `MaNV`, `MaGG`, `NgayLapHD`, `TongTien`, `GiamGia`, `ThanhTien`) VALUES
('1', 'K02', 'PK', NULL, '2021-01-18', 110000, 0, 110000),
('2', 'K05', 'PK', NULL, '2021-05-18', 75000, 0, 75000),
('3', 'K07', 'MT', NULL, '2021-02-19', 45000, 0, 45000),
('4', 'K01', 'PK', NULL, '2021-05-19', 161000, 0, 161000),
('5', 'K01', 'PK', NULL, '2021-05-19', 4289000, 0, 4289000),
('6', 'K04', 'MT', 'A02', '2021-08-16', 150000, 0, 150000),
('7', 'K01', 'TT', NULL, '2021-08-26', 225000, 0, 225000);

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
  `TCT` int(10) NOT NULL,
  `NgaySinh` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`MaKH`, `Ho`, `Ten`, `SDT`, `Email`, `Phai`, `TCT`, `NgaySinh`) VALUES
('K01', 'Nguyễn Trần Văn', 'Vũ', '0902638361', 'vanvu21@gmail.com', 1, 1000, '2001-04-16'),
('K02', 'Phạm Thiên', 'Phúc', '0363691591', 'phuc@gmail.com', 0, 1000, '2001-03-18'),
('K03', 'thanh ', 'huy', '0121455123', 'truc@gmail.com', 1, 1000, '1996-06-23'),
('K04', 'Trần Thanh', 'Tùng', '9999999999', 'tung@gmail.com', 1, 2000, '1980-04-17'),
('K05', 'Nguyễn Trần Văn', 'Bưởi', '0363691591', 'daubuoi111@gmail.com', 1, 1000, '2000-08-19'),
('K06', 'Trần Thanh', 'Tèo', '0363691591', 'teo21@gmail.com', 0, 50000, '2000-06-19'),
('K07', 'Trần Thanh', 'Táo', '0363691591', 'apple21@gmail.com', 1, 50000, '2000-05-19'),
('K08', 'Phan Trung', 'Kiên', '0123456789', 'kien@email.com', 1, 200000, '2001-12-03');

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
('A01', 'MT', 'KĐ', 1, 1850000, '2021-05-18'),
('A02', 'PK', 'NVC', 0, 1500000, '2021-05-18'),
('A03', 'TT', 'PN', 1, 1000000, '2021-05-19'),
('A04', 'VV', 'PĐ', 0, 3625000, '2021-05-19'),
('A05', 'MT', 'PĐ', 1, 1660000, '2021-08-26');

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
  `DonGia` float UNSIGNED NOT NULL,
  `imgName` varchar(20) COLLATE utf32_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

--
-- Dumping data for table `sach`
--

INSERT INTO `sach` (`MaSach`, `MaNXB`, `MaTG`, `MaTL`, `TenSach`, `NamXuatBan`, `SoLuong`, `DonGia`, `imgName`) VALUES
('KD01', 'NXB_Đại_Học_Quốc_Gia', 'J.K.R', 'Văn_Học_Nghệ_Thuật', '7 Thói Quen Hiệu Quả', 2016, 50, 11000, 'KD01.jpg'),
('KD02', 'NXB_Trẻ', 'H.Trương', 'Tôn_Giáo&Tâm_Lý', 'Chúng Ta Đã Sai', 2018, 50, 75000, 'KD02.jpg'),
('KD03', 'NXB_Trẻ', 'P.Việt', 'Văn_Học_Nghệ_Thuật', 'Cho tôi 1 vé Về tuổi thơ', 2016, 56, 75000, 'KD03.jpg'),
('KD04', 'NXB_Trẻ', 'P.Việt', 'Văn_Học_Nghệ_Thuật', 'Đời Ngắn Đừng Ngủ Dài', 2008, 50, 100000, 'KD04.jpg'),
('KD05', 'NXB_Trẻ', 'NhieuTG', 'Tôn_Giáo&Tâm_Lý', 'Hạt Giống Tâm Hồn', 2006, 50, 65000, 'KD05.jpg'),
('KD06', 'NXB_Trẻ', 'J.K.R', 'Chính_Trị', 'Đắc Nhân Tâm', 2010, 100, 110000, 'KD06.jpg'),
('KD07', 'NXB_Đại_Học_Quốc_Gia', 'Nguyễn Du', 'Truyện', 'Truyện Kiều', 2008, 55, 75000, 'KD07.jpg'),
('KD08', 'NXB_Tổng_Hợp_HCM', 'D.N.Nam', 'Văn_Học_Nghệ_Thuật', 'Thành Phố Ngày Ta Yêu', 2018, 50, 85000, 'KD08.jpg'),
('KD09', 'NXB_Hội_Nhà_Văn', 'H.Trương', 'Văn_Học_Nghệ_Thuật', 'Thương Nhau Để Đó', 2017, 55, 55000, 'KD09.jpg'),
('KD10', 'NXB_Đại_Học_Quốc_Gia', 'NhieuTG', 'Pháp _Luật', 'Luật Bảo Vệ Môi Trường', 2018, 54, 45000, 'KD10.jpg');

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
('C.Thiên', 'Cảnh Thiên', 'HCM', '0235878987'),
('D.N.Nam', 'Đỗ Nhật Nam', 'An Giang', '0907365481'),
('H.Trang', 'Trang Hạ', 'TP.HCM', '0803365421'),
('H.Trương', 'Hamlet Trương', 'TP.HCM', '0803365421'),
('J.K.R', 'J.K.Rowling', 'Anh Quốc', '02-036-798'),
('N.N.Ánh', 'Nguyễn Nhật Ánh', 'HCM', '067939771'),
('N.T.Tố', 'Ngô Tất Tố', 'TP.HCM', '0809995472'),
('Nguyễn Du', 'Nguyễn Du', 'VietNam', '0803999999'),
('NhieuTG', 'Nhiều TG', 'QT', '0222228686'),
('P.Việt', 'Nguyễn Phong Việt', 'Phú Yên', '0803365421'),
('V.T.Phụng', 'Vũ Trọng Phụng', 'Nam Viet Nam', '0589365429');

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE `taikhoan` (
  `MaTK` varchar(5) COLLATE utf32_unicode_ci NOT NULL,
  `TenTaiKhoan` varchar(255) COLLATE utf32_unicode_ci NOT NULL,
  `MatKhau` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Quyen` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `TrangThai` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`MaTK`, `TenTaiKhoan`, `MatKhau`, `Quyen`, `TrangThai`) VALUES
('MT', 'admin', 'admin', 'admin', 1);

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
-- Indexes for table `chitietchuongtrinhgiamgia`
--
ALTER TABLE `chitietchuongtrinhgiamgia`
  ADD UNIQUE KEY `unique_index` (`MaGG`,`MaSach`),
  ADD KEY `MaGG` (`MaGG`),
  ADD KEY `MaSach` (`MaSach`);

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
  ADD PRIMARY KEY (`TenTaiKhoan`),
  ADD KEY `MaTK` (`MaTK`);

--
-- Indexes for table `theloai`
--
ALTER TABLE `theloai`
  ADD PRIMARY KEY (`MaTL`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitietchuongtrinhgiamgia`
--
ALTER TABLE `chitietchuongtrinhgiamgia`
  ADD CONSTRAINT `chitietchuongtrinhgiamgia_ibfk_1` FOREIGN KEY (`MaGG`) REFERENCES `chuongtrinhgiamgia` (`MaGG`),
  ADD CONSTRAINT `chitietchuongtrinhgiamgia_ibfk_2` FOREIGN KEY (`MaSach`) REFERENCES `sach` (`MaSach`);

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

--
-- Constraints for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `taikhoan_ibfk_1` FOREIGN KEY (`MaTK`) REFERENCES `nhanvien` (`MaNV`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

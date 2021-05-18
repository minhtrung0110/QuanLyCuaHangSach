-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 17, 2021 at 09:33 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.1

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
  `MaGG` varchar(5) NOT NULL,
  `phanTramGiam` float NOT NULL,
  `MaSach` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `chitietchuongtrinhgiamgia`
--

INSERT INTO `chitietchuongtrinhgiamgia` (`MaGG`, `phanTramGiam`, `MaSach`) VALUES
('A02', 14, 'KD04'),
('A02', 30, 'KD05'),
('A03', 13, 'KD01'),
('A03', 10, 'KD02'),
('A03', 15, 'KD03'),
('A03', 10, 'KD04'),
('A03', 12, 'KD05'),
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
('0001', 'KD01', 'Nhớ Em Cô Gái Ngày Hôm QUa', 5, 125000, 0, 625000),
('0001', 'KD03', 'Chiều Hôm', 2, 450000, 0, 900000),
('0001', 'KD05', 'asaad', 1, 25000, 0, 25000),
('0002', 'KD02', 'Kiều Nguyệt Nga', 2, 95000, 0, 190000),
('0002', 'KD01', 'Nhớ Em Cô Gái Ngày Hôm QUa', 3, 125000, 0, 375000),
('0002', 'KD03', 'Chiều Hôm', 1, 450000, 135000, 315000),
('0003', 'KD04', 'Khôi Đẹp Trai', 1, 50000, 0, 50000),
('0003', 'KD02', 'Kiều Nguyệt Nga', 5, 95000, 0, 475000),
('0003', 'KD01', 'Kiều Nguyệt Nga', 4, 95000, 0, 380000),
('0004', 'KD01', 'Nhớ Em Cô Gái Ngày Hôm QUa', 5, 125000, 0, 625000),
('0004', 'KD02', 'Kiều Nguyệt Nga', 7, 95000, 0, 665000),
('0004', 'KD05', 'asaad', 1, 25000, 7500, 17500),
('0004', 'KD03', 'Chiều Hôm', 5, 450000, 675000, 1575000),
('0005', 'KD01', 'Nhớ Em Cô Gái Ngày Hôm QUa', 10, 125000, 0, 1250000);

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
('', '', '', '0000-00-00', '0000-00-00'),
('A02', 'Khai Trương Cưa Hàng Sách', 'Khuyến Mãi 30% - 40%', '2021-05-01', '2021-05-08'),
('A03', 'Khai Trương Cưa Hàng Sách Phần 2', 'Khuyến Mãi 30% - 40%', '2021-05-28', '2021-05-31'),
('A04', 'Lễ Quốc Tế Lao Động', 'Khuyến Mãi', '2021-05-01', '2021-05-02');

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

--
-- Dumping data for table `hoadon`
--

INSERT INTO `hoadon` (`MaHD`, `MaKH`, `MaNV`, `MaGG`, `NgayLapHD`, `TongTien`, `GiamGia`, `ThanhTien`) VALUES
('0001', 'K01', 'PK', '', '2021-05-15', 1550000, 0, 1550000),
('0002', 'K02', 'TT', 'A02', '2021-05-15', 1015000, 135000, 880000),
('0003', 'K04', 'MT', '', '2021-05-15', 905000, 0, 905000),
('0004', 'K05', 'VV', 'A04', '2021-05-15', 3565000, 682500, 2882500),
('0005', 'K02', 'TT', '', '2021-05-15', 1250000, 0, 1250000);

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
('K08', 'Phan Trung', 'Kiên', '0123456789', 'kien@email.com', 1, 200000, '2001-12-03'),
('K09', 'Phan Trung', 'Kiên', '0123456789', 'kien@email.com', 1, 200000, '2001-12-03'),
('K10', 'Phan Trung', 'Kiên', '0123456790', 'kien@email.com', 1, 200001, '2001-12-04'),
('K11', 'Phan Trung', 'Kiên', '0123456791', 'kien@email.com', 1, 200002, '2001-12-05'),
('K12', 'Phan Trung', 'Kiên', '0123456792', 'kien@email.com', 1, 200003, '2001-12-06'),
('K13', 'Phan Trung', 'Kiên', '0123456793', 'kien@email.com', 1, 200004, '2001-12-07'),
('K14', 'Phan Trung', 'Kiên', '0123456794', 'kien@email.com', 1, 200005, '2001-12-08'),
('K15', 'Phan Trung', 'Kiên', '0123456795', 'kien@email.com', 1, 200006, '2001-12-09'),
('K16', 'Phan Trung', 'Kiên', '0123456796', 'kien@email.com', 1, 200007, '2001-12-10'),
('K17', 'Phan Trung', 'Kiên', '0123456797', 'kien@email.com', 1, 200008, '2001-12-11');

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
  `imgName` varchar(20) COLLATE utf32_unicode_ci NOT NULL,
  `TrangThai` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

--
-- Dumping data for table `sach`
--

INSERT INTO `sach` (`MaSach`, `MaNXB`, `MaTG`, `MaTL`, `TenSach`, `NamXuatBan`, `SoLuong`, `DonGia`, `imgName`, `TrangThai`) VALUES
('KD01', 'NXB_Hội_Nhà_Văn', 'H.Trương', 'Tôn_Giáo&Tâm_Lý', 'Nhớ Em Cô Gái Ngày Hôm QUa', 2019, 2000, 125000, 'KD01.jpg', 1),
('KD02', 'NXB_Tổng_Hợp_HCM', 'Nguyễn Du', 'Truyện', 'Kiều Nguyệt Nga', 1980, 5000, 95000, 'KD02.jpg', 1),
('KD03', 'NXB_Hội_Nhà_Văn', 'D.N.Nam', 'Thiếu_Nhi', 'Chiều Hôm', 2005, 245, 450000, 'KD03.jpg', 1),
('KD04', 'NXB_Đại_Học_Quốc_Gia', 'J.K.R', 'Chính_Trị', 'Harry Porter và Chính Trị Việt Nam', 2020, 1, 200000, 'null', 1),
('KD05', 'NXB_Hội_Nhà_Văn', 'H.Trương', 'Tôn_Giáo&Tâm_Lý', 'asaad', 2346, 12, 25000, 'null', 1);

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
('J.K.R', 'J.K.Rowling', 'Anh Quốc', '02-036-798'),
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

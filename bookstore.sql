-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 06, 2021 at 06:08 PM
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
  `MaGG` varchar(5) COLLATE utf32_unicode_ci NOT NULL,
  `MaSach` varchar(5) COLLATE utf32_unicode_ci NOT NULL,
  `phantramgiamgia` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (
  `MaHD` varchar(5) COLLATE utf32_unicode_ci NOT NULL,
  `MaSach` varchar(5) COLLATE utf32_unicode_ci NOT NULL,
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
  `MaPN` varchar(5) COLLATE utf32_unicode_ci NOT NULL,
  `MaSach` varchar(5) COLLATE utf32_unicode_ci NOT NULL,
  `SoLuong` int(20) NOT NULL,
  `ThanhTien` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

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
  `TCT` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`MaKH`, `Ho`, `Ten`, `SDT`, `Email`, `Phai`, `TCT`) VALUES
('a11', 'Nguyễn Trần Văn', 'Vũ', '0902638361', 'vanvu21@gmail.com', 1, 1000),
('a12', 'Phạm Thiên', 'Phúc', '0363691591', 'phuc@gmail.com', 0, 1000),
('a13', 'thanh ', 'huy', '0121455123', 'truc@gmail.com', 1, 1000),
('b11', 'Trần Thanh', 'Tùng', '9999999999', 'tung@gmail.com', 1, 2000);

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `MaNCC` varchar(5) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `TenNCC` varchar(255) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `DiaChi` varchar(255) COLLATE utf8mb4_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNV` varchar(5) COLLATE utf32_unicode_ci NOT NULL,
  `Ho` varchar(30) COLLATE utf32_unicode_ci NOT NULL,
  `Ten` varchar(30) COLLATE utf32_unicode_ci NOT NULL,
  `SDT` char(10) COLLATE utf32_unicode_ci NOT NULL,
  `Luong` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `nhaxuatban`
--

CREATE TABLE `nhaxuatban` (
  `MaNXB` varchar(5) COLLATE utf32_unicode_ci NOT NULL,
  `TenNXB` varchar(30) COLLATE utf32_unicode_ci NOT NULL,
  `DiaChiNXB` varchar(70) COLLATE utf32_unicode_ci NOT NULL,
  `SDT` char(10) COLLATE utf32_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

--
-- Dumping data for table `nhaxuatban`
--

INSERT INTO `nhaxuatban` (`MaNXB`, `TenNXB`, `DiaChiNXB`, `SDT`) VALUES
('b11', 'Thanh Tùng', '1 Quang Trung ,f.2,q.1', '0902638361');

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

-- --------------------------------------------------------

--
-- Table structure for table `sach`
--

CREATE TABLE `sach` (
  `MaSach` varchar(5) COLLATE utf32_unicode_ci NOT NULL,
  `MaNXB` varchar(5) COLLATE utf32_unicode_ci NOT NULL,
  `MaTG` varchar(5) COLLATE utf32_unicode_ci NOT NULL,
  `MaTL` varchar(5) COLLATE utf32_unicode_ci NOT NULL,
  `TenSach` varchar(50) COLLATE utf32_unicode_ci NOT NULL,
  `SoLuong` int(20) NOT NULL,
  `DonGia` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tacgia`
--

CREATE TABLE `tacgia` (
  `MaTG` varchar(5) COLLATE utf32_unicode_ci NOT NULL,
  `TenTG` varchar(50) COLLATE utf32_unicode_ci NOT NULL,
  `DiaChi` varchar(70) COLLATE utf32_unicode_ci NOT NULL,
  `SDT` char(10) COLLATE utf32_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

--
-- Dumping data for table `tacgia`
--

INSERT INTO `tacgia` (`MaTG`, `TenTG`, `DiaChi`, `SDT`) VALUES
('d11', 'Thanh Tùng', '62/139b lct ,f.8,q.3', '0795669535');

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
  `MaTL` varchar(5) COLLATE utf32_unicode_ci NOT NULL,
  `TenTL` varchar(30) COLLATE utf32_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

--
-- Dumping data for table `theloai`
--

INSERT INTO `theloai` (`MaTL`, `TenTL`) VALUES
('c11', '18+');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitietchuongtrinhgiamgia`
--
ALTER TABLE `chitietchuongtrinhgiamgia`
  ADD PRIMARY KEY (`MaGG`,`MaSach`),
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
  ADD PRIMARY KEY (`MaPN`,`MaSach`),
  ADD KEY `FK_MaSach` (`MaSach`);

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
  ADD CONSTRAINT `FK_MaPN_1` FOREIGN KEY (`MaPN`) REFERENCES `phieunhap` (`MaPN`),
  ADD CONSTRAINT `chitietphieunhap_ibfk_1` FOREIGN KEY (`MaSach`) REFERENCES `sach` (`MaSach`);

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
  ADD CONSTRAINT `FK_MaTG` FOREIGN KEY (`MaTG`) REFERENCES `tacgia` (`MaTG`),
  ADD CONSTRAINT `sach_ibfk_1` FOREIGN KEY (`MaNXB`) REFERENCES `nhaxuatban` (`MaNXB`),
  ADD CONSTRAINT `sach_ibfk_2` FOREIGN KEY (`MaTL`) REFERENCES `theloai` (`MaTL`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

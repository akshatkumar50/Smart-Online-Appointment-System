-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 09, 2020 at 11:25 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `minor`
--

-- --------------------------------------------------------

--
-- Table structure for table `admincredentials`
--

CREATE TABLE `admincredentials` (
  `admin_id` varchar(3) NOT NULL,
  `pass` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admincredentials`
--

INSERT INTO `admincredentials` (`admin_id`, `pass`) VALUES
('A01', 'hello@12');

-- --------------------------------------------------------

--
-- Table structure for table `appointment`
--

CREATE TABLE `appointment` (
  `app_id` int(11) NOT NULL,
  `reg_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `doc_id` varchar(3) NOT NULL,
  `app_date` date NOT NULL,
  `app_time` time NOT NULL,
  `pat_id` varchar(3) NOT NULL,
  `pincode` int(6) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '1',
  `confirm` int(11) NOT NULL DEFAULT '0',
  `address` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `appointment`
--

INSERT INTO `appointment` (`app_id`, `reg_time`, `doc_id`, `app_date`, `app_time`, `pat_id`, `pincode`, `status`, `confirm`, `address`) VALUES
(1, '2020-05-09 08:06:50', 'D01', '2020-05-06', '10:00:00', 'U01', 248001, 1, 1, 'premnagar'),
(2, '2020-05-09 08:07:07', 'D02', '2020-05-03', '10:00:00', 'U02', 110001, 1, 1, 'daryagang'),
(3, '2020-05-09 08:06:13', 'D02', '2020-05-05', '10:30:00', 'U02', 110001, 0, 1, 'gzb'),
(4, '2020-05-09 08:06:20', 'D01', '2020-05-09', '11:30:00', 'U02', 110001, 1, 1, 'vas'),
(5, '2020-05-09 08:05:13', 'D05', '2020-05-07', '10:00:00', 'U02', 122001, 1, 1, 'Gurgaon'),
(8, '2020-05-09 08:05:13', 'D04', '2020-05-07', '10:00:00', 'U02', 122001, 1, 1, 'Gurgaon'),
(9, '2020-05-09 08:05:13', 'D04', '2020-05-07', '10:00:00', 'U02', 122001, 1, 1, 'Gurgaon'),
(10, '2020-05-09 08:05:13', 'D04', '2020-05-07', '10:00:00', 'U02', 122001, 1, 1, 'Gurgaon'),
(11, '2020-05-09 08:05:13', 'D04', '2020-05-07', '10:00:00', 'U02', 122001, 1, 1, 'Gurgaon'),
(12, '2020-05-09 08:05:13', 'D05', '2020-05-07', '10:00:00', 'U02', 122001, 1, 1, 'Gurgaon'),
(13, '2020-05-09 08:05:13', 'D05', '2020-05-07', '10:00:00', 'U02', 122001, 1, 1, 'Gurgaon'),
(14, '2020-05-09 08:05:13', 'D05', '2020-05-07', '10:00:00', 'U02', 122001, 1, 1, 'Gurgaon'),
(15, '2020-05-09 08:05:13', 'D05', '2020-05-09', '10:00:00', 'U02', 122001, 1, 1, 'Gurgaon'),
(16, '2020-05-09 08:05:13', 'D04', '2020-05-07', '10:30:00', 'U02', 122001, 0, 1, 'Gurgaon');

-- --------------------------------------------------------

--
-- Table structure for table `doctorinfo`
--

CREATE TABLE `doctorinfo` (
  `doc_id` varchar(3) NOT NULL,
  `name` varchar(20) NOT NULL,
  `age` int(11) NOT NULL,
  `sex` varchar(6) NOT NULL,
  `contact` int(11) NOT NULL,
  `license` varchar(10) NOT NULL,
  `blood` varchar(3) NOT NULL,
  `password` varchar(8) NOT NULL,
  `pincode` int(6) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '1',
  `city` varchar(20) NOT NULL,
  `state` varchar(20) NOT NULL,
  `lat` double(8,6) NOT NULL,
  `log` double(8,6) NOT NULL,
  `address` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctorinfo`
--

INSERT INTO `doctorinfo` (`doc_id`, `name`, `age`, `sex`, `contact`, `license`, `blood`, `password`, `pincode`, `status`, `city`, `state`, `lat`, `log`, `address`) VALUES
('D01', 'keshav', 44, 'Male', 2147483647, 'R98765', 'A+', 'pass@12', 248001, 1, 'Dehradun', 'Uttrakhand', 30.331594, 78.010726, 'vasundhara'),
('D02', 'Sarins', 34, 'Female', 2147483647, 'R98765', 'AB+', 'pass@12', 110001, 1, 'NCT of Delhi', 'New Delhi', 28.632680, 77.208535, 'vaishali'),
('D03', 'Geetha', 43, 'Female', 2147483647, 'R92441', 'O-', 'pass@12', 110001, 1, 'NCT of Delhi', 'New Delhi', 28.632437, 77.207275, 'moradabad'),
('D04', 'Harshita', 34, 'Female', 34567, 'R54321', 'A+', 'pass@12', 122001, 1, 'Gurgaon', 'Haryana', 28.459700, 77.028200, 'Gurgaon'),
('D05', 'akansha', 34, 'Female', 34567, 'R5432', 'A+', 'pass@12', 122001, 1, 'Gurgaon', 'Haryana', 28.440700, 77.008200, 'Gurgaon');

-- --------------------------------------------------------

--
-- Table structure for table `hospitalinfo`
--

CREATE TABLE `hospitalinfo` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `address` varchar(150) NOT NULL,
  `pincode` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hospitalinfo`
--

INSERT INTO `hospitalinfo` (`id`, `name`, `address`, `pincode`) VALUES
(1, 'Civil Hospital', '55, Basai Rd, Vikas Nagar, Sector 10, Gurugram, Haryana', 122001),
(2, 'Govt. Vetrinary Hospital', '480-489, Sector 12a, Sector 12A, Gurgaon Village, Sector 12,', 122001),
(3, 'Govt Ayurvedic Hospital', 'Lane Number 2, Hemkunj Colony, Dehradun, Uttarakhand ', 248001),
(4, 'Government Vetenary hospital', '86, Kanwali Rd, MDDA Colony, Laxman Chowk, Dehradun, Uttarakhand', 248001),
(5, 'Dr. Ram Manohar Lohia Hospital', 'Baba Kharak Singh Rd, near Gurudwara Bangla Sahib, Ram Manohar Lohia Hospital, Type III, Connaught Place, New Delhi, Delhi', 110001),
(6, 'Lady Hardinge Emergency Ward', '85, Panchkuian Marg, Lady Hardinge Medical College, Sector 3, Connaught Place, New Delhi, Delhi', 110001),
(7, 'Janta Charitable Hospital', ' Dev Nagar, Sonipat, Haryana', 131001),
(8, 'Civil Hospital', 'Delhi Road, Near Maharana Pratap Chowk, Sonipat, Haryana', 131001);

-- --------------------------------------------------------

--
-- Table structure for table `secinfo`
--

CREATE TABLE `secinfo` (
  `sec_id` varchar(3) NOT NULL,
  `name` varchar(20) NOT NULL,
  `age` int(11) NOT NULL,
  `sex` varchar(6) NOT NULL,
  `contact` int(11) NOT NULL,
  `blood` varchar(3) NOT NULL,
  `password` varchar(8) NOT NULL,
  `city` varchar(20) NOT NULL,
  `state` varchar(20) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '1',
  `doc_ref` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `secinfo`
--

INSERT INTO `secinfo` (`sec_id`, `name`, `age`, `sex`, `contact`, `blood`, `password`, `city`, `state`, `status`, `doc_ref`) VALUES
('S01', 'keshav', 44, 'Male', 3647, 'A+', 'pass@12', 'Dehradun', 'Uttrakhand', 1, 'D01'),
('S02', 'yadav', 23, 'Female', 345678, 'AB+', 'pass@12', 'premnagar', 'dehradun', 1, 'D02'),
('S03', 'Hasrh', 34, 'Male', 74543, 'O+', 'pass@12', 'Delhi', 'Delhi', 0, 'D01');

-- --------------------------------------------------------

--
-- Table structure for table `userinfo`
--

CREATE TABLE `userinfo` (
  `user_id` varchar(3) NOT NULL,
  `name` varchar(20) NOT NULL,
  `age` int(11) NOT NULL,
  `sex` varchar(6) NOT NULL,
  `contact` int(11) NOT NULL,
  `blood` varchar(3) NOT NULL,
  `pincode` int(6) NOT NULL,
  `password` varchar(8) NOT NULL,
  `disease` varchar(15) NOT NULL,
  `city` varchar(20) NOT NULL,
  `state` varchar(20) NOT NULL,
  `lat` double(8,6) NOT NULL,
  `log` double(8,6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userinfo`
--

INSERT INTO `userinfo` (`user_id`, `name`, `age`, `sex`, `contact`, `blood`, `pincode`, `password`, `disease`, `city`, `state`, `lat`, `log`) VALUES
('U01', 'Akash', 19, 'Male', 2147483647, 'A+', 248001, 'pass@12', 'Diabetes', 'Dehradun', 'Uttrakhand', 30.322000, 77.030000),
('U02', 'Akshat', 19, 'Male', 12345, 'O+', 110001, 'pass@123', 'HyerTension', 'Ghaziabad', 'Uttar Pradesh', 28.633100, 77.220700);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admincredentials`
--
ALTER TABLE `admincredentials`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indexes for table `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`app_id`);

--
-- Indexes for table `doctorinfo`
--
ALTER TABLE `doctorinfo`
  ADD PRIMARY KEY (`doc_id`);

--
-- Indexes for table `hospitalinfo`
--
ALTER TABLE `hospitalinfo`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `secinfo`
--
ALTER TABLE `secinfo`
  ADD PRIMARY KEY (`sec_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appointment`
--
ALTER TABLE `appointment`
  MODIFY `app_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `hospitalinfo`
--
ALTER TABLE `hospitalinfo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

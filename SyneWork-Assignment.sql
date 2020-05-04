-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 04, 2020 at 02:37 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `SyneWork-Assignment`
--

-- --------------------------------------------------------

--
-- Table structure for table `policy`
--

CREATE TABLE `policy` (
  `policy_num` bigint(20) NOT NULL,
  `age_group` varchar(255) DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `cover` bigint(20) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `num_of_years` float DEFAULT NULL,
  `plan_type` varchar(255) DEFAULT NULL,
  `policy_name` varchar(255) DEFAULT NULL,
  `premium_monthly` double DEFAULT NULL,
  `premium_yearly` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `policy`
--

INSERT INTO `policy` (`policy_num`, `age_group`, `company_name`, `cover`, `is_active`, `num_of_years`, `plan_type`, `policy_name`, `premium_monthly`, `premium_yearly`) VALUES
(1111, '20-40', 'BajajInsuranceCompany', 3000000, b'1', 2, 'couple', 'BajajGold', 629, 8546),
(1112, '20-40', 'BajajInsuranceCompany', 3500000, b'1', 1, 'couple', 'BajajSilver', 529, 8546),
(1113, '20-50', 'BajajInsuranceCompany', 500000, b'1', 1, 'individual', 'BajajPlan', 529, 8546);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `policy`
--
ALTER TABLE `policy`
  ADD PRIMARY KEY (`policy_num`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

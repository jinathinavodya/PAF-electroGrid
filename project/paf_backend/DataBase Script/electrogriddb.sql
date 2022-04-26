-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Generation Time: Apr 24, 2022 at 12:02 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `electrogriddb`
--
CREATE DATABASE IF NOT EXISTS `electrogriddb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `electrogriddb`;

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
CREATE TABLE IF NOT EXISTS `accounts` (
  `accountID` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(20) NOT NULL,
  `buildingNo` varchar(10) NOT NULL,
  `totalAmtToPay` double NOT NULL,
  `userID` int(11) NOT NULL,
  PRIMARY KEY (`accountID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
-- --------------------------------------------------------

--
-- Table structure for table `bills`
--

DROP TABLE IF EXISTS `bills`;
CREATE TABLE IF NOT EXISTS `bills` (
  `billID` int(11) NOT NULL AUTO_INCREMENT,
  `accountID` int(10) NOT NULL,
  `unitUsage` int(11) NOT NULL,
  `month` varchar(2) NOT NULL,
  `year` varchar(4) NOT NULL,
  `amount` double NOT NULL,
  PRIMARY KEY (`billID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
-- --------------------------------------------------------
--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) NOT NULL,
  `userNIC` varchar(20) NOT NULL,
  `userPhoneNo` varchar(12) NOT NULL,
  `userEmail` varchar(20) NOT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;
-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

DROP TABLE IF EXISTS `payments`;
CREATE TABLE IF NOT EXISTS `payments` (
  `paymentID` int(11) NOT NULL AUTO_INCREMENT,
  `accountID` int(11) NOT NULL,
  `amount` double NOT NULL,
  `payMethod` varchar(10) NOT NULL,
  `payDate` varchar(15) NOT NULL,
  PRIMARY KEY (`paymentID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
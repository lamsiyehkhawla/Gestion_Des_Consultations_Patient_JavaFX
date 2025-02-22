-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 22, 2025 at 08:43 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `DB_cabinet`
--

-- --------------------------------------------------------

--
-- Table structure for table `CONSULTATIONS`
--

CREATE TABLE `CONSULTATIONS` (
  `ID_CONSULTATION` int(11) NOT NULL,
  `DATE_CONSULTATION` date NOT NULL,
  `DESCRIPTION` text NOT NULL,
  `ID_PATIENT` bigint(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `patients`
--

CREATE TABLE `patients` (
  `ID_PATIENT` bigint(20) NOT NULL,
  `NOM` varchar(50) NOT NULL,
  `PRENOM` varchar(50) NOT NULL,
  `TEL` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `patients`
--

INSERT INTO `patients` (`ID_PATIENT`, `NOM`, `PRENOM`, `TEL`) VALUES
(1, 'LAM', 'Khawla', '774456799'),
(2, 'SAnsan', 'Ihssane', '12385416789');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `CONSULTATIONS`
--
ALTER TABLE `CONSULTATIONS`
  ADD PRIMARY KEY (`ID_CONSULTATION`),
  ADD KEY `FK1` (`ID_PATIENT`);

--
-- Indexes for table `patients`
--
ALTER TABLE `patients`
  ADD PRIMARY KEY (`ID_PATIENT`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `CONSULTATIONS`
--
ALTER TABLE `CONSULTATIONS`
  MODIFY `ID_CONSULTATION` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `patients`
--
ALTER TABLE `patients`
  MODIFY `ID_PATIENT` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `CONSULTATIONS`
--
ALTER TABLE `CONSULTATIONS`
  ADD CONSTRAINT `FK1` FOREIGN KEY (`ID_PATIENT`) REFERENCES `patients` (`ID_PATIENT`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

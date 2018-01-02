-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 02, 2018 at 06:57 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `timetablems`
--

-- --------------------------------------------------------

--
-- Table structure for table `computer_harmattan`
--

CREATE TABLE `computer_harmattan` (
  `id` int(5) NOT NULL,
  `courseCode` varchar(6) DEFAULT NULL,
  `courseTitle` varchar(100) DEFAULT NULL,
  `courseUnit` int(2) DEFAULT NULL,
  `lectureDuration` int(2) DEFAULT NULL,
  `coursePopulation` int(3) DEFAULT NULL,
  `courseDescription` varchar(150) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `computer_harmattan`
--

INSERT INTO `computer_harmattan` (`id`, `courseCode`, `courseTitle`, `courseUnit`, `lectureDuration`, `coursePopulation`, `courseDescription`) VALUES
(1, 'CSC101', 'Introduction to Computing I', 2, 2, 150, 'Description'),
(2, 'CPE203', 'Introduction to Digital Computer System I ', 2, 2, 150, 'Description'),
(3, 'CPE301', 'Low Level Languages', 3, 3, 150, 'Description'),
(4, 'CSC307', 'Numerical Computation I', 2, 2, 150, 'Description'),
(5, 'CPE303', 'Introduction to Computer Engineering', 2, 2, 150, 'Description'),
(6, 'CSC315', 'Data Structures and Analysis of Algorithms', 2, 2, 150, 'Description'),
(7, 'CSC415', 'Operating Systems and System Programming', 2, 2, 150, 'Description'),
(8, 'CPE401', 'Computer Architecture and Organization', 3, 3, 150, 'Description'),
(9, 'CSC403', 'Principles of Compilers', 3, 2, 150, 'Description'),
(10, 'CPE405', 'Intro. to Microprocessor Techn. and Microprogramming', 3, 3, 150, 'Description'),
(11, 'CSC505', 'Object Oriented Modelling', 2, 2, 150, 'Description'),
(12, 'CPE511', 'Computer-based Real Time System', 3, 2, 150, 'Description'),
(13, 'CPE517', 'Digital Computer Networks', 3, 3, 150, 'Description'),
(14, 'CSC305', 'Introduction to Database Systems', 3, 2, 150, 'Description'),
(15, 'CSC311', 'Introduction to Information Systems', 2, 2, 150, 'Description'),
(16, 'CSC317', 'Automata Theory and Computability', 2, 2, 150, 'Description'),
(17, 'CSC501', 'Introduction to Operations Research', 2, 2, 150, 'Description'),
(18, 'CSC515', 'Database Design and Management', 2, 2, 150, 'Description'),
(19, 'CSC523', 'Mathematical Programming', 2, 2, 150, 'Description'),
(20, 'CSC507', 'Computers in Society', 2, 2, 150, 'Description'),
(21, 'CSC513', 'Principles and Applications of Data Mining', 2, 2, 150, 'Description'),
(22, 'CPE521', 'Modelling and Simulation', 2, 2, 150, 'Description');

-- --------------------------------------------------------

--
-- Table structure for table `computer_rain`
--

CREATE TABLE `computer_rain` (
  `id` int(5) NOT NULL,
  `courseCode` varchar(6) DEFAULT NULL,
  `courseTitle` varchar(100) DEFAULT NULL,
  `courseUnit` int(2) DEFAULT NULL,
  `lectureDuration` int(2) DEFAULT NULL,
  `coursePopulation` int(3) DEFAULT NULL,
  `courseDescription` varchar(150) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `computer_rain`
--

INSERT INTO `computer_rain` (`id`, `courseCode`, `courseTitle`, `courseUnit`, `lectureDuration`, `coursePopulation`, `courseDescription`) VALUES
(1, 'CSC102', 'Introduction to Computing II', 2, 2, 150, 'Description'),
(2, 'CPE204', 'Introduction to Digital Computer System II', 2, 2, 150, 'Description'),
(3, 'CSC302', 'Object-Oriented Programming', 3, 2, 150, 'Description'),
(4, 'CSC308', 'Numerical Computation II', 2, 2, 150, 'Description'),
(5, 'CSC306', 'Introduction to Human-Computer Interaction', 3, 2, 150, 'Description'),
(6, 'CPE310', 'Introduction to Agent-based Systems', 2, 2, 150, 'Description'),
(7, 'CPE316', 'Introduction to Artificial Intelligence', 2, 2, 150, 'Description'),
(8, 'CPE206', 'Digital Laboratory I', 2, 2, 150, 'Description'),
(19, 'CPE502', 'Hardware System Studies', 3, 3, 150, 'Description'),
(10, 'CPE506', 'Industrial Applications Studies', 2, 2, 150, 'Description'),
(11, 'CPE508', 'Computer System Project Management', 3, 2, 150, 'Description'),
(12, 'CPE510', 'Natural Language Processing And Applications', 3, 2, 150, 'Description'),
(13, 'CPE514', 'Computer Graphics', 2, 2, 150, 'Description'),
(14, 'CSC520', 'Expert Systems', 2, 2, 150, 'Description'),
(15, 'CSC522', 'Information Storage and Retrieval ', 2, 2, 150, 'Description'),
(16, 'CSC524', 'Techniques in Data Analysis', 2, 2, 150, 'Description'),
(17, 'CSC304', 'Business and Commercial Programming', 2, 2, 150, 'Description'),
(18, 'CSC312', 'Systems Analysis and Design Methodologies', 3, 2, 150, 'Description');

-- --------------------------------------------------------

--
-- Table structure for table `harmat`
--

CREATE TABLE `harmat` (
  `id` int(5) NOT NULL,
  `courseCode` varchar(6) DEFAULT NULL,
  `courseTitle` varchar(100) DEFAULT NULL,
  `courseUnit` int(2) DEFAULT NULL,
  `lectureDuration` int(2) DEFAULT NULL,
  `coursePopulation` int(3) DEFAULT NULL,
  `courseDescription` varchar(150) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `harmat`
--

INSERT INTO `harmat` (`id`, `courseCode`, `courseTitle`, `courseUnit`, `lectureDuration`, `coursePopulation`, `courseDescription`) VALUES
(1, 'CSC201', 'Computer Appreciation', 3, 2, 120, 'sfds');

-- --------------------------------------------------------

--
-- Table structure for table `harmattan`
--

CREATE TABLE `harmattan` (
  `id` int(5) NOT NULL,
  `courseCode` varchar(6) DEFAULT NULL,
  `courseTitle` varchar(100) DEFAULT NULL,
  `courseUnit` int(2) DEFAULT NULL,
  `lectureDuration` int(2) DEFAULT NULL,
  `coursePopulation` int(3) DEFAULT NULL,
  `courseDescription` varchar(150) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `harmattan`
--

INSERT INTO `harmattan` (`id`, `courseCode`, `courseTitle`, `courseUnit`, `lectureDuration`, `coursePopulation`, `courseDescription`) VALUES
(1, 'CSC101', 'Introduction to Computing I', 2, 2, 150, 'Description'),
(2, 'CSC203', 'Introduction to Digital Computer System I', 2, 2, 150, 'Description'),
(3, 'CPE301', 'Low Level Languages', 3, 3, 150, 'Description'),
(4, 'CSC307', 'Numerical Computation I', 2, 2, 150, 'Description'),
(5, 'CPE303', 'Introduction to Computer Engineering', 2, 2, 60, 'Description'),
(6, 'CSC315', 'Data Structures and Analysis of Algorithm', 2, 2, 70, 'Description'),
(7, 'CSC415', 'Operating Systems and System Programming', 2, 2, 150, 'Description'),
(8, 'CPE401', 'Computer Architecture and Organization', 3, 3, 150, 'Description'),
(9, 'CSC403', 'Principles of Compilers', 3, 2, 150, 'Description'),
(10, 'CPE405', 'Intro. to Microprocessor Techn. and Microprogramming', 3, 3, 150, 'Description'),
(11, 'CSC505', 'Object Oriented Modelling', 2, 2, 150, 'Description'),
(12, 'CPE511', 'Computer-based Real Time System', 3, 2, 60, 'Description'),
(13, 'CPE517', 'Digital Computer Networks', 3, 3, 150, 'Description'),
(14, 'CSC305', 'Introduction to Database Systems', 3, 2, 60, 'Description'),
(15, 'CSC311', 'Introduction to Information Systems', 2, 2, 60, 'Description'),
(16, 'CSC317', 'Automata Theory and Computability', 2, 2, 70, 'Description'),
(17, 'CSC501', 'Intrroduction to Operations Research', 2, 2, 150, 'Description'),
(18, 'CSC515', 'Database Design and Management', 2, 2, 70, 'Description'),
(19, 'CSC523', 'Mathimatical Programming', 2, 2, 70, 'Description'),
(20, 'CSC507', 'Computers in Society', 2, 2, 70, 'Description'),
(21, 'CSC513', 'Principles and Applications of Data Mining', 2, 2, 70, 'Description'),
(22, 'CPE521', 'Modelling and Simulation', 2, 2, 60, 'Description'),
(23, 'CSC307', 'Numerical Computation 1', 2, 2, 123, 'hhshs');

-- --------------------------------------------------------

--
-- Table structure for table `rain`
--

CREATE TABLE `rain` (
  `id` int(5) NOT NULL,
  `courseCode` varchar(6) DEFAULT NULL,
  `courseTitle` varchar(100) DEFAULT NULL,
  `courseUnit` int(2) DEFAULT NULL,
  `lectureDuration` int(2) DEFAULT NULL,
  `coursePopulation` int(3) DEFAULT NULL,
  `courseDescription` varchar(150) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rain`
--

INSERT INTO `rain` (`id`, `courseCode`, `courseTitle`, `courseUnit`, `lectureDuration`, `coursePopulation`, `courseDescription`) VALUES
(1, 'CSC102', 'Introduction to Computing II', 2, 2, 150, 'Description'),
(2, 'CPE204', 'Introduction to Digital Computer System II', 2, 2, 150, 'Description'),
(3, 'CSC302', 'Object Oriented Programming', 3, 2, 150, 'Description'),
(6, 'CSC308', 'Numerical Computation II', 2, 2, 150, 'Description'),
(7, 'CSC306', 'Introduction to Human-Computer Interaction', 3, 2, 150, 'Description'),
(8, 'CPE310', 'Introduction to Agent-based Systems', 2, 2, 150, 'Description'),
(9, 'CPE316', 'Introduction to Artificial Intelligence', 2, 2, 150, 'Description'),
(10, 'CPE206', 'Digital Laboratory I', 2, 2, 70, 'Description'),
(11, 'CPE502', 'Hardware System Studies', 3, 3, 150, 'Description'),
(12, 'CPE506', 'Industrial Application Studies', 2, 2, 150, 'Description'),
(13, 'CPE508', 'Computer System Project Management', 3, 2, 150, 'Description'),
(14, 'CPE510', 'Natural Language Processing and Applications', 3, 2, 150, 'Description'),
(15, 'CPE514', 'Computer Graphics', 2, 2, 60, 'Description'),
(16, 'CSC520', 'Expert Systems', 2, 2, 60, 'Description'),
(17, 'CSC522', 'Information Storage and Retrieval', 2, 2, 60, 'Description'),
(18, 'CSC524', 'Techniques in Data Analysis', 2, 2, 60, 'Description'),
(19, 'CSC304', 'Business and Commercial Programming', 2, 2, 70, 'Description'),
(20, 'CSC312', 'System Analysis and Design Methodologies', 3, 2, 70, 'Description'),
(21, 'EEE301', 'Microelectronics I', 3, 3, 1000, 'Introduction to Semiconductor');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `computer_harmattan`
--
ALTER TABLE `computer_harmattan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `computer_rain`
--
ALTER TABLE `computer_rain`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `harmat`
--
ALTER TABLE `harmat`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `harmattan`
--
ALTER TABLE `harmattan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rain`
--
ALTER TABLE `rain`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `computer_harmattan`
--
ALTER TABLE `computer_harmattan`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
--
-- AUTO_INCREMENT for table `computer_rain`
--
ALTER TABLE `computer_rain`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT for table `harmat`
--
ALTER TABLE `harmat`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `harmattan`
--
ALTER TABLE `harmattan`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
--
-- AUTO_INCREMENT for table `rain`
--
ALTER TABLE `rain`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

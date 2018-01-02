-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 31, 2017 at 08:16 PM
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
-- Table structure for table `harmattancourses1`
--

CREATE TABLE `harmattancourses1` (
  `id` int(3) NOT NULL,
  `courseCode` varchar(6) DEFAULT NULL,
  `courseTitle` varchar(100) DEFAULT NULL,
  `courseUnit` int(1) DEFAULT NULL,
  `lectureDuration` int(2) DEFAULT NULL,
  `coursePopulation` int(3) DEFAULT NULL,
  `courseDescription` varchar(150) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `harmattancourses1`
--

INSERT INTO `harmattancourses1` (`id`, `courseCode`, `courseTitle`, `courseUnit`, `lectureDuration`, `coursePopulation`, `courseDescription`) VALUES
(1, 'CPE401', 'Computer Architecture and Organization', 3, 3, 150, 'Description'),
(2, 'CPE405', 'Introduction to Microprocessor Technology and Microprogramming', 3, NULL, 150, 'Description'),
(3, 'CPE517', 'Digital Computer Networks', 3, NULL, 150, 'Description'),
(4, 'CPE521', 'Modelling and Simulation', 2, NULL, 150, 'Description'),
(5, 'CSC407', 'Techniques in Software Development', 2, NULL, 150, 'Description');

-- --------------------------------------------------------

--
-- Table structure for table `harmattancourses2`
--

CREATE TABLE `harmattancourses2` (
  `id` int(3) NOT NULL,
  `courseCode` varchar(6) DEFAULT NULL,
  `courseTitle` varchar(90) DEFAULT NULL,
  `courseUnit` int(1) DEFAULT NULL,
  `lectureDuration` int(2) NOT NULL,
  `coursePopulation` int(3) DEFAULT NULL,
  `courseDescription` text
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `harmattancourses2`
--

INSERT INTO `harmattancourses2` (`id`, `courseCode`, `courseTitle`, `courseUnit`, `lectureDuration`, `coursePopulation`, `courseDescription`) VALUES
(1, 'CSC101', 'Introduction to Computing I', 2, 2, 150, 'Description'),
(2, 'CPE203', 'Introduction to Digital Computer System I', 2, 2, 150, 'Description'),
(3, 'CSC307', 'Numerical Computation I', 2, 2, 150, 'Description'),
(4, 'CPE301', 'Low Level Languages', 3, 2, 150, 'Description'),
(5, 'CSC303', 'Introduction to Computer Engineering', 2, 2, 150, 'Description'),
(6, 'CSC315', 'Data Structures and Analysis of Algorithms', 3, 2, 150, 'Description'),
(7, 'CSC305', 'Introduction to Database Systems', 3, 2, 150, 'Description'),
(8, 'CSC311', 'Introduction to Information Systems', 2, 2, 150, 'Description'),
(9, 'CSC317', 'Automata Theory and Computability', 2, 2, 150, 'Description'),
(10, 'CPE401', 'Computer Architecture and Organization', 3, 3, 150, 'Description'),
(11, 'CSC403', 'Principles of Compilers', 3, 2, 150, 'Description'),
(12, 'CPE405', 'Intro. to Microprocessor Technology and Microprogramming', 3, 3, 150, 'Description'),
(13, 'CSC415', 'Operating Systems and System Programming', 2, 2, 150, 'Description'),
(14, 'CSC505', 'Object Oriented Modelling', 2, 2, 150, 'Description'),
(15, 'CPE511', 'Computer-based Real Time System', 3, 2, 150, 'Description'),
(16, 'CPE517', 'Digital Computer Networks', 3, 3, 150, 'Description'),
(17, 'CSC501', 'Introduction to Operations Research', 2, 2, 150, 'Description'),
(18, 'CSC515', 'Database Design and Management', 2, 2, 150, 'Description'),
(19, 'CSC523', 'Mathematical Programming', 2, 2, 150, 'Description'),
(20, 'CSC507', 'Computers in Society', 2, 2, 150, 'Description'),
(21, 'CSC513', 'Principles and Applications of Data Mining', 2, 2, 150, 'Description'),
(22, 'CSC407', 'Techniques in Software Development', 2, 1, 150, 'Description'),
(23, 'CPE521', 'Modelling and Simulation', 2, 1, 150, 'Description');


-- --------------------------------------------------------

--
-- Table structure for table `raincourse1`
--

CREATE TABLE `raincourse1` (
  `id` int(2) NOT NULL,
  `courseCode` varchar(6) DEFAULT NULL,
  `courseTitle` varchar(100) DEFAULT NULL,
  `courseUnit` int(1) DEFAULT NULL,
  `lectureDuration` int(2) NOT NULL,
  `coursePopulation` int(3) DEFAULT NULL,
  `courseDescription` text
) ENGINE=MyISAM DEFAULT CHARSET=latin1 DELAY_KEY_WRITE=1;

--
-- Dumping data for table `raincourse1`
--

INSERT INTO `raincourse1` (`id`, `courseCode`, `courseTitle`, `courseUnit`, `lectureDuration`, `coursePopulation`, `courseDescription`) VALUES
(1, 'CSC206', 'Digital Laboratory I', 2, 1, 150, 'Description')
(2, 'CPE310', 'Introduction to Agent-based Systems', 2, 0, 150, 'Description'),
(3, 'CPE316', 'Introduction to Artificial Intelligence', 2, 0, 150, 'Description');

-- --------------------------------------------------------

--
-- Table structure for table `raincourse2`
--

CREATE TABLE `raincourse2` (
  `id` int(2) NOT NULL,
  `courseCode` varchar(6) DEFAULT NULL,
  `courseTitle` varchar(100) DEFAULT NULL,
  `courseUnit` int(1) DEFAULT NULL,
  `lectureDuration` int(2) NOT NULL,
  `coursePopulation` int(3) DEFAULT NULL,
  `courseDescription` text
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `raincourse2`
--

INSERT INTO `raincourse2` (`id`, `courseCode`, `courseTitle`, `courseUnit`, `lectureDuration`, `coursePopulation`, `courseDescription`) VALUES
(1, 'CSC102', 'Introduction to Computing II', 2, 2, 150, 'Description'),
(2, 'CPE204', 'Introduction to Digital Computer System II', 2, 2, 150, 'Description'),
(3, 'CPE206', 'Digital Laboratory I', 2, 1, 150, 'Description'),
(4, 'CSC302', 'Object-Oriented Programming', 3, 2, 150, 'Description'),
(5, 'CSC308', 'Numerical Computation II', 2, 2, 150, 'Description'),
(6, 'CSC306', 'Introduction to Human-Computer Interaction', 3, 2, 150, 'Description'),
(7, 'CSC304', 'Business and Commercial Programming', 2, 2, 150, 'Description'),
(8, 'CSC312', 'Systems Analysis and Design Methodologies', 3, 2, 150, 'Description'),
(9, 'CPE502', 'Hardware Systems Studies', 3, 2, 150, 'Description'),
(10, 'CPE506', 'Industrial Applications Studies', 2, 2, 150, 'Description'),
(11, 'CPE508', 'Computer System Project Management', 3, 2, 150, 'Description'),
(12, 'CPE510', 'Natural Language Processing And Applications', 3, 2, 150, 'Description'),
(13, 'CSC514', 'Computer Graphics', 2, 2, 150, 'Description'),
(14, 'CSC520', 'Expert Systems', 2, 2, 150, 'Description'),
(15, 'CSC522', 'Information Storage and Retrieval', 2, 2, 150, 'Description'),
(16, 'CPE524', 'Techniques in Data Analysis', 2, 2, 150, 'Description'),
(17, 'CPE310', 'Introduction to Agent-based Systems', 2, 1, 150, 'Description'),
(18, 'CPE316', 'Introduction to Artificial Intelligence', 2, 1, 150, 'Description');


--
-- Indexes for dumped tables
--

--
-- Indexes for table `harmattancourses1`
--
ALTER TABLE `harmattancourses1`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `harmattancourses2`
--
ALTER TABLE `harmattancourses2`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `raincourse1`
--
ALTER TABLE `raincourse1`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `raincourse2`
--
ALTER TABLE `raincourse2`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `harmattancourses1`
--
ALTER TABLE `harmattancourses1`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `harmattancourses2`
--
ALTER TABLE `harmattancourses2`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
--
-- AUTO_INCREMENT for table `raincourse1`
--
ALTER TABLE `raincourse1`
  MODIFY `id` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `raincourse2`
--
ALTER TABLE `raincourse2`
  MODIFY `id` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

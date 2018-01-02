-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 02, 2018 at 06:54 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `timetablemsprocess`
--

-- --------------------------------------------------------

--
-- Table structure for table `harmattanvenue1`
--

CREATE TABLE `harmattanvenue1` (
  `ID` int(5) NOT NULL,
  `courseCode` varchar(6) DEFAULT NULL,
  `courseTitle` varchar(100) DEFAULT NULL,
  `courseUnit` int(2) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `harmattanvenue1`
--

INSERT INTO `harmattanvenue1` (`ID`, `courseCode`, `courseTitle`, `courseUnit`) VALUES
(1, 'CSC101', 'Introduction to Computing I', 2),
(2, 'CSC523', 'Mathimatical Programming', 2),
(3, 'free', '', 0),
(4, 'CSC507', 'Computers in Society', 2),
(5, 'free', '', 0),
(6, 'free', '', 0),
(7, 'free', '', 0),
(8, 'free', '', 0),
(9, 'free', '', 0),
(10, 'CPE517', 'Digital Computer Networks', 3),
(11, 'free', '', 0),
(12, 'CPE517', 'Digital Computer Networks', 3),
(13, 'free', '', 0),
(14, 'CSC505', 'Object Oriented Modelling', 2),
(15, 'free', '', 0),
(16, 'free', '', 0),
(17, 'CPE401', 'Computer Architecture and Organization', 3),
(18, 'free', '', 0),
(19, 'free', '', 0),
(20, 'free', '', 0),
(21, 'free', '', 0),
(22, 'free', '', 0),
(23, 'free', '', 0),
(24, 'free', '', 0),
(25, 'free', '', 0),
(26, 'free', '', 0),
(27, 'CPE301', 'Low Level Languages', 3),
(28, 'free', '', 0),
(29, 'free', '', 0),
(30, 'free', '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `harmattanvenue2`
--

CREATE TABLE `harmattanvenue2` (
  `ID` int(5) NOT NULL,
  `courseCode` varchar(6) DEFAULT NULL,
  `courseTitle` varchar(100) DEFAULT NULL,
  `courseUnit` int(2) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `harmattanvenue2`
--

INSERT INTO `harmattanvenue2` (`ID`, `courseCode`, `courseTitle`, `courseUnit`) VALUES
(1, 'free', '', 0),
(2, 'free', '', 0),
(3, 'free', '', 0),
(4, 'free', '', 0),
(5, 'free', '', 0),
(6, 'free', '', 0),
(7, 'free', '', 0),
(8, 'CSC501', 'Intrroduction to Operations Research', 2),
(9, 'CPE511', 'Computer-based Real Time System', 3),
(10, 'CSC307', 'Numerical Comp. 1', 2),
(11, 'free', '', 0),
(12, 'free', '', 0),
(13, 'CSC317', 'Automata Theory and Computability', 2),
(14, 'free', '', 0),
(15, 'free', '', 0),
(16, 'CPE521', 'Modelling and Simulation', 2),
(17, 'free', '', 0),
(18, 'free', '', 0),
(19, 'free', '', 0),
(20, 'free', '', 0),
(21, 'CSC311', 'Introduction to Information Systems', 2),
(22, 'CSC513', 'Principles and Applications of Data Mining', 2),
(23, 'free', '', 0),
(24, 'CPE405', 'Intro. to Microprocessor Techn. and Microprogramming', 3),
(25, 'free', '', 0),
(26, 'free', '', 0),
(27, 'free', '', 0),
(28, 'free', '', 0),
(29, 'free', '', 0),
(30, 'free', '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `harmattan_`
--

CREATE TABLE `harmattan_` (
  `id` int(5) NOT NULL,
  `courseCode` varchar(6) DEFAULT NULL,
  `courseTitle` varchar(100) DEFAULT NULL,
  `courseUnit` int(2) DEFAULT NULL,
  `lectureDuration` int(2) DEFAULT NULL,
  `coursePopulation` int(3) DEFAULT NULL,
  `courseDescription` varchar(150) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `harmattan_`
--

INSERT INTO `harmattan_` (`id`, `courseCode`, `courseTitle`, `courseUnit`, `lectureDuration`, `coursePopulation`, `courseDescription`) VALUES
(1, 'CSC101', 'Introduction to Computing I', 2, 2, 150, 'Description'),
(2, 'CSC203', 'Introduction to Digital Computer System I', 2, 2, 150, 'Description'),
(3, 'CPE301', 'Low Level Languages', 3, 1, 150, 'Description'),
(4, 'CPE301', 'Low Level Languages', 3, 2, 150, 'Description'),
(5, 'CSC307', 'Numerical Computation I', 2, 2, 150, 'Description'),
(6, 'CPE303', 'Introduction to Computer Engineering', 2, 2, 60, 'Description'),
(7, 'CSC315', 'Data Structures and Analysis of Algorithm', 2, 2, 70, 'Description'),
(8, 'CSC415', 'Operating Systems and System Programming', 2, 2, 150, 'Description'),
(9, 'CPE401', 'Computer Architecture and Organization', 3, 1, 150, 'Description'),
(10, 'CPE401', 'Computer Architecture and Organization', 3, 2, 150, 'Description'),
(11, 'CSC403', 'Principles of Compilers', 3, 2, 150, 'Description'),
(12, 'CPE405', 'Intro. to Microprocessor Techn. and Microprogramming', 3, 1, 150, 'Description'),
(13, 'CPE405', 'Intro. to Microprocessor Techn. and Microprogramming', 3, 2, 150, 'Description'),
(14, 'CSC505', 'Object Oriented Modelling', 2, 2, 150, 'Description'),
(15, 'CPE511', 'Computer-based Real Time System', 3, 2, 60, 'Description'),
(16, 'CPE517', 'Digital Computer Networks', 3, 1, 150, 'Description'),
(17, 'CPE517', 'Digital Computer Networks', 3, 2, 150, 'Description'),
(18, 'CSC305', 'Introduction to Database Systems', 3, 2, 60, 'Description'),
(19, 'CSC311', 'Introduction to Information Systems', 2, 2, 60, 'Description'),
(20, 'CSC317', 'Automata Theory and Computability', 2, 2, 70, 'Description'),
(21, 'CSC501', 'Intrroduction to Operations Research', 2, 2, 150, 'Description'),
(22, 'CSC515', 'Database Design and Management', 2, 2, 70, 'Description'),
(23, 'CSC523', 'Mathimatical Programming', 2, 2, 70, 'Description'),
(24, 'CSC507', 'Computers in Society', 2, 2, 70, 'Description'),
(25, 'CSC513', 'Principles and Applications of Data Mining', 2, 2, 70, 'Description'),
(26, 'CPE521', 'Modelling and Simulation', 2, 2, 60, 'Description'),
(27, 'CSC307', 'Numerical Comp. 1', 2, 2, 123, 'hhshs');

-- --------------------------------------------------------

--
-- Table structure for table `harmat_`
--

CREATE TABLE `harmat_` (
  `id` int(5) NOT NULL,
  `courseCode` varchar(6) DEFAULT NULL,
  `courseTitle` varchar(100) DEFAULT NULL,
  `courseUnit` int(2) DEFAULT NULL,
  `lectureDuration` int(2) DEFAULT NULL,
  `coursePopulation` int(3) DEFAULT NULL,
  `courseDescription` varchar(150) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `harmat_`
--

INSERT INTO `harmat_` (`id`, `courseCode`, `courseTitle`, `courseUnit`, `lectureDuration`, `coursePopulation`, `courseDescription`) VALUES
(1, 'CSC201', 'Computer Appreciation', 3, 2, 120, 'sfds');

-- --------------------------------------------------------

--
-- Table structure for table `hvenue1`
--

CREATE TABLE `hvenue1` (
  `ID` int(5) NOT NULL,
  `courseCode` varchar(6) DEFAULT NULL,
  `courseTitle` varchar(100) DEFAULT NULL,
  `courseUnit` int(2) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hvenue1`
--

INSERT INTO `hvenue1` (`ID`, `courseCode`, `courseTitle`, `courseUnit`) VALUES
(1, 'free', '', 0),
(2, 'free', '', 0),
(3, 'free', '', 0),
(4, 'free', '', 0),
(5, 'free', '', 0),
(6, 'free', '', 0),
(7, 'free', '', 0),
(8, 'free', '', 0),
(9, 'free', '', 0),
(10, 'free', '', 0),
(11, 'free', '', 0),
(12, 'free', '', 0),
(13, 'CSC101', 'Introduction to Computing I', 2),
(14, 'free', '', 0),
(15, 'free', '', 0),
(16, 'free', '', 0),
(17, 'free', '', 0),
(18, 'free', '', 0),
(19, 'free', '', 0),
(20, 'free', '', 0),
(21, 'free', '', 0),
(22, 'free', '', 0),
(23, 'free', '', 0),
(24, 'free', '', 0),
(25, 'free', '', 0),
(26, 'CSC307', 'Numerical Computation I', 2),
(27, 'free', '', 0),
(28, 'free', '', 0),
(29, 'free', '', 0),
(30, 'free', '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `hvenue2`
--

CREATE TABLE `hvenue2` (
  `ID` int(5) NOT NULL,
  `courseCode` varchar(6) DEFAULT NULL,
  `courseTitle` varchar(100) DEFAULT NULL,
  `courseUnit` int(2) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hvenue2`
--

INSERT INTO `hvenue2` (`ID`, `courseCode`, `courseTitle`, `courseUnit`) VALUES
(1, 'free', '', 0),
(2, 'free', '', 0),
(3, 'free', '', 0),
(4, 'free', '', 0),
(5, 'free', '', 0),
(6, 'free', '', 0),
(7, 'free', '', 0),
(8, 'free', '', 0),
(9, 'free', '', 0),
(10, 'free', '', 0),
(11, 'free', '', 0),
(12, 'free', '', 0),
(13, 'free', '', 0),
(14, 'free', '', 0),
(15, 'free', '', 0),
(16, 'CSC201', 'Computer Programming', 3),
(17, 'free', '', 0),
(18, 'free', '', 0),
(19, 'free', '', 0),
(20, 'free', '', 0),
(21, 'free', '', 0),
(22, 'free', '', 0),
(23, 'free', '', 0),
(24, 'free', '', 0),
(25, 'free', '', 0),
(26, 'free', '', 0),
(27, 'free', '', 0),
(28, 'free', '', 0),
(29, 'free', '', 0),
(30, 'free', '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `processtb`
--

CREATE TABLE `processtb` (
  `id` int(5) NOT NULL,
  `courseCode` varchar(6) NOT NULL,
  `courseTitle` varchar(100) NOT NULL,
  `courseUnit` int(3) NOT NULL,
  `lectureDuration` int(3) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `rainvenue1`
--

CREATE TABLE `rainvenue1` (
  `ID` int(5) NOT NULL,
  `courseCode` varchar(6) DEFAULT NULL,
  `courseTitle` varchar(100) DEFAULT NULL,
  `courseUnit` int(2) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rainvenue1`
--

INSERT INTO `rainvenue1` (`ID`, `courseCode`, `courseTitle`, `courseUnit`) VALUES
(1, 'CPE514', 'Computer Graphics', 2),
(2, 'free', '', 0),
(3, 'free', '', 0),
(4, 'CPE506', 'Industrial Application Studies', 2),
(5, 'free', '', 0),
(6, 'free', '', 0),
(7, 'CSC520', 'Expert Systems', 2),
(8, 'free', '', 0),
(9, 'free', '', 0),
(10, 'CSC522', 'Information Storage and Retrieval', 2),
(11, 'free', '', 0),
(12, 'free', '', 0),
(13, 'free', '', 0),
(14, 'CPE316', 'Introduction to Artificial Intelligence', 2),
(15, 'free', '', 0),
(16, 'free', '', 0),
(17, 'free', '', 0),
(18, 'free', '', 0),
(19, 'free', '', 0),
(20, 'CPE508', 'Computer System Project Management', 3),
(21, 'CPE510', 'Natural Language Processing and Applications', 3),
(22, 'free', '', 0),
(23, 'free', '', 0),
(24, 'free', '', 0),
(25, 'free', '', 0),
(26, 'CSC306', 'Introduction to Human-Computer Interaction', 3),
(27, 'free', '', 0),
(28, 'free', '', 0),
(29, 'CPE204', 'Introduction to Digital Computer System II', 2),
(30, 'free', '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `rainvenue2`
--

CREATE TABLE `rainvenue2` (
  `ID` int(5) NOT NULL,
  `courseCode` varchar(6) DEFAULT NULL,
  `courseTitle` varchar(100) DEFAULT NULL,
  `courseUnit` int(2) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rainvenue2`
--

INSERT INTO `rainvenue2` (`ID`, `courseCode`, `courseTitle`, `courseUnit`) VALUES
(1, 'CSC312', 'System Analysis and Design Methodologies', 3),
(2, 'free', '', 0),
(3, 'free', '', 0),
(4, 'CSC302', 'Object Oriented Programming', 3),
(5, 'free', '', 0),
(6, 'free', '', 0),
(7, 'free', '', 0),
(8, 'free', '', 0),
(9, 'free', '', 0),
(10, 'free', '', 0),
(11, 'free', '', 0),
(12, 'CPE502', 'Hardware System Studies', 3),
(13, 'free', '', 0),
(14, 'free', '', 0),
(15, 'CSC304', 'Business and Commercial Programming', 2),
(16, 'free', '', 0),
(17, 'free', '', 0),
(18, 'free', '', 0),
(19, 'free', '', 0),
(20, 'free', '', 0),
(21, 'free', '', 0),
(22, 'free', '', 0),
(23, 'free', '', 0),
(24, 'free', '', 0),
(25, 'free', '', 0),
(26, 'CPE206', 'Digital Laboratory I', 2),
(27, 'free', '', 0),
(28, 'free', '', 0),
(29, 'free', '', 0),
(30, 'free', '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `rain_`
--

CREATE TABLE `rain_` (
  `id` int(5) NOT NULL,
  `courseCode` varchar(6) DEFAULT NULL,
  `courseTitle` varchar(100) DEFAULT NULL,
  `courseUnit` int(2) DEFAULT NULL,
  `lectureDuration` int(2) DEFAULT NULL,
  `coursePopulation` int(3) DEFAULT NULL,
  `courseDescription` varchar(150) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rain_`
--

INSERT INTO `rain_` (`id`, `courseCode`, `courseTitle`, `courseUnit`, `lectureDuration`, `coursePopulation`, `courseDescription`) VALUES
(1, 'CSC102', 'Introduction to Computing II', 2, 2, 150, 'Description'),
(2, 'CPE204', 'Introduction to Digital Computer System II', 2, 2, 150, 'Description'),
(3, 'CSC302', 'Object Oriented Programming', 3, 2, 150, 'Description'),
(8, 'CSC308', 'Numerical Computation II', 2, 2, 150, 'Description'),
(9, 'CSC306', 'Introduction to Human-Computer Interaction', 3, 2, 150, 'Description'),
(10, 'CPE310', 'Introduction to Agent-based Systems', 2, 2, 150, 'Description'),
(11, 'CPE316', 'Introduction to Artificial Intelligence', 2, 2, 150, 'Description'),
(12, 'CPE206', 'Digital Laboratory I', 2, 2, 70, 'Description'),
(13, 'CPE502', 'Hardware System Studies', 3, 1, 150, 'Description'),
(14, 'CPE502', 'Hardware System Studies', 3, 2, 150, 'Description'),
(15, 'CPE506', 'Industrial Application Studies', 2, 2, 150, 'Description'),
(16, 'CPE508', 'Computer System Project Management', 3, 2, 150, 'Description'),
(17, 'CPE510', 'Natural Language Processing and Applications', 3, 2, 150, 'Description'),
(18, 'CPE514', 'Computer Graphics', 2, 2, 60, 'Description'),
(19, 'CSC520', 'Expert Systems', 2, 2, 60, 'Description'),
(20, 'CSC522', 'Information Storage and Retrieval', 2, 2, 60, 'Description'),
(21, 'CSC524', 'Techniques in Data Analysis', 2, 2, 60, 'Description'),
(22, 'CSC304', 'Business and Commercial Programming', 2, 2, 70, 'Description'),
(23, 'CSC312', 'System Analysis and Design Methodologies', 3, 2, 70, 'Description'),
(24, 'EEE301', 'Microelectronics I', 3, 1, 1000, 'Introduction to Semiconductor'),
(25, 'EEE301', 'Microelectronics I', 3, 2, 1000, 'Introduction to Semiconductor');

-- --------------------------------------------------------

--
-- Table structure for table `rain_tablevenue1`
--

CREATE TABLE `rain_tablevenue1` (
  `ID` int(5) NOT NULL,
  `courseCode` varchar(6) DEFAULT NULL,
  `courseTitle` varchar(100) DEFAULT NULL,
  `courseUnit` int(2) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rain_tablevenue1`
--

INSERT INTO `rain_tablevenue1` (`ID`, `courseCode`, `courseTitle`, `courseUnit`) VALUES
(1, 'free', '', 0),
(2, 'CSC308', 'Numerical Computation II', 2),
(3, 'free', '', 0),
(4, 'free', '', 0),
(5, 'free', '', 0),
(6, 'free', '', 0),
(7, 'free', '', 0),
(8, 'CPE514', 'Computer Graphics', 2),
(9, 'CSC312', 'System Analysis and Design Methodologies', 3),
(10, 'free', '', 0),
(11, 'free', '', 0),
(12, 'free', '', 0),
(13, 'CSC522', 'Information Storage and Retrieval', 2),
(14, 'free', '', 0),
(15, 'free', '', 0),
(16, 'free', '', 0),
(17, 'free', '', 0),
(18, 'free', '', 0),
(19, 'free', '', 0),
(20, 'free', '', 0),
(21, 'free', '', 0),
(22, 'free', '', 0),
(23, 'free', '', 0),
(24, 'free', '', 0),
(25, 'free', '', 0),
(26, 'CSC102', 'Introduction to Computing II', 2),
(27, 'free', '', 0),
(28, 'free', '', 0),
(29, 'CSC304', 'Business and Commercial Programming', 2),
(30, 'free', '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `rain_tablevenue2`
--

CREATE TABLE `rain_tablevenue2` (
  `ID` int(5) NOT NULL,
  `courseCode` varchar(6) DEFAULT NULL,
  `courseTitle` varchar(100) DEFAULT NULL,
  `courseUnit` int(2) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rain_tablevenue2`
--

INSERT INTO `rain_tablevenue2` (`ID`, `courseCode`, `courseTitle`, `courseUnit`) VALUES
(1, 'free', '', 0),
(2, 'free', '', 0),
(3, 'CPE510', 'Natural Language Processing and Applications', 3),
(4, 'free', '', 0),
(5, 'free', '', 0),
(6, 'free', '', 0),
(7, 'free', '', 0),
(8, 'CPE508', 'Computer System Project Management', 3),
(9, 'free', '', 0),
(10, 'free', '', 0),
(11, 'free', '', 0),
(12, 'CPE502', 'Hardware System Studies', 3),
(13, 'free', '', 0),
(14, 'free', '', 0),
(15, 'free', '', 0),
(16, 'free', '', 0),
(17, 'free', '', 0),
(18, 'free', '', 0),
(19, 'CPE206', 'Digital Laboratory I', 2),
(20, 'CSC524', 'Techniques in Data Analysis', 2),
(21, 'free', '', 0),
(22, 'CPE502', 'Hardware System Studies', 3),
(23, 'free', '', 0),
(24, 'free', '', 0),
(25, 'free', '', 0),
(26, 'CPE316', 'Introduction to Artificial Intelligence', 2),
(27, 'free', '', 0),
(28, 'free', '', 0),
(29, 'CSC520', 'Expert Systems', 2),
(30, 'free', '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `timetable2017venue1`
--

CREATE TABLE `timetable2017venue1` (
  `ID` int(5) NOT NULL,
  `courseCode` varchar(6) DEFAULT NULL,
  `courseTitle` varchar(100) DEFAULT NULL,
  `courseUnit` int(2) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `timetable2017venue1`
--

INSERT INTO `timetable2017venue1` (`ID`, `courseCode`, `courseTitle`, `courseUnit`) VALUES
(1, 'free', '', 0),
(2, 'free', '', 0),
(3, 'free', '', 0),
(4, 'CPE316', 'Introduction to Artificial Intelligence', 2),
(5, 'free', '', 0),
(6, 'free', '', 0),
(7, 'free', '', 0),
(8, 'CSC520', 'Expert Systems', 2),
(9, 'free', '', 0),
(10, 'free', '', 0),
(11, 'free', '', 0),
(12, 'free', '', 0),
(13, 'free', '', 0),
(14, 'free', '', 0),
(15, 'CSC306', 'Introduction to Human-Computer Interaction', 3),
(16, 'free', '', 0),
(17, 'free', '', 0),
(18, 'free', '', 0),
(19, 'free', '', 0),
(20, 'free', '', 0),
(21, 'CPE514', 'Computer Graphics', 2),
(22, 'free', '', 0),
(23, 'free', '', 0),
(24, 'free', '', 0),
(25, 'CSC102', 'Introduction to Computing II', 2),
(26, 'free', '', 0),
(27, 'CPE502', 'Hardware System Studies', 3),
(28, 'free', '', 0),
(29, 'free', '', 0),
(30, 'free', '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `timetable2017venue2`
--

CREATE TABLE `timetable2017venue2` (
  `ID` int(5) NOT NULL,
  `courseCode` varchar(6) DEFAULT NULL,
  `courseTitle` varchar(100) DEFAULT NULL,
  `courseUnit` int(2) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `timetable2017venue2`
--

INSERT INTO `timetable2017venue2` (`ID`, `courseCode`, `courseTitle`, `courseUnit`) VALUES
(1, 'CPE508', 'Computer System Project Management', 3),
(2, 'free', '', 0),
(3, 'free', '', 0),
(4, 'free', '', 0),
(5, 'free', '', 0),
(6, 'free', '', 0),
(7, 'free', '', 0),
(8, 'free', '', 0),
(9, 'CPE310', 'Introduction to Agent-based Systems', 2),
(10, 'CPE502', 'Hardware System Studies', 3),
(11, 'free', '', 0),
(12, 'free', '', 0),
(13, 'free', '', 0),
(14, 'free', '', 0),
(15, 'free', '', 0),
(16, 'CSC522', 'Information Storage and Retrieval', 2),
(17, 'free', '', 0),
(18, 'free', '', 0),
(19, 'CSC304', 'Business and Commercial Programming', 2),
(20, 'CSC312', 'System Analysis and Design Methodologies', 3),
(21, 'free', '', 0),
(22, 'CPE510', 'Natural Language Processing and Applications', 3),
(23, 'free', '', 0),
(24, 'free', '', 0),
(25, 'free', '', 0),
(26, 'free', '', 0),
(27, 'free', '', 0),
(28, 'free', '', 0),
(29, 'free', '', 0),
(30, 'free', '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `timetablename`
--

CREATE TABLE `timetablename` (
  `id` int(3) NOT NULL,
  `name` varchar(20) NOT NULL DEFAULT 'Not_Named'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `timetablename`
--

INSERT INTO `timetablename` (`id`, `name`) VALUES
(122, 'Rain_2017/2018'),
(121, 'Rain_Table'),
(119, 'Timetable2017'),
(115, 'Rain'),
(113, 'Harmattan');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `harmattanvenue1`
--
ALTER TABLE `harmattanvenue1`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `harmattanvenue2`
--
ALTER TABLE `harmattanvenue2`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `harmattan_`
--
ALTER TABLE `harmattan_`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `harmat_`
--
ALTER TABLE `harmat_`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hvenue1`
--
ALTER TABLE `hvenue1`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `hvenue2`
--
ALTER TABLE `hvenue2`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `processtb`
--
ALTER TABLE `processtb`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rainvenue1`
--
ALTER TABLE `rainvenue1`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `rainvenue2`
--
ALTER TABLE `rainvenue2`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `rain_`
--
ALTER TABLE `rain_`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rain_tablevenue1`
--
ALTER TABLE `rain_tablevenue1`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `rain_tablevenue2`
--
ALTER TABLE `rain_tablevenue2`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `timetable2017venue1`
--
ALTER TABLE `timetable2017venue1`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `timetable2017venue2`
--
ALTER TABLE `timetable2017venue2`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `timetablename`
--
ALTER TABLE `timetablename`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `harmattanvenue1`
--
ALTER TABLE `harmattanvenue1`
  MODIFY `ID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `harmattanvenue2`
--
ALTER TABLE `harmattanvenue2`
  MODIFY `ID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `harmattan_`
--
ALTER TABLE `harmattan_`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
--
-- AUTO_INCREMENT for table `harmat_`
--
ALTER TABLE `harmat_`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `hvenue1`
--
ALTER TABLE `hvenue1`
  MODIFY `ID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `hvenue2`
--
ALTER TABLE `hvenue2`
  MODIFY `ID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `processtb`
--
ALTER TABLE `processtb`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2628;
--
-- AUTO_INCREMENT for table `rainvenue1`
--
ALTER TABLE `rainvenue1`
  MODIFY `ID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `rainvenue2`
--
ALTER TABLE `rainvenue2`
  MODIFY `ID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `rain_`
--
ALTER TABLE `rain_`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT for table `rain_tablevenue1`
--
ALTER TABLE `rain_tablevenue1`
  MODIFY `ID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `rain_tablevenue2`
--
ALTER TABLE `rain_tablevenue2`
  MODIFY `ID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `timetable2017venue1`
--
ALTER TABLE `timetable2017venue1`
  MODIFY `ID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `timetable2017venue2`
--
ALTER TABLE `timetable2017venue2`
  MODIFY `ID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `timetablename`
--
ALTER TABLE `timetablename`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=123;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

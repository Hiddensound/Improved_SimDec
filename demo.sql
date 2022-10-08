-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 08, 2022 at 05:32 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `demo`
--

-- --------------------------------------------------------

--
-- Table structure for table `avgscores`
--

CREATE TABLE `avgscores` (
  `filenames` varchar(255) NOT NULL,
  `keywordscore` varchar(255) NOT NULL,
  `identifierscore` varchar(255) NOT NULL,
  `mathscore` varchar(255) NOT NULL,
  `numscore` varchar(255) NOT NULL,
  `logscore` varchar(255) NOT NULL,
  `otheropscore` varchar(255) NOT NULL,
  `avgscore` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `avgscores`
--

INSERT INTO `avgscores` (`filenames`, `keywordscore`, `identifierscore`, `mathscore`, `numscore`, `logscore`, `otheropscore`, `avgscore`) VALUES
('student1120.cstudent1326.c', '1.0', '0.8698386272823401', '1.0', '1.0', '1.0', '0.8921731548353684', '0.960335297019618'),
('student1326.cstudent1120.c', '1.0', '0.8698386272823401', '1.0', '1.0', '1.0', '0.8921731548353684', '0.960335297019618');

-- --------------------------------------------------------

--
-- Table structure for table `distance`
--

CREATE TABLE `distance` (
  `filenames` varchar(255) NOT NULL,
  `keyword_lev` varchar(255) NOT NULL,
  `jaro_dis` varchar(255) NOT NULL,
  `jaro_wink` varchar(255) NOT NULL,
  `dice` varchar(255) NOT NULL,
  `longest_sub` text NOT NULL,
  `lcb_length` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `distance`
--

INSERT INTO `distance` (`filenames`, `keyword_lev`, `jaro_dis`, `jaro_wink`, `dice`, `longest_sub`, `lcb_length`) VALUES
('student1120.cstudent1326.c', '1.0', '1.0', '1.0', '1.0', '[float, if, if, else, else, return]', '35.0'),
('student1326.cstudent1120.c', '1.0', '1.0', '1.0', '1.0', '[float, if, if, else, else, return]', '35.0');

-- --------------------------------------------------------

--
-- Table structure for table `finalfile_distance`
--

CREATE TABLE `finalfile_distance` (
  `filenames` varchar(255) NOT NULL,
  `filestr1` text NOT NULL,
  `filestr2` text NOT NULL,
  `final_lev` varchar(255) NOT NULL,
  `final_jaro` varchar(255) NOT NULL,
  `final_jarow` varchar(255) NOT NULL,
  `final_dice` varchar(255) NOT NULL,
  `final_lcb` text NOT NULL,
  `final_lcblength` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `finalfile_distance`
--

INSERT INTO `finalfile_distance` (`filenames`, `filestr1`, `filestr2`, `final_lev`, `final_jaro`, `final_jarow`, `final_dice`, `final_lcb`, `final_lcblength`) VALUES
('student1120.cstudent1326.c', '[float, if, if, else, else, return][=, =, -, -, +, *, /][0][&&, &&, &, &, &, &][(, ), {, (, ), (, ), (, ), {, (, ), }, (, ), {, (, ), }, {, (, ), (, ), (, ), }, }][main, a1, b1, a2, b2, x, y, printf, scanf, \"Paralelne su\", \"Poklapaju se\"]', '[float, if, if, else, else, return][=, =, -, -, +, *, /][0][&&, &&, &, &, &, &][(, ), {, (, ), (, ), (, (, ), (, ), ), {, (, ), }, (, (, ), (, ), ), {, (, ), }, {, (, ), (, ), (, ), }, }][main, a1, b1, a2, b2, X, Y, printf, scanf, \" Paralelne su\", \" Poklapaju se\"]', '0.9015151515151515', '0.9039357396785114', '0.9423614438071068', '0.924', '[float, if, if, else, else, return][=, =, -, -, +, *, /][0][&&, &&, &, &, &, &][(, ), {, (, ), (, ), (, ', '104.0'),
('student1326.cstudent1120.c', '[float, if, if, else, else, return][=, =, -, -, +, *, /][0][&&, &&, &, &, &, &][(, ), {, (, ), (, ), (, (, ), (, ), ), {, (, ), }, (, (, ), (, ), ), {, (, ), }, {, (, ), (, ), (, ), }, }][main, a1, b1, a2, b2, X, Y, printf, scanf, \" Paralelne su\", \" Poklapaju se\"]', '[float, if, if, else, else, return][=, =, -, -, +, *, /][0][&&, &&, &, &, &, &][(, ), {, (, ), (, ), (, ), {, (, ), }, (, ), {, (, ), }, {, (, ), (, ), (, ), }, }][main, a1, b1, a2, b2, x, y, printf, scanf, \"Paralelne su\", \"Poklapaju se\"]', '0.9015151515151515', '0.9039357396785114', '0.9423614438071068', '0.924', '[float, if, if, else, else, return][=, =, -, -, +, *, /][0][&&, &&, &, &, &, &][(, ), {, (, ), (, ), (, ', '104.0');

-- --------------------------------------------------------

--
-- Table structure for table `identifier_score`
--

CREATE TABLE `identifier_score` (
  `filenames` varchar(255) NOT NULL,
  `iden_lev` varchar(255) NOT NULL,
  `iden_jaro` varchar(255) NOT NULL,
  `iden_jarowink` varchar(255) NOT NULL,
  `iden_dice` varchar(255) NOT NULL,
  `iden_lcb` text NOT NULL,
  `iden_lcb_length` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `identifier_score`
--

INSERT INTO `identifier_score` (`filenames`, `iden_lev`, `iden_jaro`, `iden_jarowink`, `iden_dice`, `iden_lcb`, `iden_lcb_length`) VALUES
('student1120.cstudent1326.c', '0.974025974025974', '0.9144343632014865', '0.948660617920892', '0.9066666666666666', '[main, a1, b1, a2, b2, ', '23.0'),
('student1326.cstudent1120.c', '0.974025974025974', '0.9144343632014865', '0.948660617920892', '0.9066666666666666', '[main, a1, b1, a2, b2, ', '23.0');

-- --------------------------------------------------------

--
-- Table structure for table `keywords`
--

CREATE TABLE `keywords` (
  `filenames` varchar(255) NOT NULL,
  `keylist1` varchar(255) NOT NULL,
  `keylist2` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `logical_distance`
--

CREATE TABLE `logical_distance` (
  `filenames` varchar(255) NOT NULL,
  `logical_lev` varchar(255) NOT NULL,
  `logical_jaro` varchar(255) NOT NULL,
  `logical_jarow` varchar(255) NOT NULL,
  `logical_dice` varchar(255) NOT NULL,
  `logical_lcb` text NOT NULL,
  `logical_lcblength` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `logical_distance`
--

INSERT INTO `logical_distance` (`filenames`, `logical_lev`, `logical_jaro`, `logical_jarow`, `logical_dice`, `logical_lcb`, `logical_lcblength`) VALUES
('student1120.cstudent1326.c', '1.0', '1.0', '1.0', '1.0', '[&&, &&, &, &, &, &]', '20.0'),
('student1326.cstudent1120.c', '1.0', '1.0', '1.0', '1.0', '[&&, &&, &, &, &, &]', '20.0');

-- --------------------------------------------------------

--
-- Table structure for table `math_distance`
--

CREATE TABLE `math_distance` (
  `filenames` varchar(255) NOT NULL,
  `math_lev` varchar(255) NOT NULL,
  `math_jaro` varchar(255) NOT NULL,
  `math_jarow` varchar(255) NOT NULL,
  `math_dice` varchar(255) NOT NULL,
  `math_lcb` text NOT NULL,
  `math_lcblength` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `math_distance`
--

INSERT INTO `math_distance` (`filenames`, `math_lev`, `math_jaro`, `math_jarow`, `math_dice`, `math_lcb`, `math_lcblength`) VALUES
('student1120.cstudent1326.c', '1.0', '1.0', '1.0', '1.0', '[=, =, -, -, +, *, /]', '21.0'),
('student1326.cstudent1120.c', '1.0', '1.0', '1.0', '1.0', '[=, =, -, -, +, *, /]', '21.0');

-- --------------------------------------------------------

--
-- Table structure for table `num_distance`
--

CREATE TABLE `num_distance` (
  `filenames` varchar(255) NOT NULL,
  `num_lev` varchar(255) NOT NULL,
  `num_jaro` varchar(255) NOT NULL,
  `num_jarow` varchar(255) NOT NULL,
  `num_dice` varchar(255) NOT NULL,
  `num_lcb` text NOT NULL,
  `num_lcblength` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `num_distance`
--

INSERT INTO `num_distance` (`filenames`, `num_lev`, `num_jaro`, `num_jarow`, `num_dice`, `num_lcb`, `num_lcblength`) VALUES
('student1120.cstudent1326.c', '1.0', '1.0', '1.0', '1.0', '[0]', '3.0'),
('student1326.cstudent1120.c', '1.0', '1.0', '1.0', '1.0', '[0]', '3.0');

-- --------------------------------------------------------

--
-- Table structure for table `otherops_distance`
--

CREATE TABLE `otherops_distance` (
  `filenames` varchar(255) NOT NULL,
  `otherops_lev` varchar(255) NOT NULL,
  `otherops_jaro` varchar(255) NOT NULL,
  `otherops_jarow` varchar(255) NOT NULL,
  `otherops_dice` varchar(255) NOT NULL,
  `otherops_lcb` text NOT NULL,
  `otherops_lcblength` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `otherops_distance`
--

INSERT INTO `otherops_distance` (`filenames`, `otherops_lev`, `otherops_jaro`, `otherops_jarow`, `otherops_dice`, `otherops_lcb`, `otherops_lcblength`) VALUES
('student1120.cstudent1326.c', '0.7777777777777778', '0.8842592592592592', '0.9305555555555555', '0.8736842105263158', ', ), {, (, ), }, {, (, ), (, ), (, ), }, }]', '43.0'),
('student1326.cstudent1120.c', '0.7777777777777778', '0.8842592592592592', '0.9305555555555555', '0.8736842105263158', ', ), {, (, ), }, {, (, ), (, ), (, ), }, }]', '43.0');

-- --------------------------------------------------------

--
-- Table structure for table `scores`
--

CREATE TABLE `scores` (
  `filenames` varchar(255) NOT NULL,
  `keywordscore` varchar(255) NOT NULL,
  `mathopscore` varchar(255) NOT NULL,
  `numericalscore` varchar(255) NOT NULL,
  `logicalscore` varchar(255) NOT NULL,
  `otheropscore` varchar(255) NOT NULL,
  `totalsimilarity` varchar(255) NOT NULL,
  `totaldissimilarity` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `scores`
--

INSERT INTO `scores` (`filenames`, `keywordscore`, `mathopscore`, `numericalscore`, `logicalscore`, `otheropscore`, `totalsimilarity`, `totaldissimilarity`) VALUES
('student1120.cstudent1326.c', '100', '125', '100', '50', '13', '48', '52'),
('student1326.cstudent1120.c', '100', '125', '100', '50', '13', '48', '52');

-- --------------------------------------------------------

--
-- Table structure for table `webtable`
--

CREATE TABLE `webtable` (
  `filenames` varchar(255) NOT NULL,
  `avgscores` varchar(255) NOT NULL,
  `plagiarism` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `webtable`
--

INSERT INTO `webtable` (`filenames`, `avgscores`, `plagiarism`) VALUES
('student1120.cstudent1326.c', '0.960335297019618', 'High'),
('student1326.cstudent1120.c', '0.960335297019618', 'High');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

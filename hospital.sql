-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 05, 2021 at 08:58 PM
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
-- Database: `hospital`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `uname` varchar(20) NOT NULL,
  `pwd` varchar(20) NOT NULL,
  `fname` varchar(20) NOT NULL,
  `lname` varchar(20) NOT NULL,
  `hom` varchar(50) NOT NULL,
  `mob` varchar(10) NOT NULL,
  `gen` varchar(10) NOT NULL,
  `dateAdmit` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`uname`, `pwd`, `fname`, `lname`, `hom`, `mob`, `gen`, `dateAdmit`) VALUES
('vivid', 'vizard', 'Vishnuraj', '', 'Tirunelveli', '9159227894', 'Male', '2021-05-06');

-- --------------------------------------------------------

--
-- Table structure for table `appoinment`
--

CREATE TABLE `appoinment` (
  `uname` varchar(20) NOT NULL,
  `pwd` varchar(20) NOT NULL,
  `fname` varchar(20) NOT NULL,
  `lname` varchar(20) NOT NULL,
  `hom` varchar(50) NOT NULL,
  `mob` varchar(10) NOT NULL,
  `sym` varchar(50) NOT NULL,
  `gen` varchar(10) NOT NULL,
  `diag` varchar(50) NOT NULL,
  `med` varchar(50) NOT NULL,
  `dateAdmit` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `appoinment`
--

INSERT INTO `appoinment` (`uname`, `pwd`, `fname`, `lname`, `hom`, `mob`, `sym`, `gen`, `diag`, `med`, `dateAdmit`) VALUES
('Birdie', '10', 'Sansa', 'Stark', 'North', '4789541236', 'Cold', 'Female', 'Diabetes', 'Sildenali', '2020-07-14'),
('Dani', '10', 'Daenerys', 'Targaryen', 'Old Valyria', '1547968432', 'Fever', 'Female', 'Madness', 'Dasatinib', '2017-01-04'),
('Danii', '10', 'Johnny', 'Sins', 'USA', '9159227894', 'Cold', 'Male', 'Tumors', 'Crocin', '2020-12-16'),
('gunther', '10', 'Gunther', 'Magnuson', 'Mellowbrook', '9468741236', 'Fever', 'Male', 'Pneumonia', 'Sunitnali', '2019-08-23'),
('gwen', '10', 'Triss', 'Marigold', 'UK', '476315742', 'Fever', 'Female', 'Cholera', 'Pazopanib', '2019-06-18'),
('jamie', '10', 'Jamie', 'Lannister', 'Casterly Rock', '4789541236', 'Fever', 'Male', 'Diabetes', 'Sildenali', '2018-08-14'),
('Loras', '10', 'Loras', 'Tyrell', 'HighGarden', '4123654973', 'Fever', 'Others', 'Alzheimer', 'Antinali', '2020-10-14'),
('Ned', '10', 'Eddard', 'Stark', 'Winterfell', '3489541236', 'Fever', 'Male', 'Alzheimer', 'Antinali', '2017-08-14');

-- --------------------------------------------------------

--
-- Table structure for table `discharge`
--

CREATE TABLE `discharge` (
  `uname` varchar(20) NOT NULL,
  `pwd` varchar(20) NOT NULL,
  `fname` varchar(20) NOT NULL,
  `lname` varchar(20) NOT NULL,
  `hom` varchar(50) NOT NULL,
  `mob` varchar(10) NOT NULL,
  `sym` varchar(50) NOT NULL,
  `gen` varchar(10) NOT NULL,
  `diag` varchar(50) NOT NULL,
  `med` varchar(50) NOT NULL,
  `dateAdmit` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `discharge`
--

INSERT INTO `discharge` (`uname`, `pwd`, `fname`, `lname`, `hom`, `mob`, `sym`, `gen`, `diag`, `med`, `dateAdmit`) VALUES
('Drogo', '10', 'Daenerys', 'Targaryen', 'Old Valyria', '1547968432', 'Fever', 'Female', 'Madness', 'Dasatinib', '2017-01-04'),
('Edd', '10', 'Eddard', 'Stark', 'Winterfell', '3489541236', 'Fever', 'Male', 'Alzheimer', 'Antinali', '2017-08-14'),
('High', '10', 'Johnny', 'Sins', 'USA', '9159227894', 'Cold', 'Male', 'Tumors', 'Crocin', '2020-12-16'),
('king', '10', 'Gunther', 'Magnuson', 'Mellowbrook', '9468741236', 'Fever', 'Male', 'Pneumonia', 'Sunitnali', '2019-08-23'),
('Kingslayer', '10', 'Jamie', 'Lannister', 'Casterly Rock', '4789541236', 'Fever', 'Male', 'Diabetes', 'Sildenali', '2018-08-14'),
('Olenna', '10', 'Loras', 'Tyrell', 'HighGarden', '4123654973', 'Fever', 'Others', 'Alzheimer', 'Antinali', '2020-10-14'),
('queen', '10', 'Triss', 'Marigold', 'UK', '476315742', 'Fever', 'Female', 'Cholera', 'Pazopanib', '2019-06-18'),
('Ramsay', '10', 'Sansa', 'Stark', 'North', '4789541236', 'Cold', 'Female', 'Diabetes', 'Sildenali', '2020-07-14');

-- --------------------------------------------------------

--
-- Table structure for table `doc`
--

CREATE TABLE `doc` (
  `uname` varchar(20) NOT NULL,
  `pwd` varchar(20) NOT NULL,
  `fname` varchar(20) NOT NULL,
  `lname` varchar(20) NOT NULL,
  `hom` varchar(50) NOT NULL,
  `mob` varchar(10) NOT NULL,
  `dep` varchar(50) NOT NULL,
  `gen` varchar(10) NOT NULL,
  `dateAdmit` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `doc`
--

INSERT INTO `doc` (`uname`, `pwd`, `fname`, `lname`, `hom`, `mob`, `dep`, `gen`, `dateAdmit`) VALUES
('ben', '10', 'Triss', 'Marigold', 'UK', '476315742', 'Cardiologist', 'Female', '2019-06-18'),
('catie', '10', 'Eddard', 'Stark', 'Winterfell', '3489541236', 'Neurologist', 'Male', '2017-08-14'),
('cersei', '10', 'Jamie', 'Lannister', 'Casterly Rock', '4789541236', 'Orthopaedic', 'Male', '2018-08-14'),
('Fire', '10', 'Daenerys', 'Targaryen', 'Old Valyria', '1547968432', 'Psychiatrists', 'Female', '2017-01-04'),
('Kat', '10', 'Lysa', 'Arryn', 'Vales', '8948764697', 'General', 'Radiologis', '2019-03-02'),
('Kate', '10', 'Catlyn', 'Stark', 'Winterfell', '4789487635', 'Pulmonologist', 'Female', '2018-11-30'),
('kick', '10', 'Gunther', 'Magnuson', 'Mellowbrook', '9468741236', 'Pulmonologist', 'Male', '2019-08-23'),
('Loras', '10', 'Loras', 'Tyrell', 'Highgarden', '9227894876', 'Endocrinologist', 'Others', '2016-10-04'),
('Renly', '10', 'Loras', 'Tyrell', 'HighGarden', '4123654973', 'Radiologist', 'Others', '2020-10-14'),
('Stark', '10', 'Sansa', 'Stark', 'North', '4789541236', 'Oncologist', 'Female', '2020-07-14'),
('witcher', '10', 'Geralt', 'Rivia', 'UK', '9159227894', 'Gynaecologist', 'Male', '2020-04-14'),
('YouKnow', '10', 'Johnny', 'Sins', 'USA', '9159227894', 'Paediatrician', 'Male', '2020-12-16');

-- --------------------------------------------------------

--
-- Table structure for table `don`
--

CREATE TABLE `don` (
  `u` varchar(20) NOT NULL,
  `f` varchar(20) NOT NULL,
  `l` varchar(20) NOT NULL,
  `g` varchar(10) NOT NULL,
  `ag` varchar(10) NOT NULL,
  `bg` varchar(10) NOT NULL,
  `hom` varchar(50) NOT NULL,
  `pin` varchar(10) NOT NULL,
  `stat` varchar(20) NOT NULL,
  `coun` varchar(20) NOT NULL,
  `weig` varchar(10) NOT NULL,
  `heig` varchar(10) NOT NULL,
  `medi` varchar(10) NOT NULL,
  `dise` varchar(10) NOT NULL,
  `mob` varchar(10) NOT NULL,
  `dateReg` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `don`
--

INSERT INTO `don` (`u`, `f`, `l`, `g`, `ag`, `bg`, `hom`, `pin`, `stat`, `coun`, `weig`, `heig`, `medi`, `dise`, `mob`, `dateReg`) VALUES
('Cersi', 'Cersi', 'Lannister', 'Female', '35', 'B+', 'Kingslanding', '579134', 'Tamil Nadu', 'India', 'Yes', 'Yes', 'No', 'No', '9159227894', '2021-03-16'),
('chan', 'Jackie', 'Chan', 'Male', '45', 'A+', 'Wuhan', '149834', 'Beijing', 'China', 'No', 'Yes', 'Yes', 'No', '3648227894', '2019-06-23'),
('Noone', 'Arya', 'Stark', 'Female', '25', 'B-', 'Essos', '579134', 'Tamil Nadu', 'India', 'Yes', 'Yes', 'No', 'No', '9187327888', '2019-11-30');

-- --------------------------------------------------------

--
-- Table structure for table `done`
--

CREATE TABLE `done` (
  `u` varchar(20) NOT NULL,
  `f` varchar(20) NOT NULL,
  `l` varchar(20) NOT NULL,
  `g` varchar(10) NOT NULL,
  `ag` varchar(10) NOT NULL,
  `bg` varchar(10) NOT NULL,
  `hom` varchar(50) NOT NULL,
  `pin` varchar(10) NOT NULL,
  `stat` varchar(20) NOT NULL,
  `coun` varchar(20) NOT NULL,
  `medi` varchar(10) NOT NULL,
  `dise` varchar(10) NOT NULL,
  `mob` varchar(10) NOT NULL,
  `dateReg` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `done`
--

INSERT INTO `done` (`u`, `f`, `l`, `g`, `ag`, `bg`, `hom`, `pin`, `stat`, `coun`, `medi`, `dise`, `mob`, `dateReg`) VALUES
('Bran', 'Brandon', 'Stark', 'Female', '25', 'O-', 'Winterfell', '874631', 'Andhra Pradesh', 'India', 'No', 'Tes', '9187327888', '2019-11-30'),
('Mormont', 'Jorah', 'Mormont', 'Male', '19', 'AB-', 'Essos', '579134', 'Tamil Nadu', 'India', 'No', 'No', '9159227894', '2021-03-16'),
('Rose', 'Olenna', 'Tyrell', 'Female', '45', 'A+', 'Wuhan', '149834', 'Beijing', 'China', 'Yes', 'No', '3648227894', '2019-06-23');

-- --------------------------------------------------------

--
-- Table structure for table `hold`
--

CREATE TABLE `hold` (
  `uname` varchar(20) NOT NULL,
  `pwd` varchar(20) NOT NULL,
  `fname` varchar(20) NOT NULL,
  `lname` varchar(20) NOT NULL,
  `hom` varchar(50) NOT NULL,
  `mob` varchar(10) NOT NULL,
  `dep` varchar(50) NOT NULL,
  `gen` varchar(10) NOT NULL,
  `dateAdmit` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hold`
--

INSERT INTO `hold` (`uname`, `pwd`, `fname`, `lname`, `hom`, `mob`, `dep`, `gen`, `dateAdmit`) VALUES
('Arryn', '10', 'Gunther', 'Magnuson', 'Mellowbrook', '9468741236', 'Pulmonologist', 'Male', '2021-04-23'),
('Barton', '10', 'Loras', 'Tyrell', 'HighGarden', '4123654973', 'Radiologist', 'Others', '2021-05-01'),
('Flakes', '10', 'Sansa', 'Stark', 'North', '4789541236', 'Oncologist', 'Female', '2021-05-01'),
('Kale', '10', 'Eddard', 'Stark', 'Winterfell', '3489541236', 'Neurologist', 'Male', '2021-05-02'),
('Khal', '10', 'Jamie', 'Lannister', 'Casterly Rock', '4789541236', 'Orthopaedic', 'Male', '2021-05-03'),
('Khaleesi', '10', 'Daenerys', 'Targaryen', 'Old Valyria', '1547968432', 'Psychiatrists', 'Female', '2021-04-23');

-- --------------------------------------------------------

--
-- Table structure for table `oldpatient`
--

CREATE TABLE `oldpatient` (
  `uname` varchar(20) NOT NULL,
  `pwd` varchar(20) NOT NULL,
  `fname` varchar(20) NOT NULL,
  `lname` varchar(20) NOT NULL,
  `hom` varchar(50) NOT NULL,
  `mob` varchar(10) NOT NULL,
  `sym` varchar(50) NOT NULL,
  `gen` varchar(10) NOT NULL,
  `diag` varchar(50) NOT NULL,
  `med` varchar(50) NOT NULL,
  `dateAdmit` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `oldpatient`
--

INSERT INTO `oldpatient` (`uname`, `pwd`, `fname`, `lname`, `hom`, `mob`, `sym`, `gen`, `diag`, `med`, `dateAdmit`) VALUES
('Birdi', '10', 'Sansa', 'Stark', 'North', '4789541236', 'Cold', 'Female', 'Diabetes', 'Sildenali', '2020-07-14'),
('Daniels', '10', 'Johnny', 'Sins', 'USA', '9159227894', 'Cold', 'Male', 'Tumors', 'Crocin', '2020-12-16'),
('friend', '10', 'Gunther', 'Magnuson', 'Mellowbrook', '9468741236', 'Fever', 'Male', 'Pneumonia', 'Sunitnali', '2019-08-23'),
('jam', '10', 'Jamie', 'Lannister', 'Casterly Rock', '4789541236', 'Fever', 'Male', 'Diabetes', 'Sildenali', '2018-08-14'),
('Jon', '10', 'Daenerys', 'Targaryen', 'Old Valyria', '1547968432', 'Fever', 'Female', 'Madness', 'Dasatinib', '2017-01-04'),
('Snow', '10', 'Eddard', 'Stark', 'Winterfell', '3489541236', 'Fever', 'Male', 'Alzheimer', 'Antinali', '2017-08-14'),
('Tyrell', '10', 'Loras', 'Tyrell', 'HighGarden', '4123654973', 'Fever', 'Others', 'Alzheimer', 'Antinali', '2020-10-14'),
('witch', '10', 'Triss', 'Marigold', 'UK', '476315742', 'Fever', 'Female', 'Cholera', 'Pazopanib', '2019-06-18');

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `uname` varchar(20) NOT NULL,
  `pwd` varchar(20) NOT NULL,
  `fname` varchar(20) NOT NULL,
  `lname` varchar(20) NOT NULL,
  `hom` varchar(50) NOT NULL,
  `mob` varchar(10) NOT NULL,
  `sym` varchar(50) NOT NULL,
  `gen` varchar(10) NOT NULL,
  `dateAdmit` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`uname`, `pwd`, `fname`, `lname`, `hom`, `mob`, `sym`, `gen`, `dateAdmit`) VALUES
('ben', '10', 'Triss', 'Marigold', 'UK', '476315742', 'Fever', 'Female', '2019-06-18'),
('catie', '10', 'Eddard', 'Stark', 'Winterfell', '3489541236', 'Fever', 'Male', '2017-08-14'),
('cersei', '10', 'Jamie', 'Lannister', 'Casterly Rock', '4789541236', 'Fever', 'Male', '2018-08-14'),
('Fire', '10', 'Daenerys', 'Targaryen', 'Old Valyria', '1547968432', 'Fever', 'Female', '2017-01-04'),
('kick', '10', 'Gunther', 'Magnuson', 'Mellowbrook', '9468741236', 'Fever', 'Male', '2019-08-23'),
('Renly', '10', 'Loras', 'Tyrell', 'HighGarden', '4123654973', 'Fever', 'Others', '2020-10-14'),
('Stark', '10', 'Sansa', 'Stark', 'North', '4789541236', 'Cold', 'Female', '2020-07-14'),
('YouKnow', '10', 'Johnny', 'Sins', 'USA', '9159227894', 'Cold', 'Male', '2020-12-16');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`uname`);

--
-- Indexes for table `appoinment`
--
ALTER TABLE `appoinment`
  ADD PRIMARY KEY (`uname`);

--
-- Indexes for table `discharge`
--
ALTER TABLE `discharge`
  ADD PRIMARY KEY (`uname`);

--
-- Indexes for table `doc`
--
ALTER TABLE `doc`
  ADD PRIMARY KEY (`uname`);

--
-- Indexes for table `don`
--
ALTER TABLE `don`
  ADD PRIMARY KEY (`u`);

--
-- Indexes for table `done`
--
ALTER TABLE `done`
  ADD PRIMARY KEY (`u`);

--
-- Indexes for table `hold`
--
ALTER TABLE `hold`
  ADD PRIMARY KEY (`uname`);

--
-- Indexes for table `oldpatient`
--
ALTER TABLE `oldpatient`
  ADD PRIMARY KEY (`uname`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`uname`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

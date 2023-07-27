-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: carrentalsystem
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `carbookings`
--

DROP TABLE IF EXISTS `carbookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carbookings` (
  `bookingID` double NOT NULL AUTO_INCREMENT,
  `pickuplocation` varchar(15) DEFAULT NULL,
  `dropofflocation` varchar(15) DEFAULT NULL,
  `pickpdate` varchar(15) DEFAULT NULL,
  `dropoffdate` varchar(15) DEFAULT NULL,
  `pickuptime` varchar(15) DEFAULT NULL,
  `dropofftime` varchar(15) DEFAULT NULL,
  `nameofbooker` varchar(30) DEFAULT NULL,
  `phoneofbooker` varchar(15) DEFAULT NULL,
  `emailofbooker` varchar(30) DEFAULT NULL,
  `carofbooker` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`bookingID`)
) ENGINE=InnoDB AUTO_INCREMENT=9072008412 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carbookings`
--

LOCK TABLES `carbookings` WRITE;
/*!40000 ALTER TABLE `carbookings` DISABLE KEYS */;
INSERT INTO `carbookings` VALUES (1157758532,' San Pablo',' Paete','21 Jul 2023',' 21 Aug 2023',' 20 : 15',' 10 : 09','John Carlo Anñonuevo','09964564453','karlo@gmail.com','   Honda Civic'),(1277324850,' Victoria',' Paete','22 Jul 2023',' 23 Aug 2023',' 21 : 18',' 08 : 16','John Acel Vera Cruz','09964558123','johnacel@gmail.com','   Honda Civic'),(1864413860,' Biñan',' Biñan','4 May 2023',' 3 Mar 2023',' 02 : 01',' 01 : 01','Marc Ken E. Arbas','09184702466','codenamemonika@gmail.com',' Toyota Accord'),(3828203173,' Siniloan',' Nagcarlan','22 Jul 2023',' 16 Aug 2023',' 21 : 15',' 10 : 18','Iven Felix Seredilla	','09964558123','ivenfelix@gmail.com','Toyota Fortuner'),(8568197294,' San Pablo',' Pagsanjan','22 Jun 2023',' 15 Jul 2023',' 18 : 00',' 07 : 00','Marc Ken E. Arbas	','09184702566','marcken9@gmail.com	','Toyota Fortuner');
/*!40000 ALTER TABLE `carbookings` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-27 10:14:15

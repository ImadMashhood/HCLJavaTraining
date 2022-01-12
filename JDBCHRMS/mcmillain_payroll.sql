-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: mcmillain
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `payroll`
--

DROP TABLE IF EXISTS `payroll`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payroll` (
  `User_ID` int NOT NULL,
  `Pay` double DEFAULT NULL,
  `Tax` double DEFAULT NULL,
  `Medical_Insurance` double DEFAULT NULL,
  `Dental_Insurance` double DEFAULT NULL,
  `Vision_Insurance` double DEFAULT NULL,
  `401k` double DEFAULT NULL,
  `Vacation_Days` int DEFAULT NULL,
  `Sick_Days` int DEFAULT NULL,
  `overtime_Pay` double DEFAULT NULL,
  `overtime_Hours` double DEFAULT NULL,
  KEY `User_ID` (`User_ID`),
  CONSTRAINT `payroll_ibfk_1` FOREIGN KEY (`User_ID`) REFERENCES `employee_personal_record` (`User_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payroll`
--

LOCK TABLES `payroll` WRITE;
/*!40000 ALTER TABLE `payroll` DISABLE KEYS */;
INSERT INTO `payroll` VALUES (1,80000,25,335.86,0,0,2,14,20,40,0),(2,74000,10,335.86,226.54,0,3,8,16,38,0),(3,140000,34,0,0,91.21,99.9,3,20,90,0),(4,46000,20,224.56,0,73.21,0,5,13,37,0),(5,96000,32,0,0,0,0,2,12,70,0);
/*!40000 ALTER TABLE `payroll` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-12 13:00:36

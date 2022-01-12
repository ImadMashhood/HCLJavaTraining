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
-- Table structure for table `employee_personal_record`
--

DROP TABLE IF EXISTS `employee_personal_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_personal_record` (
  `User_ID` int NOT NULL AUTO_INCREMENT,
  `First_Name` varchar(40) NOT NULL,
  `Last_Name` varchar(40) NOT NULL,
  `Phone_Number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Address` varchar(200) DEFAULT NULL,
  `City` varchar(100) DEFAULT NULL,
  `State` varchar(100) DEFAULT NULL,
  `Zip_Code` varchar(5) DEFAULT NULL,
  `Email` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`User_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_personal_record`
--

LOCK TABLES `employee_personal_record` WRITE;
/*!40000 ALTER TABLE `employee_personal_record` DISABLE KEYS */;
INSERT INTO `employee_personal_record` VALUES (1,'Little','Wayne III','919-419-5969','2930 Manchester Rd','Ralay','NC','56344','LittleMan@bing.com'),(2,'Jaseh','Onfroy','618-666-2018','444 Deerfield Beach Ln','Palm beach','AK','56474','MEMBERSONLY@gmail.com'),(3,'Carl','Bob IV','910-444-6666','2333 Bagwell Ave','Ocala','FL','45677','FredrickDouglas32@yahoo.com'),(4,'Chett','Chuggy','910-888-5555','435 Six Fingers CT','Japan','VA','34565','CoopyMar@gmail.com'),(5,'Drake','Smith','910-445-7899','3489 Marvins Room Rd','Jibudi','TX','78567','DrChrisBrownDaMan@yahoo.com'),(6,'Da','Baby','912-666-2021','3872 Fraggle Drive','Sharington','MA','56477','DASAYBY@yahoo.com'),(7,'Candice','Caroll','252-557-9238','345 Dishnet CIR','Auburn','AL','36801','CanyC101@aol.com');
/*!40000 ALTER TABLE `employee_personal_record` ENABLE KEYS */;
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

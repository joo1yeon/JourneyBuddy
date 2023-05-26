-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: enjoytrip
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `hotplace`
--

DROP TABLE IF EXISTS `hotplace`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotplace` (
  `hotplace_id` int NOT NULL AUTO_INCREMENT,
  `place_id` varchar(45) NOT NULL,
  `writer` varchar(45) NOT NULL,
  `place_name` varchar(45) NOT NULL,
  `contents` varchar(45) NOT NULL,
  `score` int NOT NULL,
  `hit` int DEFAULT '0',
  `rcmd_cnt` int NOT NULL DEFAULT '0',
  `place_type` varchar(45) DEFAULT NULL,
  `hotplace_title` varchar(255) DEFAULT NULL,
  `visit_date` date DEFAULT NULL,
  PRIMARY KEY (`hotplace_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotplace`
--

LOCK TABLES `hotplace` WRITE;
/*!40000 ALTER TABLE `hotplace` DISABLE KEYS */;
INSERT INTO `hotplace` VALUES (1,'1','1','1','1',5,0,0,'1','1',NULL),(2,'126078','','광안리해수욕장','ㅁ',5,0,0,'12','ㅁㅁ',NULL),(3,'126078','','광안리해수욕장','ㅁ',5,0,0,'12','ㅁㅁ',NULL),(4,'126078','','광안리해수욕장','ㅁ',5,0,0,'12','ㅁㅁ',NULL),(5,'126078','','광안리해수욕장','ㄷㄷ',5,0,0,'12','ㄷㄷ',NULL),(6,'126078','','광안리해수욕장','ㄷㄷㄷ',5,0,0,'12','ㄷㄷㄷ',NULL),(7,'126078','','광안리해수욕장','sss',5,0,0,'12','ss',NULL),(8,'126078','','광안리해수욕장','qqqq',5,0,0,'12','qqq',NULL),(9,'126078','','광안리해수욕장','ttt',5,0,0,'12','ttt',NULL),(10,'126078','','광안리해수욕장','ww',5,0,0,'12','www','2023-05-17'),(11,'126078','ssafy35','광안리해수욕장','ttt',5,0,0,'12','tt','2023-05-30');
/*!40000 ALTER TABLE `hotplace` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-26  9:00:08

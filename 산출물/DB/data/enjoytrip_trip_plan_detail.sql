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
-- Table structure for table `trip_plan_detail`
--

DROP TABLE IF EXISTS `trip_plan_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trip_plan_detail` (
  `trip_plan_detail_id` int NOT NULL AUTO_INCREMENT,
  `plan_num` int NOT NULL,
  `writer` varchar(45) NOT NULL,
  `detail_content_id` varchar(50) DEFAULT NULL,
  `detail_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `detail_info` varchar(45) DEFAULT NULL,
  `sequence` int NOT NULL,
  PRIMARY KEY (`trip_plan_detail_id`),
  KEY `trip_plan_detail_to_trip_plan_plan_num_fk_idx` (`plan_num`),
  CONSTRAINT `trip_plan_detail_to_trip_plan_plan_num_fk` FOREIGN KEY (`plan_num`) REFERENCES `trip_plan` (`trip_plan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip_plan_detail`
--

LOCK TABLES `trip_plan_detail` WRITE;
/*!40000 ALTER TABLE `trip_plan_detail` DISABLE KEYS */;
INSERT INTO `trip_plan_detail` VALUES (7,8,'ssafy','126078','2023-05-22 15:00:00','4시 해수욕',1),(8,8,'ssafy','133262','2023-05-22 15:00:00','6시 저녁',2),(9,9,'ssafy','130065','2023-05-22 15:00:00','1시에 박물관',1),(10,9,'ssafy','2664983','2023-05-22 15:00:00','오후 5시 반에 저녁',2),(11,13,'ssafy','126320','2023-05-22 15:00:00','공원 산책',1),(12,13,'ssafy','2759619','2023-05-22 15:00:00','저녁 식사',2),(13,14,'ssafy','126486','2023-05-22 15:00:00','산책',1),(14,14,'ssafy','854285','2023-05-22 15:00:00','저녁',2),(15,15,'ssafy','126078','2023-05-23 15:00:00','123',1),(16,16,'ssafy','126320','2023-05-23 15:00:00','산책',1),(17,16,'ssafy','1855062','2023-05-23 15:00:00','저녁 약속',2),(18,17,'ssafy','126838','2023-05-23 15:00:00','공원 산책',1),(19,17,'ssafy','842921','2023-05-23 15:00:00','저녁 약속',2),(20,17,'ssafy','2837500','2023-05-24 15:00:00','아침 간식',3);
/*!40000 ALTER TABLE `trip_plan_detail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-26  8:55:43

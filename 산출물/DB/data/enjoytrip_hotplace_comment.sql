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
-- Table structure for table `hotplace_comment`
--

DROP TABLE IF EXISTS `hotplace_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotplace_comment` (
  `hotplace_comment_id` int NOT NULL AUTO_INCREMENT,
  `hotplace_id` int NOT NULL,
  `writer` varchar(45) NOT NULL,
  `contents` varchar(45) DEFAULT NULL,
  `register_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`hotplace_comment_id`),
  KEY `hotplace_comment_to_hotplace_hotplace_id_fk_idx` (`hotplace_id`),
  CONSTRAINT `hotplace_comment_to_hotplace_hotplace_id_fk` FOREIGN KEY (`hotplace_id`) REFERENCES `hotplace` (`hotplace_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotplace_comment`
--

LOCK TABLES `hotplace_comment` WRITE;
/*!40000 ALTER TABLE `hotplace_comment` DISABLE KEYS */;
INSERT INTO `hotplace_comment` VALUES (1,11,'ssafy35','???','2023-05-25 00:33:53'),(2,11,'ssafy35','댓글을 작성해본다.','2023-05-25 00:37:53'),(3,11,'ssafy35','???','2023-05-25 00:39:51'),(4,11,'ssafy35','???','2023-05-25 00:42:26'),(5,11,'ssafy35','??????','2023-05-25 00:53:17'),(6,11,'ssafy35','!!!!!','2023-05-25 00:53:23'),(7,11,'ssafy35','???','2023-05-25 01:01:48'),(8,11,'ssafy35','???','2023-05-25 01:03:01'),(9,11,'ssafy35','@@@','2023-05-25 01:08:20'),(10,11,'ssafy35','###','2023-05-25 01:08:30'),(11,11,'ssafy35','삭제못함','2023-05-25 01:11:26'),(12,11,'ssafy35','ㅋㅋ','2023-05-25 01:13:03'),(13,11,'ssafy35','ㅋㅋ','2023-05-25 01:17:22'),(14,11,'ssafy35','ㅎㅎ','2023-05-25 01:17:47'),(15,11,'ssafy35','ㄱㄱ','2023-05-25 01:17:52'),(16,11,'ssafy35','ㅇㅇ','2023-05-25 01:17:55'),(17,11,'ssafy35','ㅎㅎ','2023-05-25 01:18:24'),(18,11,'ssafy35','11111','2023-05-25 04:22:23');
/*!40000 ALTER TABLE `hotplace_comment` ENABLE KEYS */;
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

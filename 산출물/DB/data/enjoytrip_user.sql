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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` varchar(45) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `email_id` varchar(45) NOT NULL,
  `email_domain` varchar(45) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `register_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `token` varchar(1000) DEFAULT NULL,
  `birth_date` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('','','','','','1','2023-05-15 08:53:54',NULL,''),('ssafy','김싸피','1234','ssafy','ssafy.com','여','2023-04-14 07:59:41',NULL,'2023-05-03'),('ssafy10','','$2a$10$9NE/3g7HP2twbWgW5D3DauQhUsHzkQoB18r.O0lTMvOTYZOWvOA/q','ssafy10','ssafy.com','','2023-05-16 08:21:46',NULL,''),('ssafy11','김사피','$2a$10$KJR5E5PzO1pdgsMe.vuEJeltKvAzpTo0qVVH/O3/.CsA4KHt2H3fy','ssafy11','ssafy.com','1','2023-05-16 08:27:13',NULL,'2023-05-17'),('ssafy12','김사피','1234','ssafy12','ssafy.com','','2023-05-16 08:28:08',NULL,'2023-05-18'),('ssafy13','','1234','ssafy13','ssafy.com','','2023-05-16 08:47:10',NULL,''),('ssafy14','ssafy14','$2a$10$GGOT.NTUtNFVZ7nYArc71.6UNli2Rxjiq965HcEhMuZLQ0rR6U4li','ssafy14','ssafy.com','1','2023-05-17 03:04:45',NULL,'2023-05-18'),('ssafy15','ssafy15','$2a$10$0ehB2WzLD5MnHtQw1sMbJ.6BRrU14Kq54mevlDX3eNIe0wXOo9.PG','ssafy15','ssafy.com','1','2023-05-17 05:21:48',NULL,'2023-05-18'),('ssafy16','ssafy16','$2a$10$V/GnLKtRdVzZ2tt6d7/f9uCump0Sg8rVCSeI30jXPstTw7X8u5/LG','ssafy16','ssafy.com','1','2023-05-17 05:26:52',NULL,'2023-05-18'),('ssafy17','','$2a$10$zd2ysn8fq8ZuaIWIOsdp6OWkZwvS8vqCv/nOKvdiNSgfegB0sqjiu','','0','','2023-05-17 07:09:47',NULL,''),('ssafy18','ssafy17','$2a$10$v5j4GzAi4BNKt7z1bgZsMeUiRUuzGpWHwdK/wvkRH1F4MLA0xh31C','ssafy18','ssafy.com','1','2023-05-17 08:45:36',NULL,'2023-05-18'),('ssafy19','김사피','1234','ssafy19','ssafy.com','','2023-05-18 02:18:13',NULL,''),('ssafy2','박싸피','1234','ssafy2','ssafy.com','남','2023-04-14 08:00:08',NULL,NULL),('ssafy20','','$2a$10$PjwXxNHu57guCsxu49hrielzN/PbNyljYQ5UstgYQFUEvM.afyow2','','0','','2023-05-18 02:58:06',NULL,''),('ssafy21','','$2a$10$XIwfBqWHY3oEFlvSiC2vWeDQdkGCtF1Y.K2GNS..AXDVRzQphyF3C','','0','','2023-05-19 01:29:03',NULL,''),('ssafy22','','$2a$10$NJYJEEF78du.wtdEGcmrAuwSSKNFf2rR.12xynUsIpEduSQHeMhyC','','0','','2023-05-19 01:29:51',NULL,''),('ssafy23','김사피','$2a$10$itDUGdqjjd4E9aAcTX4KsOM7f/xcp6eMugO94CuUGs3rfganiWW8a','ssafy23','ssafy.com','1','2023-05-19 05:19:52','eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2ODQ2MTAzMzB9.uokEZ5H91atcEx3p3bWMQPFqQoa7ZLEtJ0lPMT0J8Ro','2023-05-20'),('ssafy33','ssafy33','1234','','','1','2023-05-16 02:58:48',NULL,'2023-05-17'),('ssafy34','김사피','$2a$10$7zlbZ0paxPwNgR2shF2CsuT.YBcNLkxX8hsy5ak3FoIzBpXW/kM5G','ssafy34','ssafy.com','1','2023-05-23 00:16:53',NULL,'2023-05-31'),('ssafy35','김사피','$2a$10$v82PGoYUeH9Rc6d9Zy1EvuJsa6XWBJcOWo//tlt9sXclXnXV9xSnS','ssafy35','ssafy.com','1','2023-05-23 00:17:54','eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2ODUxODg1NTF9.G-5Ehy2r7950s5j7MdzdH7A3CziN8zkMS_kuKRih9k8','2023-05-31'),('ssafy36','김사피','$2a$10$chW9xlA4ebrmX4m5DSJBoe4UrQpRtfIAFqXGNSZoy3TEmX77Zsdni','ssafy36','ssafy.com','1','2023-05-25 05:01:11',NULL,'2023-05-23'),('ssafy5','김사피','$2a$10$1qcdLZpPWUKRyS6oBW21POddzVxLEjZvW6IYnD4DDSko.gksNmePa','ssafy5','ssafy.com','1','2023-05-16 07:51:17',NULL,'2023-05-17'),('ssafy6','김사피','$2a$10$dc3boAPxbigqu9jk1fTO9eQtbsZCq5CBxQpf.jDKu/LIaUew6vaia','ssafy6','ssafy.com','1','2023-05-16 07:59:39',NULL,'2023-05-17'),('ssafy7','김사피','$2a$10$Fddb6Vu1e1ZLvKfXMWpape1I/MKSSs7tfZ4Zcj8QmbsP/eHVLM5YO','ssafy7','ssafy.com','1','2023-05-16 08:11:44',NULL,'2023-05-17'),('ssafy8','김사피','1234','ssafy8','ssafy.com','1','2023-05-16 08:16:53',NULL,'2023-05-17'),('ssafy9','','1234','ssafy9','ssafy.com','','2023-05-16 08:20:34',NULL,''),('string','222','asdfasdf','string','string','string','2023-05-03 02:33:44',NULL,'string'),('test','test','$2a$10$QbH3Y7kyidKpNY7htgknE.Gs45XJVUWoglZgF.Xo2Dd0b1W1B4W1m','','0','','2023-05-16 08:03:43',NULL,'');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
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

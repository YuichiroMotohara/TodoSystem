-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: todosystem
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `users2`
--

DROP TABLE IF EXISTS `users2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users2` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user` varchar(50) NOT NULL,
  `pass` varchar(255) NOT NULL,
  `family_name` varchar(50) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `is_deleted` tinyint NOT NULL,
  `create_date_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `role` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users2`
--

LOCK TABLES `users2` WRITE;
/*!40000 ALTER TABLE `users2` DISABLE KEYS */;
INSERT INTO `users2` VALUES (1,'mos','$2a$10$xRTXvpMWly0oGiu65WZlm.3YL95LGVV2ASFjDhe6WF4.Qji1huIPa','Isono','Namihei',0,'2020-04-23 00:00:00','2020-04-23 00:00:00','ROLE_MOS'),(2,'mos2','$2a$10$xRTXvpMWly0oGiu65WZlm.3YL95LGVV2ASFjDhe6WF4.Qji1huIPa','Ogata','Ken',0,'2020-04-23 00:00:00','2020-04-23 00:00:00','ROLE_MOS'),(3,'landwehr','password2','hans','schneider',0,'2021-05-21 15:37:27','2021-05-21 15:37:27','一般社員'),(4,'landwehr','password2','hans','schneider',0,'2021-05-21 15:37:28','2021-05-21 15:37:28','一般社員'),(5,'landwehr','password2','hans','schneider',0,'2021-05-21 15:37:28','2021-05-21 15:37:28','一般社員'),(6,'landwehr','password2','hans','schneider',0,'2021-05-21 15:37:29','2021-05-21 15:37:29','一般社員'),(7,'landwehr','password2','hans','schneider',0,'2021-05-21 15:37:29','2021-05-21 15:37:29','一般社員'),(8,'landwehr','password2','hans','schneider',0,'2021-05-21 15:37:29','2021-05-21 15:37:29','一般社員'),(9,'landwehr','password2','hans','schneider',0,'2021-05-21 15:37:29','2021-05-21 15:37:29','一般社員'),(10,'test','password2','hans','schneider',0,'2021-05-21 15:43:53','2021-05-21 15:43:53','一般社員'),(11,'landwehr','password2','hans','schneider',0,'2021-05-21 15:48:56','2021-05-21 15:48:56','ROLE_MOS'),(12,'landwehr','password2','max','schneider',0,'2021-05-21 15:51:51','2021-05-21 15:51:51','ROLE_MOS'),(13,'landwehr3','password3','ron','michel',0,'2021-05-25 15:16:45','2021-05-25 15:16:45','ROLE_MOS'),(14,'landwehr','password2','hans','schneider',0,'2021-05-26 15:03:37','2021-05-26 15:03:37','ROLE_MOS'),(15,'katze1','$2a$10$vLrj/eXGhyzljLMcgtrvtOZB76HbtFkhamXrXoBwnAg.VhHkW.hca','piltz','smith',0,'2021-05-26 15:42:49','2021-05-26 15:42:49','ROLE_MOS'),(16,'fm34','$2a$10$unuvrzO5jGnKyXviMvq/PuOcPOwtCBla0xBuRKZWhCcMbVpunkEN2','hans','jack',0,'2021-05-26 15:44:38','2021-05-26 15:44:38','ROLE_MOS'),(17,'landwehr3','$2a$10$.RaCifSHUOdbJHUK9IHXpOg3lg04.uI0rz2tNrvuuis2JlykeCRKC','hans','schneider',0,'2021-05-26 15:52:49','2021-05-26 15:52:49','ROLE_MOS'),(18,'mosdos','$2a$10$j8YhODIFZ5eR2EVrmDICoO.bg/jqUr81i/gHpuYzyYooJQCEWK4UO','jack','daniel',0,'2021-06-01 15:17:58','2021-06-01 15:17:58','ROLE_MOS'),(19,'march ','$2a$10$1RcG2E2U5XmPpmsqRNzQouPAMGf/ctC3pDsWDhKHAZiEohe4BL..6','max','min',0,'2021-06-04 14:32:35','2021-06-04 14:32:35','ROLE_MOS'),(20,'landwehr','$2a$10$aWMl/08j2b1.64Ct0ZI1HO13yxnh5L534swgtXgru1udg5mvV/TNm','hans','schneider',0,'2021-06-04 15:03:37','2021-06-04 15:03:37','ROLE_MOS'),(21,'gos','$2a$10$JXNJr7NZq9/TnLyy9FRbGOiuqFzQ2hMvEnF2Jt5tYWBjNF92e7FOe','hans','schneider',0,'2021-06-04 15:14:06','2021-06-04 15:14:06','ROLE_MOS'),(22,'gos2','$2a$10$RrU0mfKOQfhPB/GIwhYqY.0P2Y.vqomctPc0koC1./5p60cdue0iG','hans','schneider',0,'2021-06-04 15:19:53','2021-06-04 15:19:53','ROLE_MOS'),(23,'lanwelt','$2a$10$wvXn1cntUYD3UcIwlfEiFeSCOJqiYDU.L69jvFDE51EpIIHh2ihty','ron','schneider',0,'2021-06-07 14:39:18','2021-06-07 14:39:18','ROLE_MOS'),(24,'landwehr3','$2a$10$mA8WEaamVK6IFAzwymr.qOMt698JwTlMHOp5RFISt0ZmX7R3wjePm','georg','fest',0,'2021-06-10 15:04:33','2021-06-10 15:04:33','ROLE_MOS'),(25,'landwehr3','$2a$10$XndAdTqk/aeehwkrDPYlcOOYuNdUWAotyzfXIY1GiftnfDsQ8KrPm','hans','rock',0,'2021-06-10 15:07:30','2021-06-10 15:07:30','ROLE_MOS'),(26,'rock111','$2a$10$bGSQKp4KnK5QBtDEiBt.TubXwO8VbpCdy09MlCbQgiZmRvS2nvBSe','max','rock111',0,'2021-07-28 15:16:16','2021-07-28 15:16:16','ROLE_MOS');
/*!40000 ALTER TABLE `users2` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-29 14:59:28

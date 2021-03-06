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
-- Table structure for table `todo_items`
--

DROP TABLE IF EXISTS `todo_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `todo_items` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `item_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `registration_date` date DEFAULT NULL,
  `expire_date` date DEFAULT NULL,
  `finished_date` date DEFAULT NULL,
  `is_deleted` tinyint NOT NULL DEFAULT '0',
  `create_date_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_date_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `todo_items`
--

LOCK TABLES `todo_items` WRITE;
/*!40000 ALTER TABLE `todo_items` DISABLE KEYS */;
INSERT INTO `todo_items` VALUES (1,1,'test1','2020-12-03','2020-06-30','2020-12-03',1,'2020-12-03 15:22:29','2020-12-03 15:22:29'),(2,1,'rockwell1515','2020-12-09','2021-11-11','2021-03-22',0,'2020-12-09 14:23:44','2020-12-09 14:23:44'),(3,1,'test3','2020-12-09',NULL,'2020-12-09',1,'2020-12-09 14:30:35','2020-12-09 14:30:35'),(4,1,'test4','2020-12-09','2020-12-20','2020-12-09',1,'2020-12-09 14:30:41','2020-12-09 14:30:41'),(5,1,'test99','2020-12-09','2021-11-11','2020-12-09',1,'2020-12-09 14:31:48','2020-12-09 14:31:48'),(7,1,'23cvb','2021-02-09','2021-07-25',NULL,1,'2021-02-09 14:43:05','2021-02-09 14:43:05'),(8,1,'c5','2021-02-10','2021-07-30',NULL,1,'2021-02-10 14:12:52','2021-02-10 14:12:52'),(9,1,'','2021-02-10',NULL,NULL,1,'2021-02-10 14:57:31','2021-02-10 14:57:31'),(10,1,'satou','2021-02-10','2021-04-15',NULL,1,'2021-02-10 14:58:36','2021-02-10 14:58:36'),(11,1,'abc','2021-11-11','2021-11-11',NULL,0,'2021-02-10 15:05:33','2021-02-10 15:05:33'),(12,1,'????????????','2021-02-10','2022-11-15','2021-03-11',0,'2021-02-10 15:24:26','2021-02-10 15:24:26'),(13,1,'????????????','2021-02-10','2021-11-11',NULL,1,'2021-02-10 15:26:29','2021-02-10 15:26:29'),(14,1,'ginkgo2030','2021-02-16','2025-05-23',NULL,1,'2021-02-16 15:17:38','2021-02-16 15:17:38'),(15,1,'c4isr','2021-02-18','2021-10-16','2021-07-01',0,'2021-02-18 14:37:32','2021-02-18 14:37:32'),(16,2,'c4','2021-02-26','2021-12-23',NULL,0,'2021-02-26 15:19:03','2021-02-26 15:19:03'),(17,2,'test7','2021-02-26','2021-04-15','2021-03-10',1,'2021-02-26 15:19:19','2021-02-26 15:19:19'),(18,1,'maxrock1975','2021-03-01','2022-11-11','2021-03-11',1,'2021-03-01 14:51:28','2021-03-01 14:51:28'),(19,1,'?????????????????????','2021-03-03','2021-09-25','2021-07-01',0,'2021-03-03 14:45:36','2021-03-03 14:45:36'),(20,2,'????????????','2021-03-03','2021-11-11',NULL,0,'2021-03-03 15:13:55','2021-03-03 15:13:55'),(21,1,'','2021-03-17',NULL,NULL,1,'2021-03-17 14:20:08','2021-03-17 14:20:08'),(22,1,'','2021-03-17',NULL,NULL,1,'2021-03-17 14:20:11','2021-03-17 14:20:11'),(23,1,'','2021-03-17',NULL,NULL,1,'2021-03-17 14:20:17','2021-03-17 14:20:17'),(24,1,'','2021-03-17',NULL,NULL,1,'2021-03-17 14:52:02','2021-03-17 14:52:02'),(25,1,'','2021-03-17',NULL,NULL,1,'2021-03-17 14:52:53','2021-03-17 14:52:53'),(26,1,'','2021-03-17',NULL,NULL,1,'2021-03-17 15:00:43','2021-03-17 15:00:43'),(27,1,'','2021-03-17',NULL,NULL,1,'2021-03-17 15:27:33','2021-03-17 15:27:33'),(28,2,'','2021-03-17',NULL,NULL,1,'2021-03-17 15:30:19','2021-03-17 15:30:19'),(29,1,'','2021-03-18',NULL,NULL,1,'2021-03-18 14:50:03','2021-03-18 14:50:03'),(30,1,'satous','2021-03-18','2021-12-01',NULL,1,'2021-03-18 15:11:18','2021-03-18 15:11:18'),(31,1,'','2021-03-18',NULL,NULL,1,'2021-03-18 15:11:32','2021-03-18 15:11:32'),(32,1,'','2021-03-18',NULL,NULL,1,'2021-03-18 15:23:44','2021-03-18 15:23:44'),(33,1,'','2021-03-18',NULL,NULL,1,'2021-03-18 15:27:10','2021-03-18 15:27:10'),(34,1,'','2021-03-19',NULL,NULL,1,'2021-03-19 14:29:56','2021-03-19 14:29:56'),(35,2,'hksfp9','2021-03-24','2021-04-23',NULL,1,'2021-03-24 15:05:49','2021-03-24 15:05:49'),(36,1,'rend','2021-03-24','2021-03-22',NULL,1,'2021-03-24 15:30:19','2021-03-24 15:30:19'),(37,2,'rk2332','2021-03-26','2021-03-22','2021-04-09',1,'2021-03-26 15:33:45','2021-03-26 15:33:45'),(38,2,'roman27','2021-04-20',NULL,NULL,1,'2021-04-20 15:20:32','2021-04-20 15:20:32'),(39,1,'','2021-04-20',NULL,NULL,1,'2021-04-20 15:20:35','2021-04-20 15:20:35'),(40,1,'','2021-04-20',NULL,NULL,1,'2021-04-20 15:20:38','2021-04-20 15:20:38'),(41,1,'c4','2021-04-20',NULL,NULL,1,'2021-04-20 15:20:43','2021-04-20 15:20:43'),(42,2,'c234','2021-04-20','2022-01-31',NULL,0,'2021-04-20 15:24:49','2021-04-20 15:24:49'),(43,1,'satous','2021-04-20','2021-12-01',NULL,0,'2021-04-20 15:31:53','2021-04-20 15:31:53'),(44,1,'c4','2021-04-20','2021-12-01',NULL,0,'2021-04-20 15:34:09','2021-04-20 15:34:09'),(45,1,'','2021-05-06',NULL,NULL,1,'2021-05-06 15:23:15','2021-05-06 15:23:15'),(46,1,'','2021-05-06',NULL,NULL,1,'2021-05-06 15:23:22','2021-05-06 15:23:22'),(47,1,'','2021-05-06',NULL,NULL,1,'2021-05-06 15:25:31','2021-05-06 15:25:31'),(48,1,'','2021-05-06',NULL,NULL,1,'2021-05-06 15:25:37','2021-05-06 15:25:37'),(49,1,'','2021-05-06',NULL,NULL,1,'2021-05-06 15:26:45','2021-05-06 15:26:45'),(50,1,'remiku','2021-05-07','2021-12-02',NULL,0,'2021-05-07 14:45:44','2021-05-07 14:45:44'),(51,1,'','2021-05-07',NULL,NULL,1,'2021-05-07 14:48:30','2021-05-07 14:48:30'),(52,1,'','2021-05-07',NULL,NULL,1,'2021-05-07 14:54:32','2021-05-07 14:54:32'),(53,1,'last0ne','2021-12-23','2022-02-25','2022-01-10',1,'2021-05-21 15:32:24','2021-05-21 15:32:24'),(54,1,'last0ne','2021-12-23','2022-02-25','2022-01-10',0,'2021-05-21 15:32:25','2021-05-21 15:32:25'),(61,2,'c5','2021-11-01','2022-09-10','2021-12-23',0,'2021-06-08 15:39:39','2021-06-08 15:39:39'),(62,2,'d5','2021-11-01','2022-09-10','2021-12-23',0,'2021-06-08 15:39:47','2021-06-08 15:39:47'),(63,2,NULL,NULL,NULL,NULL,1,'2021-11-01 00:00:00','2022-09-10 00:00:00'),(66,2,NULL,NULL,NULL,NULL,1,'2021-11-01 00:00:00','2022-09-10 00:00:00'),(67,3,NULL,NULL,NULL,NULL,1,'2021-11-01 00:00:00','2022-09-10 00:00:00'),(68,10,'c4','2021-06-08','2021-12-01',NULL,0,'2021-06-08 15:55:58','2021-06-08 15:55:58'),(69,10,'fg42','2021-06-08','2021-11-11',NULL,0,'2021-06-08 15:57:18','2021-06-08 15:57:18'),(70,13,'x1','2021-06-10','2021-12-01',NULL,0,'2021-06-10 15:21:46','2021-06-10 15:21:46'),(71,13,'ss33','2021-06-10','2021-12-01',NULL,0,'2021-06-10 15:22:56','2021-06-10 15:22:56'),(72,9,'satous','2021-06-11','2021-12-01',NULL,0,'2021-06-11 15:50:53','2021-06-11 15:50:53'),(73,15,'????????????','2021-06-11','2021-05-01',NULL,0,'2021-06-11 15:51:21','2021-06-11 15:51:21'),(74,19,'bosma','2021-06-11','2021-10-22',NULL,0,'2021-06-11 15:59:12','2021-06-11 15:59:12'),(75,15,'c4','2021-06-14','2021-10-01','2021-07-01',0,'2021-06-14 15:20:52','2021-06-14 15:20:52'),(76,2,'ys','2021-06-17','2021-12-01',NULL,0,'2021-06-17 14:13:58','2021-06-17 14:13:58'),(77,1,'satous','2021-06-22','2021-12-01',NULL,0,'2021-06-22 15:45:02','2021-06-22 15:45:02'),(78,6,'dbs','2021-06-28','2021-07-07',NULL,1,'2021-06-28 14:00:06','2021-06-28 14:00:06'),(79,1,'c4','2021-06-28','2021-12-01',NULL,0,'2021-06-28 14:03:42','2021-06-28 14:03:42'),(80,13,'aaa','2021-06-28','2023-11-11',NULL,0,'2021-06-28 14:13:20','2021-06-28 14:13:20'),(81,15,'c45','2021-06-28','2021-12-01',NULL,0,'2021-06-28 14:15:23','2021-06-28 14:15:23');
/*!40000 ALTER TABLE `todo_items` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-29 14:59:27

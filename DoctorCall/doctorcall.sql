CREATE DATABASE  IF NOT EXISTS `doctorcall` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `doctorcall`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: doctorcall
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `message` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `sender_id` int(11) NOT NULL,
  `recipient_id` int(11) NOT NULL,
  `message` tinytext,
  `creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted_by_sender` tinyint(4) DEFAULT '0',
  `deleted_by_recipient` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`mid`),
  KEY `senderid1_idx` (`sender_id`),
  KEY `recipinetid1_idx` (`recipient_id`),
  CONSTRAINT `recipinetid1` FOREIGN KEY (`recipient_id`) REFERENCES `user` (`uid`),
  CONSTRAINT `senderid1` FOREIGN KEY (`sender_id`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (2,1,2,'Kalimera Ko;ula ti kaneis?','2019-01-14 23:30:01',1,0),(3,2,2,'[message deleted by admin]','2019-01-14 23:31:01',0,0),(5,1,2,'Hello Hello Heloo','2019-01-14 23:31:01',1,0),(6,2,2,'[message deleted by admin]','2019-01-14 23:31:01',0,0),(7,2,1,'ddsaddsfs','2019-01-27 17:17:42',0,1),(9,4,2,'Kalimera giatre','2019-01-27 22:30:05',1,0),(10,4,2,'Kalimera giatre','2019-01-27 22:30:55',0,1),(11,4,6,'Geia sas kiria Soula, ti kanete?','2019-01-27 22:59:57',0,0),(12,4,4,'[please do not use the app for advertising other apps!]','2019-01-27 23:13:25',0,1),(13,4,4,'hello 1','2019-01-27 23:14:43',0,1),(14,4,4,'test2','2019-01-28 00:29:58',0,1),(15,10,1,'hello admin, state authority here','2019-01-28 01:13:55',0,0),(16,1,8,'hello2 i am the admin','2019-01-28 01:19:52',1,0),(17,1,6,'hello dear Soula','2019-01-28 02:24:40',0,0),(18,1,6,'dasdafadfsdf','2019-01-28 02:28:55',0,0),(19,1,4,'fddasfsdf','2019-01-28 02:30:06',0,0),(20,1,4,' kalo','2019-01-28 02:31:36',0,0),(21,1,4,' Hello Takis','2019-01-28 02:50:23',0,0),(22,1,2,' Gia Koula','2019-01-28 02:56:56',0,0),(23,1,2,' gia xara','2019-01-28 02:57:30',0,0),(24,1,2,'sadad','2019-01-28 03:02:00',0,0),(25,1,9,'dadsa','2019-01-28 03:04:07',0,0),(26,1,9,'heloo to print','2019-01-28 03:14:22',0,0),(27,1,2,'sd','2019-01-28 03:17:32',0,0),(28,1,4,'dada','2019-01-28 03:18:26',0,0),(29,1,9,' hello','2019-01-28 03:28:15',0,0),(30,1,7,' helloa','2019-01-28 03:59:57',0,0),(31,1,7,' hello to print','2019-01-28 04:01:10',0,0),(32,1,2,' Geia saw kyria koula','2019-01-28 04:01:53',0,0),(33,1,9,' minima xoris xreosi','2019-01-28 04:02:24',0,0),(34,2,1,' Geia sas kyrie Admin','2019-01-28 04:03:54',0,0),(35,2,7,'hello mr hello','2019-01-28 04:04:08',0,0),(36,1,2,' geia sou koula','2019-01-28 04:05:10',0,0),(37,10,1,'dsd','2019-01-28 04:08:15',0,0);
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role` (
  `rid` int(11) NOT NULL,
  `role` varchar(100) NOT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Administrator'),(2,'User'),(3,'State Authority');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `role_id` int(11) NOT NULL,
  `deleted` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`uid`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `role_id into user as FK_idx` (`role_id`),
  CONSTRAINT `role_id into user as FK` FOREIGN KEY (`role_id`) REFERENCES `role` (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','admin',1,0),(2,'koula','loukia',2,0),(4,'takis','takias',2,0),(6,'soula','soula',2,0),(7,'hello','hello',2,0),(8,'hello2','hello',2,1),(9,'xarilaos','trikoupis',2,0),(10,'xaril','trikoup',3,0);
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

-- Dump completed on 2019-01-28  4:21:23

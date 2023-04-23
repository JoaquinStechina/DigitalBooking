
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: proyectointegrador
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `caracteristicas`
--

DROP TABLE IF EXISTS `caracteristicas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `caracteristicas` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `icono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caracteristicas`
--

LOCK TABLES `caracteristicas` WRITE;
/*!40000 ALTER TABLE `caracteristicas` DISABLE KEYS */;
/*!40000 ALTER TABLE `caracteristicas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'descripcion hotel','Hoteles','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/hotel/hotel1.jpg'),
(2,'descripcion casas','Casas','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/casas/foto1casa.jpg'),
(3,'descripcion hostel','Hostels','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/hostel/hostel1.jpg'),
(4,'descripcion departamentos','Departamentos','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/departamentos/dep1.jpg');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciudades`
--

DROP TABLE IF EXISTS `ciudades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ciudades` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre_ciudad` varchar(255) DEFAULT NULL,
  `nombre_pais` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudades`
--

LOCK TABLES `ciudades` WRITE;
/*!40000 ALTER TABLE `ciudades` DISABLE KEYS */;
INSERT INTO `ciudades` VALUES (1,'Avellaneda','Argentina'),(2,'Pilar','Argentina'),(3,'San Fernando del Valle','Argentina'),(4,'Reconquista','Argentina'),(5,'Bariloche','Argentina'),(6,'Calafate','Argentina'),(7,'San Luis','Argentina'),(8,'Gualeguaychu','Argentina'),(9,'Obera','Argentina'),(10,'Viedma','Argentina'),(11,'Ciudad de Mexico','Mexico'),(12,'Sao Paulo','Brasil'),(13,'Lima','Peru'),(14,'Monterrey','Mexico'),(15,'Guadalajara','Mexico'),(16,'Porto Alegre','Brasil'),(17,'Fortaleza','Brasil'),(18,'Cali','Colombia'),(19,'Medellín','Colombia'),(20,'Barranquilla','Colombia');
/*!40000 ALTER TABLE `ciudades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imagenes`
--

DROP TABLE IF EXISTS `imagenes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `imagenes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKswpig7nda0oj2ci8rsbto57kg` (`product_id`),
  CONSTRAINT `FKswpig7nda0oj2ci8rsbto57kg` FOREIGN KEY (`product_id`) REFERENCES `productos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imagenes`
--

LOCK TABLES `imagenes` WRITE;
/*!40000 ALTER TABLE `imagenes` DISABLE KEYS */;
INSERT INTO `imagenes` VALUES (1,'balcon1','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/hotel/balcon1.jpg',1),
(2,'balcon2','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/hotel/balcon2.jpg',2),(3,'hotel1','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/hotel/hotel1.jpg',1),
(4,'hotel2','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/hotel/hotel2.jpg',2),(5,'hotel3','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/hotel/hotel33.jpg',3),
(16,'hotel4','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/hotel/hotel4.jpg',4),(6,'livinghotel1','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/hotel/livinghotel1.jpg',1),
(7,'livinghotel2','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/hotel/livinghotel2.jpg',2),(8,'livinghotel3','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/hotel/livinghotel3.jpg',3),
(9,'livinghotel4','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/hotel/livinghotel4.jpg',4),
(10,'pileta1','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/hotel/pileta1.jpg',1),
(11,'pileta2','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/hotel/pileta2.jpg',2),
(12,'pileta3','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/hotel/pileta3.jpg',3),
(13,'pileta4','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/hotel/pileta4.jpg',4),
(14,'terraza1','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/hotel/terraza.jpg',1),
(15,'terraza2','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/hotel/terraza23.jpg',2),
(17,'compartido1','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/hostel/compartido1.jpg',5),
(18,'compartido2','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/hostel/compartido2.jpg',6),
(19,'compartido3','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/hostel/compartido3.jpg',7),
(20,'hostel1','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/hostel/hostel1.jpg',5),
(21,'hostel2','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/hostel/hostel2.jpg',6),
(22,'hostel3','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/hostel/hostel3.jpg',7),
(23,'hostel4','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/hostel/hostel4.jpg',8),
(24,'baño1','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/departamentos/ba%C3%B1o1.jpg',5),
(25,'baño2','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/departamentos/ba%C3%B1o2.jpg',6),
(26,'baño3','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/departamentos/ba%C3%B1o3.jpg',7),
(27,'baño4','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/departamentos/ba%C3%B1o4.jpg',8),
(28,'comedor1','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/departamentos/comedor1.webp',5),
(29,'comedor2','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/departamentos/comedor2.webp',6),
(30,'comedor3','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/departamentos/comedor3.jpg',7),
(31,'dep1','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/departamentos/dep1.jpg',9),
(32,'dep2','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/departamentos/dep2.jpg',10),
(33,'dep3','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/departamentos/dep3.jpg',11),
(34,'dep4','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/departamentos/dep4.jpg',12),
(35,'depliving1','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/departamentos/depliving1.jpg',9),
(36,'depliving2','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/departamentos/depliving2.jpg',10),
(37,'depliving3','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/departamentos/depliving3.jpg',11),
(38,'casa1','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/casas/foto1casa.jpg',13),
(39,'casa2','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/casas/foto2casa.jpg',14),
(40,'casa3','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/casas/foto3casa.jpg',15),
(41,'casa4','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/casas/foto4casa.jpg',16),
(42,'livingcasa1','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/casas/livingcasa1.jpg',13),
(43,'livingcasa2','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/casas/livingcasa2.jpg',14),
(44,'livingcasa3','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/casas/livingcasa3.jpg',15),
(45,'livingcasa4','https://bucket-img-equipo-6.s3.us-east-2.amazonaws.com/img/casas/livingcasa4.jpg',16);
/*!40000 ALTER TABLE `imagenes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto_caracteristica`
--

DROP TABLE IF EXISTS `producto_caracteristica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto_caracteristica` (
  `producto_id` bigint NOT NULL,
  `caracteristica_id` bigint NOT NULL,
  PRIMARY KEY (`producto_id`,`caracteristica_id`),
  KEY `FKp7sxommck2r629h007c2mau4t` (`caracteristica_id`),
  CONSTRAINT `FK3vp3d65unfl7gokrmb6pjf651` FOREIGN KEY (`producto_id`) REFERENCES `productos` (`id`),
  CONSTRAINT `FKp7sxommck2r629h007c2mau4t` FOREIGN KEY (`caracteristica_id`) REFERENCES `caracteristicas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_caracteristica`
--

LOCK TABLES `producto_caracteristica` WRITE;
/*!40000 ALTER TABLE `producto_caracteristica` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto_caracteristica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `numero_habitacion` int DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `categoria_id` bigint DEFAULT NULL,
  `ciudad_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2fwq10nwymfv7fumctxt9vpgb` (`categoria_id`),
  KEY `FK2n66ase94bg4q6j56jdm4nj17` (`ciudad_id`),
  CONSTRAINT `FK2fwq10nwymfv7fumctxt9vpgb` FOREIGN KEY (`categoria_id`) REFERENCES `categorias` (`id`),
  CONSTRAINT `FK2n66ase94bg4q6j56jdm4nj17` FOREIGN KEY (`ciudad_id`) REFERENCES `ciudades` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'descripcion producto1','direccion1234','Hotel Arizona',12,'Titulo hotel1',1,5),
(2,'descripcion producto2','direccion12','Hotel Miranda',9,'Titulo hotel2',1,8),
(3,'descripcion producto3','direccion1333','Casa La Margarita',12,'Titulo casa1',2,10),
(4,'descripcion producto4','direccion123444','Casa San Luis',11,'Titulo hotel1',2,7),
(5,'descripcion producto5','direccion19999','Hostel Mad',8,'Titulo hostel1',3,13),
(6,'descripcion producto6','direccion99999','Hostel Adm',1,'Titulo hostel2',3,18),
(7,'descripcion producto7','direccion111111','Departamento Avenue',76,'Titulo depto1',4,13),
(8,'descripcion producto8','direccion22222','Departamento Insis',19,'Titulo depto2',4,9)
;
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-08 21:28:35
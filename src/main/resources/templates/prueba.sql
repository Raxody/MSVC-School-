-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: institucion
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.13-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `asignatura`
--

DROP TABLE IF EXISTS `asignatura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asignatura` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `id_docente` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_asignatura_docente_idx` (`id_docente`),
  CONSTRAINT `fk_asignatura_docente` FOREIGN KEY (`id_docente`) REFERENCES `docente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asignatura`
--

LOCK TABLES `asignatura` WRITE;
/*!40000 ALTER TABLE `asignatura` DISABLE KEYS */;
INSERT INTO `asignatura` VALUES (1,'Matematicas',1),(2,'Español',1),(3,'Religión',2),(4,'Etica',2),(5,'Fisica 2',3);
/*!40000 ALTER TABLE `asignatura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dane`
--

DROP TABLE IF EXISTS `dane`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dane` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `id_tipodane` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_dane_tipodane_idx` (`id_tipodane`),
  CONSTRAINT `fk_dane_tipodane` FOREIGN KEY (`id_tipodane`) REFERENCES `tipo_dane` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dane`
--

LOCK TABLES `dane` WRITE;
/*!40000 ALTER TABLE `dane` DISABLE KEYS */;
INSERT INTO `dane` VALUES (1,'Colombia',1),(2,'Chile',1),(3,'Valle del Cauca',3),(4,'Antofagastaaa',3),(5,'Cali',2),(6,'Calama',2);
/*!40000 ALTER TABLE `dane` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docente`
--

DROP TABLE IF EXISTS `docente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `docente` (
  `id` int(11) NOT NULL,
  `id_tipodocumento` int(11) NOT NULL,
  `numerodocumento` varchar(45) DEFAULT NULL,
  `nombres` varchar(45) DEFAULT NULL,
  `apellidos` varchar(45) DEFAULT NULL,
  `fecha_nacimiento` varchar(45) DEFAULT NULL,
  `asig_dictadas` int(11) DEFAULT NULL,
  `grado_escolaridad` varchar(45) DEFAULT NULL,
  `id_gradoresponsable` int(11) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `fijo` varchar(45) DEFAULT NULL,
  `celular` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_docente_tipodocumento_idx` (`id_tipodocumento`),
  KEY `fk_docente_grado_idx` (`id_gradoresponsable`),
  CONSTRAINT `fk_docente_grado` FOREIGN KEY (`id_gradoresponsable`) REFERENCES `grado` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_docente_tipodocumento` FOREIGN KEY (`id_tipodocumento`) REFERENCES `tipo_documento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docente`
--

LOCK TABLES `docente` WRITE;
/*!40000 ALTER TABLE `docente` DISABLE KEYS */;
INSERT INTO `docente` VALUES (1,1,'1143877351','Luis','Rivera','19-02-1999',2,'Postgrado',4,'r23felipe@gmail.com','310-38-84','315-277-97-61'),(2,1,'29842118','Bernarda','Molina','16-08-1972',2,'Postgrado',1,'bernarda@gmail.com','4223891','310-337-93-92'),(3,1,'64294153','Eduardo','Rojas','05-05-1970',1,'Postgrado',2,'eduardo@gmail.com','3742050','315-466-27-29');
/*!40000 ALTER TABLE `docente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudiante`
--

DROP TABLE IF EXISTS `estudiante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estudiante` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_tipodocumento` int(11) NOT NULL,
  `numerodocumento` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellidos` varchar(45) DEFAULT NULL,
  `fecha_nacimiento` varchar(45) DEFAULT NULL,
  `id_grado` int(11) NOT NULL,
  `id_dane` int(11) NOT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `fijo` varchar(45) DEFAULT NULL,
  `celular` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_estudiante_tipodocumento_idx` (`id_tipodocumento`),
  KEY `fk_estudiante_grado_idx` (`id_grado`),
  KEY `fk_estudiante_dane_idx` (`id_dane`),
  CONSTRAINT `fk_estudiante_dane` FOREIGN KEY (`id_dane`) REFERENCES `dane` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_estudiante_grado` FOREIGN KEY (`id_grado`) REFERENCES `grado` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_estudiante_tipodocumento` FOREIGN KEY (`id_tipodocumento`) REFERENCES `tipo_documento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiante`
--

LOCK TABLES `estudiante` WRITE;
/*!40000 ALTER TABLE `estudiante` DISABLE KEYS */;
INSERT INTO `estudiante` VALUES (1,2,'99021902949','Anggelo','Moncada','01-01-2001',2,5,'Diag 26 J #77-57','anggelo@gmail.com','300-00-00','311-300-10-10'),(2,2,'99021902900','Diego','Bocanegra','01-01-1998',4,5,'Cra 7s #42-63','diego@gmail.com','300-00-29','311-399-10-20'),(3,2,'9802190750','Oscar','Naranjo','01-08-1998',3,5,'Cra 8 #63-80','oscar@gmail.com','310-80-29','300-400-50-20'),(4,1,'29843220','Bryan','Portillo','01-10-2004',1,6,'Avenida las Americas','bryan@gmail.com','No aplica','300-110-99-99'),(5,1,'1116269948','Andres','Bedoya','12-26-1995',1,1,'Cra 42a #23-39','piperomero1226@gmail.com','2305539','3156624815'),(6,1,'1116266973','Juan David','Barbosa','8-4-1995',1,1,'Transv 9 #22-42','juandabar22@hotmail.com','2305539','3156624815');
/*!40000 ALTER TABLE `estudiante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudiante_asignatura`
--

DROP TABLE IF EXISTS `estudiante_asignatura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estudiante_asignatura` (
  `nota` double DEFAULT NULL,
  `periodo` int(11) DEFAULT NULL,
  `id_estudiante` int(11) NOT NULL,
  `id_asignatura` int(11) NOT NULL,
  PRIMARY KEY (`id_estudiante`,`id_asignatura`),
  KEY `fk_estudiante_idx` (`id_estudiante`),
  KEY `fk_asignatura_idx` (`id_asignatura`),
  CONSTRAINT `fk_asignatura` FOREIGN KEY (`id_asignatura`) REFERENCES `asignatura` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_estudiante` FOREIGN KEY (`id_estudiante`) REFERENCES `estudiante` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiante_asignatura`
--

LOCK TABLES `estudiante_asignatura` WRITE;
/*!40000 ALTER TABLE `estudiante_asignatura` DISABLE KEYS */;
INSERT INTO `estudiante_asignatura` VALUES (4.5,1,1,1),(5,1,1,2),(0,1,1,3),(1.5,1,2,1),(3.1,1,2,2),(4.2,1,2,3),(4,1,3,1),(4,1,3,2),(4,1,3,3),(5,1,4,1),(1.2,1,4,2),(1.7,1,4,3);
/*!40000 ALTER TABLE `estudiante_asignatura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grado`
--

DROP TABLE IF EXISTS `grado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grado` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grado`
--

LOCK TABLES `grado` WRITE;
/*!40000 ALTER TABLE `grado` DISABLE KEYS */;
INSERT INTO `grado` VALUES (1,'Primero'),(2,'Tercero'),(3,'Quinto'),(4,'Septimo'),(5,'Quinto'),(6,'Sexto'),(7,'Septimo'),(8,'Octavo'),(9,'Novenos');
/*!40000 ALTER TABLE `grado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_dane`
--

DROP TABLE IF EXISTS `tipo_dane`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_dane` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_dane`
--

LOCK TABLES `tipo_dane` WRITE;
/*!40000 ALTER TABLE `tipo_dane` DISABLE KEYS */;
INSERT INTO `tipo_dane` VALUES (1,'Pais'),(2,'Ciudad'),(3,'Departamento');
/*!40000 ALTER TABLE `tipo_dane` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_documento`
--

DROP TABLE IF EXISTS `tipo_documento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_documento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_documento`
--

LOCK TABLES `tipo_documento` WRITE;
/*!40000 ALTER TABLE `tipo_documento` DISABLE KEYS */;
INSERT INTO `tipo_documento` VALUES (1,'Cedula de Ciudadania'),(2,'Tarjeta de Identidad'),(3,'Cedula de Extranjeria');
/*!40000 ALTER TABLE `tipo_documento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'institucion'
--

--
-- Dumping routines for database 'institucion'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-29 19:14:58




-- SELECT p.nombres AS nombreProfesor,p.apellidos AS apellidosProfesor,a.descripcion AS nombreMateria,e.nombre AS nombreEstudiante,e.apellidos AS apellidoEstudiante,ea.nota AS notaMateria
-- FROM estudiante AS e JOIN estudiante_asignatura AS ea ON (ea.id_estudiante = e.id) JOIN asignatura as a ON (ea.id_asignatura = a.id) JOIN docente AS p ON (p.id = a.id_docente) WHERE ea.nota > 3.1 ORDER BY notaMateria ASC;

-- SELECT p.nombres AS nombreProfesor,p.apellidos AS apellidosProfesor,
-- a.descripcion AS nombreMateria,e.nombre AS nombreEstudiante,e.apellidos AS apellidoEstudiante,MAX(ea.nota) AS notaMateria
-- FROM estudiante AS e JOIN estudiante_asignatura AS ea ON (ea.id_estudiante = e.id) JOIN asignatura as a ON 
-- (ea.id_asignatura = a.id) JOIN docente AS p ON (p.id = a.id_docente) WHERE ea.periodo = 1
-- HAVING MAX(ea.nota)
-- LIMIT 1;




-- SELECT p.nombres AS nombreProfesor,p.apellidos AS apellidosProfesor,
-- a.descripcion AS nombreMateria,e.nombre AS nombreEstudiante,e.apellidos AS apellidoEstudiante,ea.nota AS notaMateria
-- FROM estudiante AS e JOIN estudiante_asignatura AS ea ON (ea.id_estudiante = e.id) JOIN asignatura as a ON 
-- (ea.id_asignatura = a.id) JOIN docente AS p ON (p.id = a.id_docente) WHERE ea.periodo = 1
-- HAVING MAX(ea.nota)
-- LIMIT 1;




-- SELECT p.nombres AS nombreProfesor,p.apellidos AS apellidosProfesor,
-- a.descripcion AS nombreMateria,e.nombre AS nombreEstudiante,e.apellidos AS apellidoEstudiante,MAX(ea.nota)
-- FROM estudiante AS e
-- JOIN estudiante_asignatura AS ea ON (ea.id_estudiante = e.id)
-- JOIN asignatura AS a ON (ea.id_asignatura = a.id)
-- JOIN docente AS p ON (p.id = a.id_docente)
-- WHERE ea.periodo = 1
-- GROUP BY e.id
-- HAVING MAX(ea.nota)
-- LIMIT 1;



-- SELECT p.nombres AS nombreProfesor,p.apellidos AS apellidosProfesor,
-- a.descripcion AS nombreMateria,e.nombre AS nombreEstudiante,e.apellidos AS apellidoEstudiante,ea.nota AS notaMateria
-- FROM estudiante AS e JOIN estudiante_asignatura AS ea ON (ea.id_estudiante = e.id) JOIN asignatura as a ON 
-- (ea.id_asignatura = a.id) JOIN docente AS p ON (p.id = a.id_docente) ;
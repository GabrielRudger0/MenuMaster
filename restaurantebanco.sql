-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.4.27-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para restaurantebanco
CREATE DATABASE IF NOT EXISTS `restaurantebanco` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `restaurantebanco`;

-- Copiando estrutura para tabela restaurantebanco.cadastro_cliente
CREATE TABLE IF NOT EXISTS `cadastro_cliente` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `nome_cliente` varchar(45) NOT NULL,
  `cep_cliente` varchar(11) NOT NULL,
  `endereco_cliente` varchar(70) NOT NULL,
  `email_cliente` varchar(45) NOT NULL,
  `tel_cliente` varchar(12) NOT NULL,
  `senha_cliente` varchar(45) NOT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela restaurantebanco.cardapio
CREATE TABLE IF NOT EXISTS `cardapio` (
  `idproduto` int(11) NOT NULL AUTO_INCREMENT,
  `nome_prato` varchar(45) NOT NULL,
  `preco` float NOT NULL,
  `categoria` varchar(24) DEFAULT NULL,
  `disponibilidade` varchar(4) DEFAULT NULL,
  `restricoes` varchar(80) DEFAULT NULL,
  `ingredientes` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`idproduto`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela restaurantebanco.contabil
CREATE TABLE IF NOT EXISTS `contabil` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` date DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `receitas` decimal(10,2) DEFAULT NULL,
  `despesas` decimal(10,2) DEFAULT NULL,
  `saldo` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela restaurantebanco.pedidos
CREATE TABLE IF NOT EXISTS `pedidos` (
  `idpedidos` int(11) NOT NULL AUTO_INCREMENT,
  `idcliente` int(11) DEFAULT NULL,
  `itenspedidos` varchar(50) NOT NULL DEFAULT '',
  `quantidade` varchar(50) DEFAULT NULL,
  `observacao` varchar(200) DEFAULT '',
  `avaliacao5star` varchar(5) DEFAULT NULL,
  `avaliacaoobs` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idpedidos`),
  KEY `clienteFK1` (`idcliente`),
  CONSTRAINT `clienteFK1` FOREIGN KEY (`idcliente`) REFERENCES `cadastro_cliente` (`id_cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela restaurantebanco.vrp_admin
CREATE TABLE IF NOT EXISTS `vrp_admin` (
  `idvrp_admin` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idvrp_admin`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Exportação de dados foi desmarcado.

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

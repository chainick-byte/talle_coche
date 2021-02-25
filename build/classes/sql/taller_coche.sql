
drop database if exists prueba;
create database prueba;
use prueba;
SET FOREIGN_KEY_CHECKS=0;

CREATE TABLE `propietario` (
  `id_propietario` SERIAL  NOT NULL,
  `nombre` varchar(256) NOT NULL,
  `primer_apellido` varchar(256) NOT NULL,
  `segundo_apellido` varchar(256) NOT NULL,
  `dni` varchar(256) NOT NULL,
  `telefono` int(11) NOT NULL,
  PRIMARY KEY(`id_propietario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `consulta` (
  `id_auto` SERIAL  NOT NULL,
  `propietario_id` bigint(20) UNSIGNED NOT NULL,
  `matricula` varchar(11) NOT NULL,
  `descripcion_averia` text NOT NULL,
  `modelo` varchar(256) NOT NULL,
  `anno` year(4) NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY(`id_auto`),
  CONSTRAINT `consulta_ibfk_1` FOREIGN KEY (`propietario_id`) REFERENCES `propietario` (`id_propietario`) ON DELETE CASCADE ON UPDATE CASCADE

) ENGINE=InnoDB DEFAULT CHARSET=latin1;



CREATE TABLE `factura` (
  `id_factura` SERIAL  NOT NULL,
  `fecha_emision` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `auto_id` bigint(20) UNSIGNED NOT NULL,
  PRIMARY KEY(`id_factura`),
  CONSTRAINT `factura_ibfk_2` FOREIGN KEY (`auto_id`) REFERENCES `consulta` (`id_auto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `operacion` (
  `id_operacion` SERIAL  NOT NULL,
  `nombre_operacion` varchar(256) NOT NULL,
  `precio` decimal(4,2) NOT NULL,
  PRIMARY KEY(`id_operacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `factura_operacion` (
  `id_factura_operacion` SERIAL  NOT NULL,
  `factura_id` bigint(20) UNSIGNED NOT NULL,
  `operacion` bigint(20) UNSIGNED NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY(`id_factura_operacion`),
  CONSTRAINT `factura_operacion_ibfk_2` FOREIGN KEY (`operacion`) REFERENCES `operacion` (`id_operacion`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `factura_operacion_ibfk_3` FOREIGN KEY (`factura_id`) REFERENCES `factura` (`id_factura`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;




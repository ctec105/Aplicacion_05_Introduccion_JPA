CREATE DATABASE IF NOT EXISTS mysqljpa;
USE mysqljpa;


DROP TABLE IF EXISTS tb_empleado;
CREATE TABLE tb_empleado (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  nombre varchar(45) NOT NULL,
  apellido varchar(45) NOT NULL,
  edad int(10) unsigned NOT NULL,
  area varchar(45) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


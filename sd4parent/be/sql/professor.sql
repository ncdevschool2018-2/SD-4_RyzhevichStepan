CREATE TABLE `professor` (
  `id_professor` bigint(20) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) DEFAULT NULL,
  `secondname` varchar(45) DEFAULT NULL,
  `patronymic` varchar(45) DEFAULT NULL,
  `telnumber` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  UNIQUE KEY `id_professor_UNIQUE` (`id_professor`)
) ENGINE=InnoDB
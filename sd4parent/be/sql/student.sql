CREATE TABLE `student` (
  `id_student` BIGINT(20)  NOT NULL AUTO_INCREMENT,
  `firstname`  VARCHAR(45) NULL,
  `secondname` VARCHAR(45) NULL,
  `patronymic` VARCHAR(45) NULL,
  `id_group`   INT         NULL,
  `telnumber`  VARCHAR(45) NULL,
  `email`      VARCHAR(45) NULL,
  `course`     INT         NULL,
  `subgroup`   INT         NULL,
  PRIMARY KEY (`id_student`),
  UNIQUE INDEX `id_student_UNIQUE` (`id_student`)
) ENGINE=InnoDB

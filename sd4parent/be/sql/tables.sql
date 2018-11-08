CREATE TABLE `faculty` (
  `id_faculty` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_faculty`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `professor` (
  `id_professor` bigint(20) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) DEFAULT NULL,
  `secondname` varchar(45) DEFAULT NULL,
  `patronymic` varchar(45) DEFAULT NULL,
  `telnumber` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_professor`),
  CONSTRAINT `professor_id_professor_foreign` FOREIGN KEY (`id_professor`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `student` (
  `id_student` bigint(20) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) DEFAULT NULL,
  `secondname` varchar(45) DEFAULT NULL,
  `patronymic` varchar(45) DEFAULT NULL,
  `id_group` bigint(20) NOT NULL,
  `telnumber` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `subgroup` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_student`),
  KEY `id_group_foreign_idx` (`id_group`),
  CONSTRAINT `student_id_group_foreign` FOREIGN KEY (`id_group`) REFERENCES `studentsgroup` (`id_group`),
  CONSTRAINT `student_id_student_foreign` FOREIGN KEY (`id_student`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `studentsgroup` (
  `id_group` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `id_faculty` bigint(20) NOT NULL,
  `course` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_group`),
  KEY `id_faculty_foreign` (`id_faculty`),
  CONSTRAINT `id_faculty_foreign` FOREIGN KEY (`id_faculty`) REFERENCES `faculty` (`id_faculty`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `subject` (
  `id_subject` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `id_professor` bigint(20) NOT NULL,
  `timeslot` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id_subject`),
  KEY `id_professor_foreign` (`id_professor`),
  CONSTRAINT `id_professor_foreign` FOREIGN KEY (`id_professor`) REFERENCES `professor` (`id_professor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `subject_groups` (
  `id_subject_groups` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_subject` bigint(20) NOT NULL,
  `id_group` bigint(20) NOT NULL,
  PRIMARY KEY (`id_subject_groups`),
  KEY `id_group_foreign` (`id_group`),
  KEY `id_subject_foreign` (`id_subject`),
  CONSTRAINT `id_group_foreign` FOREIGN KEY (`id_group`) REFERENCES `studentsgroup` (`id_group`),
  CONSTRAINT `id_subject_foreign` FOREIGN KEY (`id_subject`) REFERENCES `subject` (`id_subject`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `user` (
  `id_user` bigint(20) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
CREATE TABLE cst339.users (
	id int(11) auto_increment NOT NULL,
	username varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
	password varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
	enabled tinyint(1) NOT NULL,
	F_NAME varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL NULL,
	L_NAME varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL NULL,
	EMAIL varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL NULL,
	ADDRESS varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL NULL,
	PHONE varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL NULL,
	CONSTRAINT `PRIMARY` PRIMARY KEY (id),
	CONSTRAINT username_UNIQUE UNIQUE KEY (username)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci
COMMENT='';
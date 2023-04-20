CREATE TABLE cst339.authorities (
	id int(11) auto_increment NOT NULL,
	username varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
	authority varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
	CONSTRAINT `PRIMARY` PRIMARY KEY (id),
	CONSTRAINT fk_authorities_1_copy FOREIGN KEY (username) REFERENCES cst339.users(username) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci
COMMENT='';
CREATE INDEX fk_authorities_1_idx USING BTREE ON cst339.authorities (username);

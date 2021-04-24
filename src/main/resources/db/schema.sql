DROP TABLE accounts;
DROP TABLE users;
DROP TABLE account_images;

CREATE TABLE accounts (
	id INT PRIMARY KEY AUTO_INCREMENT,					-- 계정 고유번호
    name VARCHAR(30) UNIQUE,							-- 계정명
    password VARCHAR(255),								-- 패스워드
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP	-- 생성일
);

CREATE TABLE users (
	account_id INT PRIMARY KEY,			
    first_name VARCHAR(50) NOT NULL,					
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(255) UNIQUE,
    phone VARCHAR(30),
    CONSTRAINT user_account_id_fk FOREIGN KEY (account_id)
		REFERENCES accounts (id)
);

CREATE TABLE account_images (
	account_id INT PRIMARY KEY,
	path VARCHAR(255) NOT NULL,
    CONSTRAINT account_image_account_id_fk FOREIGN KEY (account_id)
		REFERENCES accounts (id)
);
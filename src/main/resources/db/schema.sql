DROP TABLE accounts;
DROP TABLE users;
DROP TABLE account_images;
DROP TABLE messages;

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

CREATE TABLE messages (
	message_no INT PRIMARY KEY auto_increment,			-- 메세지 고유번호(순차)
    sender_id VARCHAR(50) NOT NULL,						-- 메세지 송신자
    receiver_id VARCHAR(50) NOT NULL,					-- 메세지 수신자
    content VARCHAR(255),								-- 메세지 내용
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP	-- 메세지 보낸 날짜
);
-- maven_project 데이터베이스 생성
CREATE DATABASE maven_project CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

-- 생성된 데이터베이스 사용
USE maven_project;

-- 회원(member) 테이블 생성
CREATE TABLE member (
    member_no INT AUTO_INCREMENT PRIMARY KEY,
    member_id VARCHAR(50),
    member_pw VARCHAR(100)
);
-- 게시판(board) 테이블 생성
CREATE TABLE board (
	board_no INT AUTO_INCREMENT PRIMARY KEY,
  board_title VARCHAR(100) NOT NULL,
  board_content TEXT,
  board_writer INT NOT NULL,
  reg_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  mod_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);
-- 첨부파일(attach) 테이블 생성
CREATE TABLE attach (
  attach_no INT AUTO_INCREMENT PRIMARY KEY,
  board_no INT NOT NULL,                         
  ori_name VARCHAR(255) NOT NULL,           
  re_name VARCHAR(255) NOT NULL,             
  reg_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

select * FROM member;
select * FROM board;

DELETE FROM member where member_no = 1;



INSERT INTO board (board_title, board_content, board_writer) 
VALUES 
('1', '테스트 게시글1', 1),
('2', '테스트 게시글1', 2),
('3', '테스트 게시글1', 3),
('4', '테스트 게시글1', 4),
('5', '테스트 게시글1', 5),
('6', '테스트 게시글1', 6),
('7', '테스트 게시글1', 7),
('8', '테스트 게시글1', 8),
('9', '테스트 게시글1', 9),
('10', '테스트 게시글1', 10),
('11', '테스트 게시글1', 11),
('12', '테스트 게시글1', 12),
('13', '테스트 게시글1', 13),
('14', '테스트 게시글1', 14),
('15', '테스트 게시글1', 15),
('16', '테스트 게시글1', 16),
('17', '테스트 게시글1', 17),
('18', '테스트 게시글1', 18),
('19', '테스트 게시글1', 19),
('20', '테스트 게시글1', 20),
('21', '테스트 게시글1', 21),
('22', '테스트 게시글1', 22),
('23', '테스트 게시글1', 23),
('24', '테스트 게시글1', 24),
('25', '테스트 게시글1', 25);
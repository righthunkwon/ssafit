-- SSAFIT DB --
DROP DATABASE IF EXISTS ssafit;

-- 데이터베이스 생성
CREATE DATABASE ssafit DEFAULT CHARACTER SET utf8mb4;
USE ssafit;

-- 사용자 테이블 생성
CREATE TABLE IF NOT EXISTS `user` ( 
`user_id` VARCHAR(50) NOT NULL,  -- 사용자 아이디(PK)
`password` VARCHAR(300) NOT NULL, -- 사용자 비밀번호
`name` VARCHAR(50) NOT NULL, -- 사용자 이름
`nickname` VARCHAR(50) NOT NULL, -- 사용자 닉네임
`birthdate` VARCHAR(50), -- 사용자 생년월일
PRIMARY KEY(`user_id`));

-- 영상 테이블 생성
CREATE TABLE IF NOT EXISTS `video` ( 
`video_id` INT AUTO_INCREMENT NOT NULL, -- 영상 고유번호(PK)
`title` varchar(300) NOT NULL, -- 영상 제목
`content` TEXT NOT NULL, -- 영상 내용
`part` VARCHAR(300) NOT NULL, -- 운동 부위
`creator` VARCHAR(300) NOT NULL,
`link` VARCHAR(300) NOT NULL, -- URL
`viewcnt` INT DEFAULT 0,
`regdate` DATETIME DEFAULT NOW(), -- 영상 등록일
 PRIMARY KEY(`video_id`)
 );

-- 리뷰 테이블 생성
CREATE TABLE IF NOT EXISTS `review` ( 
`review_id` INT AUTO_INCREMENT NOT NULL, -- 리뷰 고유번호(PK) 
`user_id` VARCHAR(50) NOT NULL, -- 사용자 아이디(FK)
`video_id` INT NOT NULL, -- 영상 고유번호(FK)
`title` VARCHAR(300) NOT NULL, -- 리뷰 제목
`content` TEXT NOT NULL, -- 리뷰 내용
`viewcnt` INT DEFAULT 0, -- 리뷰 조회수
`regdate` DATETIME DEFAULT NOW(), -- 리뷰 둥록일(기본값은 현재 시간)
PRIMARY KEY(`review_id`),
CONSTRAINT `fk_review_user_id` FOREIGN KEY (`user_id`)
        REFERENCES `user` (`user_id`) ON DELETE CASCADE,
CONSTRAINT `fk_review_video_id` FOREIGN KEY (`video_id`)
        REFERENCES `video` (`video_id`) ON DELETE CASCADE
);

-- 위시리스트 테이블 생성
CREATE TABLE IF NOT EXISTS `wishlist` ( 
`wishlist_id` INT AUTO_INCREMENT NOT NULL, -- 리뷰 고유번호(PK) 
`user_id` varchar(50) NOT NULL, -- 사용자 아이디(FK)
`video_id` INT NOT NULL, -- 영상 고유번호(FK)
PRIMARY KEY(`wishlist_id`),
CONSTRAINT `fk_wishlist_user_id` FOREIGN KEY (`user_id`)
        REFERENCES `user` (`user_id`) ON DELETE CASCADE,
CONSTRAINT `fk_wishlist_video_id` FOREIGN KEY (`video_id`)
        REFERENCES `video` (`video_id`) ON DELETE CASCADE
);

-- 좋아요 테이블 생성
CREATE TABLE IF NOT EXISTS `video_like` ( 
`video_like_id` INT AUTO_INCREMENT NOT NULL, -- 리뷰 고유번호(PK) 
`user_id` varchar(50) NOT NULL, -- 사용자 아이디(FK)
`video_id` INT NOT NULL, -- 영상 고유번호(FK)
PRIMARY KEY(`video_like_id`),
CONSTRAINT `fk_video_like_user_id` FOREIGN KEY (`user_id`)
        REFERENCES `user` (`user_id`) ON DELETE CASCADE,
CONSTRAINT `fk_video_like_video_id` FOREIGN KEY (`video_id`)
        REFERENCES `video` (`video_id`) ON DELETE CASCADE,
UNIQUE KEY `unique_user_video` (`user_id`, `video_id`) -- 유니크 키 설정하여 중복 데이터 방지
);

-- 아래는 Debug용으로 사용한 SQL문
-- 데이버 베이스 목록 조회
SHOW DATABASES;

-- 테이블 정보 확인
DESC user; -- 사용자 테이블 확인
DESC video; -- 영상 테이블 확인
DESC review; -- 리뷰 테이블 확인
DESC wishlist; -- 즐겨찾기 테이블 확인
DESC video_like; -- 비디오 좋아요 테이블 확인

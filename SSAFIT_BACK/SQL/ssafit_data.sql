
-- (1) 사용자 데이터 삽입
INSERT INTO `user` 
VALUES 
("ssafyid1", "pwd1", "김싸피", "토끼", '950513'),
("ssafyid2", "pwd2", "박싸피", "두루미", '001217'),
("ssafyid3", "pwd3", "서싸피", "호랑이", '980112'),
("ssafyid4", "pwd4", "김싸피", "자라", '990513'),
("ssafyid5", "pwd5", "박싸피", "거북이", '021217'),
("ssafyid6", "pwd6", "서싸피", "참새", '920114'),
("ssafyid7", "pwd7", "김싸피", "매", '950713'),
("test123!", "test123!", "test123!", "test123!", '000000'); -- 특수문자 유효성 검사

-- (2) 비디오 데이터 삽입
INSERT INTO `video`
VALUES (1, '가슴 운동 5가지 - 강경원 루틴', '벤치프레스와 덤벨프레스를 기반으로 한 가슴운동', '가슴', '강경원', 'https://www.youtube.com/embed/iv8reqGucYE', 0, SYSDATE());

INSERT INTO `video` (`title`, `content`, `part`, `creator`, `link`)
VALUES 
('벤치프레스 완벽 가이드 - 강경원 방식', '벤치프레스를 기반으로 한 강경원님의 가슴운동', '가슴', '강경원', 'https://www.youtube.com/embed/A2kHURY746E'),
('인클라인 벤치프레스, 윗가슴을 채우는 가장 좋은 운동', '인클라인 벤치프레스를 기반으로 한 강경원님의 가슴운동', '가슴', '강경원', 'https://www.youtube.com/embed/4HvI_mFhzVQ'),
('오랜만에 상의 탈의하고 가슴 운동', '강경원님의 가슴운동(상의탈의)', '가슴', '강경원', 'https://www.youtube.com/embed/-ZHWut0mS-c'),
('딥스 | 가슴 보조 운동 마스터하기', '딥스를 기반으로 한 가슴운동', '가슴', '강경원', 'https://www.youtube.com/embed/YDZrMoJK_lQ'),
('가슴운동 6가지 | 프리웨이트 루틴', '이용승님의 프리웨이트 가슴운동 6가지', '가슴', '코리안헤라클레스 이용승', 'https://www.youtube.com/embed/3bxRDUs5hL0'),
('내가 하는 가슴 루틴', '이용승님의 가슴 운동 루틴', '가슴', '코리안헤라클레스 이용승', 'https://www.youtube.com/embed/KGHrjTKU7jE'),
('벤치프레스 정복 가이드ㅣ이용승의 개인화', '이용승님의 벤치프레스', '가슴', '코리안헤라클레스 이용승', 'https://www.youtube.com/embed/1LKA14mXy9E'),
('가슴운동 이렇게 합니다 | CHEST DAY', '이용승님의 가슴운동', '가슴', '코리안헤라클레스 이용승', 'https://www.youtube.com/embed/81QwGNwd0X4'),
('반복 속에 새로움 | CHEST WORKOUT', '이용승님의 가슴운동 반복루틴', '가슴', '코리안헤라클레스 이용승', 'https://www.youtube.com/embed/DNXRG6DhaX8');

INSERT INTO `video` (`title`, `content`, `part`, `creator`, `link`)
VALUES 
('상의 탈의하고 등 운동, 1시간 추천 운동법', '강경원님의 등운동(상의탈의)', '등', '강경원', 'https://www.youtube.com/embed/pKoR-uJd_vk'),
('등 운동 6가지 - 강경원 루틴', '강경원님의 등운동 6가지', '등', '강경원', 'https://www.youtube.com/embed/tIyfSwFNfuc'),
('바벨로우로 등 운동이 되긴 하나요?', '강경원님의 등운동 이야기(바벨로우편)', '등', '강경원', 'https://www.youtube.com/embed/XMl3VtFN3VU'),
('시티드 로우 | 가장 기본이 되는 등 운동', '강경원님의 등운동(시티드 로우편)', '등', '강경원', 'https://www.youtube.com/embed/pkKfWeQ9APQ'),
('강경원 선수 "등 운동 루틴" 공개', '강경원님의 등운동 루틴', '등', '강경원', 'https://www.youtube.com/embed/onwoGwzNLpU'),
('등운동 이렇게 합니다.', '이용승님의 등운동', '등', '코리안헤라클레스 이용승', 'https://www.youtube.com/embed/8R0O1zKsdA8'),
('등운동 | FULL WORKOUT', '이용승님의 등운동(FULL)', '등', '코리안헤라클레스 이용승', 'https://www.youtube.com/embed/oXssLXdKoP8'),
('지금부터는 정신력의 영역이다 | 등 훈련', '이용승님의 강인한 정신력의 등운동', '등', '코리안헤라클레스 이용승', 'https://www.youtube.com/embed/SaKATEG_omk'),
('일관성의 힘 ⎜등 운동 루틴', '이용승님의 등운동 루틴', '등', '코리안헤라클레스 이용승', 'https://www.youtube.com/embed/ZDgJjpMGZRA'),
('광활한 광배 넓히는 운동 알려드림ㅣ코리안헤라클레스 ', '이용승님의 광배 운동', '등', '코리안헤라클레스 이용승', 'https://www.youtube.com/embed/LhlIHvieZfk');

INSERT INTO `video` (`title`, `content`, `part`, `creator`, `link`)
VALUES 
('어깨, 삼두 운동 | 강경원의 운동 피드백', '강경원님의 어깨운동 피드백', '어깨', '강경원', 'https://www.youtube.com/embed/5CKZDmIfNF0'),
('밀리터리 프레스 | 어깨 운동', '강경원님의 밀리터리 프레스', '어깨', '강경원', 'https://www.youtube.com/embed/JyAhfMb3FIw'),
('강경원 선수 "어깨 운동 루틴"', '강경원님의 비시즌 어깨 운동 루틴', '어깨', '강경원', 'https://www.youtube.com/embed/N4mC74eo23Y'),
('사이드 레터럴 레이즈 기초 ', '강경원님의 사이드 레터럴 레이즈 기초', '어깨', '강경원', 'https://www.youtube.com/embed/iNgwwI3WBTo'),
('어깨를 커 보이게 만들어주는 운동', '강경원님의 어깨운동(승모근 통제)', '어깨', '강경원', 'https://www.youtube.com/embed/n3aX0oJyvWA'),
('오늘의 운동 | 어깨', '이용승님의 오늘의 어깨운동', '어깨', '코리안헤라클레스 이용승', 'https://www.youtube.com/embed/bDO8K52XVxk'),
('어깨 근육 부화시키기', '이용승님의 어깨운동 입문', '어깨', '코리안헤라클레스 이용승', 'https://www.youtube.com/embed/iS7Gy12_Sug'),
('어깨 루틴 | 반복에 지치지 말것', '이용승님의 어깨 운동 루틴', '어깨', '코리안헤라클레스 이용승', 'https://www.youtube.com/embed/_aOFbVC3sTg'),
('누구나 따라하기쉬운 어깨훈련 5가지', '이용승님의 어깨 운동 기초 5가지', '어깨', '코리안헤라클레스 이용승', 'https://www.youtube.com/embed/6Tl1uCuEIGg'),
('코리안 하데스의 저승길 어깨운동', '이용승님의 저승길 직행 어깨운동', '어깨', '코리안헤라클레스 이용승', 'https://www.youtube.com/embed/baARpCZCZrg');

INSERT INTO `video` (`title`, `content`, `part`, `creator`, `link`)
VALUES 
('꽉! 차는 머슬핏 만드는 팔 루틴 (이두,삼두)', '권혁이 직접 짜준 식단, 권혁이 직접 짜준 식단 및 운동루틴', '팔', '권혁TV', 'https://www.youtube.com/embed/qkQdIMW1xlw'),
('집에서 10kg 덤벨로 하는 팔 운동루틴', '집에서도 할 수 있는 팔 운동 홈트레이닝 영상', '팔', '홍범석 tiger_stone.h', 'https://www.youtube.com/embed/xK68FIFWdnI'),
('일반인이 팔뚝을 가장 빠르게 키우는 방법?', '부위별 가장 효과적인 전완근 운동', '팔', '운동 루틴 가이드', 'https://www.youtube.com/embed/Z5tIB3EsAyw'),
('헬린이들을 위한 삼두운동의 모든것!', '김명섭과 함께 해부학적으로 풀어가는 쉽고 재미있는 팔운동', '팔', '김명섭의 헬스교실', 'https://www.youtube.com/embed/5azIr-srI6U'),
('팔 사이즈 키우는 가장 빠른 방법!?', 'feat. 3가지 슈퍼세트 루틴', '팔', '쇠질연구소', 'https://www.youtube.com/embed/aG6XHTb78S0'),
('라잉 트라이셉 익스텐션', '제가 가장 추천하고 효과적인 삼두 운동', '팔', '강경원', 'https://www.youtube.com/embed/ogyGQxuxxn4'),
('많은 분들이 잘 못하고 있는 운동', '케이블 푸쉬다운', '팔', '강경원', 'https://www.youtube.com/embed/ObEtLS9heOo'),
('팔 운동 8가지, 총 45세트 - 강경원 루틴', '강경원 루틴', '팔', '강경원', 'https://www.youtube.com/embed/vU5sfsTXI7I'),
('팔 운동 이렇게 하세요!', '김명섭의 팔 운동루틴', '팔', '김명섭의 헬스교실', 'https://www.youtube.com/embed/QeALMum2CVI'),
('팔 근육을 빠르게 키우는 팔 운동 루틴!?', '이두 삼두 운동 루틴, 팔 두꺼워 지는 운동', '팔', '쇠질사전', 'https://www.youtube.com/embed/upTkK5GvNvY');

INSERT INTO `video` (`title`, `content`, `part`, `creator`, `link`)
VALUES 
('13분만에 하체 마비시키는 루틴! ', '(누구나 집에서 가능) 13mins intense Legs Workout', '하체', '권혁TV', 'https://www.youtube.com/embed/KXYi6bI-UPE'),
('달리기에 최적화된 5분하체운동!', '하체 중량운동을 하지 않는 이유?', '하체', '홍범석 tiger_stone.h', 'https://www.youtube.com/embed/FS_hmVHlFVs'),
('하체비만 11자다리 최고의 운동 ', '핵매운맛st 불타는 하체 다리토닝 운동', '하체', 'Thankyou_BUBU', 'https://www.youtube.com/embed/NDsjmxTROEo'),
('탄력적인 애플힙 만드는 하체 + 힙업루틴!', '(누구나 쉽게 가능) [12mins Intense Booty Workout]', '하체', '권혁TV', 'https://www.youtube.com/embed/ErIx1ZUSE3I'),
('가장 기본이 되는 필수 하체운동 | 레그 익스텐션', '레그 익스텐션', '하체', '강경원', 'https://www.youtube.com/embed/mS9iwXhycJI'),
('핏블리가 손에 꼽은 하체운동 5가지', '5 MUST DO LEG EXERCISES', '하체', '필블리 FITVELY', 'https://www.youtube.com/embed/0VtJnWm2PSU'),
('그냥 따라해봐 생각하지 말고', '레그프레스는 꼭 한 번쯤은 따라해보시길 바랍니다', '하체', 'Allright24_박재훈', 'https://www.youtube.com/embed/KqhCpQtOqic'),
('하체 날, 딱 10분 밖에 없다면', '스쿼트 10가지 동작 - 하체운동 홈트 루틴', '하체', '빅씨스 Bigsis', 'https://www.youtube.com/embed/DWYDL-WxF1U'),
('하체운동 딱 3가지면 허벅지 쫙쫙 갈라집니다!!', '하체 필수 운동루틴', '하체', '헬린이 탈출을 위한 운동정보', 'https://www.youtube.com/embed/9_AiWMlH87U'),
('이것만 깨달으면 하체는 반드시 좋아집니다', '리듬과 템포, 가동범위에 대한 내용', '하체', '고독한갯츠비', 'https://www.youtube.com/embed/pYZIRUm45Go');

INSERT INTO `video` (`title`, `content`, `part`, `creator`, `link`)
VALUES 
('체중감량을 무조건 약속드리는 아갈머리 전신유산소', '일반인 남자분과 다시 한 번 찍었습니다 (런지X 스쿼트X 층간소음X)', '전신', '에이핏 afit', 'https://www.youtube.com/embed/xFMvbnharlk'),
('전신 다이어트 최고의 운동 ', '이번 영상은 정말! 정말! 맵습니다', '전신', 'Thankyou BUBU', 'https://www.youtube.com/embed/gMaB-fG4u4g'),
('운동초보 분들은 이 영상을 무조건 따라 하세요!', '떠먹는홈트', '전신', '권혁TV', 'https://www.youtube.com/embed/Oz5ts01rzEo'),
('이 12분짜리 영상 하나로 전신 한방에 끝내버리세요!', '12mins Full body workout', '전신', '권혁TV', 'https://www.youtube.com/embed/yka0VGRh1oc'),
('올인원 전신 근력운동 50분 홈트레이닝', '근육통주의', '전신', '힙으뜸', 'https://www.youtube.com/embed/A5MzlPgNcJM'),
('진짜 역대급 20분 루틴ㅣ전신올인원 I', '힙으뜸 유산소 운동', '전신', '힙으뜸', 'https://www.youtube.com/embed/46vQnzaZ6aU'),
('가장 짧고 강력한 전신운동! 힘든 만큼 효과 보장', '한번에 온몸을 단련할 수 있는 강력한 전신운동루틴', '전신', '한국운동', 'https://www.youtube.com/embed/xA3joqtfDt8'),
('Lv.3 효율끝판왕 전신 근력 + 체지방 운동', '권혁이 직접 짜준 식단, 권혁이 직접 짜준 식단 및 운동루틴', '전신', '권혁TV', 'https://www.youtube.com/embed/jZT3I2QRUKU'),
('헬스장 처음이라면 이렇게 운동 해보세요', '헬스(헬린이) 초보자를 위한 5가지 전신운동루틴(가슴/등/하체/어깨)', '전신', 'MSG훈', 'https://www.youtube.com/embed/pXzEw2D8bds'),
('굿모닝 전신 스트레칭 (초보자 루틴)', 'Good Morning Full Body Stretch (Beginner Routine)', '전신', 'Allblanc TV', 'https://www.youtube.com/embed/JhSZw8fiTLc');


-- (3) 리뷰 데이터 삽입
-- 각각 부모키가 user / video에 있음
INSERT INTO `review`  
VALUES 
(1, "ssafyid1", 1, "후기 제목1-1", "후기 내용1-1", 0, SYSDATE());

INSERT INTO `review` (user_id, video_id, title, content, viewcnt) 
VALUES
("ssafyid1", 1, "후기 제목1-2", "후기 내용1-2", 0),
("ssafyid1", 3, "후기 제목3-1", "후기 내용3-1", 0),
("ssafyid2", 3, "후기 제목3-2", "후기 내용3-2", 0),
("ssafyid2", 3, "후기 제목3-3", "후기 내용3-3", 0),
("ssafyid2", 3, "후기 제목3-3", "후기 내용3-3", 0),
("ssafyid3", 4, "후기 제목4-1", "후기 내용4-1", 0);

-- (4) 찜 목록 데이터 삽입
INSERT INTO `wishlist`
VALUES (1, "ssafyid1", 1);

INSERT INTO `wishlist` (user_id, video_id)
VALUES
("ssafyid1", 2),
("ssafyid2", 1);

-- (4) 비디오 좋아요 데이터 삽입
INSERT INTO `video_like`
VALUES (1, "ssafyid1", 1);

INSERT INTO `video_like` (user_id, video_id)
VALUES
("ssafyid1", 2),
("ssafyid1", 3),
("ssafyid1", 4),
("ssafyid2", 1),
("ssafyid3", 1),
("ssafyid4", 1),
("ssafyid5", 1),
("ssafyid6", 1),
("ssafyid7", 1);

-- 데이터 삽입 확인
SELECT * FROM user;
SELECT * FROM video;
SELECT * FROM review;
SELECT * FROM wishlist;
SELECT * FROM video_like;

-- 데이터 삭제(초기화)
-- DELETE FROM user;
-- DELETE FROM review;
-- DELETE FROM video;
-- DELETE FROM wishlist;
-- DELETE FROM video_like;
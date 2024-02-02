##################
# 날짜/시간 조작 #
##################

/*
 * 1. 테이블 생성
 */

CREATE TABLE if NOT EXISTS dateTable (  
    id INT PRIMARY KEY AUTO_INCREMENT,              -- 정수타입
    regDate DATE DEFAULT (CURRENT_DATE),            -- 날짜타입
    modTime DATETIME DEFAULT CURRENT_TIMESTAMP   -- 날짜타입 디폴트값은 (CURRENT_TIMESTAMP)  
);

/*
 * 2. 데이터 입력
 */
INSERT INTO dateTable VALUES (default, default, default)
INSERT INTO dateTable(id) VALUES (DEFAULT);
INSERT INTO dateTable(regDate, modTime) 
    VALUES ('2024-01-01', '2024-01-31 10:25:00'),
           ('2024-02-01', '2024-02-02 16:45:00');
    
/*
 * 3. 데이터 조회
 */
# 2024-02-02 형식
SELECT regDate, DATE_FORMAT(modTime, '%Y-%m-%d') FROM dateTable;

# 10:45:00 AM 형식
SELECT DATE_FORMAT(modTime, '%h:%i:%s %p') FROM dateTable;

# 24-02-02 16:45 형식
SELECT DATE_FORMAT(modTime, '%y-%m-%d %H:%I') FROM dateTable;

# 날짜 조회 함수
SELECT NOW(), CURDATE(), CURTIME();

/*
 * 4. 데이터 수정
 */

UPDATE dateTable SET regDate=CURDATE(), modTime=NOW() WHERE id=3;
SELECT * FROM dateTable;

/*
 * 5. 날짜 계산
 */
# 날짜 더하기/빼기
SELECT DATE_ADD(NOW(), INTERVAL 40 DAY);    -- DATE_ADD 더하기
SELECT DATE_SUB(NOW(), INTERVAL 3 MONTH);   -- DATE_SUB 빼기

# D-day 계산
SELECT TO_DAYS('2024-11-14') - TO_DAYS(CURDATE()); -- D-286

# 요일: 1 - 일요일
SELECT DAYOFWEEK(regDate) FROM datetable;
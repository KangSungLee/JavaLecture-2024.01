############################
#  테이블 조인(Table join) #
############################

/*
 * 1. 테이블 생성
 */
# song TABLE
CREATE TABLE if NOT EXISTS song (
    SID INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(32) NOT NULL,
    lyrics VARCHAR(64)
) AUTO_INCREMENT=101;   -- 시작을 101번부터 시작하겠다.

# girl_group Table
CREATE TABLE if NOT EXISTS girl_group(
    gid INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(32) NOT NULL,
    debut DATE NOT NULL,
    hit_song_id INT 
) AUTO_INCREMENT=1001;

/*
 * 2. 데이터 입력
 */
# song TABLE
INSERT INTO song (title, lyrics) VALUES
   ('Tell Me', 'tell me tell me tetetete tel me'),
   ('Gee', 'GEE GEE GEE GEE GEE BABY BABY'),
   ('미스터', '이름이 뭐야 미스터'), 
   ('Abracadabra', '이러다 미쳐 내가 여리여리'),
   ('8282', 'Give me a call Baby baby'), ('기대해', '기대해'),
   ('I Dont care', '다른 여자들의 다리를'), 
   ('Bad Girl Good Girl', '앞에선 한 마디 말도'), ('피노키오', '뉴예삐오'),
   ('별빛달빛', '너는 내 별빛 내 마음의 별빛'), 
   ('A', 'A 워오우 워오우워 우우우'),
   ('나혼자', '나 혼자 밥을 먹고 나 혼자 영화 보고'), ('LUV', '설레이나요 '),
   ('짧은치마', '짧은 치마를 입고 내가 길을 걸으면'),
   ('위아래', '위 아래 위위 아래'), ('Dumb Dumb', '너 땜에 하루종일');

   

# girl_group Table
Insert INTO girl_group (name, debut, hit_song_id) value
    ('원더걸스', '2007-02-10', 101),
    ('소녀시대', '2007-08-02', 102), ('카라', '2009-07-30', 103),
    ('브라운아이드걸스', '2008-01-17', 104), ('다비치', '2009-02-27', 105),
    ('2NE1', '2009-07-08', 106), ('f(x)', '2011-04-20', 108),
    ('시크릿', '2011-01-06', 109), ('레인보우', '2010-08-12', 110),
    ('애프터 스쿨', '2009-11-25', 120), ('포미닛', '2009-08-28', 121);

/*
 * 3. Table join
 */
# Inner join
SELECT r.name, r.debut, l.title, l.lyrics FROM song l
	Inner JOIN girl_group r  --inner 생략가능
	ON l.SID=r.hit_song_id;

# Left OUTER join
SELECT r.name, r.debut, l.title, l.lyrics FROM song l
	LEFT OUTER JOIN girl_group r        -- outer 생략가능
	ON l.SID=r.hit_song_id;

# Right outer join
SELECT r.name, r.debut, l.title, l.lyrics FROM song l
	Right OUTER JOIN girl_group r        -- outer 생략가능
	ON l.SID=r.hit_song_id;

# Full outer join -- MySQL에서는 Left join 과 Right join을 UNION
SELECT r.name, r.debut, l.title, l.lyrics FROM song l
	LEFT OUTER JOIN girl_group r      
	ON l.SID=r.hit_song_id
UNION
SELECT r.name, r.debut, l.title, l.lyrics FROM song l
	Right OUTER JOIN girl_group r   
	ON l.SID=r.hit_song_id;

    WHERE r.debut = 2009
######################################################
#
# 데이터 조작 언어(DML: Data Manipulation Language)
#
######################################################

SHOW DATABASES;
USE world;
SHOW TABLES;
DESC city;

/*
 *  1. Select 
 */
/*
SELECT 필드명 
    FROM 테이블명
    JOIN 테이블명
    ON 조인 조건
    WHERE 조회 조건
    GROUP BY 필드명
    HAVING 그룹(필드) 조건
    ORDER BY 필드명 순서
    LIMIT 숫자 OFFSET 숫자;
*/

SELECT * FROM city;     -- * 모든필드
SELECT 'name', population FROM city LIMIT 10; -- 필드명을 보존하고 싶을 때 `back quote`

/*
 * 1.1 조회 조건: WHERE
 */

SELECT * FROM city WHERE countrycode='KOR';
SELECT * FROM city WHERE population > 9000000;
SELECT * FROM city WHERE countrycode='KOR' AND population >= 1000000;

SELECT DISTINCT district FROM city WHERE countrycode='KOR';     -- 고유한 값 - DISTINCT

-- 수도권 도시(서월, 인천, 경기)
SELECT * FROM city
    WHERE district='Seoul' or district='Inchon' or district='Kyonggi';
SELECT * FROM city WHERE district IN ('Seoul','Inchon','Kyonggi');  -- IN = or?

-- 경기도에서 인구수가 홀수인 도시
SELECT * FROM city WHERE district='Kyonggi' AND population % 2 = 1;

-- 국내에서 인구수가 50만 ~ 100만 도시
SELECT * FROM city WHERE countrycode='KOR' AND 
    population >= 500000 AND population <= 1000000;
SELECT * FROM city WHERE countrycode='KOR' AND population between 500000 AND 1000000;   
-- between 어디서부터 어디까지를 구분해주는것 같음

-- 충청남북도의 도시
SELECT * FROM city WHERE district='Chungchongbuk' or district='Chungchongnam';  
SELECT * FROM city WHERE district LIKE 'Chungchong%';  -- % - 임의의 문자, 이때는 LIKE 사용
-- % 와일드캐릭터 Chungchong가 들어가있는 모든 district // = 대신 LIKE 사용

/*
 * 1.2 순서(Order) - ASC(Ascennding: 오름차순, default), DESC(Descending: 내림차순)
 */
-- 인구수가 900만 이상인 도시를 인구수의 내림차순으로 조회
SELECT * FROM city WHERE population >= 9000000
    ORDER BY population DESC;   --  ORDER BY는 하나

-- 국내에서 인구수가 50만 ~ 100만 도시를 지역 오름차순, 인구수 내림차순으로 조회
SELECT * FROM city WHERE countrycode='KOR' AND population between 500000 AND 1000000
    ORDER BY district ASC, population DESC;     -- ASC는 생략가능

/*
 * 1.3 갯수 
 */
-- 전세계 인구수 Top 10 도시
SELECT * FROM city ORDER BY population DESC LIMIT 10;

-- 국내 인구수 Top 5 도시
SELECT * FROM city WHERE countrycode='KOR' ORDER BY population DESC LIMIT 5;

-- 국내 인구수 Top 11~20 도시
SELECT * FROM city WHERE countrycode='KOR' 
    ORDER BY population DESC
    LIMIT 10 OFFSET 10;     -- 앞에서 10개를 건너뛰고, 10개를 보여줌

/*
 * 1. 4 함수
 */
-- 현재 날짜와 시각
SELECT now();   -- 2024-02-01 13:44:54

-- 국내 도시의 갯수 - 레코드의 갯수
SELECT count(*) FROM city WHERE countrycode='KOR';

-- 최대, 최소 - 국내 도시중 인구수 최대, 최소 도시
SELECT MAX(population), MIN(population) FROM city WHERE countrycode='KOR';
-- SELECT * FROM city WHERE countrycode='KOR' AND population=92239;

-- 국내의 도시의 인구 평균
-- SELECT AVG(population) FROM city WHERE countrycode='KOR';
SELECT ROUND(AVG(population)) FROM city WHERE countrycode='KOR';

-- Aliasing - DTO, SELECT 필드명이 같으면 알아서 꽂아주기 때문에 사용한다
SELECT ROUND(AVG(population)) AS avgPop FROM city WHERE countrycode='KOR'; 
-- AS avgPop AS를 이용하거나 생략 후 이름을 변경
SELECT count(*) numCity FROM city WHERE countrycode='KOR';

/*
 * 1.5 그룹핑
 */
-- 국내 광역시도별 인구수의 평균을 내림차순으로 조회
SELECT district, ROUND(AVG(population)) avgPop FROM city
    WHERE countrycode='KOR'
    GROUP BY district 
    ORDER BY avgPop DESC;

-- 국내 도별(도시의 갯수가 2개 이상) 인구수의 평균을 내림차순으로 조회
SELECT district, ROUND(AVG(population)) avgPop FROM city
    WHERE countrycode='KOR'
    GROUP BY district
    HAVING count(*) >= 2        -- HAVING(그룹핑 조건) - 도시의 갯수가 2개이상
    ORDER BY avgPop DESC;

-- 도시의 갯수가 많은나라 TOP 100
SELECT countrycode, count(*) numCity FROM city
    GROUP BY countrycode
    ORDER BY numCity DESC
    LIMIT 10;

-- 경기도의 도시 이름
SELECT `name` FROM city WHERE district='Kyonggi';
SELECT GROUP_CONCAT(`name`) cities FROM city WHERE district='Chungchongnam';

-- 국내 광역시도 이름
SELECT DISTINCT district FROM city WHERE countrycode='KOR';
SELECT GROUP_CONCAT(district) districts FROM city WHERE countrycode='KOR';

/*
 * 1.6 그룹핑 조건
 */
-- 국내 도별(도시의 갯수가 2개 이상) 인구수의 평균을 내림차순으로 조회
SELECT district, ROUND(AVG(population)) avgPop FROM city
    WHERE countrycode='KOR'
    GROUP BY district
    HAVING count(*) >= 2        -- HAVING(그룹핑 조건) - 도시의 갯수가 2개이상
    ORDER BY avgPop DESC;

-- 국내 도시의 갯수가 5개 이상인 도
SELECT district, count(*) numCity FROM city WHERE countrycode='KOR'
    GROUP BY district
    HAVING numCity >=5;

-- 국내 도시의 갯수가 5개 이상인 도의 평균 도시 인구수를 인구 평균 내림차순으로 정렬
SELECT district, ROUND(AVG(population)) avgPop FROM city WHERE countrycode='KOR'
    GROUP BY district
    HAVING count(*) >= 5
    ORDER BY avgPop DESC;

-- 도시 갯수가 100개 이상인 국가의 도시인구 평균을 내림차순으로 정렬
SELECT countrycode,count(*) numCity, ROUND(AVG(population)) avgPop FROM city
    GROUP BY countrycode
    HAVING numCity >= 100
    ORDER BY avgPop DESC;

/*
 * 1.7 Join
 */
-- 1. 인구수가 800만 보다 큰 도시의 국가명, 도시명, 인구수
SELECT country.Name, city.Name, city.population FROM city   
    JOIN country ON city.countrycode=country.Code
    WHERE city.population > 8000000;

-- 1-1. 처음에 작성후
SELECT * FROM city l  
    Join country r 
    ON l.countrycode=r.Code
    WHERE l.population > 8000000;
-- 1-2. 이런식으로 자동완성문장을 이용해서 수정하면 편하다.
SELECT r.Name countryName, l.Name cityName, l.Population FROM city l  
    INNER JOIN country r            -- INNER 는 생략 가능
    ON l.countrycode=r.Code
    WHERE l.population > 8000000;

-- 양쪽 테이블에서 필드명이 고유한 필드는 테이블 이름을 생략할 수 있음(Continent)
SELECT Continent, r.Name countryName, l.Name cityName, l.Population FROM city l  
    INNER JOIN country r          
    ON l.countrycode=r.Code
    WHERE l.population > 8000000;

-- 아시아 대륙에서 인구수가 많은도시 Top 10
SELECT * FROM city l 
    JOIN country r 
    ON l.countrycode=r.Code
    WHERE r.Continent='Asia'
    ORDER BY l.population DESC
    LIMIT 10;
-- 위처럼 작성하고 아래처럼 정리
SELECT Continent, r.Name countryName, l.Name cityName, l.Population FROM city l 
    JOIN country r 
    ON l.countrycode=r.Code
    WHERE r.Continent='Asia'
    ORDER BY l.population DESC
    LIMIT 10;

/*
 * 1.8 Sub Query
 */
-- 국내 도시만으로 새로운 테이블을 만드는 경우
CREATE TABLE if NOT EXISTS kcity LIKE city;
INSERT INTO kcity
    SELECT * FROM city WHERE countrycode='KOR';


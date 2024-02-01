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

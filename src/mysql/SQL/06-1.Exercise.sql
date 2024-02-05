# 1. 2009년도에 데뷔한 걸그룹의 힛스토송은?
# (걸그룹 이름, 데뷔일자, 힛트송 제목)
SELECT r.name, r.debut, l.title 
	FROM song l
	INNER JOIN girl_group r
	ON l.sid = r.hit_song_id
	WHERE YEAR(r.debut) = 2009;

# 2. 데뷔일자가 빠른 5개 그룹의 힛스트송은?
# (걸그룹 이름, 데뷔일자, 힛트송 제목)
SELECT r.name, r.debut, l.title 
	FROM song l
	INNER JOIN girl_group r
	ON l.sid = r.hit_song_id
	ORDER BY r.debut
	LIMIT 5;

# 3. 대륙별로 국가숫자, GNP의 합, 평균 국가별 GNP는?
Select continent, COUNT(*),ROUND(SUM(GNP)) , ROUND(AVG(GNP)) 
    FROM country
    GROUP BY continent

# 4. 아시아 대륙에서 인구가 가장 많은 도시 10개를 내림차순으로 보여줄 것
#   (대륙명, 국가명, 도시명, 인구수)
SELECT l.Continent, l.Name, r.Name, r.Population FROM country l
    JOIN city r
    ON l.Code=r.CountryCode
    WHERE l.Continent='Asia'
    ORDER BY population DESC
    LIMIT 10;

# 5. 전 세계에서 GNP가 높은 10개 국가에서 사용하는 공식 언어는?
#   (국가명, GNP, 언어명)
SELECT l.name, l.GNP, min(r.Language)
    FROM country l
    JOIN countrylanguage r
    ON l.Code = r.CountryCode
    WHERE r.IsOfficial='T'
    GROUP BY l.Code
    ORDER BY l.gnp DESC
    LIMIT 10;

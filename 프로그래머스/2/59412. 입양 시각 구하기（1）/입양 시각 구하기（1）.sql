-- 코드를 입력하세요
SELECT DATE_FORMAT(DATETIME, '%H') AS HOUR, COUNT(*)
FROM ANIMAL_OUTS
WHERE DATE_FORMAT(DATETIME, '%H:%m') >= '09:00' AND DATE_FORMAT(DATETIME, '%H:%m')<'20:00'
GROUP BY HOUR
ORDER BY HOUR;
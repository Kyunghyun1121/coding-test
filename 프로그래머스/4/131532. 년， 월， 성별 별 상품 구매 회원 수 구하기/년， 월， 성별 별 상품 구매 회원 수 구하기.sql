-- 코드를 입력하세요
SELECT  year(s.SALES_DATE) as YEAR,	month(s.SALES_DATE) as MONTH,
    i.GENDER, count(distinct i.USER_ID) as USERS
from USER_INFO as i, ONLINE_SALE as s
where i.USER_ID = s.USER_ID and i.GENDER is not null
group by year(s.SALES_DATE), month(s.SALES_DATE), i.GENDER
order by YEAR, MONTH, i.GENDER asc
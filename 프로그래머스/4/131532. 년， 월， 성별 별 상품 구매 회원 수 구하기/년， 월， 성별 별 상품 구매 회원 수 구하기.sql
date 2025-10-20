-- 코드를 입력하세요
SELECT YEAR(b.SALES_DATE) as YEAR, MONTH(b.SALES_DATE) as MONTH, a.GENDER as GENDER, 
    count(distinct a.USER_ID) as USERS
from (select * from USER_INFO where GENDER is not null)
      as a join ONLINE_SALE as b on a.USER_ID = b.USER_ID
group by YEAR(b.SALES_DATE), MONTH(b.SALES_DATE), a.GENDER
order by YEAR, MONTH, GENDER
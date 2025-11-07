-- 코드를 입력하세요
SELECT year(b.SALES_DATE) as 'YEAR', month(b.SALES_DATE) as 'MONTH',
    count(distinct a.USER_ID) as 'PURCHASED_USERS',
    round(count(distinct b.USER_ID)
          / (select count(distinct USER_ID) from USER_INFO where year(JOINED) = '2021') , 1)
          as 'PUCHASED_RATIO'
from USER_INFO as a
    join ONLINE_SALE as b on a.USER_ID = b.USER_ID
where year(a.JOINED) = '2021'
group by year(b.SALES_DATE), month(b.SALES_DATE)
order by YEAR, MONTH


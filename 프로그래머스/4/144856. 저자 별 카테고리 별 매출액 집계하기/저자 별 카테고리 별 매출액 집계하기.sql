-- 코드를 입력하세요
SELECT b.AUTHOR_ID, b.AUTHOR_NAME, a.CATEGORY, sum(a.PRICE * c.SALES) as TOTAL_SALES
from BOOK as a join AUTHOR as b on a.AUTHOR_ID = b.AUTHOR_ID
    join (select * from BOOK_SALES where date_format(SALES_DATE, "%Y-%m") like '2022-01') as c 
        on a.BOOK_ID = c.BOOK_ID
group by b.AUTHOR_ID, b.AUTHOR_NAME, a.CATEGORY
order by  b.AUTHOR_ID, a.CATEGORY desc
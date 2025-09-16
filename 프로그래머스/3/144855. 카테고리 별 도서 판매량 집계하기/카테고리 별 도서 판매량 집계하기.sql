-- 코드를 입력하세요
SELECT category, sum(SALES) as TOTAL_SALES
from BOOK as a join BOOK_SALES  as b on a.BOOK_ID = b.BOOK_ID
where date_format(SALES_DATE, "%Y-%m") like "2022-01"
group by category
order by category asc
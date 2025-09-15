-- 코드를 입력하세요
SELECT PRODUCT_CODE, sum(a.PRICE * b.SALES_AMOUNT) as SALES
from PRODUCT as a join OFFLINE_SALE as b on a.PRODUCT_ID = b.PRODUCT_ID
group by a.product_code
order by SALES desc, PRODUCT_CODE asc
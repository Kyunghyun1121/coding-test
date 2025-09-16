-- 코드를 입력하세요
SELECT a.PRODUCT_ID, PRODUCT_NAME, sum(AMOUNT * PRICE) as TOTAL_SALES
from FOOD_PRODUCT as a join FOOD_ORDER as b on a.PRODUCT_ID = b.PRODUCT_ID
where date_format(PRODUCE_DATE, "%Y-%m") like "2022-05"
group by a.PRODUCT_ID
order by TOTAL_SALES desc, PRODUCT_ID asc
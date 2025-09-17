-- 코드를 입력하세요
SELECT a.CATEGORY, b.MAX_PRICE, a.PRODUCT_NAME
from FOOD_PRODUCT as a join 
    (select MAX(PRICE) as MAX_PRICE, CATEGORY from FOOD_PRODUCT group by  CATEGORY) as b 
    on a.CATEGORY = b.CATEGORY
where a.CATEGORY in ( '과자', '국', '김치', '식용유') and 
    a.PRICE = b.MAX_PRICE
order by b.MAX_PRICE desc
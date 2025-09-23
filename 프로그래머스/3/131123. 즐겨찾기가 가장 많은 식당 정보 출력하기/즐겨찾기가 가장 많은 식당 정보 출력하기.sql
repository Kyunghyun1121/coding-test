-- 코드를 입력하세요
select a.FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
from (SELECT FOOD_TYPE, max(FAVORITES) as max
        from REST_INFO 
        group by FOOD_TYPE) as a join REST_INFO as b 
        on a.FOOD_TYPE = b.FOOD_TYPE and a.max = b.FAVORITES
order by a.FOOD_TYPE desc
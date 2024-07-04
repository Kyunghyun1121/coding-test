-- 코드를 입력하세요
SELECT distinct f.FLAVOR
from (select distinct * from FIRST_HALF where TOTAL_ORDER > 3000) as f
    , (select distinct * from ICECREAM_INFO where INGREDIENT_TYPE = 'fruit_based')as i
where i.FLAVOR = f.FLAVOR
order by f.TOTAL_ORDER desc
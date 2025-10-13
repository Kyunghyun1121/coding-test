-- 코드를 입력하세요
SELECT a.FLAVOR
from FIRST_HALF as a join (select * from ICECREAM_INFO where INGREDIENT_TYPE like 'fruit_based')
    as b on a.FLAVOR = b.FLAVOR
group by  a.FLAVOR
having sum(a.TOTAL_ORDER) >= 3000
order by sum(a.TOTAL_ORDER) desc
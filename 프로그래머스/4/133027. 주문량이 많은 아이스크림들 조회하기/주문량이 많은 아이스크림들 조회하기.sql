-- 코드를 입력하세요
SELECT a.FLAVOR
from FIRST_HALF as a join JULY as b on a.FLAVOR = b.FLAVOR
group by a.FLAVOR
order by sum(a.TOTAL_ORDER + b.TOTAL_ORDER) desc limit 3

-- 코드를 입력하세요
with recursive cte (HOUR) as(
    select 0
    union all
    select HOUR + 1 from cte where HOUR < 23
)

select c.HOUR, ifnull(o.count, 0) as COUNT
from cte as c left join
    (select HOUR(DATETIME) as HOUR, count(ANIMAL_ID) as count 
     from ANIMAL_OUTS group by HOUR) as o on c.HOUR = o.HOUR
order by c.HOUR
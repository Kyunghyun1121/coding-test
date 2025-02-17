with recursive h (HOUR) as (
    select 0
    union all
    select HOUR + 1 from h where HOUR < 23
)

select h.HOUR, count(ANIMAL_ID) as COUNT
from h left join ANIMAL_OUTS on h.HOUR = HOUR(ANIMAL_OUTS.DATETIME)
group by h.HOUR
order by h.HOUR
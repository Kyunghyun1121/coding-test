-- 코드를 작성해주세요
with recursive temp as (
    select ID, case when PARENT_ID is null then 1 end as gen
    from ECOLI_DATA 
    
    union all
    
    select a.ID,  b.gen + 1 as gen
    from ECOLI_DATA as a, temp as b
    where a.PARENT_ID = b.ID
)

select ID
from temp
where gen = 3
order by ID asc
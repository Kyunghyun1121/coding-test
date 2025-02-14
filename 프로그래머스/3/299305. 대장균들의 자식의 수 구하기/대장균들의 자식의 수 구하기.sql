select a.ID, count(b.ID) as CHILD_COUNT
from ECOLI_DATA as a left join ECOLI_DATA as b on b.PARENT_ID = a.ID
group by a.ID
order by a.ID
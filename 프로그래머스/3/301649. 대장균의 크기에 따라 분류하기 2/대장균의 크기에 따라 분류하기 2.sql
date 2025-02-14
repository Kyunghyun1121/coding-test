select a.ID, 
    (case when a.r <= 0.25 then "CRITICAL"
    when a.r <= 0.50 then "HIGH"
    when a.r <= 0.75 then "MEDIUM"
    else "LOW" end) as COLONY_NAME
from 
    (select ID, (percent_rank() over (order by SIZE_OF_COLONY desc)) as r
      from ECOLI_DATA) as a
order by a.ID asc
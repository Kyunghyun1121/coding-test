select year(a.DIFFERENTIATION_DATE) as YEAR, 
    b.m - a.SIZE_OF_COLONY as YEAR_DEV, a.ID
from ECOLI_DATA as a join
    (select max(SIZE_OF_COLONY) as m, year(DIFFERENTIATION_DATE) as year
     from ECOLI_DATA group by year(DIFFERENTIATION_DATE)) as b
    on year(a.DIFFERENTIATION_DATE) = b.year
order by year asc ,YEAR_DEV asc
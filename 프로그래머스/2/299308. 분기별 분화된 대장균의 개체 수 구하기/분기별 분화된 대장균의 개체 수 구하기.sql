select concat(a.QUARTER, "Q") as QUARTER, a.ECOLI_COUNT
from (select quarter(DIFFERENTIATION_DATE) as QUARTER ,
    count(ID) as ECOLI_COUNT
from ECOLI_DATA
group by quarter(DIFFERENTIATION_DATE)
order by QUARTER asc) as a
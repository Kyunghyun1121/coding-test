select b.ID as ID, b.GENOTYPE, a.GENOTYPE as PARENT_GENOTYPE
from ECOLI_DATA as a, ECOLI_DATA as b
where a.ID = b.PARENT_ID
    and a.GENOTYPE & b.GENOTYPE >= a.GENOTYPE
order by ID asc
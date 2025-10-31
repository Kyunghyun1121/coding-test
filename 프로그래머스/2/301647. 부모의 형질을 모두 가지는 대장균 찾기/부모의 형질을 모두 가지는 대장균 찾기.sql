-- 코드를 작성해주세요
select a.ID, a.GENOTYPE, b.GENOTYPE as PARENT_GENOTYPE
from ECOLI_DATA as a join ECOLI_DATA as b on a.PARENT_ID = b.ID
where a.GENOTYPE & b.GENOTYPE = b.GENOTYPE
order by a.ID
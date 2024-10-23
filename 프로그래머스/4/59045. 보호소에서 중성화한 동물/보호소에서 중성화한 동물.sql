-- 코드를 입력하세요
SELECT i.ANIMAL_ID,	i.ANIMAL_TYPE,	i.NAME
from (select * from ANIMAL_INS where SEX_UPON_INTAKE like ("%Intact%")) as i,
    (select * from ANIMAL_OUTS where SEX_UPON_OUTCOME not like ("%Intact%")) as o
where i.ANIMAL_ID = o.ANIMAL_ID
order by i.ANIMAL_ID
-- 코드를 입력하세요
SELECT a.ANIMAL_ID, a.ANIMAL_TYPE, a.NAME
from (select * from ANIMAL_INS where SEX_UPON_INTAKE like ("Intact%")) as a
    join 
    (select * from ANIMAL_OUTS where SEX_UPON_OUTCOME not like ("Intact%")) as b on a.ANIMAL_ID = b.ANIMAL_ID
order by a.ANIMAL_ID

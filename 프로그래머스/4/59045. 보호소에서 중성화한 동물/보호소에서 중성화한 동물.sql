select ANIMAL_INS.ANIMAL_ID,	ANIMAL_INS.ANIMAL_TYPE,	ANIMAL_INS.NAME
from ANIMAL_INS join ANIMAL_OUTS on ANIMAL_INS.ANIMAL_ID = ANIMAL_OUTS.ANIMAL_ID
where SEX_UPON_INTAKE != SEX_UPON_OUTCOME
order by ANIMAL_INS.ANIMAL_ID
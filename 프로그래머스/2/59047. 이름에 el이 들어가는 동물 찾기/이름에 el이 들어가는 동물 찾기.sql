-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME
from ANIMAL_INS
where Upper(NAME) like "%EL%" and ANIMAL_TYPE like "Dog"
order by NAME
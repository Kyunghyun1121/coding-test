-- 코드를 입력하세요
SELECT a.CAR_ID
from CAR_RENTAL_COMPANY_CAR as a join CAR_RENTAL_COMPANY_RENTAL_HISTORY as b 
    on a.CAR_ID = b.CAR_ID
where a.CAR_TYPE like '세단' and month(b.START_DATE) = 10
group by a.CAR_ID
order by a.CAR_ID desc
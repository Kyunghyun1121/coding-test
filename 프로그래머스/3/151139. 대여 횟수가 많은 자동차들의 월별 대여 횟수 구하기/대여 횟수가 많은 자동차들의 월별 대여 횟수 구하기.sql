-- 코드를 입력하세요
select month(START_DATE) as MONTH, CAR_ID, count(CAR_ID) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where CAR_ID in
    (SELECT CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where date_format(START_DATE, "%Y-%m") >= '2022-08' && date_format(START_DATE, "%Y-%m") <= '2022-10'
    group by CAR_ID
    having count(CAR_ID) >= 5) && date_format(START_DATE, "%Y-%m") >= '2022-08' && date_format(START_DATE, "%Y-%m") <= '2022-10'
group by month(START_DATE), CAR_ID
order by MONTH asc, CAR_ID desc
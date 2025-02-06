select month(START_DATE) as MONTH, CAR_ID, count(HISTORY_ID) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    where CAR_ID in (select CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    where date_format(START_DATE , "%Y-%m") >= "2022-08" and 
            date_format(START_DATE , "%Y-%m") <= "2022-10"
    group by CAR_ID
    having count(HISTORY_ID) >= 5) and date_format(START_DATE , "%Y-%m") >= "2022-08" and 
            date_format(START_DATE , "%Y-%m") <= "2022-10"
group by month(START_DATE), CAR_ID
having count(HISTORY_ID) > 0
order by MONTH asc, CAR_ID desc
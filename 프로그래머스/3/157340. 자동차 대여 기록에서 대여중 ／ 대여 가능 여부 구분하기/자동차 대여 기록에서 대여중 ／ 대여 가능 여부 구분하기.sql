-- 코드를 입력하세요
select a.CAR_ID, case when sum(a.s) > 0 then "대여중" else "대여 가능" end as AVAILABILITY
from (SELECT CAR_ID, 
        case 
        when START_DATE <= "2022-10-16" and END_DATE >= "2022-10-16" then 1
        else 0
        end as s
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY) as a
group by a.CAR_ID 
order by a.CAR_ID desc
-- 코드를 입력하세요
SELECT distinct h.ID as HISTORY_ID,
    round((case when h.history < 7 then h.history * c.DAILY_FEE
    else (h.history * dis.DISCOUNT_RATE) * c.DAILY_FEE end)) as FEE
from (select (case when DURATION_TYPE like "7%" then 7
             when DURATION_TYPE like "30%" then 30
             else 90 end) as s,
        (case when DURATION_TYPE like "7%" then 30
             when DURATION_TYPE like "30%" then 90
             else null end) as e,
      (100-DISCOUNT_RATE)/100 as DISCOUNT_RATE
      from CAR_RENTAL_COMPANY_DISCOUNT_PLAN  where CAR_TYPE like "트럭") as dis,
    CAR_RENTAL_COMPANY_CAR as c, 
    (select CAR_ID, (datediff(END_DATE , START_DATE)+1) as history, HISTORY_ID as ID,START_DATE,END_DATE
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY ) as h
where c.CAR_ID = h.CAR_ID and c.CAR_TYPE like "트럭"
    and ((h.history >= dis.s and h.history < dis.e) or 
        (h.history >= dis.s and dis.e is null) or 
         (h.history < 7))
order by FEE desc, HISTORY_ID desc
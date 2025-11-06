-- 코드를 작성해주세요
select round(avg(a.LENGTH), 2) as AVERAGE_LENGTH
from (select case when LENGTH <= 10 || LENGTH is null then 10 else LENGTH end as LENGTH
from FISH_INFO) as a

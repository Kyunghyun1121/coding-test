-- 코드를 작성해주세요
select *
from (select (case
       when count(case when s.CATEGORY like "Front End" then 1 else null end) *
            count(case when s.NAME like "Python" then 1 else null end)
                   >= 1 then "A"
        when count(case when s.NAME like "C#" then 1 else null end) >= 1 then "B"
        when count(case when s.CATEGORY like "Front End" then 1 else null end) >= 1 then "C"
       end)as GRADE, d.ID, d.EMAIL
from DEVELOPERS as d, SKILLCODES as s
where d.SKILL_CODE & s.CODE >= 1
group by d.ID, d.EMAIL
order by GRADE, d.ID) as c
where c.GRADE is not null
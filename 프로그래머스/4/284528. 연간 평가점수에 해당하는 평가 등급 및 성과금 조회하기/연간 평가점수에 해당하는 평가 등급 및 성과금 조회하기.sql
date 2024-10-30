-- 코드를 작성해주세요
select e.EMP_NO,	e.EMP_NAME,	g.GRADE,
 (case when g.GRADE like 'S' then e.SAL * 0.2
      when g.GRADE like 'A' then e.SAL * 0.15
      when g.GRADE like 'B' then e.SAL * 0.1
     else 0 end) as BONUS
from HR_EMPLOYEES as e, 
 (select EMP_NO,
     (case when round(avg(SCORE),5) >= 96.0 then 'S'
       when round(avg(SCORE),5) >= 90.0 then 'A'
       when round(avg(SCORE),5) >= 80.0 then 'B'
     else 'C' end) as GRADE from HR_GRADE group by EMP_NO) as g
where e.EMP_NO = g.EMP_NO
order by e.EMP_NO asc
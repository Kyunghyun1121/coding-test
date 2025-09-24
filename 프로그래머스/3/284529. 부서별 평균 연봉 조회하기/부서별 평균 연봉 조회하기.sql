-- 코드를 작성해주세요
select a.DEPT_ID, a.DEPT_NAME_EN, round(avg(b.SAL), 0) as AVG_SAL
from HR_DEPARTMENT as a join HR_EMPLOYEES as b on a.DEPT_ID = b.DEPT_ID
group by a.DEPT_ID, a.DEPT_NAME_EN
order by AVG_SAL desc
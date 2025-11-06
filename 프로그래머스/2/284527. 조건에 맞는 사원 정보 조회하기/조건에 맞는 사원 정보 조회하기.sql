-- 코드를 작성해주세요
select sum(c.SCORE) as SCORE, b.EMP_NO, b.EMP_NAME, b.POSITION, b.EMAIL
from HR_DEPARTMENT as a join HR_EMPLOYEES as b on a.DEPT_ID = b.DEPT_ID 
    join HR_GRADE as c on b.EMP_NO = c.EMP_NO
where c.YEAR = 2022
group by b.EMP_NO, b.EMP_NAME, b.POSITION, b.EMAIL
order by sum(c.SCORE) desc limit 1
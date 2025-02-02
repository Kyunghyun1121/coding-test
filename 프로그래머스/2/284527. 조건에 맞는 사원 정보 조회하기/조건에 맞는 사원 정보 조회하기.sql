-- 코드를 작성해주세요
select  sum(SCORE) as SCORE, HR_EMPLOYEES.EMP_NO, EMP_NAME, POSITION, EMAIL
from HR_EMPLOYEES join HR_GRADE on HR_EMPLOYEES.EMP_NO = HR_GRADE.EMP_NO
group by HR_EMPLOYEES.EMP_NO, EMP_NAME, POSITION, EMAIL
having sum(SCORE) = 
    (select sum(SCORE) from HR_GRADE group by EMP_NO order by sum(SCORE)desc limit 1)
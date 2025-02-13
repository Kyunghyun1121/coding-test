select HR_DEPARTMENT.DEPT_ID, DEPT_NAME_EN, round(avg(SAL),0) as AVG_SAL
from HR_DEPARTMENT join HR_EMPLOYEES on HR_DEPARTMENT.DEPT_ID = HR_EMPLOYEES.DEPT_ID
group by HR_DEPARTMENT.DEPT_ID, DEPT_NAME_EN
order by AVG_SAL desc
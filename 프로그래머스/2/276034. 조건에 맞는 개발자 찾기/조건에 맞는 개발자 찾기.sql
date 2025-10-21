-- 코드를 작성해주세요
select distinct a.ID, a.EMAIL, a.FIRST_NAME, a.LAST_NAME
from DEVELOPERS as a join SKILLCODES as b 
where b.CODE & a.SKILL_CODE = b.CODE and b.NAME in ('Python', 'C#')
order by a.ID
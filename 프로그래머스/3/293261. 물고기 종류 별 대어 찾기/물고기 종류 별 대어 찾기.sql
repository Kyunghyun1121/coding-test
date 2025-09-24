-- 코드를 작성해주세요
select c.ID, d.FISH_NAME, d.LENGTH
from (select b.FISH_NAME, b.FISH_TYPE, max(a.LENGTH) as LENGTH
    from FISH_INFO as a join FISH_NAME_INFO as b on a.FISH_TYPE = b.FISH_TYPE
    group by b.FISH_NAME, b.FISH_TYPE) as d join FISH_INFO as c
        on c.FISH_TYPE = d.FISH_TYPE and c.LENGTH = d.LENGTH
order by c.ID asc
-- 코드를 작성해주세요
select count(ID) as FISH_COUNT, max(LENGTH) as MAX_LENGTH, FISH_TYPE
from (select ID, FISH_TYPE, 
      case when LENGTH < 10 then 10 else LENGTH end as LENGTH from FISH_INFO) as a
group by FISH_TYPE
having sum(LENGTH) >= 33
order by FISH_TYPE
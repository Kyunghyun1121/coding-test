-- 코드를 작성해주세요
select c.ITEM_ID, c.ITEM_NAME, c.RARITY
from ITEM_INFO as a join ITEM_TREE as b on a.ITEM_ID = b.PARENT_ITEM_ID
    join ITEM_INFO as c on b.ITEM_ID  = c.ITEM_ID
where a.RARITY like 'RARE'
order by c.ITEM_ID desc
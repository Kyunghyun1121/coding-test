-- 코드를 입력하세요
SELECT b.USER_ID, NICKNAME, sum(PRICE) as TOTAL_SALES
from USED_GOODS_BOARD as a join USED_GOODS_USER as b on a.WRITER_ID = b.USER_ID
where a.STATUS like "DONE"
group by a.WRITER_ID
having sum(PRICE) >= 700000
order by sum(PRICE) asc
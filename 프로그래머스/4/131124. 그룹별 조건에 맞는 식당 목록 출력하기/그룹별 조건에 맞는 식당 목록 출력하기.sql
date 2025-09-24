-- 코드를 입력하세요
SELECT c.MEMBER_NAME, a.REVIEW_TEXT, date_format(a.REVIEW_DATE, "%Y-%m-%d") as REVIEW_DATE
from (REST_REVIEW as a join (
    select MEMBER_ID from REST_REVIEW group by MEMBER_ID order by count(REVIEW_ID) desc limit 1) 
    as b on a.MEMBER_ID = b.MEMBER_ID) join MEMBER_PROFILE as c on a.MEMBER_ID = c.MEMBER_ID
order by REVIEW_DATE asc, a.REVIEW_TEXT asc

-- 코드를 입력하세요
SELECT b.APNT_NO, a.PT_NAME, b.PT_NO, d.MCDP_CD, d.DR_NAME, b.APNT_YMD
from (PATIENT as a join APPOINTMENT as b on a.PT_NO = b.PT_NO) join
    DOCTOR as d on MDDR_ID = d.DR_ID
where date_format(b.APNT_YMD, "%Y-%m-%d") like '2022-04-13' and b.APNT_CNCL_YN like 'N'
    and d.MCDP_CD like "CS"
order by b.APNT_YMD asc
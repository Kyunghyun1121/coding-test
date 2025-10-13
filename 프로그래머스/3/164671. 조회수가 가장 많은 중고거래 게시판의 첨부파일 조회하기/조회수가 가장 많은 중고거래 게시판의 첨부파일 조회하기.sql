-- 코드를 입력하세요
SELECT concat('/home/grep/src/', a.BOARD_ID, '/', a.FILE_ID, a.FILE_NAME, a.FILE_EXT) 
    as FILE_PATH
from USED_GOODS_FILE as a join 
    (select * from USED_GOODS_BOARD order by VIEWS desc limit 1) 
    as b on a.BOARD_ID = b.BOARD_ID
order by a.FILE_ID desc

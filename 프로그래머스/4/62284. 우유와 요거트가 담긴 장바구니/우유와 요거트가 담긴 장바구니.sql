select distinct a.CART_ID
from CART_PRODUCTS as a, CART_PRODUCTS as b
where a.CART_ID = b.CART_ID and
    ((a.NAME like "Milk" and b.NAME like "Yogurt") or 
     (a.NAME like "Yogurt" and b.NAME like "Milk"))
order by CART_ID
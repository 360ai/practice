select GROUP_CONCAT(CONCAT_WS(',', pp.id, pp.name, ppc.name) separator '-') as productName
from pms_product pp
         left join pms_product_category ppc on pp.product_category_id = pp.id;




SELECT *,
       AES_DECRYPT(
               from_base64 (),
               '4ec15ac331e64998'
           ) as mobile,
       count(*) AS countNumber
FROM
    ums_member where 1=1
GROUP BY
    phone
HAVING
        countNumber > 1 ORDER BY create_time desc;

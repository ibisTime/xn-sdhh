ALTER TABLE `tsd_business` 
ADD COLUMN `ywfxbzj` bigint(20) NULL COMMENT '业务风险保证金' AFTER `bzjdke`;

SET SQL_SAFE_UPDATES = 0;
CREATE TABLE tmp as select code,ysfdje from tsd_business;
UPDATE tsd_business b SET b.ysfdje=b.fdje;
UPDATE tsd_business b,tmp t SET b.fdje=t.ysfdje WHERE b.code = t.code;
drop table tmp;
SET SQL_SAFE_UPDATES = 1;
ALTER TABLE `tsd_business` 
ADD COLUMN `qdfffrq` datetime NULL COMMENT '渠道费发放日期' AFTER `qdf`;

INSERT INTO `tsys_menu` (`code`,`parent_code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('SM201812091459084276596','SM201811092208430952590','删除','2','/delete',3,'admin','2018-12-09 14:59:08','','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`parent_code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('SM201812091606442563542','SM20181110000005880849','全部业务','1','/biz/business.htm',0,'admin','2018-12-09 16:06:44','','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`parent_code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('SM201812091607024775006','SM201812091606442563542','详情','2','/detail',1,'admin','2018-12-09 16:07:02','','CD-CHH000020');
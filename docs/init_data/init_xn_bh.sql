/*
-- Query: SELECT type,parent_key,dkey,dvalue,updater,now() update_datetime,remark FROM tsys_dict
-- Date: 2018-11-10 16:03
*/
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('0',NULL,'car_type','汽车种类','admin',now(),NULL);
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('1','car_type','0','其他车','admin',now(),'');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('1','car_type','1','二手车','admin',now(),'');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('0',NULL,'user_status','用户状态','admin',now(),NULL);
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('1','user_status','0','正常','admin',now(),NULL);
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('1','user_status','1','程序锁定','admin',now(),NULL);
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('1','user_status','2','人工锁定','admin',now(),NULL);

insert into `tsys_config` (`type`, `ckey`, `cvalue`, `updater`, `update_datetime`, `remark`) values('qiniu','qiniu_access_key','Dc0pMP8ImFm78-uk4iGsOPpB2-vHc64D07OsOQVi','admin',now(),'七牛云key1');
insert into `tsys_config` (`type`, `ckey`, `cvalue`, `updater`, `update_datetime`, `remark`) values('qiniu','qiniu_secret_key','3NP-tpZP9-5fH-R-FhvKTfYpPPVFNvjFF3JXmrcq','admin',now(),'七牛云key1');
insert into `tsys_config` (`type`, `ckey`, `cvalue`, `updater`, `update_datetime`, `remark`) values('qiniu','qiniu_bucket','sdhh','admin',now(),'存储空间');
insert into `tsys_config` (`type`, `ckey`, `cvalue`, `updater`, `update_datetime`, `remark`) values('sys_txt','telephone','0571-88888888','admin',now(),'服务热线');
insert into `tsys_config` (`type`, `ckey`, `cvalue`, `updater`, `update_datetime`, `remark`) values('sys_txt','about_us','<p><img src=\"http://otoieuivb.bkt.clouddn.com/IMG_2130_1524907296779.JPG\" style=\"max-width:100%\"></p><p>关于我们</p><p><br></p>','admin',now(),'关于我们');
insert into `tsys_config` (`type`, `ckey`, `cvalue`, `updater`, `update_datetime`, `remark`) values('sys_txt','service_time','<p><span style=\"font-size: xx-large;\">9:00-17:00</span></p>','admin',now(),'服务时间');
insert into `tsys_config` (`type`, `ckey`, `cvalue`, `updater`, `update_datetime`, `remark`) values('cost','pg_amount','200','admin',now(),'评估费');
insert into `tsys_config` (`type`, `ckey`, `cvalue`, `updater`, `update_datetime`, `remark`) values('cost','gpsdj_fee','400','admin',now(),'GPS打件费用');

/*
-- Query: select `code`,`name`,`type`,`url`,`order_no`,`updater`,now() `update_datetime`,`remark`,`parent_code`,`system_code` from tsys_menu
-- Date: 2018-11-10 15:52
*/
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('CD201700000000000000','根目录','1','#',1,'admin',now(),'','','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('CD201809281556563159269','数据字典管理','1','/system/dataDict.htm',2,'admin',now(),'','COINSM201700001000000002','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('CD201809281557164456982','新增','2','/add',1,'admin',now(),'','CD201809281556563159269','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('CD201809281557350347620','修改','2','/edit',2,'admin',now(),'','CD201809281556563159269','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM201700001000000001','系统管理','1','#',1,'admin',now(),'','CD201700000000000000','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM201700001000000002','运维管理','1','#',2,'admin',now(),NULL,'COINSM201700001000000001','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM201700001000000003','菜单管理','1','/system/menu.htm',1,'admin',now(),NULL,'COINSM201700001000000002','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM201700001000000004','新增','2','/add',1,'admin',now(),'','COINSM201700001000000003','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017032911200961325','修改','2','/edit',2,'admin',now(),'','COINSM201700001000000003','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM201708241024194086655','删除','2','/delete',3,'admin',now(),'','COINSM201700001000000003','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017101716241339082','运营管理','1','#',1,'admin',now(),'','COINSM201700001000000001','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017101716253866426','角色管理','1','/system/role.htm',1,'admin',now(),'','COINSM2017101716241339082','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017101716261754674','会员查询','1','/system/user.htm',2,'admin',now(),'','COINSM2017101716241339082','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017101716450533995','分配菜单','2','/change',4,'admin',now(),'','COINSM2017101716253866426','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017101717551955993','新增','2','/add',1,'admin',now(),'','COINSM2017101716253866426','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017101717560118734','修改','2','/edit',2,'admin',now(),'','COINSM2017101716253866426','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017101717563661357','删除','2','/delete',3,'admin',now(),'','COINSM2017101716253866426','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017101719082391126','新增','2','/add',1,'admin',now(),'','COINSM2017101716261754674','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017101719094151894','重置密码','2','/reset',2,'admin',now(),'','COINSM2017101716261754674','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017101719100760088','注销','2','/rock',4,'admin',now(),'','COINSM2017101716261754674','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017101719110981215','设置角色','2','/assign',5,'admin',now(),'','COINSM2017101716261754674','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('COINSM2017120610552303416','激活','2','/active',3,'admin',now(),'','COINSM2017101716261754674','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM20181109215806711279','系统参数管理','1','/system/sysPara.htm',3,'admin',now(),'','COINSM201700001000000002','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201811092203319902076','修改','2','/edit',1,'admin',now(),'','SM20181109215806711279','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201811092204223325616','业务管理','1','#',2,'admin',now(),'','CD201700000000000000','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201811092207551275490','业务录入','1','#',1,'admin',now(),'','SM201811092204223325616','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201811092208430952590','开录','1','/biz/start.htm',1,'admin',now(),'','SM201811092207551275490','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM20181109221214623389','出纳','1','/biz/cashier.htm',2,'admin',now(),'','SM201811092207551275490','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201811092212516555365','会计','1','/biz/accounting.htm',3,'admin',now(),'','SM201811092207551275490','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201811092213344119511','贷后','1','/biz/afterloan.htm',4,'admin',now(),'','SM201811092207551275490','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201811092214036961203','新增','2','/add',1,'admin',now(),'','SM201811092208430952590','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201811092214161553223','修改','2','/edit',2,'admin',now(),'','SM201811092208430952590','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201811092214345171614','详情','2','/detail',3,'admin',now(),'','SM201811092208430952590','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201811092233417418293','录入','2','/edit',1,'admin',now(),'','SM20181109221214623389','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201811092233556436125','详情','2','/detail',2,'admin',now(),'','SM20181109221214623389','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201811092306097062330','录入','2','/edit',1,'admin',now(),'','SM201811092212516555365','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201811092306240117277','详情','2','/detail',2,'admin',now(),'','SM201811092212516555365','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201811092355238932998','录入','2','/edit',1,'admin',now(),'','SM201811092213344119511','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201811092355371623446','详情','2','/detail',2,'admin',now(),'','SM201811092213344119511','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM20181110000005880849','业务查询','1','#',2,'admin',now(),'','SM201811092204223325616','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201811100001304199040','未归档查询','1','/biz/handling.htm',1,'admin',now(),'','SM20181110000005880849','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201811100002075702958','归档查询','1','biz/finished.htm',2,'admin',now(),'','SM20181110000005880849','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201811100002415119054','参数设置','1','#',3,'admin',now(),'','SM201811092204223325616','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201811100002554088779','参数设置','1','/biz/params.htm',1,'admin',now(),'','SM201811100002415119054','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201811100003421437947','归档','2','/edit',1,'admin',now(),'','SM201811100001304199040','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201811100003544225785','详情','2','/detail',2,'admin',now(),'','SM201811100001304199040','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM20181110000415627619','导出','2','/export',3,'admin',now(),'','SM201811100001304199040','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201811100004403211845','详情','2','/detail',1,'admin',now(),'','SM201811100002075702958','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM20181110000502740452','导出','2','/export',2,'admin',now(),'','SM201811100002075702958','CD-CHH000020');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201811100005209782921','修改','2','/edit',1,'admin',now(),'','SM201811100002554088779','CD-CHH000020');

/*
-- Query: select `role_code`,`menu_code`,'admin' `updater`,now() `update_datetime`,`remark`,`system_code` from tsys_menu_role
-- Date: 2018-11-10 15:54
*/
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','CD201700000000000000','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','CD201809281557164456982','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','COINSM201700001000000001','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','COINSM201700001000000003','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','COINSM201700001000000004','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','COINSM2017101716241339082','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','COINSM2017101716253866426','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','COINSM2017101717551955993','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','COINSM2017101719082391126','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','SM201811092203319902076','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','SM201811092207551275490','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','SM201811092208430952590','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','SM201811092214036961203','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','SM201811092233417418293','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','SM201811092306097062330','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','SM201811092355238932998','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','CD201809281556563159269','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','CD201809281557350347620','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','COINSM201700001000000002','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','COINSM2017032911200961325','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','COINSM2017101716261754674','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','COINSM2017101717560118734','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','COINSM2017101719094151894','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','SM201811092204223325616','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','SM20181109221214623389','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','SM201811092214161553223','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','SM201811092233556436125','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','SM201811092306240117277','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','SM201811092355371623446','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','COINSM201708241024194086655','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','COINSM2017101717563661357','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','COINSM2017120610552303416','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','SM20181109215806711279','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','SM201811092212516555365','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','SM201811092214345171614','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','COINSM2017101716450533995','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','COINSM2017101719100760088','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','SM201811092213344119511','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','COINSM2017101719110981215','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','SM20181110000005880849','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','SM201811100001304199040','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','SM201811100003421437947','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','SM201811100003544225785','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','SM20181110000415627619','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','SM201811100002075702958','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','SM201811100004403211845','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','SM20181110000502740452','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','SM201811100002415119054','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','SM201811100002554088779','admin',now(),NULL,'CD-CHH000020');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('RO201800000000000001','SM201811100005209782921','admin',now(),NULL,'CD-CHH000020');

insert into `tsys_role` (`code`, `name`, `level`, `updater`, `update_datetime`, `remark`, `system_code`) values('RO201800000000000001','超级管理员','1','admin',now(),NULL,'CD-CHH000020');

insert into `tsys_user` (`user_id`, `role_code`, `real_name`, `photo`, `mobile`, `login_name`, `login_pwd`, `login_pwd_strength`, `create_datetime`, `status`, `updater`, `update_datetime`, `remark`, `system_code`) values('USYS201800000000002','RO201800000000000001','',NULL,NULL,'admin','21218cca77804d2ba1922c33e0151105','1',NULL,'0','admin','2018-04-03 19:39:47',NULL,'');



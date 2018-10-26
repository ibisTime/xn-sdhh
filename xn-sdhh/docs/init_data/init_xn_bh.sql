insert into `tsys_config` (`type`, `ckey`, `cvalue`, `updater`, `update_datetime`, `remark`) values('qiniu','qiniu_access_key','Dc0pMP8ImFm78-uk4iGsOPpB2-vHc64D07OsOQVi','admin',now(),'七牛云key1');
insert into `tsys_config` (`type`, `ckey`, `cvalue`, `updater`, `update_datetime`, `remark`) values('qiniu','qiniu_secret_key','3NP-tpZP9-5fH-R-FhvKTfYpPPVFNvjFF3JXmrcq','admin',now(),'七牛云key1');
insert into `tsys_config` (`type`, `ckey`, `cvalue`, `updater`, `update_datetime`, `remark`) values('qiniu','qiniu_domain','ounm8iw2d.bkt.clouddn.com','admin',now(),'访问域名');
insert into `tsys_config` (`type`, `ckey`, `cvalue`, `updater`, `update_datetime`, `remark`) values('sys_txt','telephone','0571-88888888','admin',now(),'服务热线');
insert into `tsys_config` (`type`, `ckey`, `cvalue`, `updater`, `update_datetime`, `remark`) values('sys_txt','about_us','<p><img src=\"http://otoieuivb.bkt.clouddn.com/IMG_2130_1524907296779.JPG\" style=\"max-width:100%\"></p><p>关于我们</p><p><br></p>','admin',now(),'关于我们');
insert into `tsys_config` (`type`, `ckey`, `cvalue`, `updater`, `update_datetime`, `remark`) values('sys_txt','service_time','<p><span style=\"font-size: xx-large;\">9:00-17:00</span></p>','admin',now(),'服务时间');
insert into `tsys_config` (`type`, `ckey`, `cvalue`, `updater`, `update_datetime`, `remark`) values('cost','pg_amount','200000','admin','2018-06-04 16:09:32','评估费');

insert into `tsys_menu` (`code`, `parent_code`, `name`, `type`, `url`, `order_no`, `updater`, `update_datetime`, `remark`, `system_code`) values('BHXTSM201700000000000000','','根目录','1','#','1','admin',now(),'','CD-CBH000020');
insert into `tsys_menu` (`code`, `parent_code`, `name`, `type`, `url`, `order_no`, `updater`, `update_datetime`, `remark`, `system_code`) values('BHXTSM201700001000000001','BHXTSM201700000000000000','系统管理','1','#','1','admin',now(),'','CD-CBH000020');
insert into `tsys_menu` (`code`, `parent_code`, `name`, `type`, `url`, `order_no`, `updater`, `update_datetime`, `remark`, `system_code`) values('BHXTSM201700001000000002','BHXTSM201700001000000001','运维管理','1','#','2','admin',now(),NULL,'CD-CBH000020');
insert into `tsys_menu` (`code`, `parent_code`, `name`, `type`, `url`, `order_no`, `updater`, `update_datetime`, `remark`, `system_code`) values('BHXTSM201700001000000003','BHXTSM201700001000000002','菜单管理','1','/system/menu.htm','1','admin',now(),NULL,'CD-CBH000020');
insert into `tsys_menu` (`code`, `parent_code`, `name`, `type`, `url`, `order_no`, `updater`, `update_datetime`, `remark`, `system_code`) values('BHXTSM201700001000000004','BHXTSM201700001000000003','新增','2','/add','1','admin',now(),'','CD-CBH000020');

insert into `tsys_menu_role` (`role_code`, `menu_code`, `updater`, `update_datetime`, `remark`, `system_code`) values('RO201800000000000001','BHXTSM201700000000000000','admin',now(),NULL,'CD-CBH000020');
insert into `tsys_menu_role` (`role_code`, `menu_code`, `updater`, `update_datetime`, `remark`, `system_code`) values('RO201800000000000001','BHXTSM201700001000000001','admin',now(),NULL,'CD-CBH000020');
insert into `tsys_menu_role` (`role_code`, `menu_code`, `updater`, `update_datetime`, `remark`, `system_code`) values('RO201800000000000001','BHXTSM201700001000000002','admin',now(),NULL,'CD-CBH000020');
insert into `tsys_menu_role` (`role_code`, `menu_code`, `updater`, `update_datetime`, `remark`, `system_code`) values('RO201800000000000001','BHXTSM201700001000000003','admin',now(),NULL,'CD-CBH000020');
insert into `tsys_menu_role` (`role_code`, `menu_code`, `updater`, `update_datetime`, `remark`, `system_code`) values('RO201800000000000001','BHXTSM201700001000000004','admin',now(),NULL,'CD-CBH000020');

insert into `tsys_role` (`code`, `name`, `level`, `updater`, `update_datetime`, `remark`, `system_code`) values('RO201800000000000001','超级管理员','1','admin',now(),NULL,'CD-CBH000020');

insert into `tsys_user` (`user_id`, `role_code`, `real_name`, `photo`, `mobile`, `login_name`, `login_pwd`, `login_pwd_strength`, `create_datetime`, `status`, `updater`, `update_datetime`, `remark`, `system_code`) values('USYS201800000000002','RO201800000000000001','',NULL,NULL,'admin','21218cca77804d2ba1922c33e0151105','1',NULL,'0','admin','2018-04-03 19:39:47',NULL,'');



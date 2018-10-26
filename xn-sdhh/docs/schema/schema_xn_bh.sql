DROP TABLE IF EXISTS `tsd_business`;
CREATE TABLE `tsd_business` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `qyfzrmc` varchar(255) DEFAULT NULL COMMENT '区域负责人名称',
  `qczl` varchar(4) DEFAULT NULL COMMENT '汽车种类',
  `khmc` varchar(255) DEFAULT NULL COMMENT '客户名称',
  `dkje` bigint(20) DEFAULT NULL COMMENT '贷款金额',
  `zhll` decimal(10,5) DEFAULT NULL COMMENT '综合利率',
  `dkrq` datetime DEFAULT NULL COMMENT '打款日期',
  `yhfkrq` datetime DEFAULT NULL COMMENT '银行放款日期',
  `gshkrq` datetime DEFAULT NULL COMMENT '公司回款日期',
  `fbhhsrq` datetime DEFAULT NULL COMMENT '发保合回收日期',
  `fbhrc` int(11) DEFAULT NULL COMMENT '发保合日差',
  `wzdzrq` datetime DEFAULT NULL COMMENT '温州垫资日期',
  `djrq` datetime DEFAULT NULL COMMENT '打件日期',
  `djrc` int(11) DEFAULT NULL COMMENT '打件日差',
  `terq` datetime DEFAULT NULL COMMENT '调额日期',
  `fkrc` int(11) DEFAULT NULL COMMENT '放款日差',
  `dyrq` datetime DEFAULT NULL COMMENT '抵押日期',
  `dyrc` int(11) DEFAULT NULL COMMENT '抵押日差',
  `fdje` bigint(20) DEFAULT NULL COMMENT '返点金额',
  `pgf` bigint(20) DEFAULT NULL COMMENT '评估费',
  `dzlx` bigint(20) DEFAULT NULL COMMENT '垫资利息',
  `ysfdje` bigint(20) DEFAULT NULL COMMENT '应收返点金额',
  `qdf` bigint(20) DEFAULT NULL COMMENT '渠道费',
  `jx` bigint(20) DEFAULT NULL COMMENT '绩效',
  `qtlr` bigint(20) DEFAULT NULL COMMENT '其他利润',
  `bzjdke` bigint(20) DEFAULT NULL COMMENT '保证金贷款额',
  `mlr` bigint(20) DEFAULT NULL COMMENT '毛利润',
  `status` char(1) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `tsys_config` */
DROP TABLE IF EXISTS `tsys_config`;
CREATE TABLE `tsys_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(32) DEFAULT NULL COMMENT '类型',
  `ckey` varchar(255) DEFAULT NULL COMMENT 'key',
  `cvalue` text COMMENT 'value',
  `updater` varchar(32) DEFAULT NULL COMMENT '最近修改人',
  `update_datetime` datetime DEFAULT NULL COMMENT '最近修改人',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Table structure for table `tsys_dict` */
DROP TABLE IF EXISTS `tsys_dict`;
CREATE TABLE `tsys_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(32) DEFAULT NULL COMMENT '类型（第一层/第二层）',
  `parent_key` varchar(32) DEFAULT NULL COMMENT '父亲key',
  `dkey` varchar(32) DEFAULT NULL COMMENT 'key',
  `dvalue` varchar(255) DEFAULT NULL COMMENT 'value',
  `updater` varchar(32) DEFAULT NULL COMMENT '最近修改人',
  `update_datetime` datetime DEFAULT NULL COMMENT '最近修改人',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `tsys_menu` */
DROP TABLE IF EXISTS `tsys_menu`;
CREATE TABLE `tsys_menu` (
  `code` varchar(32) NOT NULL DEFAULT '' COMMENT '编号',
  `parent_code` varchar(32) DEFAULT NULL COMMENT '父亲key',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `type` varchar(2) DEFAULT NULL COMMENT '类型',
  `url` varchar(255) DEFAULT NULL COMMENT 'url',
  `order_no` int(11) DEFAULT NULL COMMENT '次序',
  `updater` varchar(32) DEFAULT NULL COMMENT '最近修改人',
  `update_datetime` datetime DEFAULT NULL COMMENT '最近修改人',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `tsys_menu_role` */
DROP TABLE IF EXISTS `tsys_menu_role`;
CREATE TABLE `tsys_menu_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_code` varchar(32) DEFAULT NULL COMMENT '角色编号',
  `menu_code` varchar(32) DEFAULT NULL COMMENT '菜单编号',
  `updater` varchar(32) DEFAULT NULL COMMENT '最近修改人',
  `update_datetime` datetime DEFAULT NULL COMMENT '最近修改人',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

/*Table structure for table `tsys_role` */
DROP TABLE IF EXISTS `tsys_role`;
CREATE TABLE `tsys_role` (
  `code` varchar(32) NOT NULL DEFAULT '' COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `updater` varchar(32) DEFAULT NULL COMMENT '最近修改人',
  `update_datetime` datetime DEFAULT NULL COMMENT '最近修改人',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `tsys_user` */
DROP TABLE IF EXISTS `tsys_user`;
CREATE TABLE `tsys_user` (
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `role_code` varchar(32) DEFAULT NULL COMMENT '角色编号',
  `real_name` varchar(64) DEFAULT NULL COMMENT '真实姓名',
  `photo` varchar(255) DEFAULT NULL COMMENT '头像',
  `mobile` varchar(16) DEFAULT NULL COMMENT '手机号',
  `login_name` varchar(64) DEFAULT NULL COMMENT '登录名',
  `login_pwd` varbinary(32) DEFAULT NULL COMMENT '登录密码',
  `login_pwd_strength` char(1) DEFAULT NULL COMMENT '登录密码强度',
  `create_datetime` datetime DEFAULT NULL COMMENT '注册时间',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` text COMMENT '备注',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编号',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
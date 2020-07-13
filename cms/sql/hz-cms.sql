-- 2020-06-28 16:16 创建用户表
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(20) NOT NULL COMMENT '登录名',
  `password` varchar(20) NOT NULL COMMENT '登录密码',
  `real_name` varchar(20) NOT NULL COMMENT '真实姓名',
  `role` int(1) NOT NULL COMMENT '用户角色 1：管理员 2：业务员',
  `state` int(1) NOT NULL COMMENT '用户状态 1：在职  2：离职',
  `img` varchar(100) DEFAULT NULL COMMENT '用户头像URL',
  `create_time` varchar(19) NOT NULL COMMENT '创建时间',
  `modify_time` varchar(19) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
);
-- 2020-06-30 16:16 创建客户表
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cust_name` varchar(20) NOT NULL COMMENT '客户名称',
  `company` varchar(50) NOT NULL COMMENT '客户公司',
  `position` varchar(20) NOT NULL COMMENT '客户职位',
  `salary` int(10) NOT NULL COMMENT '客户月薪',
  `phone` varchar(11) NOT NULL COMMENT '客户电话',
  `sex` int(1) NOT NULL COMMENT '客户性别  1 男  2 女',
  `state` int(1) NOT NULL COMMENT '客户状态  1 有效   2 无效',
  `user_id` int(11) NOT NULL COMMENT '业务员ID',
  `create_time` varchar(19) NOT NULL COMMENT '创建时间  2020-06-28 14:55:00',
  `modify_time` varchar(19) NOT NULL COMMENT '修改时间  2020-06-28 14:55:00',
  PRIMARY KEY (`id`)
);
-- 2020-07-01 16:16 创建拜访记录表
CREATE TABLE `visit_log` (
  `visit_time` varchar(10) NOT NULL COMMENT '拜访时间',
  `user_id` int(11) NOT NULL COMMENT '业务员ID',
  `cust_id` int(11) NOT NULL COMMENT '客户ID',
  `visit_desc` varchar(500) DEFAULT NULL COMMENT '拜访内容介绍',
  `create_time` varchar(19) NOT NULL COMMENT '创建时间'
);
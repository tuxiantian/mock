
Create Table

CREATE TABLE `t_intf_mock_data` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '无意义主键',
  `intf_code` varchar(50) DEFAULT NULL COMMENT '接口编码',
  `tran_id` varchar(20) DEFAULT NULL COMMENT '业务流水号,让一个接口可以配置多个模拟报文',
  `resp_data` text COMMENT '接口响应报文',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4

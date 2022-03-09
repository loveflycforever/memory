CREATE TABLE `t_flow` (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '唯一编号',

    `serial_no` varchar(255) NOT NULL DEFAULT '' COMMENT '序列号',
    `creator_id` varchar(255) NOT NULL DEFAULT '' COMMENT '创建人',
    `creator_name` varchar(255) NOT NULL DEFAULT '' COMMENT '创建人名称',
    `format` varchar(255) NOT NULL DEFAULT '' COMMENT '类型',
    `status` varchar(255) NOT NULL DEFAULT '' COMMENT '状态',

    `remark` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
    `delete_flag` tinyint(2) NOT NULL DEFAULT '0' COMMENT '作废标志 0 未作废 1作废',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '操作人',
    `operator_name` varchar(64) NOT NULL DEFAULT '' COMMENT '操作人名称',
    `operate_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
    `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `operate_sort` (`operate_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='流程表';

CREATE TABLE `t_thing` (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '唯一编号',

    `serial_no` varchar(255) NOT NULL DEFAULT '' COMMENT '序列号',
    `name` varchar(255) NOT NULL DEFAULT '' COMMENT '名称',
    `summary` varchar(255) NOT NULL DEFAULT '' COMMENT '概要',
    `production_date` varchar(255) NOT NULL DEFAULT '' COMMENT '生产日期',
    `expiration_date` varchar(255) NOT NULL DEFAULT '' COMMENT '有效日期',
    `creator_id` varchar(255) NOT NULL DEFAULT '' COMMENT '创建人',
    `creator_name` varchar(255) NOT NULL DEFAULT '' COMMENT '创建人名称',
    `format` varchar(255) NOT NULL DEFAULT '' COMMENT '类型',
    `status` varchar(255) NOT NULL DEFAULT '' COMMENT '状态',

    `remark` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
    `delete_flag` tinyint(2) NOT NULL DEFAULT '0' COMMENT '作废标志 0 未作废 1作废',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '操作人',
    `operator_name` varchar(64) NOT NULL DEFAULT '' COMMENT '操作人名称',
    `operate_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
    `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `operate_sort` (`operate_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='物品表';


CREATE TABLE `t_form` (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '唯一编号',

    `serial_no` varchar(255) NOT NULL DEFAULT '' COMMENT '序列号',
    `flow_no` varchar(255) NOT NULL DEFAULT '' COMMENT '流程号',

    `remark` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
    `delete_flag` tinyint(2) NOT NULL DEFAULT '0' COMMENT '作废标志 0 未作废 1作废',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '操作人',
    `operator_name` varchar(64) NOT NULL DEFAULT '' COMMENT '操作人名称',
    `operate_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
    `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `operate_sort` (`operate_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='表单表';
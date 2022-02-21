CREATE TABLE `m_flow` (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '唯一编号',

    `serial_no` varchar(255) NOT NULL DEFAULT '' COMMENT '序列号',
    `creator_id` varchar(255) NOT NULL DEFAULT '' COMMENT '创建人',
    `creator_name` varchar(255) NOT NULL DEFAULT '' COMMENT '创建人名称',
    `genre` int(11) NOT NULL DEFAULT '0' COMMENT '类型',
    `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态',

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
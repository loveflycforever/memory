package com.nafapap.memory.source;

import lombok.Data;

import java.util.Date;


/**
CREATE TABLE `table_name` (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '唯一编号',
    ......
    `remark` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
    `delete_flag` tinyint(2) NOT NULL DEFAULT '0' COMMENT '作废标志 0 未作废 1作废',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '操作人',
    `operator_name` varchar(64) NOT NULL DEFAULT '' COMMENT '操作人名称',
    `operate_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `operate_sort` (`operate_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='表名';

 * <p>Project: memory </p>
 * <p>Name: Basis </p>
 * <p>Description: 实体基础 </p>
 * <p>Date: 2022/2/22 11:00 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@Data
public class BasisEntity {

    /**
     * 唯一编号
     */
    private Long id;

    /**
     * 备注
     */
    private String remark;

    /**
     * 作废标志
     */
    private Integer deleteFlag;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后操作记录
     */
    private Long operatorId;
    private String operatorName;
    private Date operateTime;

    private Integer version;
}

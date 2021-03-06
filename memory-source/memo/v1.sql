-- 1、重置已有数据主键
-- SET @rownum = 0;
-- UPDATE table_name SET id = @rownum := @rownum +1;

-- 2、修改自增主键，beginIndex为查询出来的最大id+1
-- SELECT max(id)+1 from table_name;
-- alter table table_name auto_increment= beginIndex;

CREATE TABLE `t_subject`
(
    `id`            bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '唯一编号',
    `serial_no`     varchar(100)        NOT NULL DEFAULT '' COMMENT '序列号',

    `name`          varchar(100)        NOT NULL DEFAULT '' COMMENT '名称',
    `summary`       varchar(255)        NOT NULL DEFAULT '' COMMENT '简介',

    `creator_id`    bigint(20)          NOT NULL DEFAULT '0' COMMENT '创建人',
    `creator_name`  varchar(64)         NOT NULL DEFAULT '' COMMENT '创建人名称',
    `create_time`   timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `status`        varchar(50)         NOT NULL DEFAULT '' COMMENT '状态',

    `remark`        varchar(255)        NOT NULL DEFAULT '' COMMENT '备注',
    `delete_flag`   tinyint(2)          NOT NULL DEFAULT '0' COMMENT '作废标志 0 未作废 1作废',
    `operator_id`   bigint(20)          NOT NULL DEFAULT '0' COMMENT '操作人',
    `operator_name` varchar(64)         NOT NULL DEFAULT '' COMMENT '操作人名称',
    `operate_time`  timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
    `version`       int(11)             NOT NULL DEFAULT '0' COMMENT '版本',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `operate_sort` (`operate_time`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='类型表';

CREATE TABLE `t_thing`
(
    `id`            bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '唯一编号',
    `serial_no`     varchar(100)        NOT NULL DEFAULT '' COMMENT '序列号',

    `name`          varchar(100)        NOT NULL DEFAULT '' COMMENT '名称',
    `summary`       varchar(255)        NOT NULL DEFAULT '' COMMENT '简介',
    `symbol`        varchar(255)        NOT NULL DEFAULT '' COMMENT '标识',

    `creator_id`    bigint(20)          NOT NULL DEFAULT '0' COMMENT '创建人',
    `creator_name`  varchar(64)         NOT NULL DEFAULT '' COMMENT '创建人名称',
    `create_time`   timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `status`        varchar(50)         NOT NULL DEFAULT '' COMMENT '状态',

    `remark`        varchar(255)        NOT NULL DEFAULT '' COMMENT '备注',
    `delete_flag`   tinyint(2)          NOT NULL DEFAULT '0' COMMENT '作废标志 0 未作废 1作废',
    `operator_id`   bigint(20)          NOT NULL DEFAULT '0' COMMENT '操作人',
    `operator_name` varchar(64)         NOT NULL DEFAULT '' COMMENT '操作人名称',
    `operate_time`  timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
    `version`       int(11)             NOT NULL DEFAULT '0' COMMENT '版本',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `operate_sort` (`operate_time`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='事物表';

CREATE TABLE `t_thing_check`
(
    `id`            bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '唯一编号',
    `serial_no`     varchar(100)        NOT NULL DEFAULT '' COMMENT '序列号',

    `x_thing`       varchar(50)         NOT NULL DEFAULT '' COMMENT '事物',
    `quantity`      decimal(14, 4)      NOT NULL DEFAULT 0.0000 COMMENT '数量',
    `specific`      varchar(10)         NOT NULL DEFAULT '' COMMENT '单位',

    `creator_id`    bigint(20)          NOT NULL DEFAULT '0' COMMENT '创建人',
    `creator_name`  varchar(64)         NOT NULL DEFAULT '' COMMENT '创建人名称',
    `create_time`   timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `status`        varchar(50)         NOT NULL DEFAULT '' COMMENT '状态',

    `remark`        varchar(255)        NOT NULL DEFAULT '' COMMENT '备注',
    `delete_flag`   tinyint(2)          NOT NULL DEFAULT '0' COMMENT '作废标志 0 未作废 1作废',
    `operator_id`   bigint(20)          NOT NULL DEFAULT '0' COMMENT '操作人',
    `operator_name` varchar(64)         NOT NULL DEFAULT '' COMMENT '操作人名称',
    `operate_time`  timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
    `version`       int(11)             NOT NULL DEFAULT '0' COMMENT '版本',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `operate_sort` (`operate_time`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='事物盘点表';

CREATE TABLE `t_goods`
(
    `id`              bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '唯一编号',
    `serial_no`       varchar(100)        NOT NULL DEFAULT '' COMMENT '序列号',

    `x_thing`         varchar(50)         NOT NULL DEFAULT '' COMMENT '事物',
    `brand`           varchar(50)         NOT NULL DEFAULT '' COMMENT '品牌',
    `name`            varchar(100)        NOT NULL DEFAULT '' COMMENT '名称',
    `summary`         varchar(255)        NOT NULL DEFAULT '' COMMENT '简介',
    `production_date` varchar(50)         NOT NULL DEFAULT '' COMMENT '生产日期',
    `validation_term` int(11)             NOT NULL DEFAULT '0' COMMENT '有效期时间',
    `validation_unit` varchar(10)         NOT NULL DEFAULT '' COMMENT '有效期单位',
    `expiration_date` varchar(50)         NOT NULL DEFAULT '' COMMENT '失效日期',
    `barcode`         varchar(50)         NOT NULL DEFAULT '' COMMENT '条形码',
    `unit_price`      decimal(14, 4)      NOT NULL DEFAULT 0.0000 COMMENT '单价',
    `unit_spec`       varchar(255)        NOT NULL DEFAULT '' COMMENT '规格',

    `creator_id`      bigint(20)          NOT NULL DEFAULT '0' COMMENT '创建人',
    `creator_name`    varchar(64)         NOT NULL DEFAULT '' COMMENT '创建人名称',
    `create_time`     timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `status`          varchar(50)         NOT NULL DEFAULT '' COMMENT '状态',

    `remark`          varchar(255)        NOT NULL DEFAULT '' COMMENT '备注',
    `delete_flag`     tinyint(2)          NOT NULL DEFAULT '0' COMMENT '作废标志 0 未作废 1作废',
    `operator_id`     bigint(20)          NOT NULL DEFAULT '0' COMMENT '操作人',
    `operator_name`   varchar(64)         NOT NULL DEFAULT '' COMMENT '操作人名称',
    `operate_time`    timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
    `version`         int(11)             NOT NULL DEFAULT '0' COMMENT '版本',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `operate_sort` (`operate_time`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='商品表';

CREATE TABLE `t_procure`
(
    `id`                bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '唯一编号',
    `serial_no`         varchar(100)        NOT NULL DEFAULT '' COMMENT '序列号',

    `x_goods`           varchar(50)         NOT NULL DEFAULT '' COMMENT '商品',
    `summary`           varchar(255)        NOT NULL DEFAULT '' COMMENT '简介',
    `purchase_quantity` decimal(14, 4)      NOT NULL DEFAULT 0.0000 COMMENT '购买数量',
    `purchase_specific` varchar(10)         NOT NULL DEFAULT '' COMMENT '购买单位',
    `purchase_location` varchar(255)        NOT NULL DEFAULT '' COMMENT '购买地点',
    `purchase_datetime` varchar(50)         NOT NULL DEFAULT '' COMMENT '购买日期',
    `price`             decimal(14, 4)      NOT NULL DEFAULT 0.0000 COMMENT '价格',
    `currency`          varchar(20)         NOT NULL DEFAULT '' COMMENT '货币',
    `china_yuan`        decimal(14, 4)      NOT NULL DEFAULT 0.0000 COMMENT '人民币',

    `hold`              decimal(14, 4)      NOT NULL DEFAULT 0.0000 COMMENT '实际可用总量',
    `unit`              varchar(10)         NOT NULL DEFAULT '' COMMENT '单位',
    `plan_day`          int(11)             NOT NULL DEFAULT '0' COMMENT '计划使用日',
    `closed_date`       varchar(50)         NOT NULL DEFAULT '' COMMENT '结束日期',
    `actual_day`        int(11)             NOT NULL DEFAULT '0' COMMENT '实际天数',

    `creator_id`        bigint(20)          NOT NULL DEFAULT '0' COMMENT '创建人',
    `creator_name`      varchar(64)         NOT NULL DEFAULT '' COMMENT '创建人名称',
    `create_time`       timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `status`            varchar(50)         NOT NULL DEFAULT '' COMMENT '状态',

    `remark`            varchar(255)        NOT NULL DEFAULT '' COMMENT '备注',
    `delete_flag`       tinyint(2)          NOT NULL DEFAULT '0' COMMENT '作废标志 0 未作废 1作废',
    `operator_id`       bigint(20)          NOT NULL DEFAULT '0' COMMENT '操作人',
    `operator_name`     varchar(64)         NOT NULL DEFAULT '' COMMENT '操作人名称',
    `operate_time`      timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
    `version`           int(11)             NOT NULL DEFAULT '0' COMMENT '版本',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `operate_sort` (`operate_time`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='采购表';

CREATE TABLE `t_ticket`
(
    `id`                bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '唯一编号',
    `serial_no`         varchar(100)        NOT NULL DEFAULT '' COMMENT '序列号',

    `name`              varchar(100)        NOT NULL DEFAULT '' COMMENT '名称',
    `summary`           varchar(255)        NOT NULL DEFAULT '' COMMENT '简介',
    `purchase_location` varchar(255)        NOT NULL DEFAULT '' COMMENT '购买地点',
    `purchase_datetime` varchar(50)         NOT NULL DEFAULT '' COMMENT '购买时间',
    `price`             decimal(14, 4)      NOT NULL DEFAULT 0.0000 COMMENT '价格',
    `expense`           decimal(14, 4)      NOT NULL DEFAULT 0.0000 COMMENT '实际支出',
    `currency`          varchar(20)         NOT NULL DEFAULT '' COMMENT '货币',
    `china_yuan`        decimal(14, 4)      NOT NULL DEFAULT 0.0000 COMMENT '人民币',
    `channel`           varchar(50)         NOT NULL DEFAULT '' COMMENT '渠道方式',
    `payment`           varchar(50)         NOT NULL DEFAULT '' COMMENT '支付方式',
    `forward`           varchar(50)         NOT NULL DEFAULT '' COMMENT '付款方式',

    `creator_id`        bigint(20)          NOT NULL DEFAULT '0' COMMENT '创建人',
    `creator_name`      varchar(64)         NOT NULL DEFAULT '' COMMENT '创建人名称',
    `create_time`       timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `status`            varchar(50)         NOT NULL DEFAULT '' COMMENT '状态',

    `remark`            varchar(255)        NOT NULL DEFAULT '' COMMENT '备注',
    `delete_flag`       tinyint(2)          NOT NULL DEFAULT '0' COMMENT '作废标志 0 未作废 1作废',
    `operator_id`       bigint(20)          NOT NULL DEFAULT '0' COMMENT '操作人',
    `operator_name`     varchar(64)         NOT NULL DEFAULT '' COMMENT '操作人名称',
    `operate_time`      timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
    `version`           int(11)             NOT NULL DEFAULT '0' COMMENT '版本',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `operate_sort` (`operate_time`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='票据表';


CREATE TABLE `t_factum`
(
    `id`            bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '唯一编号',
    `serial_no`     varchar(100)        NOT NULL DEFAULT '' COMMENT '序列号',

    `note`          varchar(255)        NOT NULL DEFAULT '' COMMENT '事由',
    `format`        varchar(255)        NOT NULL DEFAULT '' COMMENT '类型',
    `flow_no`       varchar(255)        NOT NULL DEFAULT '' COMMENT '流程号',

    `creator_id`    bigint(20)          NOT NULL DEFAULT '0' COMMENT '创建人',
    `creator_name`  varchar(64)         NOT NULL DEFAULT '' COMMENT '创建人名称',
    `create_time`   timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `status`        varchar(50)         NOT NULL DEFAULT '' COMMENT '状态',

    `remark`        varchar(255)        NOT NULL DEFAULT '' COMMENT '备注',
    `delete_flag`   tinyint(2)          NOT NULL DEFAULT '0' COMMENT '作废标志 0 未作废 1作废',
    `operator_id`   bigint(20)          NOT NULL DEFAULT '0' COMMENT '操作人',
    `operator_name` varchar(64)         NOT NULL DEFAULT '' COMMENT '操作人名称',
    `operate_time`  timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
    `version`       int(11)             NOT NULL DEFAULT '0' COMMENT '版本',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `operate_sort` (`operate_time`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='表单表';
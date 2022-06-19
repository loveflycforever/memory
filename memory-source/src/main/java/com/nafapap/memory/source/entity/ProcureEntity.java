package com.nafapap.memory.source.entity;

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis;
import cn.org.atool.fluent.mybatis.annotation.LogicDelete;
import cn.org.atool.fluent.mybatis.annotation.TableField;
import cn.org.atool.fluent.mybatis.annotation.TableId;
import cn.org.atool.fluent.mybatis.annotation.Version;
import cn.org.atool.fluent.mybatis.base.RichEntity;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * ProcureEntity: 数据映射实体定义
 *
 * @author Powered By Fluent Mybatis
 */
@SuppressWarnings({"rawtypes", "unchecked"})
@Data
@Accessors(
    chain = true
)
@EqualsAndHashCode(
    callSuper = false
)
@FluentMybatis(
    table = "t_procure",
    schema = "s_memory"
)
public class ProcureEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  /**
   * 唯一编号
   */
  @TableId("id")
  private Long id;

  /**
   * 创建时间
   */
  @TableField(
      value = "create_time",
      insert = "now()"
  )
  private Date createTime;

  /**
   * 操作时间
   */
  @TableField(
      value = "operate_time",
      insert = "now()",
      update = "now()"
  )
  private Date operateTime;

  /**
   * 作废标志 0 未作废 1作废
   */
  @TableField(
      value = "delete_flag",
      insert = "0"
  )
  @LogicDelete
  private Boolean deleteFlag;

  /**
   * 实际天数
   */
  @TableField("actual_day")
  private Integer actualDay;

  /**
   * 人民币
   */
  @TableField("china_yuan")
  private BigDecimal chinaYuan;

  /**
   * 结束日期
   */
  @TableField("closing_date")
  private String closingDate;

  /**
   * 创建人
   */
  @TableField("creator_id")
  private Long creatorId;

  /**
   * 创建人名称
   */
  @TableField("creator_name")
  private String creatorName;

  /**
   * 货币
   */
  @TableField("currency")
  private String currency;

  /**
   * 实际可用总量
   */
  @TableField("hold")
  private Integer hold;

  /**
   * 操作人
   */
  @TableField("operator_id")
  private Long operatorId;

  /**
   * 操作人名称
   */
  @TableField("operator_name")
  private String operatorName;

  /**
   * 计划使用日
   */
  @TableField("planned_day")
  private Integer plannedDay;

  /**
   * 购买价格
   */
  @TableField("price")
  private BigDecimal price;

  /**
   * 购买数量
   */
  @TableField("purchase_amount")
  private Integer purchaseAmount;

  /**
   * 购买日期
   */
  @TableField("purchase_datetime")
  private String purchaseDatetime;

  /**
   * 购买地点
   */
  @TableField("purchase_place")
  private String purchasePlace;

  /**
   * 备注
   */
  @TableField("remark")
  private String remark;

  /**
   * 序列号
   */
  @TableField("serial_no")
  private String serialNo;

  /**
   * 状态
   */
  @TableField("status")
  private String status;

  /**
   * 简介
   */
  @TableField("summary")
  private String summary;

  /**
   * 单位
   */
  @TableField("unit")
  private String unit;

  /**
   * 版本
   */
  @TableField(
      value = "version",
      insert = "0",
      update = "`version` + 1"
  )
  @Version
  private Long version;

  /**
   * 商品
   */
  @TableField("x_goods")
  private String xGoods;

  @Override
  public final Class entityClass() {
    return ProcureEntity.class;
  }
}

package com.nafapap.memory.source.entity;

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis;
import cn.org.atool.fluent.mybatis.annotation.LogicDelete;
import cn.org.atool.fluent.mybatis.annotation.TableField;
import cn.org.atool.fluent.mybatis.annotation.TableId;
import cn.org.atool.fluent.mybatis.annotation.Version;
import cn.org.atool.fluent.mybatis.base.RichEntity;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * FactumEntity: 数据映射实体定义
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
    table = "t_factum",
    schema = "s_memory"
)
public class FactumEntity extends RichEntity {
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
   * 流程号
   */
  @TableField("flow_no")
  private String flowNo;

  /**
   * 类型
   */
  @TableField("format")
  private String format;

  /**
   * 事由
   */
  @TableField("note")
  private String note;

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
   * 版本
   */
  @TableField(
      value = "version",
      insert = "0",
      update = "`version` + 1"
  )
  @Version
  private Long version;

  @Override
  public final Class entityClass() {
    return FactumEntity.class;
  }
}

package com.dragon.banana.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author llx
 * @since 2023-09-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("auth_user")
@ApiModel(value="authUser对象", description="")
public class AuthUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户唯一标识名")
    private String ldap;

    @ApiModelProperty(value = "用户名称")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "性别：1男 0女")
    private Integer sex;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "家庭地址")
    private String address;

    @ApiModelProperty(value = "创建人")
    private String creater;

    @ApiModelProperty(value = "最后修改人")
    private String updater;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime dbctime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime dbutime;

    @ApiModelProperty(value = "是否可用，0可用，1不可用")
    private String enabled;


}

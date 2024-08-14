package com.ibase.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 
 * @TableName sys_user
 */
@TableName(value ="sys_user")
@Data
public class SysUser implements Serializable, UserDetails {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    @JsonIgnore
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户密码
     */
    @JsonIgnore
    private String password;

    /**
     * 用户类型：数据字典sys_user_type
     */
    private Integer userType;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 邮箱地址
     */
    private String mail;

    /**
     * 性别: 数据字典sys_user_sex
     */
    private Integer sex;

    /**
     * 账号是否启用：数据字典sys_user_enabled
     */
    private boolean enabled;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 账号是否过期：数据字典sys_true_false
     */
    private boolean accountNonExpired;

    /**
     * 用户凭证是否过期：数据字典sys_true_false
     */
    private boolean credentialsNonExpired;

    /**
     * 账号是否锁定：数据字典sys_true_false
     */
    private boolean accountNonLocked;

    /**
     * 创建用户id
     */
    private Long createUserId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后修改用户id
     */
    private Long lastModUser;

    /**
     * 最后修改时间
     */
    private Date lastModTime;

    /**
     * 删除标记
     */
    @TableLogic
    private Integer delFlag;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
}
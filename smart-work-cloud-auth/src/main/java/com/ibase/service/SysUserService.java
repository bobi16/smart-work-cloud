package com.ibase.service;

import com.ibase.domain.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
* @author bobiko
* @description 针对表【sys_user】的数据库操作Service
* @createDate 2024-05-06 23:49:43
*/
public interface SysUserService extends IService<SysUser>, UserDetailsService {

}

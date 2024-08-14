package com.ibase.mapper;

import com.ibase.domain.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author bobiko
* @description 针对表【sys_user】的数据库操作Mapper
* @createDate 2024-05-06 23:49:43
* @Entity com.ibase.domain.SysUser
*/
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

}





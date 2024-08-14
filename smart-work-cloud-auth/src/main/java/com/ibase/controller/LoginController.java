package com.ibase.controller;

import com.ibase.domain.Result;
import com.ibase.domain.SysUser;
import com.ibase.service.SysUserService;
import jakarta.annotation.Resource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class LoginController
{
    @Resource
    private SysUserService sysUserService;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/list")
    public Result list(){
        List<SysUser> list = sysUserService.list();
        return Result.ok(list);
    }

    @PostMapping("/add")
    public Result add(@RequestBody SysUser user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        boolean save = sysUserService.save(user);
        if (save){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }
}

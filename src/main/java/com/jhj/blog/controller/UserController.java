package com.jhj.blog.controller;


import com.jhj.blog.common.lang.Result;
import com.jhj.blog.entity.User;
import com.jhj.blog.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 关注公众号：jhj
 * @since 2021-11-08
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequiresAuthentication
    @GetMapping("/index")
    public Object index(){
        User user=userService.getById(1L);
    return Result.succ(200,"操作成功",user);
    }

    //@Validated校验在类中写的@NotBlank等规则
    @PostMapping("/save")
    public Result save(@Validated @RequestBody User user){
        return Result.succ(user);
    }
}

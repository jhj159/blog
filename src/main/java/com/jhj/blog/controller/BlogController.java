package com.jhj.blog.controller;



import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jhj.blog.common.lang.Result;
import com.jhj.blog.entity.Blog;
import com.jhj.blog.service.BlogService;
import com.jhj.blog.util.ShiroUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 关注公众号：jhj
 * @since 2021-11-08
 */
@RestController
public class BlogController {
    @Autowired
    BlogService blogService;
    @GetMapping("/blogs")
    public Result list(@RequestParam(defaultValue = "1")Integer currentPage){
        Page page=new Page(currentPage,5);
        IPage pageData=blogService.page(page,new QueryWrapper<Blog>().orderByDesc("created"));
        return  Result.succ(pageData);
    }
    @GetMapping("/blog/{id}")
    public Result detail(@PathVariable(name="id")Long id){
        Blog blog=blogService.getById(id);
        Assert.notNull(blog,"该博客已被删除");
        return  Result.succ(blog);
    }
    //认证之后才能访问
    @RequiresAuthentication
    @PostMapping("/blog/edit")
    public Result edit(@Validated @RequestBody Blog blog){
        Blog temp=null;
        if (blog.getId()!=null){
            temp=blogService.getById(blog.getId());
            Assert.isTrue(temp.getUserId().longValue()== ShiroUtil.getProfile().getId().longValue(),"你没有权限编辑");
        }else{
            temp=new Blog();
            temp.setUserId(ShiroUtil.getProfile().getId());
            temp.setCreated(LocalDateTime.now());
            temp.setStatus(0);
        }
        BeanUtil.copyProperties(blog,temp,"id","userId","created","status");
        blogService.saveOrUpdate(temp);
        return  Result.succ(null);
    }
}

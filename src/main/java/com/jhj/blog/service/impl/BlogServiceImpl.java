package com.jhj.blog.service.impl;

import com.jhj.blog.entity.Blog;
import com.jhj.blog.mapper.BlogMapper;
import com.jhj.blog.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 关注公众号：jhj
 * @since 2021-11-08
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}

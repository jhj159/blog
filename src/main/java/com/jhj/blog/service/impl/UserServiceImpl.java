package com.jhj.blog.service.impl;

import com.jhj.blog.entity.User;
import com.jhj.blog.mapper.UserMapper;
import com.jhj.blog.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

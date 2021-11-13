package com.jhj.blog.shiro;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jhj
 * @data 2021/11/9 - 11:07
 */
@Data
public class AccountProfile implements Serializable {
    private Long id;

    private String username;

    private String avatar;

    private String email;

}

package com.jhj.blog.util;

import com.jhj.blog.shiro.AccountProfile;
import org.apache.shiro.SecurityUtils;

/**
 * @author jhj
 * @data 2021/11/9 - 16:57
 */
public class ShiroUtil {
    public static AccountProfile getProfile(){
        return (AccountProfile) SecurityUtils.getSubject().getPrincipal();
    }
}


package com.leotech.shiro.util;

import com.leotech.shiro.business.consts.SessionConst;
import com.leotech.shiro.business.entity.User;
import com.leotech.shiro.business.consts.SessionConst;
import com.leotech.shiro.business.entity.User;
import com.leotech.shiro.framework.holder.RequestHolder;

import java.util.UUID;

/**
 * Session工具类
 */
public class SessionUtil {

    /**
     * 获取session中的用户信息
     *
     * @return User
     */
    public static User getUser() {
        return (User) RequestHolder.getSession(SessionConst.USER_SESSION_KEY);
    }

    /**
     * 添加session
     *
     * @param user
     */
    public static void setUser(User user) {
        RequestHolder.setSession(SessionConst.USER_SESSION_KEY, user);
    }

    /**
     * 删除session信息
     */
    public static void removeUser() {
        RequestHolder.removeSession(SessionConst.USER_SESSION_KEY);
    }

    /**
     * 获取session中的Token信息
     *
     * @return String
     */
    public static String getToken(String key) {
        return (String) RequestHolder.getSession(key);
    }

    /**
     * 添加Token
     */
    public static void setToken(String key) {
        RequestHolder.setSession(key, UUID.randomUUID().toString());
    }

    /**
     * 删除Token信息
     */
    public static void removeToken(String key) {
        RequestHolder.removeSession(key);
    }

    /**
     * 删除所有的session信息
     */
    public static void removeAllSession() {
        String[] keys = RequestHolder.getSessionKeys();
        if (keys != null && keys.length > 0) {
            for (String key : keys) {
                RequestHolder.removeSession(key);
            }
        }
    }
}

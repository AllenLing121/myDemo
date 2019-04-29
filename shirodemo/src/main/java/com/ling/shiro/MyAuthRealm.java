package com.ling.shiro;

import com.ling.entity.Privilege;
import com.ling.entity.Role;
import com.ling.entity.User;
import com.ling.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by Lian on 04/29/2019.
 */
@Component
public class MyAuthRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    /**
     * 认证.登录
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户输入的token
        UsernamePasswordToken utoken=(UsernamePasswordToken) token;
        String username = utoken.getUsername();
        User user = this.userService.findUserByUserName(username);
        //放入shiro.调用CredentialsMatcher检验密码
        return new SimpleAuthenticationInfo(user,user.getPassword(),this.getClass().getName());
    }

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取session中的用户
        User user = (User) principalCollection.fromRealm(this.getClass().getName()).iterator().next();
        List<String> permissions = new ArrayList<>();
        Set<Role> roles = user.getRoles();
        if(CollectionUtils.isNotEmpty(roles)){
            for(Role role : roles){
                Set<Privilege> privileges = role.getPrivileges();
                for (Privilege privilege : privileges){
                    permissions.add(privilege.getName());
                }
            }
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //将权限放入shiro中.
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }
}

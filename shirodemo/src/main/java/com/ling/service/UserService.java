package com.ling.service;

import com.ling.dao.BaseDao;
import com.ling.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lian on 04/29/2019.
 */
@Service
public class UserService {
    @Autowired
    private BaseDao baseDao;

    public User findUserByUserName(String userName){
        User user = this.baseDao.queryForObject("UserMapper.findUserByUserName",userName);
        return user;
    }
}

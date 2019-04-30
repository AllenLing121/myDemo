package com.ling.service;

import com.ling.dao.BaseDao;
import com.ling.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lian on 04/30/2019.
 */
@Service
public class RoleService {
    @Autowired
    private BaseDao baseDao;

    public List<Role> findRoleByUserId(Long userId){
        List<Role> rosles = this.baseDao.queryForList("RoleMapper.findRoleByUserId",userId);

        return rosles;
    }

}

package com.ling.service;

import com.ling.dao.BaseDao;
import com.ling.entity.Privilege;
import com.ling.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lian on 04/30/2019.
 */
@Service
public class PrivilegeService {
    @Autowired
    private BaseDao baseDao;

    public List<Privilege> findPrivilegeByUserId(Long roleId){
        List<Privilege> privileges = this.baseDao.queryForList("PrivilegeMapper.findPrivilegeByRoleId",roleId);

        return privileges;
    }

}

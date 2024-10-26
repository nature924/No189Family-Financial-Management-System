package com.example.cwgl.service.impl;


import com.example.cwgl.dao.PrivilegeMapper;
import com.example.cwgl.entity.Privilege;
import com.example.cwgl.service.PrivilegeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {
    @Resource
    private PrivilegeMapper mapper;

    @Override
    public List<Privilege> getPrivilegeByRoleid(int roleid) {
        return this.mapper.getPrivilegeByRoleid(roleid);
    }

    @Override
    public int addDefaultPrivilegesWhenAddRole(String roleid) {
        return mapper.addDefaultPrivilegesWhenAddRole(roleid);
    }

    @Override
    public int delPrivilegesWenDelRole(String roleid) {
        return mapper.delPrivilegesWenDelRole(roleid);
    }
}

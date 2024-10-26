package com.example.cwgl.dao;


import com.example.cwgl.entity.Privilege;

import java.util.List;

public interface PrivilegeMapper {

    List<Privilege> getPrivilegeByRoleid(int roleid);

    int addDefaultPrivilegesWhenAddRole(String roleid);

    int delPrivilegesWenDelRole(String roleid);
}

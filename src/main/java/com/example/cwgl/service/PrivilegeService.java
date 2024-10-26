package com.example.cwgl.service;


import com.example.cwgl.entity.Privilege;

import java.util.List;

public interface PrivilegeService {

    List<Privilege> getPrivilegeByRoleid(int roleid);

    int addDefaultPrivilegesWhenAddRole(String roleid);

    int delPrivilegesWenDelRole(String roleid);
}

package com.example.cwgl.service;


import com.example.cwgl.entity.Role;
import com.example.cwgl.entity.UserInfo;
import com.example.cwgl.utils.PageModel;
import com.example.cwgl.utils.Result;

import java.util.List;

public interface UserInfoService {

    int add(UserInfo userInfo);

    int update(UserInfo userInfo);

    boolean userIsExisted(UserInfo userInfo);

    int delete(String id);

    UserInfo getUserInfo(UserInfo userInfo);

    Result getUsersByWhere(PageModel<UserInfo> model);

    List<Role> getAllRoles();

    int addRole(Role role);

    int updateRole(Role role);

    int deleteRole(String id);

    Role getRoleById(String id);

}

package com.wujq.mapper;

import java.util.List;
import java.util.Map;

import com.wujq.domain.Role;

public interface RoleMapper {
    /**
     * role
     * 方法描述:
     * @param
     * @return
     * @throws
     * @author 胖先生
     * @date 2019-08-19 10:48:35
     *
     **/
    int delete(Integer role_id);

    /**
     * role
     * 方法描述:
     * @param
     * @return
     * @throws
     * @author 胖先生
     * @date 2019-08-19 10:48:35
     *
     **/
    int add(Role role);

    /**
     * role
     * 方法描述:
     * @param
     * @return
     * @throws
     * @author 胖先生
     * @date 2019-08-19 10:48:35
     *
     **/
    Role load(Integer role_id);

    /**
     * role
     * 方法描述:
     * @param
     * @return
     * @throws
     * @author 胖先生
     * @date 2019-08-19 10:48:35
     *
     **/
    int update(Role role);
    //查询角色列表
    List<Role> roleList(Map<String, Object> map);
    //查询数量
    int count(Map<String, Object> map);
    //查询角色列表
    List<Role> roleAllList();
}
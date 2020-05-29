package com.wujq.service.impl;

import com.wujq.domain.Menu;
import com.wujq.domain.Rlm;
import com.wujq.domain.User;
import com.wujq.mapper.RlmMapper;
import com.wujq.mapper.UserMapper;
import com.wujq.mapper.MenuMapper;
import com.wujq.service.UserService;
import com.wujq.util.GetIds;
import com.wujq.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RlmMapper rlmMapper;
    @Autowired
    private MenuMapper menuMapper;

    /**
     * check user
     * @param map
     * @return
     */
    @Override
    public Map<String, Object> userList(Map<String, Object> map) {
        List<User> userList = userMapper.userList(map);
        int count = userMapper.count(map);
        PageBean.serMap(map, count, userList, User.class);
        return map;
    }

    /**
     * user add
     * @param user
     * @param map
     * @return
     */
    @Override
    public Map<String, Object> userAdd(User user, Map<String, Object> map) {
        int result = userMapper.add(user);
        if(result>0){
            map.put("message", "successfully added");
        }else {
            map.put("message", "fail to add");
        }
        return map;
    }

    /**
     * user load
     * @param user_id
     * @return
     */
    @Override
    public User load(Integer user_id) {
        return userMapper.load(user_id);
    }

    /**
     * user modify
     * @param user
     * @param map
     * @return
     */
    @Override
    public Map<String, Object> userMdi(User user, Map<String, Object> map) {
        int result = userMapper.update(user);
        if(result>0){
            map.put("message", "successfully modified");
        }else {
            map.put("message", "fail to modify");
        }
        return map;
    }

    /**
     * user delete
     * @param user_id
     * @param map
     * @return
     */
    @Override
    public Map<String, Object> userDel(Integer user_id, Map<String, Object> map) {
        int result = userMapper.delete(user_id);
        if(result>0){
            map.put("message", "successfully delete");
        }else {
            map.put("message", "fail to delete");
        }
        return map;
    }

    /**
     * user login
     * @param map
     * @param request
     * @return
     */
    @Override
    public Map<String, Object> login(Map<String, Object> map, HttpServletRequest request) {
        User user = userMapper.login(map);
        if(user!=null){
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            if(user.getFk_role_id()!=null){
                List<Rlm> sonList = rlmMapper.havList(user.getFk_role_id());
                if(sonList!=null&&sonList.size()>0){
                    List<Menu> fatherList = menuMapper.fatherList(user.getFk_role_id());
                    session.setAttribute("sonList", sonList);
                    session.setAttribute("fatherList", fatherList);
                }
            }
            map.put("url", "main");
        }else {
            map.put("url", "login");
        }
        return map;
    }

    /**
     * delete multiple
     * @param ids
     * @return
     */
    @Override
    public int delAll(GetIds ids) {
        List list = ids.getIds();
        int result = userMapper.delAll(list);
        return result;
    }

}

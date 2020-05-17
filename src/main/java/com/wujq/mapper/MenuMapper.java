/**
 * MenuMapper.java
 * ©2006-2016 四海兴唐科技有限公司 
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2019-08-20 09:19:29
 **/
package com.wujq.mapper;

import java.util.List;

import com.wujq.domain.Menu;

public interface MenuMapper {
    /**
     * menu
     * 方法描述:
     * @param  
     * @return 
     * @throws 
     * @author 胖先生
     * @date 2019-08-20 09:19:29
     * 
     **/
    int delete(Integer menu_id);

    /**
     * menu
     * 方法描述:
     * @param  
     * @return 
     * @throws 
     * @author 胖先生
     * @date 2019-08-20 09:19:29
     * 
     **/
    int add(Menu menu);

    /**
     * menu
     * 方法描述:
     * @param  
     * @return 
     * @throws 
     * @author 胖先生
     * @date 2019-08-20 09:19:29
     * 
     **/
    Menu load(Integer menu_id);

    /**
     * menu
     * 方法描述:
     * @param  
     * @return 
     * @throws 
     * @author 胖先生
     * @date 2019-08-20 09:19:29
     * 
     **/
    int update(Menu menu);
    List<Menu> noList(Integer role_id);
    List<Menu> fatherList(Integer role_id);
}
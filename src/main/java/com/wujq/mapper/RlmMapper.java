/**
 * RlmMapper.java
 * ©2006-2016 四海兴唐科技有限公司 
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2019-08-20 09:20:54
 **/
package com.wujq.mapper;

import java.util.List;
import java.util.Map;

import com.wujq.domain.Rlm;

public interface RlmMapper {
    /**
     * rlm
     * 方法描述:
     * @param  
     * @return 
     * @throws 
     * @author 胖先生
     * @date 2019-08-20 09:20:54
     * 
     **/
    int delete(Integer rlm_id);

    /**
     * rlm
     * 方法描述:
     * @param  
     * @return 
     * @throws 
     * @author 胖先生
     * @date 2019-08-20 09:20:54
     * 
     **/
    int add(Rlm rlm);

    /**
     * rlm
     * 方法描述:
     * @param  
     * @return 
     * @throws 
     * @author 胖先生
     * @date 2019-08-20 09:20:54
     * 
     **/
    Rlm load(Integer rlm_id);

    /**
     * rlm
     * 方法描述:
     * @param  
     * @return 
     * @throws 
     * @author 胖先生
     * @date 2019-08-20 09:20:54
     * 
     **/
    int update(Rlm rlm);
    List<Rlm> havList(Integer role_id);
    int menuDel(Map<String, Object> map);
    int menuAdd(Map<String, Object> map);
}
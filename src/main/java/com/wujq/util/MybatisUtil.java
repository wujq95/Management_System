package com.wujq.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {

    private MybatisUtil(){};

    private static final String PATH="mybatis-config.xml";
    private static InputStream is = null;
    private static SqlSessionFactory sqlSessionFactory = null;

    //静态代码块
    static {
        try {
            //加载核心配置文件
            is  = Resources.getResourceAsStream(PATH);
            //创建sqlSession工厂，相当于connection
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            throw new RuntimeException("核心配置文件加载异常，原因可能是映射文件写错了："+e.getMessage());
        }
    }

    //获取sqlSession
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
    //关闭资源
    public static void closeSqlSession(SqlSession sqlSession){
        if(sqlSession!=null){
            sqlSession.close();
        }
    }

}

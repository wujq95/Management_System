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

    //static code clock
    static {
        try {
            //load the code configure file
            is  = Resources.getResourceAsStream(PATH);
            //create sqlSession factory，as the connection in jdbc
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * close sqlSession
     */
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

    /**
     * close resource
     * @param sqlSession
     */
    public static void closeSqlSession(SqlSession sqlSession){
        if(sqlSession!=null){
            sqlSession.close();
        }
    }

}

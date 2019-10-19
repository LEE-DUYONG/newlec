package com.newlec.config;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {
    //SqlSession 생성 팩토리
	
   private static SqlSessionFactory sqlsession;
   
   static{
	  try {
		  
		String resource ="com/newlec/config/sqlMapConfig.xml";
		  Reader reader = Resources.getResourceAsReader(resource); 
		  sqlsession = new SqlSessionFactoryBuilder().build(reader);
		  reader.close();
		  
	  } catch (IOException e) {
		e.printStackTrace();
		throw new RuntimeException("런타임 에러 : "+ e);
	  }
   }
   
   public static SqlSessionFactory getSqlMapInstance(){
	   return sqlsession;
   }
}

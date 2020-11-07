package com.manish.session;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.manish.mapper.TestMapper;

public class DatabaseSession {
	
	public static SqlSession getSession()
	{
		SqlSession session =  null;
		try
		{
			java.io.Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
			session = new SqlSessionFactoryBuilder().build(reader).openSession();  
			session.getConfiguration().addMapper(TestMapper.class);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return session;
	}
}
package com.boco.common;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:mybatis-config.xml",
		"classpath:datasource-druid.xml",
		"classpath:spring-context.xml",
		"classpath:spring-mybatis.xml",
		})
public class JunitTestCase {
	protected Logger logger = Logger.getLogger(getClass());
	
	
	
	
	@Test
	public void gets(){
		
	}

		
}

/**
 * 
 */
package com.jam.productmanager.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jam.productmanager.dao.DaoManager;
import com.jam.productmanager.product.service.ProductManager;

/**
 * @autor JamZhou
 *
 * 2012-6-23 ÉÏÎç1:53:57
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class TestSpring extends AbstractDependencyInjectionSpringContextTests {

	@Autowired
	private ApplicationContext applicationContext;
	
	@Test
	public void test() {
		boolean b = applicationContext.containsBean("daoManager");
		assertEquals(true, b);
		
		DaoManager daoManager = (DaoManager) applicationContext.getBean("daoManager");
		assertNotNull(daoManager);
		
		ProductManager productManager = (ProductManager) applicationContext.getBean("productManager");
		assertNotNull(productManager);
		
		productManager.test();
	}

}


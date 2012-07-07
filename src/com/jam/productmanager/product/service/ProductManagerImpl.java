/**
 * 
 */
package com.jam.productmanager.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jam.productmanager.dao.DaoManager;

/**
 * @autor JamZhou
 *
 * 2012-6-23 ионГ1:38:43
 */
@Component("productManager")
public class ProductManagerImpl implements ProductManager {

	@Autowired
	private DaoManager daoManager;

	@Override
	public void test() {
		if(daoManager==null) {
			System.out.println("null");
		} else {
			System.out.println(daoManager);
		}
	}
}

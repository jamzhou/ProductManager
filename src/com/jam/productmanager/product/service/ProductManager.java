/**
 * 
 */
package com.jam.productmanager.product.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.jam.productmanager.product.model.Product;

/**
 * @autor JamZhou
 *
 * 2012-6-23 ионГ1:38:14
 */
public interface ProductManager {

	public void test();
	
	public void saveProduct(Product product);
	
	public void updateProduct(Product product);
	
	public void deleteProduct(Product product);
	
	public List<Product> getProducts(int pageIndex, int pageSize);
	
	public int getCountOfProducts();
	
	public String saveImage(File file,HttpServletRequest request);
	
	public Product getById(String id);
}

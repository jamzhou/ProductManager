/**
 * 
 */
package com.jam.productmanager.product.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.jam.productmanager.product.model.Product;
import com.jam.productmanager.product.service.ProductManager;
import com.jam.utils.StrutsUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * @autor JamZhou
 *
 * 2012-7-10 ÏÂÎç9:45:43
 */
public class ProductAction implements ModelDriven<Product>, Preparable{

	private Product product;
	private File productImage;
	
	public void setProductImage(File productImage) {
		this.productImage = productImage;
	}

	private ProductManager productManager;
	
	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}

	public String save() {
		try{
			ActionContext ct= ActionContext.getContext();
			HttpServletRequest request = (HttpServletRequest)ct.get(ServletActionContext. HTTP_REQUEST );
			if(productImage!= null && productImage.length() > 0) {
				String fileName = productManager.saveImage(productImage,request);
				product.setImagePath(fileName);
			}
			if(product.getId()==null) {
				productManager.saveProduct(product);
			} else {
				productManager.updateProduct(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "LIST";
	}

	public String load() {
		return "FORM";
	}
	
	public String read() {
		return "DETAIL";
	}
	
	@Override
	public void prepare() throws Exception {
		String id = StrutsUtils.getRequestParameter("id");
		if(id!=null && !"".equals(id)) {
			product = productManager.getById(id);
		} else {
			product = new Product();
		}
	}

	@Override
	public Product getModel() {
		return product;
	}
}

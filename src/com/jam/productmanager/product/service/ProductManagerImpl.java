/**
 * 
 */
package com.jam.productmanager.product.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jam.productmanager.dao.DaoManager;
import com.jam.productmanager.product.model.Product;

/**
 * @autor JamZhou
 *
 * 2012-6-23 ÉÏÎç1:38:43
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

	@Override
	public void saveProduct(Product product) {
		String sql = "insert into product (productname,price,category,characteristic,description,imagePath) value ('"
				+ product.getProductName() + "','" + product.getPrice() + "','" + product.getCategory() + "','" + product.getCharacteristic() + "','"
				+ product.getDescription() + "','" + product.getImagePath() + "')";
		System.out.println(sql);
		try {
			daoManager.executeSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateProduct(Product product) {
		String sql = "update product set productname='" + product.getProductName() + "',price='"
				+ product.getPrice() + "',category='" + product.getCategory() + "',characteristic='"
				+ product.getCategory() + "',description='" + product.getDescription() + "',imagePath='"
				+ product.getImagePath() + "' where id="
				+ product.getId();
		try {
			daoManager.executeSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProduct(Product product) {
		String sql = "delete from product where id=" + product.getId();
		try {
			daoManager.executeSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> getProducts(int pageIndex, int pageSize) {
		int index = pageIndex * pageSize;
		List<Product> products = null;
		String sql = "select * from (SELECT * FROM product p order by id desc) as t limit " + index + " , " + pageSize;
		Map<String,Object> daoResult = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			products = new ArrayList<Product>();
			daoResult = daoManager.querySql(sql);
			conn = (Connection) daoResult.get(DaoManager.KEY_CONNECTION);
			ps = (PreparedStatement) daoResult.get(DaoManager.KEY_PREPAREDSTATEMENT);
			rs = (ResultSet) daoResult.get(DaoManager.KEY_RESULTSET);
			while(rs.next()) {
				Product product = new Product();
				Long id = rs.getLong("id");
				String productName = rs.getString("productName");
				String price = rs.getString("price");
				String category = rs.getString("category");
				String characteristic = rs.getString("characteristic");
				String description = rs.getString("description");
				String imagePath = rs.getString("imagePath");
				product.setId(id);
				product.setProductName(productName);
				product.setPrice(price);
				product.setCategory(category);
				product.setDescription(description);
				product.setCharacteristic(characteristic);
				product.setImagePath(imagePath);
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return products;
	}

	@Override
	public int getCountOfProducts() {
		String sql = "select count(*) from product";
		Map<String,Object> daoResult = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			daoResult = daoManager.querySql(sql);
			conn = (Connection) daoResult.get(DaoManager.KEY_CONNECTION);
			ps = (PreparedStatement) daoResult.get(DaoManager.KEY_PREPAREDSTATEMENT);
			rs = (ResultSet) daoResult.get(DaoManager.KEY_RESULTSET);
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}

	@Override
	public String saveImage(File file,HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("/");
		String fileName = new SimpleDateFormat("yyMMddHHmmSS").format(new Date());
		File image = new File(path + "/images/products/" + fileName + ".png");
		
		FileInputStream fileIs = null;
		FileOutputStream fileOs = null;
		byte[] buffer = new byte[1024];
		try {
			fileIs = new FileInputStream(file);
			fileOs = new FileOutputStream(image);
			while(fileIs.read(buffer) > 0){
				fileOs.write(buffer);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fileOs.flush();
				if(fileIs != null) {
					fileIs.close();
				}
				if(fileOs != null) {
					fileOs.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return fileName + ".png";
	}

	@Override
	public Product getById(String productId) {
		String sql = "select * from product where id = " + productId;
		Map<String,Object> daoResult = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			daoResult = daoManager.querySql(sql);
			ps = (PreparedStatement) daoResult.get(DaoManager.KEY_PREPAREDSTATEMENT);
			rs = (ResultSet) daoResult.get(DaoManager.KEY_RESULTSET);
			if(rs.next()) {
				Product product = new Product();
				Long id = rs.getLong("id");
				String productName = rs.getString("productName");
				String price = rs.getString("price");
				String category = rs.getString("category");
				String characteristic = rs.getString("characteristic");
				String description = rs.getString("description");
				String imagePath = rs.getString("imagePath");
				product.setId(id);
				product.setProductName(productName);
				product.setPrice(price);
				product.setCategory(category);
				product.setDescription(description);
				product.setCharacteristic(characteristic);
				product.setImagePath(imagePath);
				return product;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}

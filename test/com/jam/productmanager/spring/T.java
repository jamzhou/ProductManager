package com.jam.productmanager.spring;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

import com.jam.productmanager.product.model.Product;

public class T {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		ReferenceQueue<Product> p = new ReferenceQueue<Product>();
		WeakReference<Product> rq = new WeakReference<Product>(new Product(),p);
		System.gc();
		Thread.sleep(1000);
		Product product = rq.get();
		System.err.println("ppp:"+product);
		Reference<? extends Product> ref= p.poll();
		System.err.println(">>:" + ref);
	}

}

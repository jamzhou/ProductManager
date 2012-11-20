/**
 * 
 */
package com.jam.productmanager.action;

import java.io.File;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @autor JamZhou
 *
 * 2012-7-2 ÏÂÎç11:59:54
 */
public class HelloAction extends ActionSupport {

	private File myFile;
	private String contentType;
	private String fileName;
	private String imageFileName;
	private String caption;
	
    public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}
	
	public String sayHello() {
		System.out.println("fuck");
		return "SUCCESS";
	}

	@Override
	public String execute() throws Exception {
		System.out.println(myFile.length());
		return "SUCCESS";
	}
	
}

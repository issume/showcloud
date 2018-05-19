package com.showcloud.code.test;

import java.io.IOException;
import java.sql.SQLException;

import com.showcloud.code.common.AutoGenerationJavaCode;

import freemarker.template.TemplateException;

public class GenerationTest {
	
	public static void main(String[] args) throws ClassNotFoundException, IOException, TemplateException, SQLException {  
	    String url="jdbc:mysql://10.67.18.17:3306/xx";  
	    String username="xx";  
	    String password="xx";  
	    String driver="com.mysql.jdbc.Driver";  
	    String tableName="t_test_operate";  
	    String basePath="com.xx.test";  
	    String templateDir=System.getProperty("user.dir")+"/src/main/java/"+"com/xx/common/code/template";  
	      
	    String generateFilePath=System.getProperty("user.dir")+"/src/main/java/"+basePath.replace(".", "/");  
	    AutoGenerationJavaCode autoGenerationJavaCode=  
	            new AutoGenerationJavaCode(url, username, password, driver, tableName, generateFilePath, "com.xx.test");  
	    autoGenerationJavaCode.autoGenerationJavaCode();  
	  
	}  

}

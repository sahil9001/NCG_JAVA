package com.adobe.prj.dao;

import java.util.ResourceBundle;

public class MobileDaoFactory {
	static String DAO = "";
	// static blocks gets executed as soon as class is loaded into JVM
	static {
		ResourceBundle res = ResourceBundle.getBundle("database");
		DAO = res.getString("MOBILE_DAO");
	}
	
	public static MobileDao getMobileDao() {
		try {
			return (MobileDao) Class.forName(DAO).getDeclaredConstructor().newInstance();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
//	public static MobileDao getMobileDao() {
//		return new MobileDaoMongoImpl();
//	}
	
}

package com.adobe.prj.dao;

import com.adobe.prj.entity.Mobile;

public class MobileDaoMongoImpl implements MobileDao {

	@Override
	public void addMobile(Mobile m) {
		System.out.println(m.getName() + " stored in MongoDB");
	}

}

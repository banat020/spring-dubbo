package com.banling.springdubbo.ds.sys.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.banling.spring.dubbo.module.db.sys.SysUsers;
import com.banling.springdubbo.ds.base.dao.IGenericDao;
import com.banling.springdubbo.ds.base.service.impl.GenericService;
import com.banling.springdubbo.ds.sys.dao.ISysUsersDao;
import com.banling.springdubbo.ds.sys.service.ISysUsersService;

@Service
public class SysUsersService extends GenericService<SysUsers> implements ISysUsersService {

	@Resource
	private ISysUsersDao sysUserDao;
	
	@Override
	public IGenericDao<SysUsers> getDao() {
		// TODO Auto-generated method stub
		return sysUserDao;
	}

}

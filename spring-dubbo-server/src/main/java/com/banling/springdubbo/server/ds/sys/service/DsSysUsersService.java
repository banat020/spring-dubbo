package com.banling.springdubbo.server.ds.sys.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.banling.spring.dubbo.module.db.sys.SysUsers;
import com.banling.springdubbo.api.ds.base.IBaseDsService;
import com.banling.springdubbo.api.ds.service.IDsSysUsersService;
import com.banling.springdubbo.ds.base.service.IGenericService;
import com.banling.springdubbo.ds.sys.service.ISysUsersService;
import com.banling.springdubbo.server.ds.service.base.BaseDsService;

@Service
public class DsSysUsersService extends BaseDsService<SysUsers,String> implements IDsSysUsersService {

	@Resource
	private ISysUsersService sysUsersService;

	@Override
	protected IGenericService<SysUsers> getGenericService() {
		// TODO Auto-generated method stub
		return sysUsersService;
	}

	@Override
	public String createJpql() {
		// TODO Auto-generated method stub
		return "select a from SysUsers a where userName like :userName";
	}


}

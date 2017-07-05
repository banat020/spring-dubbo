package com.banling.springdubbo.ds.sys.dao.impl;

import com.banling.spring.dubbo.module.db.sys.SysUsers;
import com.banling.springdubbo.ds.base.dao.impl.GenericDao;
import com.banling.springdubbo.ds.sys.dao.ISysUsersDao;

import org.springframework.stereotype.Component;

@Component("sysUserDao")
public class SysUsersDao extends GenericDao<SysUsers> implements ISysUsersDao {

}

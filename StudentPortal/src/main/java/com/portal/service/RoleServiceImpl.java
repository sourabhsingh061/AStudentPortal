package com.portal.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portal.common.BaseServiceImpl;
import com.portal.common.UserContext;
import com.portal.dao.RoleDAOInt;
import com.portal.dto.RoleDTO;

/**
 * Session facade of Role Service. It is transactional, apply declarative
 * transactions with help of Spring AOP.
 * 
 * If unchecked exception is propagated from a method then transaction is rolled
 * back.
 * 
 * Default propagation value is Propagation.REQUIRED and readOnly = false
 * @author Sourabh Singh Rajput
 */
@Service
@Transactional
public class RoleServiceImpl extends BaseServiceImpl<RoleDTO, RoleDAOInt> implements RoleServiceInt {

	private static Logger log = LoggerFactory.getLogger(RoleServiceImpl.class);

	@Transactional(readOnly = true)
	public RoleDTO findByName(String name, UserContext userContext) {
		return baseDao.findByUniqueKey("name", name, userContext);
	}

}

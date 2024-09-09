package com.portal.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portal.common.BaseServiceImpl;
import com.portal.common.UserContext;
import com.portal.dao.MarksheetDAOInt;
import com.portal.dto.MarksheetDTO;
import com.portal.exception.DuplicateRecordException;

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
public class MarksheetServiceImpl extends BaseServiceImpl<MarksheetDTO, MarksheetDAOInt>
		implements MarksheetServiceInt {

	private static Logger log = Logger.getLogger(MarksheetServiceImpl.class);

	@Transactional(readOnly = true)
	public MarksheetDTO findByName(String name, UserContext context) {
		return baseDao.findByUniqueKey("name", name, context);
	}

	@Override
	public MarksheetDTO findByRollNo(String rollNo, UserContext context) {
		return baseDao.findByUniqueKey("rollNo", rollNo, context);
	}

	@Override
	public List<MarksheetDTO> getMeritList(UserContext context) {
		System.out.println("getMeritList run in service");
		return baseDao.getMeritList();
	}
}
package com.portal.dao;

import java.util.List;

import com.portal.common.BaseDAOInt;
import com.portal.dto.MarksheetDTO;

/**
 * Marksheet DAO interface.
 * @author Sourabh Singh Rajput
 */
public interface MarksheetDAOInt extends BaseDAOInt<MarksheetDTO> {

	/**
	 * Get merit list
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<MarksheetDTO> getMeritList();
}

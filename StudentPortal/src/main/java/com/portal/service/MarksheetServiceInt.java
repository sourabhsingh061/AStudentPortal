package com.portal.service;

import java.util.List;

import com.portal.common.BaseServiceInt;
import com.portal.common.UserContext;
import com.portal.dto.MarksheetDTO;

/**
 * College Service interface.
 * @author Sourabh Singh Rajput
 */

public interface MarksheetServiceInt extends BaseServiceInt<MarksheetDTO> {

	/**
	 * Finds marksheet by name.
	 * 
	 * @param name
	 * @return
	 */
	public MarksheetDTO findByName(String name, UserContext context);

	/**
	 * Finds marksheet by Roll No
	 * 
	 * @param rollNo
	 * @return
	 */
	public MarksheetDTO findByRollNo(String rollNo, UserContext context);

	/**
	 * Gets merit list of students
	 * 
	 * @return
	 */
	public List<MarksheetDTO> getMeritList(UserContext context);
}
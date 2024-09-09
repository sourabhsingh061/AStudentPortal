package com.portal.service;

import com.portal.common.BaseServiceInt;
import com.portal.common.UserContext;
import com.portal.dto.StudentDTO;

/**
 * College Service interface.
 * @author Sourabh Singh Rajput
 */

public interface StudentServiceInt extends BaseServiceInt<StudentDTO> {

	/**
	 * Finds a Role by name.
	 * 
	 * @param roleName
	 * @return
	 */
	public StudentDTO findByEmail(String email, UserContext context);

}
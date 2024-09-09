package com.portal.service;

import com.portal.common.BaseServiceInt;
import com.portal.common.UserContext;
import com.portal.dto.RoleDTO;

/**
 * College Service interface.
 * 
 * @author Sourabh Singh Rajput
 
 */

public interface RoleServiceInt extends BaseServiceInt<RoleDTO> {

	/**
	 * Finds Role by name.
	 * 
	 * @param name
	 * @return
	 */
	public RoleDTO findByName(String name, UserContext userContext);

}

package com.portal.dao;

import com.portal.common.BaseDAOInt;
import com.portal.common.UserContext;
import com.portal.dto.UserDTO;

/**
 * User DAO interface.
 * @author Sourabh Singh Rajput
 */
public interface UserDAOInt extends BaseDAOInt<UserDTO> {

	public UserDTO findByEmail(String attribute, String val, UserContext userContext);
	
	
}

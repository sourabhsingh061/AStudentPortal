package com.portal.exception;

/**
 * DuplicateRecordException thrown when a duplicate record occurred
 * @author Sourabh Singh Rajput
 */
public class DuplicateRecordException extends RuntimeException {

	/**
	 * @param msg
	 *            error message
	 */
	public DuplicateRecordException(String msg) {
		super(msg);
	}

}
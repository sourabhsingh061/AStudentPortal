package com.portal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portal.common.BaseDAOImpl;
import com.portal.common.UserContext;
import com.portal.dto.CollegeDTO;
import com.portal.dto.StudentDTO;
/**
 * @author Sourabh Singh Rajput
 *
 */
@Repository
public class StudentDAOImpl extends BaseDAOImpl<StudentDTO> implements StudentDAOInt {

	@Override
	protected List<Predicate> getWhereClause(StudentDTO dto, CriteriaBuilder builder, Root<StudentDTO> qRoot) {
		// Create where conditions
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getEnrolNo())) {

			whereCondition.add(builder.like(qRoot.get("enrolNo"), dto.getEnrolNo() + "%"));
		}

		if (!isEmptyString(dto.getCollegeName())) {

			whereCondition.add(builder.like(qRoot.get("collegeName"), dto.getCollegeName() + "%"));
		}

		if (!isEmptyString(dto.getEmail())) {

			whereCondition.add(builder.like(qRoot.get("email"), dto.getEmail() + "%"));
		}

		if (isNotNull(dto.getDob())) {

			whereCondition.add(builder.equal(qRoot.get("dob"), dto.getDob()));
		}

		if (!isEmptyString(dto.getPhoneNo())) {
			whereCondition.add(builder.like(qRoot.get("phoneNo"), dto.getPhoneNo()+ "%"));
		}

		return whereCondition;
	}

	@Override
	public Class<StudentDTO> getDTOClass() {
		return StudentDTO.class;
	}

	@Autowired
	CollegeDAOInt collegeService = null;

	@Override
	protected void populate(StudentDTO dto, UserContext userContext) {
		CollegeDTO collegeDTO = collegeService.findByPK(dto.getCollegeId(), userContext);
		if (collegeDTO != null) {
			dto.setCollegeName(collegeDTO.getName());
		}
	}

}

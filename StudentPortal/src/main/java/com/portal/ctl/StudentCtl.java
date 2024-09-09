package com.portal.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.common.BaseCtl;
import com.portal.common.ORSResponse;
import com.portal.dto.CollegeDTO;
import com.portal.dto.StudentDTO;
import com.portal.form.StudentForm;
import com.portal.service.CollegeServiceInt;
import com.portal.service.StudentServiceInt;
/**
 * @author Sourabh Singh Rajput
 *
 */
@RestController
@RequestMapping(value = "Student")
public class StudentCtl extends BaseCtl<StudentForm, StudentDTO, StudentServiceInt> {

	@Autowired
	private CollegeServiceInt collegeService;

	@GetMapping("/preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);
		List<CollegeDTO> list = collegeService.search(new CollegeDTO(), userContext);
		res.addResult("collegeList", list);
		return res;
	}
}

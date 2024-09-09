package com.portal.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.common.BaseCtl;
import com.portal.common.DropdownList;
import com.portal.common.ORSResponse;
import com.portal.dto.MarksheetDTO;
import com.portal.dto.RoleDTO;
import com.portal.dto.StudentDTO;
import com.portal.form.MarksheetForm;
import com.portal.service.MarksheetServiceInt;
import com.portal.service.RoleServiceInt;
import com.portal.service.StudentServiceInt;

/**
 * @author Sourabh Singh Rajput
 *
 */
@RestController
@RequestMapping(value = "Marksheet")
public class MarksheetCtl extends BaseCtl<MarksheetForm, MarksheetDTO, MarksheetServiceInt> {

	@Autowired
	private StudentServiceInt studentService;
	@Autowired
	private MarksheetServiceInt marksheetService;

	@GetMapping("/preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);
		List<StudentDTO> list = studentService.search(new StudentDTO(), userContext);
		res.addResult("studentList", list);
		List<DropdownList> mlist = marksheetService.search(new MarksheetDTO(), userContext);
		res.addResult("marksheetList", mlist);
		return res;
	}

	@GetMapping("rollno/{rollNo}")
	public ORSResponse rollNo(@PathVariable String rollNo) {
		ORSResponse res = new ORSResponse(true);
		MarksheetDTO dto = baseService.findByRollNo(rollNo, userContext);
		if (dto != null) {
			res.addData(dto);
		} else {
			res.setSuccess(false);
			res.addMessage("Record not found");
		}
		return res;
	}

	@GetMapping("meritlist")
	public ORSResponse getMeritList() {
		System.out.println("getMeritList run on ctl");
		List<MarksheetDTO> list = baseService.getMeritList(userContext);
		ORSResponse res = new ORSResponse(true);
		res.addResult("list",list);
//		System.out.println("Merit list :: " + list);
		return res;
	}

}

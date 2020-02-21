package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.User;
import com.revature.service.EmailService;
import com.revature.service.UserService;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class EmailController {

	@Autowired
	EmailService ms;
	
	@Autowired
	UserService us;

	// @RequestMapping(method = RequestMethod.POST, value = "/recovery.app",
	// consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
	// produces = {MediaType.APPLICATION_ATOM_XML_VALUE,
	// MediaType.APPLICATION_JSON_VALUE})
	@RequestMapping(method = RequestMethod.POST, value = "/recovery.app", consumes = "application/json")
	public @ResponseBody void sendEmail(@RequestBody User user) {
		String email = user.getEmail();
		if (us.findUserByEmail(email) != null) {
			String mail = email;
			try {
				ms.sendEmail(mail);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

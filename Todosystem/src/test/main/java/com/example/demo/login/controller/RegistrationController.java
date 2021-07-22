package com.example.demo.login.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.domain.model.RegistrationForm;
import com.example.demo.login.domain.model.Users;
import com.example.demo.login.domain.service.Todo_itemsService;
import com.example.demo.login.domain.service.UsersService;

@Controller
public class RegistrationController {


	private Map<String, String> radioRegistration;


	private Map<String, String> initRadioRegistration(){

		Map<String,String>radio = new LinkedHashMap<>();


		radio.put("管理者", "ROLE_ADMIN");
		radio.put("一般社員","ROLE_MOS");


		return radio;
	}


@Autowired
UsersService usersService;
@Autowired
Todo_itemsService todo_itemsService;
@GetMapping("/registration")
public String getRegistration(@ModelAttribute RegistrationForm form,Model model) {

	radioRegistration = initRadioRegistration();

	//List<Users>radioRegistration= usersService.selectMany();

	form.setRole("ROLE_ADMIN");

	model.addAttribute("radioRegistration", radioRegistration);



	return "login/registration";

}

//int count = usersService.count();
//model.addAttribute("userListCount",count);




@PostMapping(value="/registration", params="registration")
public String postRegistration(@ModelAttribute  @Validated RegistrationForm form,
		BindingResult bindingResult, Model model) {


	if(bindingResult.hasErrors()) {
		return getRegistration(form,model);
	}
	System.out.println(form.getRole());
	 Users users = new Users();


	    users.setUser(form.getUser());
	    users.setPassword(form.getPassword());
	    users.setFamily_name(form.getFamily_name());
	    users.setFirst_name(form.getFirst_name());
	    users.setIs_deleted(form.getIs_deleted());
	    users.setRole(form.getRole());


	try {

	      boolean result= usersService.insertOne(users);

	      if(result==true) {
		     System.out.println("登録成功");
	      }else{
		     System.out.println("登録失敗");
	      }

	}catch(DataAccessException e ) {
		System.out.println("更新失敗(トランザクションテスト)");
	}

	return "redirect:/login";




}



//@PostMapping(value= "/registration",params="cancel")
//public String postRegistration() {

 // return "redirect:/login";
//}


}

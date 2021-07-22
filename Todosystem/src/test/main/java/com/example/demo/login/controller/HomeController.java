package com.example.demo.login.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.login.domain.model.SignupForm;
import com.example.demo.login.domain.model.Todo_items;
import com.example.demo.login.domain.model.Users;
import com.example.demo.login.domain.service.Todo_itemsService;
import com.example.demo.login.domain.service.UsersService;

@Controller
public class HomeController {

	@Autowired
    UsersService usersService;
    @Autowired
    Todo_itemsService todo_itemsService;
    @GetMapping("/workList")
    public String getHome(Model model) {

        model.addAttribute("contents", "login/workList :: workList_contents");

        List<Todo_items> todo_items = todo_itemsService.selectMany();

        model.addAttribute("todo_items", todo_items);


       loginName(model);



    	return "login/workList";
    }



    @PostMapping("/logout")
    public String postLogout() {

    	return "redirect:/login";
    }



    @GetMapping("/signup")
    public String getSignup(@ModelAttribute SignupForm signupForm, Model model) {

    	List<Users>userList= usersService.selectMany();
    	model.addAttribute("userList", userList);

    	return "login/signup";
    }



    @PostMapping(value="/signup", params="registration")
    public String postSignUp(@ModelAttribute @Validated SignupForm form,BindingResult bindingResult, Model model) {

    	if(bindingResult.hasErrors()) {

    		return getSignup(form, model);
    	}

    	   Todo_items todo_items = new Todo_items();

    	   Date date = new Date();


		    todo_items.setItem_name(form.getArticle());
		    todo_items.setUser_id(form.getUsersName());
		    todo_items.setExpire_date(form.getLimited());
		    todo_items.setRegistration_date(date);
		    todo_items.setFinished_date(null);
//		    todo_items.setCreate_date_time(date);
//		    todo_items.setUpdate_date_time(date);

		try {

		      boolean result= todo_itemsService.insertOne(todo_items);

		      if(result==true) {
			     System.out.println("登録成功");
		      }else{
			     System.out.println("登録失敗");
		      }

		}catch(DataAccessException e ) {
			System.out.println("更新失敗(トランザクションテスト)");
		}

		return "redirect:/workList";
	}



    @PostMapping(value= "/signup",params="cancel")
    public String postSignUp() {

	  return "redirect:/workList";
	}






    @PostMapping(value="/update", params="update")
    public String update(@ModelAttribute  @Validated SignupForm form,BindingResult bindingResult, Model model) {

    	System.out.println("更新ボタンの処理");

    	 if(bindingResult.hasErrors()) {

        		return getUpdate(form, model,form.getId());
         }

    	         Todo_items todo_items = new Todo_items();

    		      todo_items.setItem_name(form.getArticle());
    		      todo_items.setUser_id(form.getUsersName());
    		      todo_items.setExpire_date(form.getLimited());
                  todo_items.setId(form.getId());

         if(form.isCheck() == true ) {

        	 Date now = new Date();

        	 todo_items.setFinished_date(now);

         }else {

      		 todo_items.setFinished_date(null);

         }

         try {
    			   boolean result= todo_itemsService.updateOne(todo_items);

    	             if(result == true) {

    	    	            System.out.println("更新成功");

    	             }else{

    	    	            System.out.println("更新失敗");

    	             }

         }catch(DataAccessException e ) {

        	 System.out.println("更新失敗(トランザクションテスト)");

        	 model.addAttribute("result", "更新失敗(トランザクションテスト)");

         }



    	return "redirect:/workList";
    }



    @PostMapping(value="/update", params="cancel")
    public String update() {


    	return "redirect:/workList";
    }



    @GetMapping("/Update/{id:.+}")
    public String getUpdate(@ModelAttribute SignupForm form,Model model,@PathVariable("id")int todo_id) {

    	model.addAttribute("contents","login/Update::Update_contents");

      		if(todo_id!= 0) {

      			   Todo_items todo_items= todo_itemsService.selectOne(todo_id);

      			     form.setArticle(todo_items.getItem_name());//項目名
      			     form.setUsersName(todo_items.getUser_id());//担当者
      			     form.setLimited(todo_items.getExpire_date());//期限
      			     form.setId(todo_items.getId());

      			 if(todo_items.getFinished_date()  != null) {
      				  form.setCheck(true);
      			 }else {
      				  form.setCheck(false);
      			 }

      			model.addAttribute("signupForm",form);
      		}

        List<Users>usersList = usersService.selectMany();

            model.addAttribute("usersList", usersList);

      		return "login/update";
      	}



    @PostMapping("/delete")
    public String delete(@ModelAttribute SignupForm form, Model model) {

    	System.out.println(form.getId());

    	 boolean result = todo_itemsService.deleteOne(form.getId());

		  if(result) {

			 System.out.println("削除成功");

		  }else {

			 System.out.println("削除失敗");

		  }

		return "redirect:/workList";
    }



    @GetMapping("/Delete/{id:.+}")
    public String getUserDetail(@ModelAttribute SignupForm form,Model model,@PathVariable("id")int todo_id) {

  		model.addAttribute("contents","login/Delete::Delete_contents");


  		if(todo_id!= 0) {

  			Todo_items todo_items= todo_itemsService.selectOne(todo_id);

  			   form.setArticle(todo_items.getItem_name());
     		   form.setId(todo_items.getId());

  			 model.addAttribute("signupForm",form);

  		}

  		return "login/delete";
  	}



  	@GetMapping("/search")
  	public String search(@RequestParam("search") String search, Model model) {

  		List<Todo_items> todo_items = todo_itemsService.search(search);

  		  model.addAttribute("contents", "login/workList :: workList_contents");
          model.addAttribute("todo_items", todo_items);


         loginName(model);


		return "login/workList";
  	}


  	public String loginName(Model model) {
  		 String id = SecurityContextHolder.getContext().getAuthentication().getName();

         Users all = usersService.selectOne(id);

         String username = all.getUser();

         model.addAttribute("username" , username);

         return "login/workList";
  	}










  	@GetMapping("/Finished/{id:.+}" )
  	public String finished(@ModelAttribute SignupForm form, BindingResult bindingResult, Model model,
  			                @PathVariable("id")int todo_id) {

  		model.addAttribute("contents","login/Finish::Finish_contents");

		  Todo_items todo_items = new Todo_items();

		    Todo_items todo_items2= todo_itemsService.selectOne(todo_id);

		     todo_items.setId(todo_id);

		if(todo_items2.getFinished_date() == null) {

		     Date date = new Date();

		     todo_items.setFinished_date(date);

	    }else {

		     todo_items.setFinished_date(null);

	    }

		try {

		    boolean result= todo_itemsService.finished(todo_items);

		      if(result == true) {

			     System.out.println("成功");

		      }else{

			     System.out.println("失敗");

		      }

		}catch(DataAccessException e ) {

			System.out.println("失敗");

			model.addAttribute("result", "失敗");

		}

		return "redirect:/workList";
  	}


    @PostMapping(value= "/registration",params="cancel")
    public String postRegistration() {

	  return "redirect:/login";
	}



}

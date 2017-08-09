package com.pmb.olakoa;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pmb.olakoa.users.*;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;	

	@RequestMapping(value = {"/" , "/login"}, method = RequestMethod.GET)
	public String login(
			@RequestParam(value="error", required=false, defaultValue="false") Boolean error,
			Model model
			){
		model.addAttribute("error", error);
	
		return "login";
	}
	
	@RequestMapping(value= {"/" , "/login"}, method = RequestMethod.POST)
	public String validatingLogin(
			@RequestParam(value="login", required = true) String username,
			@RequestParam(value="password", required = true) String password,
			HttpSession session
			){
		
		User user = userService.getUser(username, password);	
		if(user != null) {
			session.setAttribute("user", user);
			if(user.getRole().equals("USER")){				
				return "redirect:/user/drinks";
			}else if(user.getRole().equals("ADMIN")){
				return "redirect:/home/admin";
			}else if(user.getRole().equals("SHOPPER")){
				return "redirect:/home/shop";
			}else{
				return "redirect:/login";
			}
		} else {		
			return "redirect:/login?error=true";
		}		
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.setAttribute("user", null);
		return "redirect:/login";
	}
	
}

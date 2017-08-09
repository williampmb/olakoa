package com.pmb.olakoa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pmb.olakoa.users.User;
import com.pmb.olakoa.users.UserService;
import com.pmb.olokoa.drinks.Drink;
import com.pmb.olokoa.drinks.DrinkService;

@Controller
@SessionAttributes(value="user", types=User.class)
public class AdminController {


	@Autowired
	private DrinkService drinkService;
	@Autowired
	private UserService userService;
	
	@ModelAttribute("drinks")
	private List<Drink> getDrinkByUser() {
		List<Drink> result = drinkService.findAllDrinks();
		return result;
	}
	
	
	@RequestMapping(value="/home/admin", method=RequestMethod.GET)
	public String goHome(User user) {		
		if(user.getId() == null || (!user.getRole().equals("ADMIN"))){
			return "redirect:/login";
		} 
		return "admin";
	}
	
	
}

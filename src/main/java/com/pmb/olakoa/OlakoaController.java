package com.pmb.olakoa;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pmb.olakoa.users.User;
import com.pmb.olokoa.drinks.Drink;
import com.pmb.olokoa.drinks.DrinkService;



@Controller
@SessionAttributes(value="user", types=User.class)
@RequestMapping(value="/user/drinks")
public class OlakoaController {
	@Autowired
	private DrinkService drinkService;
	
	
	@ModelAttribute("drinks")
	private List<Drink> getDrinkByUser(
			User user,
			@RequestParam(required=false, defaultValue= "name") String sort,
			@RequestParam(required=false, defaultValue= "asc") String order
			) {	
		
		
		List<Drink> result = drinkService.findAllDrinksByUser(user);
		switch(sort){
			case "cost":
				Collections.sort(result, new Comparator<Drink>() {
					public int compare(Drink t1, Drink t2) {
						return t1.getCost().compareTo(t2.getCost());
					}				
				});
				break;
			case "posted":
				Collections.sort(result, new Comparator<Drink>() {
					public int compare(Drink t1, Drink t2) {
						return Boolean.compare (t1.isPosted(),t2.isPosted());
					}				
				});
				break;
			default:
				Collections.sort(result, new Comparator<Drink>() {
					public int compare(Drink t1, Drink t2) {
						return t1.getName().compareToIgnoreCase(t2.getName());
					}				
				});
				break;
			
		}
		
		if(order.equals("desc")){
			Collections.reverse(result);
		}
		return result;
	}	
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String goHome(User user, Model model) {
		if(user.getId() == null || (!user.getRole().equals("USER"))){
			return "redirect:/login";
		}
		model.addAttribute("user", user);
		return "home";
	
	}
	

	
	
	
	
	
	
	
}

package com.pmb.olakoa;


import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pmb.olakoa.users.User;
import com.pmb.olokoa.drinks.Drink;
import com.pmb.olokoa.drinks.DrinkService;

@Controller
@RequestMapping(value = "/home/drinks/update/{did}")
@SessionAttributes(value = "user", types = User.class)
public class UpdateController {
	@Autowired
	private DrinkService drinkService;

	@ModelAttribute("d")
	private Drink getDrinkByUser(@PathVariable String did, User user) {
		Drink dd = drinkService.getDrinkById(did);		
		return dd;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String goDrinkUpdate(User user) {
		if (user.getId() == null || (!user.getRole().equals("USER"))){
			return "redirect:/login";
		}
		return "update";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String updateDrink(
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "description", required = true) String description,
			@RequestParam(value = "thumbnail", required = true) URL thumbnail,
			@RequestParam(value = "cost", required = true) Integer cost,
			@RequestParam(value = "posted", defaultValue = "false", required = true) Boolean posted,
			@PathVariable(value = "did") String did) {
		
		Drink dd = drinkService.getDrinkById(did);
		Drink d;

		d = new Drink.Builder().name(name).description(description)
				.thumbnail(thumbnail).cost(Integer.valueOf(cost))
				.posted(Boolean.valueOf(posted)).id(dd.getId())
				.ownerId(dd.getOwnerId()).build();
		
		drinkService.updateDrink(d);

		return "redirect:/user/drinks";
	}
}

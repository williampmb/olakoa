package com.pmb.olakoa;

import java.net.URL;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pmb.olakoa.users.User;
import com.pmb.olokoa.drinks.Drink;
import com.pmb.olokoa.drinks.DrinkService;

@Controller
@SessionAttributes(value = "user", types = User.class)
public class HomeController {
	@Autowired
	private DrinkService drinkService;

	@RequestMapping(value = "/home/drinks/create")
	public String goDrinkCreator(User user) {
		if (user.getId() == null || (!user.getRole().equals("USER"))) {
			return "redirect:/login";
		}
		return "create";
	}

	@RequestMapping(value = "/home/drinks/create", method = RequestMethod.POST)
	public String createDrink(
			@RequestParam(value = "name", required=true) String name,
			@RequestParam(value = "description", required=true) String description,
			@RequestParam(value = "thumbnail", required=true) URL thumbnail,
			@RequestParam(value = "cost", required=true) Integer cost,
			@RequestParam(value = "posted", defaultValue = "false", required=true) Boolean posted,
			HttpServletResponse response, HttpSession session,
			User user) {
		if (user.getId() == null || (!user.getRole().equals("USER"))) {
			return "redirect:/login";
		}
		Drink d;
		d = new Drink.Builder().name(name).description(description)
				.thumbnail(thumbnail).cost(Integer.valueOf(cost))
				.posted(posted).id(UUID.randomUUID().toString())
				.ownerId(user.getId()).build();
		drinkService.addDrink(d);
		
		return "create";
	}
}

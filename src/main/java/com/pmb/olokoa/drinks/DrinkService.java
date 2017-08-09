package com.pmb.olokoa.drinks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmb.olakoa.users.User;

@Service
public class DrinkService {

	@Autowired
	private DrinkDao database;
	
	public List<Drink> findAllDrinksByUser(User user) {	
		List<Drink> result = database.findAllDrinksByUser(user);	
		return result;
	}

	public void addDrink(Drink d) {
		database.addDrink(d);		
	}

	public Drink getDrinkById(String id) {
		Drink d = database.getDrinkById(id);
		return d;
	}

	public void updateDrink(Drink d) {
		database.removeDrinkById(d.getId());
		database.addDrink(d);
	}

	public List<Drink> findAllDrinks(){		
		return database.findAllDrinks();
	}

}

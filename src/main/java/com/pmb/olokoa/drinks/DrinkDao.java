package com.pmb.olokoa.drinks;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Repository;

import com.pmb.olakoa.users.User;

@Repository
public class DrinkDao {

	String property = "java.io.tmpdir";
	String tempDir = System.getProperty(property);

	public List<Drink> findAllDrinksByUser(User user) {
		List<Drink> result = new ArrayList<Drink>();

		List<Drink> findAllDrinks = findAllDrinks();

		for (Drink d : findAllDrinks) {
			if (d.getOwnerId().equals(user.getId())) {
				result.add(d);
			}
		}
		return result;
	}

	public void addDrink(Drink d) {
		File relativeFile;
		FileWriter fw = null;
		BufferedWriter bw;
		try {
			relativeFile = new File(tempDir + "drinksdb.txt");
			fw = new FileWriter(relativeFile, true);
			bw = new BufferedWriter(fw);

			bw.write(d.toString());
			bw.write("\n");
			bw.flush();
			bw.close();
			fw.close();

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Drink> findAllDrinks() {
		List<Drink> result = new ArrayList<Drink>();
		File relativeFile;
		Scanner s = null;
		try {

			relativeFile = new File(tempDir + "drinksdb.txt");
			s = new Scanner(relativeFile);
			while (s.hasNext()) {
				String line = s.nextLine();
				String[] drink = line.split(", ");

				Drink d;
				d = new Drink.Builder().id(drink[0]).name(drink[1])
						.thumbnail(new URL(drink[2])).description(drink[3])
						.cost(Integer.valueOf(drink[4])).ownerId(drink[5])
						.posted(Boolean.valueOf(drink[6])).build();
				result.add(d);

			}
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return result;
	}

	public void removeDrinkById(String id) {
		List<Drink> result = new ArrayList<Drink>();
		File relativeFile;
		Scanner s = null;
		relativeFile = new File(tempDir + "drinksdb.txt");
		try {

			s = new Scanner(relativeFile);
			while (s.hasNext()) {
				String line = s.nextLine();
				String[] drink = line.split(", ");
				Drink d = new Drink.Builder().id(drink[0]).name(drink[1])
						.thumbnail(new URL(drink[2])).description(drink[3])
						.cost(Integer.valueOf(drink[4])).ownerId(drink[5])
						.posted(Boolean.valueOf(drink[6])).build();
				if (!d.getId().equals(id)) {
					result.add(d);
				}

			}
			s.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		relativeFile.delete();
		FileWriter fw = null;
		BufferedWriter bw;
		try {
			relativeFile = new File(tempDir + "drinksdb.txt");
			fw = new FileWriter(relativeFile, true);
			bw = new BufferedWriter(fw);
			for (Drink d : result) {
				bw.write(d.toString());
				bw.write("\n");
			}
			bw.flush();
			bw.close();
			fw.close();

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Drink getDrinkById(String id) {
		List<Drink> findAllDrinks = findAllDrinks();
		for (Drink d : findAllDrinks) {
			if (d.getId().equals(id)) {
				return d;
			}
		}
		return null;
	}
}

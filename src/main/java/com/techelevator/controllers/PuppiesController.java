package com.techelevator.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.techelevator.daos.PuppyJdbcDao;
import com.techelevator.exceptions.PuppyNotFoundException;
import com.techelevator.models.Puppy;

/**
 * PuppiesController
 */
@Controller
public class PuppiesController {

	@Autowired
	PuppyJdbcDao puppyJdbcDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView puppyList(ModelMap model) {
		List<Puppy> puppies = puppyJdbcDao.getPuppies();
		model.put("puppies", puppies);
		return new ModelAndView("puppyList", model);
	}

	@RequestMapping(value = "puppies/save", method = RequestMethod.POST)
	public ModelAndView savePuppy(@RequestParam String name, @RequestParam int weight, @RequestParam String gender,
			@RequestParam(defaultValue = "false") Boolean paperTrained, ModelMap model) {

		// create new puppy
		Puppy puppy = new Puppy(name, weight, gender, paperTrained);
		puppyJdbcDao.savePuppy(puppy);

		// I prefer a clean redirect after a successful add to a list
		return new ModelAndView("redirect:/", model);

		// But I could have also shown the detail page:
		// model.put("puppy", puppy);
		// return new ModelAndView("puppyDetail", model);
	}

	@RequestMapping(value = "puppy", method = RequestMethod.GET)
	public ModelAndView puppyDetail(@RequestParam(defaultValue = "-1") int id, ModelMap model) {
		// check case where no id was entered
		if (id == -1) {
			model.put("error", "No puppy selected to view.");
			return new ModelAndView("puppyDetail", model);
		}

		Puppy puppy = null;
		try {
			puppy = puppyJdbcDao.getPuppy(id);
		} catch (PuppyNotFoundException e) {
			// an id for a puppy that doesn't exist was entered
			model.put("error", e.getMessage());
			return new ModelAndView("puppyDetail", model);
		}

		// return the puppy
		model.put("puppy", puppy);
		return new ModelAndView("puppyDetail", model);
	}
}

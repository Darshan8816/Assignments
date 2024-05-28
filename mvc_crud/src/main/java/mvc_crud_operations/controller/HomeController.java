package mvc_crud_operations.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mvc_crud_operations.dto.Person;

@Controller
public class HomeController {

	@Autowired
	private EntityManager manager;

	@GetMapping("/")
	public String hello() {
		return "home";
	}

	@GetMapping("/home")
	public String goHome() {
		return "home";
	}

	@GetMapping("/savePerson")
	public ModelAndView loadPage(ModelAndView view) {
		view.addObject("person", new Person());
		view.setViewName("saveDetails");
		return view;
	}

	@PostMapping("/save")
	public ModelAndView savePerson(@ModelAttribute Person p, ModelAndView view) {
		manager.getTransaction().begin();
		manager.persist(p);
		manager.getTransaction().commit();
		view.addObject("msg", "Person saved with id : " + p.getId());
		view.setViewName("home");
		return view;
	}

	@GetMapping("/fetchPerson")
	public ModelAndView getPersonById(ModelAndView view) {
		view.addObject("p", "Please enter Person id to fetch");
		view.setViewName("personId");
		return view;
	}

	@RequestMapping("/printPerson")
	public ModelAndView fetchPersonById(@RequestParam int id, ModelAndView view) {
		Person p = manager.find(Person.class, id);
		if (p != null) {
			view.addObject("p", p);
			view.setViewName("print");
			return view;
		}
		view.setViewName("home");
		view.addObject("msg", "Invalid id , please enter the valid Person id...!!!!");
		return view;

	}

	@GetMapping("/updatePerson")
	public String loadUpdate() {
		return "update";
	}

	@GetMapping("/updatest")
	public ModelAndView updatePerson(@RequestParam long number) {
		Person Person = manager.find(Person.class, number);
		ModelAndView view = new ModelAndView();
		if (!Person.equals(null)) {
			view.addObject("Person", Person);
			view.setViewName("updatedata");
		} else {
			System.out.println("data not found");
			view.setViewName("home");
		}
		return view;
	}

	@PostMapping("/update")
	public ModelAndView updatesave(Person p, ModelAndView view) {
		Person ps = manager.find(Person.class, p.getId());
		if (ps != null) {
			manager.getTransaction().begin();
			manager.merge(p);
			manager.getTransaction().commit();
			view.setViewName("home");
			view.addObject("msg", "Person Updated with id : " + p.getId());
			return view;
		}
		view.setViewName("home");
		view.addObject("msg", "Invalid Person id , please enter valid person_id...!!!");
		return view;
	}

	@GetMapping("/deletePerson")
	public String loaddelete() {
		return "IdToDelete";
	}

	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam int id, ModelAndView view) {
		Person ps = manager.find(Person.class, id);
		if (ps != null) {
			view.addObject("msg", "Person deleted with id : " + ps.getId());
			view.setViewName("home");
			manager.remove(ps);
			return view;
		}
		view.setViewName("home");
		view.addObject("msg", "Invalid Person id , please enter valid person_id...!!!");
		return view;
	}

}

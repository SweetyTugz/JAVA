package com.administrate.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.administrate.entity.Person;
import com.administrate.services.PersonFacade;
import com.administrate.services.PersonFacadeImpl;

@Controller
public class PersonContoller {
	@RequestMapping("/person.htm")
	public ModelAndView getAvailableEvents(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Object[]> personList = new ArrayList<Object[]>();
		PersonFacade service = new PersonFacadeImpl();
		personList = service.getAllPersons();

		ModelAndView mv = new ModelAndView();
		mv.addObject("persons", personList);
		mv.setViewName("/person.jsp");
		return mv;
	}

	@RequestMapping("/deletePerson.htm")
	public ModelAndView deleteOrganisation(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = request.getParameter("id");

		List<Object[]> organisationList = new ArrayList<Object[]>();
		PersonFacade service = new PersonFacadeImpl();
		service.deletePerson(Integer.parseInt(id));
		organisationList = service.getAllPersons();

		ModelAndView mv = new ModelAndView();
		mv.addObject("persons", organisationList);
		mv.setViewName("/person.jsp");
		return mv;
	}

	@RequestMapping("/insertPerson.htm")
	public ModelAndView insertPerson(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String statusString = "";

		String personId = request.getParameter("person_id");
		String personName = request.getParameter("person_name");
		String organisationId = request.getParameter("organisation_id");
		String address = request.getParameter("address");
		String phoneNumber = request.getParameter("phone_number");

		Person newPerson = new Person();
		newPerson.setPersonId(Integer.parseInt(personId));
		newPerson.setAddress(address);
		newPerson.setPersonName(personName);
		newPerson.setPhoneNumber(phoneNumber);
		newPerson.setOrganisationId(organisationId);

		ModelAndView mv = new ModelAndView();

		PersonFacade service = new PersonFacadeImpl();
		int status = -99;
		status = service.insertPerson(newPerson);

		statusString = "Person added Succesfully !!!";
		if (status > 0) {
			mv.addObject("REGISTRATIONSTATUSMESSAGE", statusString);

		} else if (status == 0) {
			mv.addObject("REGISTRATIONSTATUSMESSAGE",
					"There was error while saving the person. Please see log file for more details..");
		}

		List<Object[]> personsList = new ArrayList<Object[]>();
		personsList = service.getAllPersons();

		mv.addObject("persons", personsList);
		mv.setViewName("/person.jsp");
		return mv;
	}

	@RequestMapping("/updatePerson.htm")
	public ModelAndView updatePerson(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String statusString = "";

		String personId = request.getParameter("person_id");
		String personName = request.getParameter("person_name");
		String organisationId = request.getParameter("organisation_id");
		String address = request.getParameter("address");
		String phoneNumber = request.getParameter("phone_number");

		Person updatedPerson = new Person();
		updatedPerson.setPersonId(Integer.parseInt(personId));
		updatedPerson.setAddress(address);
		updatedPerson.setPersonName(personName);
		updatedPerson.setPhoneNumber(phoneNumber);
		updatedPerson.setOrganisationId(organisationId);

		ModelAndView mv = new ModelAndView();

		PersonFacade service = new PersonFacadeImpl();
		int status = -99;
		status = service.updatePerson(updatedPerson);

		statusString = "Person updated Succesfully !!!";
		if (status > 0) {
			mv.addObject("REGISTRATIONSTATUSMESSAGE", statusString);

		} else if (status == 0) {
			mv.addObject("REGISTRATIONSTATUSMESSAGE",
					"There was error while saving the person. Please see log file for more details..");
		}

		List<Object[]> personList = new ArrayList<Object[]>();
		personList = service.getAllPersons();

		mv.addObject("persons", personList);
		mv.setViewName("/person.jsp");
		return mv;
	}

	@RequestMapping("/updatePersonPage.htm")
	public ModelAndView updateOrganisationPage(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String id = request.getParameter("id");

		ModelAndView mv = new ModelAndView();

		mv.addObject("id", id);

		mv.setViewName("/updatePerson.jsp");
		return mv;
	}

}

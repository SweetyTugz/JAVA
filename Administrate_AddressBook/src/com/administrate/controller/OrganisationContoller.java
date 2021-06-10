package com.administrate.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.administrate.entity.Organisation;
import com.administrate.services.OrganisationFacade;
import com.administrate.services.OrganisationFacadeImpl;

@Controller
public class OrganisationContoller {
	@RequestMapping("/organisation.htm")
	public ModelAndView getAvailableEvents(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Object[]> orgList = new ArrayList<Object[]>();
		OrganisationFacade service = new OrganisationFacadeImpl();
		orgList = service.getAllOrganisation();

		System.out.print("in controller");
		for (Object o : orgList) {
			System.out.print(o.toString());
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("organisations", orgList);
		mv.setViewName("/organisation.jsp");
		return mv;
	}

	@RequestMapping("/deleteOrganisation.htm")
	public ModelAndView deleteOrganisation(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = request.getParameter("id");

		List<Object[]> organisationList = new ArrayList<Object[]>();
		OrganisationFacade service = new OrganisationFacadeImpl();
		service.deleteOrg(Integer.parseInt(id));
		organisationList = service.getAllOrganisation();

		ModelAndView mv = new ModelAndView();
		mv.addObject("organisations", organisationList);
		mv.setViewName("/organisation.jsp");
		return mv;
	}

	@RequestMapping("/insertOrg.htm")
	public ModelAndView insertOrganisation(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String statusString = "";

		String id = request.getParameter("id");
		String orgName = request.getParameter("orgName");

		Organisation newOrg = new Organisation();
		newOrg.setID(Integer.parseInt(id));
		newOrg.setOrganisation_Name(orgName);

		ModelAndView mv = new ModelAndView();

		OrganisationFacade serviceImpl = new OrganisationFacadeImpl();
		int status = -99;
		status = serviceImpl.insertOrg(newOrg);

		statusString = "Org added Succesfully !!!";
		if (status > 0) {
			mv.addObject("REGISTRATIONSTATUSMESSAGE", statusString);

		} else if (status == 0) {
			mv.addObject("REGISTRATIONSTATUSMESSAGE",
					"There was error while saving the organisation. Please see log file for more details..");
		}

		List<Object[]> orgList = new ArrayList<Object[]>();
		OrganisationFacade service = new OrganisationFacadeImpl();
		orgList = service.getAllOrganisation();

		mv.addObject("organisations", orgList);
		mv.setViewName("/organisation.jsp");
		return mv;
	}

	@RequestMapping("/updateOrg.htm")
	public ModelAndView updateOrganisation(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String statusString = "";

		String id = request.getParameter("id");
		String orgName = request.getParameter("orgName");
		Organisation updatedOrg = new Organisation();
		updatedOrg.setID(Integer.parseInt(id));
		updatedOrg.setOrganisation_Name(orgName);

		ModelAndView mv = new ModelAndView();

		OrganisationFacade serviceImpl = new OrganisationFacadeImpl();
		int status = -99;
		status = serviceImpl.updateOrg(updatedOrg);

		statusString = "Org updated Succesfully !!!";
		if (status > 0) {
			mv.addObject("REGISTRATIONSTATUSMESSAGE", statusString);

		} else if (status == 0) {
			mv.addObject("REGISTRATIONSTATUSMESSAGE",
					"There was error while saving the organisation. Please see log file for more details..");
		}

		List<Object[]> orgList = new ArrayList<Object[]>();
		OrganisationFacade service = new OrganisationFacadeImpl();
		orgList = service.getAllOrganisation();

		mv.addObject("organisations", orgList);
		mv.setViewName("/organisation.jsp");
		return mv;
	}

	@RequestMapping("/updateOrgPage.htm")
	public ModelAndView updateOrganisationPage(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String id = request.getParameter("id");

		ModelAndView mv = new ModelAndView();

		mv.addObject("id", id);
		mv.setViewName("/updateOrganisation.jsp");
		return mv;
	}
}

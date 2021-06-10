package com.administrate.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.administrate.dao.OrganisationDAO;
import com.administrate.entity.Organisation;

public class OrganisationFacadeImpl implements OrganisationFacade {

	@Override
	public int deleteOrg(int id) {
		OrganisationDAO dao = new OrganisationDAO();
		int status = 1;

		try {
			status = dao.deleteOrg(id);
		} catch (ClassNotFoundException exception) {
			return 0;
		} catch (SQLException exception) {

			return 0;
		}
		return status;
	}

	@Override
	public int insertOrg(Organisation newOrg) {
		OrganisationDAO dao = new OrganisationDAO();
		int status = 1;

		try {
			status = dao.insertOrg(newOrg);
		} catch (ClassNotFoundException exception) {
			return 0;
		} catch (SQLException exception) {

			return 0;
		}
		return status;
	}

	@Override
	public int updateOrg(Organisation updatedOrg) {
		OrganisationDAO dao = new OrganisationDAO();
		int status = 1;

		try {
			status = dao.updateOrg(updatedOrg);
		} catch (ClassNotFoundException exception) {
			return 0;
		} catch (SQLException exception) {

			return 0;
		}
		return status;
	}

	@Override
	public List<Object[]> getAllOrganisation() {

		OrganisationDAO dao = new OrganisationDAO();
		ArrayList<Object[]> showEvents = new ArrayList<Object[]>();
		try {
			showEvents = dao.showAllOrganisations();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return showEvents;
	}

}

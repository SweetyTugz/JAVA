package com.administrate.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.administrate.dao.PersonDAO;
import com.administrate.entity.Person;

public class PersonFacadeImpl implements PersonFacade {

	public List<Object[]> getAllPersons() {

		PersonDAO dao = new PersonDAO();
		ArrayList<Object[]> showPersons = new ArrayList<Object[]>();
		try {
			showPersons = dao.showAllPersons();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return showPersons;
	}

	@Override
	public int deletePerson(int id) {
		PersonDAO dao = new PersonDAO();
		int status = 1;

		try {
			status = dao.deletePerson(id);
		} catch (ClassNotFoundException exception) {
			return 0;
		} catch (SQLException exception) {

			return 0;
		}
		return status;
	}

	@Override
	public int insertPerson(Person newOrg) {
		PersonDAO dao = new PersonDAO();
		int status = 1;

		try {
			status = dao.insertPerson(newOrg);
		} catch (ClassNotFoundException exception) {
			return 0;
		} catch (SQLException exception) {

			return 0;
		}
		return status;
	}

	@Override
	public int updatePerson(Person updatedPerson) {
		PersonDAO dao = new PersonDAO();
		int status = 1;

		try {
			status = dao.updatePerson(updatedPerson);
		} catch (ClassNotFoundException exception) {
			return 0;
		} catch (SQLException exception) {

			return 0;
		}
		return status;
	}

}

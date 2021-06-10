package com.administrate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.administrate.connection.DataConnection;
import com.administrate.connection.DataQuery;
import com.administrate.entity.Organisation;
import com.administrate.entity.Person;

public class PersonDAO {
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	private DataQuery query;

	public PersonDAO() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Context.xml");
		query = (DataQuery) context.getBean("SqlBean");
	}

	public ArrayList<Object[]> showAllPersons() throws ClassNotFoundException, SQLException {
		connection = DataConnection.createConnection();
		statement = connection.prepareStatement(query.getSearchPerson());
		resultSet = statement.executeQuery();
		ArrayList<Object[]> personList = new ArrayList<Object[]>();

		while (resultSet.next()) {
			Object[] personObject = new Object[8];
			personObject[0] = resultSet.getInt("person_id");
			personObject[1] = resultSet.getString("person_name");
			personObject[2] = resultSet.getString("organisation_id");
			personObject[3] = resultSet.getString("address");
			personObject[4] = resultSet.getString("phone_number");
			personList.add(personObject);
		}
		resultSet.close();
		DataConnection.closeConnection();
		return personList;
	}

	public int deletePerson(int id) throws ClassNotFoundException, SQLException {

		connection = DataConnection.createConnection();

		PreparedStatement statement1 = connection.prepareStatement(query.getDeletePerson());
		statement1.setInt(1, id);
		int statusEvent = statement1.executeUpdate();
		if (statusEvent == 1) {
			return statusEvent;
		} else {
			System.out.println("NOT DELETED FORM PERSON TABLE");
			return 0;
		}

	}

	public int insertPerson(Person newPerson) throws SQLException, ClassNotFoundException {

		connection = DataConnection.createConnection();
		PreparedStatement statement = connection.prepareStatement(query.getInsertPerson());

		statement.setInt(1, newPerson.getPersonId());
		statement.setString(2, newPerson.getPersonName());
		statement.setString(3, newPerson.getOrganisationId());
		statement.setString(4, newPerson.getAddress());
		statement.setString(5, newPerson.getPhoneNumber());

		int status = statement.executeUpdate();

		if (status == 1) {
			return status;
		} else {
			System.out.println("NOT INSERTED INTO PERSON TABLE");
			return 0;
		}
	}

	public int updatePerson(Person updatedPerson) throws ClassNotFoundException, SQLException {

		connection = DataConnection.createConnection();

		PreparedStatement statement = connection.prepareStatement(query.getUpdatePerson());
		statement.setString(1, updatedPerson.getPersonName());
		statement.setString(2, updatedPerson.getOrganisationId());
		statement.setString(3, updatedPerson.getAddress());
		statement.setString(4, updatedPerson.getPhoneNumber());
		statement.setInt(5, updatedPerson.getPersonId());

		int status = statement.executeUpdate();

		if (status == 1) {
			return status;
		} else {
			System.out.println("NOT UPDATED INTO PERSON TABLE");
			return 0;
		}
	}

}

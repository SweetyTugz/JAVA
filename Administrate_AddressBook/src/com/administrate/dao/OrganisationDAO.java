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

public class OrganisationDAO {
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	private DataQuery query;

	public OrganisationDAO() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Context.xml");
		query = (DataQuery) context.getBean("SqlBean");
	}

	public ArrayList<Object[]> showAllOrganisations() throws ClassNotFoundException, SQLException {
		connection = DataConnection.createConnection();
		statement = connection.prepareStatement(query.getSearchOrganisation());
		resultSet = statement.executeQuery();
		ArrayList<Object[]> eventList = new ArrayList<Object[]>();

		while (resultSet.next()) {
			Object[] eventObject = new Object[8];
			eventObject[0] = resultSet.getInt("ID");
			eventObject[1] = resultSet.getString("Organisation_Name");
			eventList.add(eventObject);
		}
		resultSet.close();
		DataConnection.closeConnection();
		return eventList;
	}

	public int deleteOrg(int id) throws ClassNotFoundException, SQLException {

		connection = DataConnection.createConnection();

		PreparedStatement statement1 = connection.prepareStatement(query.getDeleteOrganisation());
		statement1.setInt(1, id);
		int statusEvent = statement1.executeUpdate();
		if (statusEvent == 1) {
			return statusEvent;
		} else {
			System.out.println("NOT DELETED FORM EVENT TABLE");
			return 0;
		}

	}

	public int insertOrg(Organisation newOrg) throws SQLException, ClassNotFoundException {
		
		connection = DataConnection.createConnection();
		PreparedStatement statement = connection.prepareStatement(query.getInsertOrganisation());

//		statement.setInt(1, newOrg.getID());
		statement.setString(2, newOrg.getOrganisation_Name());
		
		
		int status = statement.executeUpdate();
		
		if (status == 1) {
			return status;
		} else {
			System.out.println("NOT INSERTED INTO ORG TABLE");
			return 0;
		}
	}

	public int updateOrg(Organisation updatedOrg) throws ClassNotFoundException, SQLException {
		
		connection = DataConnection.createConnection();
		
		PreparedStatement statement = connection.prepareStatement(query.getUpdateOrganisation());
		statement.setString(1, updatedOrg.getOrganisation_Name());
		statement.setInt(2, updatedOrg.getID());
		
		
		int status = statement.executeUpdate();
		
		if (status == 1) {
			return status;
		} else {
			System.out.println("NOT UPDATED INTO ORG TABLE");
			return 0;
		}
	}

}

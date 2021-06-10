package com.administrate.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DataConnection {
	
		//LOGGER for logging connection details
		private static Logger log = Logger.getLogger(DataConnection.class);
		
		// New instance of Connection
		private static Connection connection = null;

		/**
		 * <br/>
		 * METHOD DESCRIPTION: <br/>
		 * 
		 * Open connection to access the underlying database. <br/>
		 * 
		 * @return Connection
		 *  
		 * @throws ClassNotFoundException
		 * @throws SQLException
		 * 
		 */

		public static Connection createConnection() throws ClassNotFoundException,
				SQLException {
			log.info("----inside createConnection----");
			System.out.println("----inside createConnection----");
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/festivaldatabase2", "root", "admin");
			log.info("----Connection established with MYSQL database----");
			return connection;
		}

		/**
		 * <br/>
		 * METHOD DESCRIPTION: <br/>
		 * 
		 * Close connection accessing the underlying database. <br/>
		 * 
		 * @return Connection
		 *  
		 * @throws SQLException
		 * 
		 */

		public static void closeConnection() throws SQLException {
			log.info("----Connection closed with MYSQL database----");
			connection.close();
		}
	}




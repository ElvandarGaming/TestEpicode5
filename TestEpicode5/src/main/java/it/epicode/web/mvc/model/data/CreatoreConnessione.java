package it.epicode.web.mvc.model.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreatoreConnessione {

	private Connection con;
	private final String url;

	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public CreatoreConnessione(String typeDatabase, String address, String port, String databaseName, String schema,
			String username, String password) {
		url = String.format("jdbc:%s://%s:%s/%s?currentSchema=%s&user=%s&password=%s", typeDatabase, address, port,
				databaseName, schema, username, password);
	}
	
	private CreatoreConnessione(String url) {
		this.url = url;
	}
	
	public static CreatoreConnessione creatoreConnessione() {
		return new CreatoreConnessione("jdbc:postgresql://localhost:5432/esercitazione4?currentSchema=negozio&user=postgres&password=123");
	}
	
	
	
	public Connection getConnection() throws SQLException {
		if (con == null || con.isClosed()) {
			this.con = DriverManager.getConnection(url);
		}
		return this.con;
	}

}

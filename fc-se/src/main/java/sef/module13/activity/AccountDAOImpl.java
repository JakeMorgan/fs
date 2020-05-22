package sef.module13.activity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class AccountDAOImpl implements AccountDAO {

	@SuppressWarnings("unused")
	private Connection conn;

	public AccountDAOImpl(Connection conn) {
		this.conn = conn;
	}

	public List<Account> findAccount(String firstName, String lastName)
			throws AccountDAOException {
		List<Account> accountList = new ArrayList<>();
		try {
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM ACCOUNT WHERE FIRST_NAME = ? OR LAST_NAME = ? ORDER BY ID ASC");

			statement.setString(1, firstName);
			statement.setString(2, lastName);

			ResultSet result = statement.executeQuery();

			while(result.next()){
				accountList.add(new AccountImpl(result.getInt(1), result.getString(2), result.getString(3), result.getString(4)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountList;
	}

	public Account findAccount(int id) throws AccountDAOException {
		AccountImpl account = null;
		try {
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM ACCOUNT WHERE ID = ?");
			statement.setInt(1, id);
			ResultSet resultSets = statement.executeQuery();
			while (resultSets.next()) {
				account = new AccountImpl(resultSets.getInt(1), resultSets.getString(2), resultSets.getString(3), resultSets.getString(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}


	public boolean insertAccount(String firstName, String lastName, String email)
			throws AccountDAOException {
		int i = 0;
		try {

			PreparedStatement statement = conn.prepareStatement("INSERT INTO ACCOUNT VALUES (Account_SEQ.nextval,?,?,?)");
			statement.setString(1, firstName);
			statement.setString(2, lastName);
			statement.setString(3, email);

			i = statement.executeUpdate();
			conn.commit();

		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
		}

		return i > 0;
	}

}

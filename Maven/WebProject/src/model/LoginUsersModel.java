package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import entity.LoginUsers;

public class LoginUsersModel {
	
	public boolean addUser(DataSource dataSource, LoginUsers newUser) {
		Connection conn = null;
		PreparedStatement mySt = null;
		try {
			conn = dataSource.getConnection();
			String name = newUser.getName();
			String email = newUser.getEmail();
			String password = newUser.getPassword();
			String query = "insert into loginusers (name, email, password) values (?, ?, ?)";
			mySt = conn.prepareStatement(query);
			mySt.setString(1, name);
			mySt.setString(2, email);
			mySt.setString(3, password);
			return mySt.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
	}
	
	public List<LoginUsers> listUser(DataSource dataSource) {
		List<LoginUsers> listUser = new ArrayList<>();
		Connection connect = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			connect = dataSource.getConnection();

			String query = "select * from loginusers";
			stmt = connect.createStatement();

			rs = stmt.executeQuery(query);
			while(rs.next()) {
				listUser.add(new LoginUsers(rs.getInt("users_id"), rs.getString("name"), rs.getString("email"), rs.getString("password")));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return listUser;

	}
}

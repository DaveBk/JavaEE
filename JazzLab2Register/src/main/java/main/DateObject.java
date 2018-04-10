package main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import object.User;

public class DateObject {

	Connection connection = new DbManager().DbConnection();
	
	public boolean addUser(User u) {
		String query = "INSERT INTO USERS (LOGIN,PASSWORD,EMAIL,RIGHTS) VALUES (?,?,?,?)";
	
		if (UserIsInDb(u.getLogin())) {
			return false;
		}else {
			try {
                PreparedStatement insertRecord = connection.prepareStatement(query);
                insertRecord.setString(1, u.getLogin());
                insertRecord.setString(2, u.getPassword());
                insertRecord.setString(3, u.getEmail());
                insertRecord.setString(4, u.getRights());
                insertRecord.executeUpdate();

                connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	private ResultSet selectUserFromDb(String login) {
		ResultSet rs = null;
		String query = "SELECT * FROM USERS WHERE LOGIN = (?)";
		
		try {
			PreparedStatement select = connection.prepareStatement(query);
			select.setString(1, login);
			rs = select.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
    private boolean UserIsInDb(String login) {
        String query = "SELECT LOGIN FROM USERS WHERE LOGIN = (?)";
        boolean exist = true;
        try {
            PreparedStatement select = connection.prepareStatement(query);
            select.setString(1, login);

            ResultSet rs = select.executeQuery();
            rs.next();
            exist = rs.isFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exist;
    }
    
    public boolean isAuthorizationCorrect(String login, String password) {
        ResultSet rs = selectUserFromDb(login);
        boolean isCorrect = false;

        try {
            rs.next();
            isCorrect = rs.getString("LOGIN").equals(login) & rs.getString("PASSWORD").equals(password);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isCorrect;
    }
    
    public User getUserByName(String login) {
        ResultSet rs = selectUserFromDb(login);

        User user = new User();
        try {
            rs.next();
            user.setLogin(rs.getString("LOGIN"));
            user.setEmail(rs.getString("EMAIL"));
            user.setRights(rs.getString("RIGHTS"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
    
    public void updateRightsUser(String user, String right) {
        String query = "UPDATE USERS SET (RIGHTS) = (?) WHERE LOGIN = ?";
        try {
            PreparedStatement update = connection.prepareStatement(query);
            update.setString(1, right);
            update.setString(2, user);
            update.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUserFromDb(String user){
        String query = "DELETE FROM USERS WHERE LOGIN = ?";
        try {
            PreparedStatement delete = connection.prepareStatement(query);
            delete.setString(1,user);
            delete.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM USERS";

        try {
            PreparedStatement select = connection.prepareStatement(query);
            ResultSet rs = select.executeQuery();
            while (rs.next()) {
                if(rs.getString("LOGIN").equals("admin")) continue;
                User user = new User();
                user.setLogin(rs.getString("LOGIN"));
                user.setEmail(rs.getString("EMAIL"));
                user.setRights(rs.getString("RIGHTS"));
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    
}
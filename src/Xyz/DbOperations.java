package Xyz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbOperations {
	
	
	// CREATING A CONNECTION IN DATABASE.
	
	Connection connection = null;
	
	public Connection connectDB(String dbname, String username, String password) {
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname,username,password);
			if(connection!= null)
				System.out.println("Connection Established");
			else
				System.out.println("Connection Failed");
		}
		
		
		
		
		catch(Exception e) {
		  System.out.println(e);	
		}
		
		
		return connection;
			
	}
	
	
	
	// CREATING TABLE IN DATABASE.
	
		public void createTable(String tableName)
		{
			Statement statement;
			try {
				String query = "CREATE TABLE IF NOT EXISTS " + tableName + " (id SERIAL PRIMARY KEY, name VARCHAR(25), price DOUBLE PRECISION);";

				
			
			    statement = connection.createStatement();
			    statement.execute(query);
			    System.out.println("Table Created");
			}
			catch (Exception e)
			{
				
				System.out.println(e);
			}
			
			
			
		}
		

	
	// INSERTING FOOD NAME.
		
		public void insertFood(String tableName, Foods food) {
			String sql = "INSERT INTO " + tableName + " (name, price) VALUES (?, ?)";
			try (PreparedStatement stmt = connection.prepareStatement(sql)) {
				stmt.setString(1, food.getName());
				stmt.setDouble(2, food.getPrice());
				stmt.executeUpdate();
				System.out.println("Food inserted: " + food.getName());
			} 
			
			
			catch (Exception e) {
				System.out.println(e);
			}
		}
	
	
  // Show all item
		
		 public void showAllFoods(String tableName) {
		        String sql = "SELECT name, price FROM " + tableName;

		        try (Statement stmt = connection.createStatement();
		             ResultSet rs = stmt.executeQuery(sql)) {

		            System.out.println("\n===== Food Menu =====");
		            while (rs.next()) {
		                String name = rs.getString("name");
		                double price = rs.getDouble("price");
		                System.out.println("{Name: " + name + ", Price: " + price + "}");
		            }

		        } catch (Exception e) {
		            System.out.println(e);
		        }
		    }
		
	
	
	
}

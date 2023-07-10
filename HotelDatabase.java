import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class HotelDatabase {
	
	private static Connection connection = null;
	private  static Scanner scanner = new Scanner(System.in);
	
	

	public static void main(String[] args){
		// TODO Auto-generated method stub
		 HotelDatabase sdb = new HotelDatabase();

		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//String dbUrl = "jdbc:mysql://localhost: 3006/jdbcstart";
			String dbUrl = "jdbc:mysql://localhost:3306/hotel_db"; // Corrected the port number and removed extra space

			String userName = "root";
			String password = "irelander26";
			connection = DriverManager.getConnection(dbUrl, userName, password);
			
			
			
			
			
			System.out.println("Enter Choice");
			System.out.println(" 1: Insert record");
			System.out.println(" 2: Select record");
			System.out.println(" 3: Callable Statement: Select record");
			int choice = Integer.parseInt(scanner.nextLine());

			
			switch(choice) {
			
			case 1:
				sdb.insertRecord();
				break;
				
			
				
			case 2:
				sdb.selectRecord();
				
				break;
				
			case 3:
				sdb.selectAllRecords();
				
				break;
				
				
			default:
			
			System.out.println("You do not have this choice");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error: JDBC driver not found");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error: Failed to connect to the database");
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println("Error: Failed to close the database connection");
					e.printStackTrace();
				}
			}
		}
			
		

	}//End of Main Method
	
	private void insertRecord() throws SQLException  {
		
		
		System.out.println("inside insertRecord method");
		
	//	String sql = "insert into student(name, percentage,address) values(?, ?, ?)";
	    String sql = "insert into Customers(name, email, phone, address) values(?, ?, ?, ?)";

		
		PreparedStatement preparedstatement = connection.prepareStatement(sql);
		System.out.println("Enter Name :");
		preparedstatement.setString(1, scanner.nextLine());
		System.out.println("Enter Email:");
		preparedstatement.setString(2, scanner.nextLine());
	
		System.out.println("Enter Phone :");
		preparedstatement.setString(3, scanner.nextLine());
		System.out.println("Enter Address :");
		preparedstatement.setString(4, scanner.nextLine());
		System.out.println();
		
		int rows = preparedstatement.executeUpdate();
		
		if(rows > 0) {
			
			System.out.println("Our record inserted successfully");
		}
		
	}//End of insertRecord()
	
	private void selectRecord() throws SQLException {
		
		System.out.println("You  are inside selectRecord()");
		System.out.println("Enter customer_id to find result");
		
		
		int number = Integer.parseInt(scanner.nextLine());
		
		String sql = "select * from customers where customer_id = "+ number;
		
		
		 Statement statement = connection.createStatement();
		 
		 ResultSet  result = statement.executeQuery(sql);
		 
		 if(result.next()) {
			 
			 int customer_id = result.getInt("customer_id");
			 String name = result.getString("name");
			 String email = result.getString("email");
			 String phone = result.getString("phone");
             String address = result.getString("address");
			 
			 System.out.println("customer_id  number is "+ customer_id);
			 System.out.println(" name is "+ name);
			 System.out.println("email is "+ email);
			 System.out.println("phone is " + phone);
			 System.out.println("address is "+ address);


			 
		 }else {
			 
			 System.out.println("result not found");
			 
		 }//End of Else Statement
		 
		
		 
	}//End of selectRecord()
	
	
	private void selectAllRecords() throws SQLException {
		
		System.out.println("Inside selectAllRecords()");
	    String sql = "SELECT * FROM Customers";

	    Statement statement = connection.createStatement();
	    ResultSet resultSet = statement.executeQuery(sql);

	    while (resultSet.next()) {
	        int customer_id = resultSet.getInt("customer_id");
	        String name = resultSet.getString("name");
	        String email = resultSet.getString("email");
	        String phone = resultSet.getString("phone");
	        String address = resultSet.getString("address");

	        System.out.println("Customer ID: " + customer_id);
	        System.out.println("Name: " + name);
	        System.out.println("Email: " + email);
	        System.out.println("Phone: " + phone);
	        System.out.println("Address: " + address);
	        System.out.println();
	    }

	    resultSet.close();
	    statement.close();
	}

	

}




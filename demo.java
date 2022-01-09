package studentcrud;
import java.sql.*;
import java.util.Scanner;


public class democlass {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, ClassNotFoundException, SQLException{

		try
		{
			student s = new student();
			s.getStudentDetails();
			s.insertStudent();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}


}
class student
{
	private String STUDENT_NO;
	private String STUDENT_NAME;
	private String STUDENT_DOB;
	private String STUDENT_DOJ;

	public void getStudentDetails() 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Your STUDENT_NO:");
		STUDENT_NO = input.nextLine();
		System.out.println("Enter Your STUDENT_NAME:");
		STUDENT_NAME = input.nextLine();
		System.out.println("Enter Your STUDENT_DOB:");
		STUDENT_DOB = input.nextLine();
		System.out.println("Enter STUDENT_DOJ:");
		STUDENT_DOJ = input.nextLine();

	}

	public void insertStudent() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		dbmsconnection dbmsconnect = new dbmsconnection("jdbc:mysql://localhost:3306/student","1lAIHXc8Va","TEMA3CTgGO");
		Connection con = dbmsconnect.getConnnection();
		String sql = "insert into student values (?,?,?,?);";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, STUDENT_NO);
		stmt.setString(2, STUDENT_NAME);
		stmt.setString(3, STUDENT_DOB);
		stmt.setString(4, STUDENT_DOJ);
		stmt.execute();
		System.out.println("Records inserted Successfully");
		dbmsconnect.closeConnection(con, stmt);

	}
	public void UpdateStudent() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		String sql = "UPDATE Users SET STUDENT_NO=?, STUDENT_NAME=?, STUDENT_DOB=? WHERE username=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "323");
		stmt.setString(2, "Ajay Shinde");
		stmt.setString(3, "21/04/1999");
		stmt.setString(4, "11/04/2020");
		int rowsUpdated = stmt.executeUpdate();
		if (rowsUpdated > 0) {
		    System.out.println("An existing user was updated successfully!");
		}
	}

	public void Delete() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
	String sql = "DELETE FROM Users WHERE username=?";

	PreparedStatement statement = conn.prepareStatement(sql);
	statement.setString(1, "Akash");

	int rowsDeleted = statement.executeUpdate();
	if (rowsDeleted > 0) {
	    System.out.println("A user was deleted successfully!");
	}

}
class dbmsconnection
{
	String url;
	String username;
	String password;



	public dbmsconnection(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}



	public Connection getConnnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection con=null;
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		con = DriverManager.getConnection(url, username, password);
		System.out.println("Connection Established Successfully");
		return con; 

	}
	public void closeConnection(Connection con, Statement stmt) throws SQLException
	{

	stmt.close();
	con.close();
	System.out.println("The connection is closed...");
	}

}}

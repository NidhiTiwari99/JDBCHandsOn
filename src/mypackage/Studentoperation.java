package mypackage;
import java.sql.*;
import java.util.Scanner;

public class Studentoperation {
	
	public void FetchStudents() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger"); 
			Statement st=con.createStatement();   
			ResultSet rs=st.executeQuery("select * from student_details");  
			while(rs.next())
			{
				int r= rs.getInt("rno");
				String n = rs.getString("name");
				String q = rs.getString("qualification");
				float p = rs.getFloat("percentage");
				System.out.println(r+" "+n+" "+q+" "+p);
			}
		}
		catch(Exception ex) {
			
			System.out.println("Exception Caught=>"+ex.getMessage());
		}
	}
		
		public void AddStudents() {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger"); 
				Statement st=con.createStatement();   
				int cnt = st.executeUpdate("insert into student_details(rno,name,qualification,percentage) values (6,'Sagar','MCA',90)");
				if(cnt>0) {
					System.out.println("Student Added Successfully");
				}
				else {
					System.out.println("Error!! Please Try Again");
				}
			}
			catch(Exception ex) {
				
				System.out.println("Exception Caught=>"+ex.getMessage());
			}	
			
		}
		
		public void AddStudentByUser() {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter Roll Number");
				int r = sc.nextInt();
				System.out.println("Enter Student Name");
				String n = sc.next();
				System.out.println("Enter Student Qualification");
				String q = sc.next();
				System.out.println("Enter Student Percentages");
				Float p =sc.nextFloat();
				
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger"); 
				Statement st=con.createStatement();   
				int cnt = st.executeUpdate("insert into student_details(rno,name,qualification,percentage) values ("+r+",'"+n+"','"+q+"',"+p+")");
				if(cnt>0) {
					System.out.println("Student Added Successfully");
				}
				else {
					System.out.println("Error!! Please Try Again");
				}
			}
			catch(Exception ex) {
				
				System.out.println("Exception Caught=>"+ex.getMessage());
			}	
			
		}
		
		public void UpdateStudent() {
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger"); 
				Statement st=con.createStatement();   
				int cnt = st.executeUpdate("update student_details set name ='Vidya Tiwari', qualification = 'BA', percentage =85 where rno =6 ");
				if(cnt>0) {
					System.out.println("Student Updated Successfully");
				}
				else {
					System.out.println("Error!! Please Try Again");
				}
			}
			catch(Exception ex) {
				
				System.out.println("Exception Caught=>"+ex.getMessage());
			}	
		}
		
	public void DeleteStudent() {
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger"); 
				Statement st=con.createStatement();   
				int cnt = st.executeUpdate("delete from student_details where rno =6 ");
				if(cnt>0) {
					System.out.println("Student Deleted Successfully");
				}
				else {
					System.out.println("Error!! Please Try Again");
				}
			}
			catch(Exception ex) {
				
				System.out.println("Exception Caught=>"+ex.getMessage());
			}	
		}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Studentoperation s = new Studentoperation();
		s.FetchStudents();
//		s.AddStudents();
//		s.FetchStudents();
		s.AddStudentByUser();
//		s.UpdateStudent();
//		s.DeleteStudent();
	}

}

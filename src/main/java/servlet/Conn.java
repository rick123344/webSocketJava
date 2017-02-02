package servlet;

import java.sql.*;

class Conn{
	
	Connection connect=null;
	
	Conn(){
		try{
			Class.forName("org.postgresql.Driver");
		}catch(Exception e){
			System.out.println("Error Driver");
			e.printStackTrace();
			return;
		}
		System.out.println("Driver Found");
		try{
			connect = DriverManager.getConnection("jdbc:postgresql://ec2-54-163-234-140.compute-1.amazonaws.com:5432/dat6a739fq4uhg?sslmode=require","anqjcagciofbxt","de4155895419470f1bf4eb3b24ecf21392133a876f7d7bff36ea64078d37c33b");
			// "jdbc:oracle:thin:@//(HOST):(PORT)/(SID)" can be found in tnsnames.ora
		}catch(Exception e){
			System.out.println("Connect Error");
			e.printStackTrace();
			return;
		}
		
		if(connect != null){
			System.out.println(connect);
			System.out.println("Connected");
		}else{
			System.out.println("Fail get connect");
		}
		
	}
	
	String doDbRequest(){
		String str = "";
		if(connect != null){
			Statement statement=null;
			try{
				statement=connect.createStatement();
				ResultSet result=statement.executeQuery("SELECT * FROM ticks");
				while(result.next()){
					//System.out.println(result.getString("tick"));
					str += result.getString("tick")+" ";
				}
			}catch(SQLException e){
				System.out.println("Error When Execute Statement");
				e.printStackTrace();
			}finally{
				try{
					statement.close();
				}catch(Exception e){}
			}
		}
		return str;
	}
	
}
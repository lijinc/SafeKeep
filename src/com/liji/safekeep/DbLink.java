package com.liji.safekeep;
import java.sql.*;

public class DbLink {
	private Connection conn;
	private String url;
	private String dbName;
	private String driver;
	private String userName;  
	private String password;
	private String table;
	private String insertTable;
	public DbLink()
	{	
		url = "jdbc:mysql://localhost:3306/";
		dbName = "encdata";
		driver = "com.mysql.jdbc.Driver";
		userName = "root";
		password = "root";
		table="CREATE TABLE encdata.enctable (sno INTEGER UNIQUE NOT NULL,id VARCHAR(50) NOT NULL,sitename VARCHAR(25) NOT NULL,username VARCHAR(25),password VARCHAR(25) NOT NULL,PRIMARY KEY (id))";	
		try 
		{	 
			//Tries to establish connection to mysql driver
			Class.forName(driver).newInstance();
		    conn = DriverManager.getConnection(url,userName,password);
		    System.out.println("Debug:connected");
			try
			{ 
				//Tries to create a DB if DB is not present
				Statement st=conn.createStatement();
				st.executeUpdate("CREATE DATABASE "+dbName);
				System.out.println("Debug:created new db");
		    }
			catch(Exception dbCreate)
			{
				System.out.println("Debug:Database already exists");
			}
		} 
		catch (Exception dbExist) 
		{
			System.out.println("Debug:error connecting localhost");
		}
		try
		{
			//tries to create a new table if table not present
			  Statement st = conn.createStatement();
			  st.executeUpdate(table);
			  System.out.println("Debug:Table created");
			  try
			  {
					//first time add data
					st.executeUpdate("INSERT encdata.enctable VALUES("+0+","+"'rootapp'"+","+"'root'"+","+"'app'"+","+"'root'"+")" );
					System.out.println("Debug:Added dummy data");
			  }
			  catch(SQLException s)
			  {
				    System.out.println("Debug:Error adding dummy data");
		   	  }
		}
		catch(SQLException s)
		{
			  System.out.println("Debug:Table already exists");
		}
	
		
	}
	
	public void addRecord(String sName,String uName,String pwd)
	{	
		int reccount=0;
		try
		{
			  //tries to count ie get sno
			  Statement st = conn.createStatement();
			  ResultSet res = st.executeQuery("SELECT MAX(sno) FROM encdata.enctable");
			  while (res.next())
			  {
				  reccount = res.getInt(1);
			  }
		}
		catch (SQLException s)
		{
			  System.out.println("Debug:unable to count");
		}
		try
		{
			  //tries to insert a data to table
			  reccount+=1;
			  PreparedStatement prest = conn.prepareStatement("insert encdata.enctable values(?,?,?,?,?)");
			  prest.setObject(1,reccount);
			  prest.setObject(2,sName+uName);
			  prest.setObject(3,sName);
			  prest.setObject(4,uName);
			  prest.setObject(5,pwd);
			  int n = prest.executeUpdate();
			  System.out.println("Debug:Data insertion succesfull");
		}
		catch (SQLException s)
		{
			  System.out.println("Debug:Data insertion failed(Duplicate value)");
		}
	}
	
	public String searchPassword(String sName,String uName)
	{
		String pwd="error no password found";
		try
		{	  //tries to searc for pwd given sName,uName
			  String sqlquerry=sName+uName; 
			  PreparedStatement prest = conn.prepareStatement("select password from encdata.enctable where id like ?");
			  prest.setString(1,sqlquerry );
			  ResultSet rs = prest.executeQuery();
			  while (rs.next())
			  {
					pwd=rs.getString("password");
			  }
			  System.out.println("Debug:Search sucessful");
		}
		catch (SQLException s)
		{
			  System.out.println("Debug:unable to search");
		}
		return pwd;
	}
	public void deleteRecord(String sName,String uName)
	{
		try
		{
			String sqlquerry=sName+uName;
			PreparedStatement prest = conn.prepareStatement("delete from encdata.enctable where id like ?");
			prest.setObject(1,sqlquerry);
			int n = prest.executeUpdate();
			System.out.println("Debug:Data deletion succesful");
		}	
		catch(SQLException s)
		{
			System.out.println("Debug:Failed to delete data");
		}
		
	}
	public String allPassword(int sno)
	{
		String pwd="error no password found";
		try
		{	  //tries to search for pwd given sno
			  PreparedStatement prest = conn.prepareStatement("select password from encdata.enctable where sno =?");
			  prest.setInt(1, sno);
			  ResultSet rs = prest.executeQuery();
			  while (rs.next())
			  {
					pwd=rs.getString("password");
			  }
			  System.out.println("Debug:Search sucessful");
		}
		catch (SQLException s)
		{
			  System.out.println("Debug:unable to search");
		}
		return pwd;
	}
	public String allUserName(int sno)
	{
		String pwd="error no username";
		try
		{	  //tries to search for uname given sno
			  PreparedStatement prest = conn.prepareStatement("select username from encdata.enctable where sno =?");
			  prest.setInt(1, sno);
			  ResultSet rs = prest.executeQuery();
			  while (rs.next())
			  {
					pwd=rs.getString("username");
			  }
			  System.out.println("Debug:Search sucessful");
		}
		catch (SQLException s)
		{
			  System.out.println("Debug:unable to search");
		}
		return pwd;
	}
	public String allSiteName(int sno)
	{
		String pwd="error no sitename";
		try
		{	  //tries to search for sname given sno
			  PreparedStatement prest = conn.prepareStatement("select sitename from encdata.enctable where sno =?");
			  prest.setInt(1, sno);
			  ResultSet rs = prest.executeQuery();
			  while (rs.next())
			  {
					pwd=rs.getString("sitename");
			  }
			  System.out.println("Debug:Search sucessful");
		}
		catch (SQLException s)
		{
			  System.out.println("Debug:unable to search");
		}
		return pwd;
	}
	public void updateRecord(String sName,String uName,String nPassword)
	{
		try
		{
			String sqlquerry=sName+uName;
			PreparedStatement prest = conn.prepareStatement("update encdata.enctable set password = ? where id like ?");
			prest.setObject(1,nPassword);
			prest.setObject(2, sqlquerry);
			int n = prest.executeUpdate();
			System.out.println("Debug:Succesfully modified");
		}	
		catch(SQLException s)
		{
			System.out.println("Debug:Failed to modify Data");
		}
	}
	public int countRec()
	{int reccount = 0;
		try
		{
			  //tries to count 
			  Statement st = conn.createStatement();
			  ResultSet res = st.executeQuery("SELECT MAX(sno) FROM encdata.enctable");
			  while (res.next())
			  {
				  reccount = res.getInt(1);
			  }
		}
		catch (SQLException s)
		{
			  System.out.println("Debug:unable to count");
		}
		return reccount;
	}
	public void closeConnection()
	{
		try
		{
			conn.close();
			System.out.println("Debug:Disconnected from database");	
		}
		catch(Exception e)
		{
			System.out.println("Debug:Unable to disconnect");	
		}
	}
}	  


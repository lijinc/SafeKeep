package com.liji.safekeep;

public class EncUData {
	private String entity;
	private String userName;
	private String password;
	private static int reccount;
	public EncUData(String ename,String uname,String pwd)
	{
		entity=ename;
		userName=uname;
		password=pwd;
		reccount=reccount+1;
	}
	

}

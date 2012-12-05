package com.liji.safekeep;
import java.sql.*;

import java.awt.*;

import javax.swing.JFrame;

public class SafeKeep {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
		      public void run() {
		      SafeFrame mainframe=new SafeFrame();
		      mainframe.setVisible(true);
		      mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      }
		});*/
		DbLink db=new DbLink(); 
		db.addRecord("www.yahoo.com", "lijyahoo", "pwd");
	}

}

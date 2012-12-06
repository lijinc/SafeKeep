package com.liji.safekeep;
import java.sql.*;

import java.awt.*;

import javax.swing.JFrame;

public class SafeKeep {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
		      public void run() {
		      SafeMainFrame mainframe=new SafeMainFrame();
		      mainframe.setVisible(true);
		      mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      }
		});
	}

}
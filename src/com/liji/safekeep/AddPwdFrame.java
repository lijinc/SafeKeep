package com.liji.safekeep;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.*;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;

public class AddPwdFrame extends JFrame {
	private JPanel mainPane;
	private DbLink db;
	private JButton btnAddPassword;
	private JTextField txtSite;
	private JTextField txtUser;
	private JPasswordField passwordField;
	private JLabel lblUser;
	private JLabel lblPassword;
	private JButton btnGoBack;
	public AddPwdFrame()
	{	
		db=new DbLink();
		setResizable(false);
		setTitle("SafeKeep");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 227, 225);
		mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane);
		mainPane.setLayout(null);
		
		txtSite = new JTextField();
		txtSite.setBounds(5, 25, 217, 20);
		mainPane.add(txtSite);
		txtSite.setColumns(10);
		
		txtUser = new JTextField();
		txtUser.setBounds(5, 69, 217, 20);
		mainPane.add(txtUser);
		txtUser.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(5, 113, 217, 20);
		mainPane.add(passwordField);
		
		btnAddPassword = new JButton("Add Password");
		btnAddPassword.setBounds(5, 140, 217, 26);
		mainPane.add(btnAddPassword);
		
		JLabel lblSiteName = new JLabel("Site Name:");
		lblSiteName.setBounds(5, 5, 97, 15);
		mainPane.add(lblSiteName);
		
		lblUser = new JLabel("User Name:");
		lblUser.setBounds(5, 49, 82, 15);
		mainPane.add(lblUser);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(5, 93, 82, 15);
		mainPane.add(lblPassword);
		
		btnGoBack = new JButton("Go Back!");
		btnGoBack.setBounds(5, 170, 217, 26);
		mainPane.add(btnGoBack);
		btnGoBack.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent eve)
	    	{	
	    		setVisible(false);
	    		db.closeConnection();
	    		SafeIndexFrame sif=new SafeIndexFrame();
	    		sif.setVisible(true);
	    		
	    	}
	    });
		btnAddPassword.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent eve)
	    	{	
	    		String sName=new String(txtSite.getText());
	    		String uName=new String(txtUser.getText());
	    		String pwd=new String(passwordField.getPassword());
	    		db.addRecord(sName, uName, pwd);
				db.closeConnection();
	    		setVisible(false);
	    		SafeIndexFrame sf=new SafeIndexFrame();
	    		sf.setVisible(true);
	    		
	    	}
	    });
	}
}

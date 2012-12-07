package com.liji.safekeep;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.*;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;

public class GetPwdFrame extends JFrame {
	private JPanel mainPane;
	private DbLink db;
	private String adminPassword;
	private JTextField txtSite;
	private JTextField txtUser;
	private JTextField txtPwd;
	private String uName;
	private String sName;
	public GetPwdFrame()
	{	
		setResizable(false);
		setTitle("SafeKeep");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 240, 230);
		mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane);
		mainPane.setLayout(null);
		
		JLabel lblSiteName = new JLabel("Site Name:");
		lblSiteName.setBounds(5, 0, 228, 26);
		mainPane.add(lblSiteName);
		
		txtSite = new JTextField();
		txtSite.setBounds(5, 23, 228, 20);
		mainPane.add(txtSite);
		txtSite.setColumns(10);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setBounds(5, 43, 228, 26);
		mainPane.add(lblUserName);
		
		txtUser = new JTextField();
		txtUser.setBounds(5, 66, 228, 20);
		mainPane.add(txtUser);
		txtUser.setColumns(10);
		
		JButton btnGetPassword = new JButton("Get Password!");
		btnGetPassword.setBounds(5, 90, 228, 26);
		mainPane.add(btnGetPassword);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(5, 116, 228, 26);
		mainPane.add(lblPassword);
		
		txtPwd = new JTextField();
		txtPwd.setBounds(5, 139, 228, 20);
		mainPane.add(txtPwd);
		txtPwd.setColumns(10);
		
		JButton btnEditPassword = new JButton("Edit Password!");
		btnEditPassword.setBounds(5, 163, 228, 26);
		mainPane.add(btnEditPassword);
		
		JButton btnGoBack = new JButton("Go Back!");
		btnGoBack.setBounds(5, 193, 228, 26);
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
		db=new DbLink();
		
		btnGetPassword.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent eve)
	    	{	
	    		sName=txtSite.getText();
	    		uName=txtUser.getText();
	    		txtPwd.setText(db.searchPassword(sName, uName));
	    	}
	    });
		
		btnEditPassword.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent eve)
	    	{	
	    		setVisible(false);
	    		db.closeConnection();
	    		ChangePwdFrame cp=new ChangePwdFrame(sName,uName);
	    		cp.setVisible(true);
	    		
	    	}
	    });
	}

}

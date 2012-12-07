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
public class SafeIndexFrame extends JFrame {
	private JPanel mainPane;
	private DbLink db;
	private String adminPassword;
	private JButton btnAddPassword;
	private JButton btnRemovePassword;
	private JButton btnGetPassword;
	private JButton btnShowAllPassword;
	private JButton btnChangeAdminPassword;
	public SafeIndexFrame()
	{	
		db=new DbLink();
		setResizable(false);
		setTitle("SafeKeep");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 239, 265);
		mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane);
		mainPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnAddPassword = new JButton("Add a new Password");
		mainPane.add(btnAddPassword);
		
		btnAddPassword.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent eve)
	    	{	
	    		setVisible(false);
	    		db.closeConnection();
	    		AddPwdFrame apf=new AddPwdFrame();
	    		apf.setVisible(true);
	    		
	    	}
	    });
		
		btnGetPassword = new JButton("Get Password");
		mainPane.add(btnGetPassword);
		
		btnGetPassword.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent eve)
	    	{	
	    		setVisible(false);
	    		db.closeConnection();
	    		GetPwdFrame gpf=new GetPwdFrame();
	    		gpf.setVisible(true);
	    		
	    	}
	    });
		
		btnRemovePassword = new JButton("Remove a Password");
		mainPane.add(btnRemovePassword);
		
		btnRemovePassword.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent eve)
	    	{	
	    		setVisible(false);
	    		db.closeConnection();
	    		RemovePwdFrame re=new RemovePwdFrame();
	    		re.setVisible(true);
	    	}
	    });
		
		btnShowAllPassword = new JButton("Show all Passwords");
		mainPane.add(btnShowAllPassword);
		
		btnShowAllPassword.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent eve)
	    	{	
	    		setVisible(false);
	    		db.closeConnection();
	    		ShowAllFrame sh=new ShowAllFrame();
	    		sh.setVisible(true);
	    	}
	    });
		
		btnChangeAdminPassword = new JButton("Change Admin Password");
		mainPane.add(btnChangeAdminPassword);
		
		btnChangeAdminPassword.addActionListener(new ActionListener()
		    {
		    	public void actionPerformed(ActionEvent eve)
		    	{	
		    		setVisible(false);
		    		db.closeConnection();
		    		ChangePwdFrame cpwd=new ChangePwdFrame("root","app");
		    		cpwd.setVisible(true);
		    	}
		    });
	}
	
}

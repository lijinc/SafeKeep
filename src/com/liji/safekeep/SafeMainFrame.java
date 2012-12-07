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
public class SafeMainFrame extends JFrame {
	private JPanel mainPane;
	protected JPasswordField passwordField;
	private DbLink db;
	private String adminPassword;
	private JLabel lblEnterYourPassword;
	public SafeMainFrame()
	{	
		setResizable(false);
		setTitle("SafeKeep");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 249, 90);
		mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane);
		mainPane.setLayout(null);
		
		lblEnterYourPassword = new JLabel("Enter Your Password:");
		lblEnterYourPassword.setBounds(5, 0, 237, 37);
		mainPane.add(lblEnterYourPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(5, 30, 237, 20);
		passwordField.setToolTipText("Default Password is 'root'");
		mainPane.add(passwordField);
		db=new DbLink();
		adminPassword=db.searchPassword("root", "app");
		JButton btnOk = new JButton("Login!");
		btnOk.setBounds(5, 53, 237, 26);
	    btnOk.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent eve)
	    	{	
	    		String s=new String(passwordField.getPassword());
	    		if(s.equals(adminPassword))
	    		{
	    			System.out.println("Debug:Acces Granted");
	    			setVisible(false);
	    			if(adminPassword.equals("root"))
	    			{
	    				db.closeConnection();
	    				ChangePwdFrame npwd=new ChangePwdFrame("root","app");
	    				npwd.setVisible(true);
	    				npwd.bakDisable();
	    			}
	    			else
	    			{
	    				db.closeConnection();
	    				SafeIndexFrame sfi= new SafeIndexFrame();
	    				sfi.setVisible(true);
	 
	    			}
	    		}
	    		else
	    		{
	    			JOptionPane.showMessageDialog(null, "Invalid Password!","Error",2);
	    			passwordField.setText("");
	    		}
	    	}
	    });
		mainPane.add(btnOk);
	}

}

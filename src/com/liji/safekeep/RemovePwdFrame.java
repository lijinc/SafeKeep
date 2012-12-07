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
public class RemovePwdFrame extends JFrame {
	private JPanel mainPane;
	private DbLink db;
	private String adminPassword;
	private JTextField txtSite;
	private JTextField txtUser;
	public RemovePwdFrame()
	{	
		setResizable(false);
		setTitle("SafeKeep");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 245, 157);
		mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane);
		mainPane.setLayout(null);
		
		JLabel lblS = new JLabel("Site Name:");
		lblS.setBounds(5, 0, 237, 35);
		mainPane.add(lblS);
		
		txtSite = new JTextField();
		txtSite.setBounds(5, 27, 237, 20);
		mainPane.add(txtSite);
		txtSite.setColumns(10);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setBounds(5, 43, 237, 35);
		mainPane.add(lblUserName);
		db=new DbLink();
		JButton btnDeletePassword = new JButton("Delete Password!");
		btnDeletePassword.setBounds(5, 100, 237, 26);
		btnDeletePassword.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent eve)
	    	{	
	    		if(JOptionPane.showConfirmDialog(null, "Are you Sure You Wanna Delete Record?","Delete",JOptionPane.YES_NO_OPTION)==0)
	    		{
	    			db.deleteRecord(txtSite.getText(),txtUser.getText());
	    			setVisible(false);
	    			db.closeConnection();
	    			SafeIndexFrame si=new SafeIndexFrame();
	    			si.setVisible(true);
	    		}
	    	}
	    });
		
		txtUser = new JTextField();
		txtUser.setBounds(5, 71, 237, 20);
		mainPane.add(txtUser);
		txtUser.setColumns(10);
		mainPane.add(btnDeletePassword);
		
	}

}

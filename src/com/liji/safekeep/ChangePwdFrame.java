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
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;

public class ChangePwdFrame extends JFrame {
	private JPanel changePwdPane;
	private DbLink db;
	private String oldPassword;
	private JPasswordField currentPassword;
	private JPasswordField newPassword;
	private JPasswordField confirmPassword;
	public ChangePwdFrame(final String sName,final String uName)
	{	
		setResizable(false);
		setTitle("SafeKeep");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 259, 164);
		changePwdPane = new JPanel();
		changePwdPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(changePwdPane);
		changePwdPane.setLayout(null);
		
		JLabel lblCurrentPassword = new JLabel("Current Password:");
		lblCurrentPassword.setBounds(5, 6, 247, 19);
		changePwdPane.add(lblCurrentPassword);
		
		currentPassword = new JPasswordField();
		currentPassword.setBounds(5, 25, 247, 19);
		currentPassword.setToolTipText("Default:root");
		changePwdPane.add(currentPassword);
		
		JLabel lblNewLabel = new JLabel("New Password:");
		lblNewLabel.setBounds(5, 44, 247, 19);
		changePwdPane.add(lblNewLabel);
		
		newPassword = new JPasswordField();
		newPassword.setBounds(5, 63, 247, 19);
		changePwdPane.add(newPassword);
		
		JLabel lblRe = new JLabel("Confirm PassWord:");
		lblRe.setBounds(5, 82, 247, 19);
		changePwdPane.add(lblRe);
		
		confirmPassword = new JPasswordField();
		confirmPassword.setBounds(5, 101, 247, 19);
		changePwdPane.add(confirmPassword);
		
		JButton btnUpdate = new JButton("Update!");
		btnUpdate.setBounds(5, 125, 247, 30);
		changePwdPane.add(btnUpdate);
		
		btnUpdate.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent eveUpdate)
	    	{	
	    		String currPwd=new String(currentPassword.getPassword());
	    		if(currPwd.equals(oldPassword))
	    		{
	    			System.out.println("Debug:current pass = old pass allowed to change pwd ");
	    			String nPwd=new String(newPassword.getPassword());
	    			String cPwd=new String(confirmPassword.getPassword());
	    			if(nPwd.equals(cPwd))
	    			{
	    				System.out.println("Debug:New password confirmed");
	    				oldPassword=nPwd;
	    				db.updateRecord(sName, uName, nPwd);
	    				db.closeConnection();
	    				JOptionPane.showMessageDialog(null,"New Password Confirmed!","SafeKeep",1);
	    				setVisible(false);
	    				SafeIndexFrame sfi=new SafeIndexFrame();
	    				sfi.setVisible(true);
	    			}
	    			else
	    			{
		    			JOptionPane.showMessageDialog(null, "Can't Confirm New Password!","Error",2);
	    			}
	    		}
	    		else
	    		{
	    			JOptionPane.showMessageDialog(null, "Wrong Current Password!","Error",2);
	    		}
	    	}
	    });
		
		JLabel label = new JLabel("");
		label.setBounds(5, 139, 247, 19);
		changePwdPane.add(label);
		db=new DbLink();
		oldPassword=db.searchPassword(sName, uName);
	}

}

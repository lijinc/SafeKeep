package com.liji.safekeep;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.event.*;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextArea;
public class ShowAllFrame extends JFrame {
	private JPanel mainPane;
	private DbLink db;
	private String adminPassword;
	private String allPwd;
	public ShowAllFrame()
	{	
		allPwd="";
		setResizable(false);
		setTitle("SafeKeep");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 283, 298);
		mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane);
		mainPane.setLayout(null);
		
		JLabel lblPasswords = new JLabel("Passwords:");
		lblPasswords.setBounds(5, 0, 273, 23);
		mainPane.add(lblPasswords);
		
		db=new DbLink();
		int i=1;
		for(i=1;i<=db.countRec();i++)
		{
			if("error no password found".equals(db.allPassword(i)))
			{
				continue;
			}
			allPwd=allPwd+"=================================================="
					+"\n"+String.valueOf(i)+". \n"+"Site Name : "+db.allSiteName(i)+"\n"+"User Name : "+db.allUserName(i)
					+"\n"+"Password : "+db.allPassword(i)+"\n";
		}
		allPwd=allPwd+"==================================================";
		db.closeConnection();
		JTextArea textArea = new JTextArea(allPwd);
		textArea.setBounds(5, 104, 273, 98);
		mainPane.add(textArea);
		
		JScrollPane jbr =new JScrollPane(textArea);
		jbr.setSize(273, 200);
		jbr.setLocation(5, 28);
		mainPane.add(jbr);
		JButton btnGoBack = new JButton("Go Back!");
		btnGoBack.setBounds(5, 233, 273, 26);
		mainPane.add(btnGoBack);
		btnGoBack.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent eve)
	    	{	
	    		setVisible(false);
	    		db.closeConnection();
	    		SafeIndexFrame apf=new SafeIndexFrame();
	    		apf.setVisible(true);
	    		
	    	}
	    });
	}
}

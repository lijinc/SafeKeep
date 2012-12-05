package com.liji.safekeep;

import java.awt.*;
import javax.swing.JFrame;
public class SafeFrame extends JFrame {
	public SafeFrame()
	{
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int screenHeight=screenSize.height;
		int screenWidth=screenSize.width;
		setSize(screenWidth/4,screenHeight/2);
		setTitle("Safe Keep");
	}
}

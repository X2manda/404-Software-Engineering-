package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Register extends JFrame
{
	private static final int HEIGHT = 275;
	private static final int WIDTH = 375;

	private JLabel titleLabel = new JLabel("CREATE AN ACCOUNT");  

	private JLabel accountLabel = new JLabel("Account Information");
	
	private JLabel firstNameLabel = new JLabel("First")

	public Register() 
	{
		//title
		setTitle("Login");
		setLayout(null);

		//Layout size and visibility
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//adding contents
		add(loginLabel);
		add(logUserTf);
		add(logPassTf);
		add(loginButton);
		
		//content positions
	  
		loginLabel.setBounds(50, 30, 200, 20);
		logUserTf.setBounds(50, 80, 260, 30);
		logPassTf.setBounds(50, 120, 260, 30);
		loginButton.setBounds(225, 180, 85, 30);

		//designs
		loginLabel.setForeground(new Color(33, 56, 162));
		loginButton.setForeground(new Color(255, 255, 255));

		loginButton.setBackground(new Color(40, 67, 181));

		loginLabel.setFont(new Font("Verdana", Font.BOLD, 12));
	}
	
	
	public static void main(String[] args) 
	{
		try
		{
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch(Exception e)
		{
			
		}
		
		Register reg = new Register();
		reg.setVisible(true);
	}

}

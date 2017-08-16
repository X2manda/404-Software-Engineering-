package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import imports.TextPrompt;

public class Login extends JFrame
{
	private static final int HEIGHT = 275;
	private static final int WIDTH = 375;

	private JLabel loginLabel = new JLabel("LOG IN");  

	private JTextField logUserTf = new JTextField();
	private JPasswordField logPassTf = new JPasswordField();

	private TextPrompt logUserTp = new TextPrompt("username", logUserTf);
	private TextPrompt logPassTp = new TextPrompt("password", logPassTf);

	private JLabel newUserLabel = new JLabel("New User? Click here to Register.");
	private JLabel forgotPassLabel = new JLabel("Forgot Password?");
	private JButton loginButton = new JButton("LOG IN");

	public Login() 
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
		add(newUserLabel);
		add(forgotPassLabel);
		add(loginButton);
		
		//content positions
	  
		loginLabel.setBounds(50, 30, 200, 20);
		logUserTf.setBounds(50, 80, 260, 30);
		logPassTf.setBounds(50, 120, 260, 30);
		newUserLabel.setBounds(50, 150, 260, 30);
		forgotPassLabel.setBounds(50, 175, 170, 30);
		loginButton.setBounds(225, 180, 85, 30);

		//designs
		loginLabel.setForeground(new Color(33, 56, 162));
		loginButton.setForeground(new Color(255, 255, 255));

		loginButton.setBackground(new Color(40, 67, 181));

		loginLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		
		//underlines making it look like hyperlink
		Font font = newUserLabel.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		newUserLabel.setFont(font.deriveFont(attributes));
		forgotPassLabel.setFont(font.deriveFont(attributes));
		
		//change to Alpha changes text prompts transparency
		logUserTp.changeAlpha(0.5f);
		logPassTp.changeAlpha(0.5f);

		//borderT
		
		logUserTf.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		logPassTf.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
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
		
		Login login = new Login();
		login.setVisible(true);
	}

}

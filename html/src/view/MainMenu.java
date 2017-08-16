package view;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class MainMenu extends JFrame
{
	private static final int HEIGHT = 400;
	private static final int WIDTH = 450;
	
	private ImageIcon profPics = new ImageIcon(getClass().getResource("/imports/menupic.jpg"));
	
	private JLabel picture;
	
	private JButton adviseButton = new JButton("Advising");
	private JButton checklistButton = new JButton("Check List");
	private JButton gradesButton = new JButton("Check Grades");
	private JButton accountButton = new JButton("Account info");
	private JButton changeButton = new JButton("Change Password");
	
	private JButton logoutButton = new JButton("Logout");

	public MainMenu() 
	{

		//title
		setTitle("Main Menu");
		setLayout(null);

		//Layout size and visibility
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);


		//designs
		adviseButton.setForeground(new Color(255, 255, 255));
		checklistButton.setForeground(new Color(255, 255, 255));
		gradesButton.setForeground(new Color(255, 255, 255));
		accountButton.setForeground(new Color(255, 255, 255));
		changeButton.setForeground(new Color(255, 255, 255));
		logoutButton.setForeground(new Color(255, 255, 255));

		adviseButton.setBackground(new Color(40, 67, 181));
		checklistButton.setBackground(new Color(40, 67, 181));
		gradesButton.setBackground(new Color(40, 67, 181));
		accountButton.setBackground(new Color(40, 67, 181));
		changeButton.setBackground(new Color(40, 67, 181));
		logoutButton.setBackground(new Color(255, 119, 0));
		
		//change pic size
		Image img = profPics.getImage();
		Image sizedimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		picture = new JLabel(new ImageIcon(sizedimg));
		
		//adding contents
		add(picture);
		add(adviseButton);
		add(checklistButton);
		add(gradesButton);
		add(accountButton);
		add(changeButton);
		add(logoutButton);
		
		//content positions
		picture.setBounds(330, 80, 100, 100);
		adviseButton.setBounds(15, 80, 135, 50);
		checklistButton.setBounds(15, 130, 135, 50);
		gradesButton.setBounds(15, 180, 135, 50);
		accountButton.setBounds(15, 230, 135, 50);
		changeButton.setBounds(15, 280, 135, 50);
		logoutButton.setBounds(80, 330, 70, 30);
		
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
		
		MainMenu menu = new MainMenu();
		menu.setVisible(true);
	}

}

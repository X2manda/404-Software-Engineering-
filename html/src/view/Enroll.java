package view;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableColumn;

public class Enroll extends JFrame
{
	private static final int HEIGHT = 500;
	private static final int WIDTH = 800;
	
	private ImageIcon profPics = new ImageIcon(getClass().getResource("/imports/menupic.jpg"));
	
	private JLabel picture;

	private JLabel nameLabel = new JLabel("Student Name");
	private JLabel mynameLabel = new JLabel("Suzuki, Ayane");
	private JLabel courseLabel = new JLabel("Course/Major");
	private JLabel mycourseLabel = new JLabel("Bachelor of Science in Information Technology");
	private JLabel yearLabel = new JLabel("Year Level");
	private JLabel myyearLabel = new JLabel("3");

	private Object[] columnNames = {"<html>YEAR</html>",
								  	"<html>TERM</html>",
								  	"<html>SUBJECT CODE</html>",
								  	"<html>SUBJECT TITLE</html>",
								  	"<html>LEC/LAB UNITS</html>",
								  	"<html>TOTAL UNITS</html>",
								  	"<html>SECTION</html>",
								  	"<html>SCHEDULE</html>",
								  	"<html>SELECT</html>",
								  	"<html>ASSIGN SECTION</html>"};
	
	private Object[][] rowNames = new Object[20][10];
	
	private JTable schedTable = new JTable(rowNames, columnNames);
	
	private JScrollPane schedPane = new JScrollPane(schedTable);
	
	public Enroll() 
	{

		//title
		setTitle("Enroll");
		setLayout(null);

		//Layout size and visibility
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//designs
		
		//table design
		schedTable.setEnabled(true);
		schedTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		schedTable.getTableHeader().setReorderingAllowed(false);
		schedTable.getTableHeader().setResizingAllowed(false);
		
		TableColumn columnwid = schedTable.getColumnModel().getColumn(0);
		columnwid.setPreferredWidth(42);
		columnwid = schedTable.getColumnModel().getColumn(1);
		columnwid.setPreferredWidth(42);
		columnwid = schedTable.getColumnModel().getColumn(2);
		columnwid.setPreferredWidth(60);
		columnwid = schedTable.getColumnModel().getColumn(3);
		columnwid.setPreferredWidth(90);
		columnwid = schedTable.getColumnModel().getColumn(4);
		columnwid.setPreferredWidth(57);
		columnwid = schedTable.getColumnModel().getColumn(5);
		columnwid.setPreferredWidth(48);
		columnwid = schedTable.getColumnModel().getColumn(6);
		columnwid.setPreferredWidth(60);
		columnwid = schedTable.getColumnModel().getColumn(7);
		columnwid.setPreferredWidth(85);
		columnwid = schedTable.getColumnModel().getColumn(8);
		columnwid.setPreferredWidth(43);
		columnwid = schedTable.getColumnModel().getColumn(9);
		columnwid.setPreferredWidth(52);
		
		//changing header height
		schedTable.getTableHeader().setPreferredSize(new Dimension(schedPane.getWidth(), 50));
		
		//change pic size
		Image img = profPics.getImage();
		Image sizedimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		picture = new JLabel(new ImageIcon(sizedimg));
		
		//adding contents
		add(picture);
		add(nameLabel);
		add(mynameLabel);
		add(courseLabel);
		add(mycourseLabel);
		add(yearLabel);
		add(myyearLabel);
		add(schedPane);
		
		//content positions
		picture.setBounds(680, 30, 100, 100);
		nameLabel.setBounds(20, 30, 80, 30);
		mynameLabel.setBounds(150, 30, 300, 30);
		courseLabel.setBounds(20, 60, 80, 30);
		mycourseLabel.setBounds(150, 60, 300, 30);
		yearLabel.setBounds(20, 90, 80, 30);
		myyearLabel.setBounds(150, 90, 300, 30);
		schedPane.setBounds(20, 150, 760, 300);
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
		
		Enroll enroll = new Enroll();
		enroll.setVisible(true);
	}

}

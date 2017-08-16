package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableColumn;

public class Schedule extends JFrame
{
	private static final int HEIGHT = 500;
	private static final int WIDTH = 800;

	private JLabel code = new JLabel("Code:");
	private JLabel mycode = new JLabel("PHY 111");
	private JLabel name = new JLabel("Name:");
	private JLabel myname = new JLabel("Physics 1");
	private JLabel units = new JLabel("Units:");
	private JLabel myunits = new JLabel("2.0");
	
	private JButton proceedButton = new JButton("Proceed");
	
	private Object[] columnNames = {"<html>SECTION (ROOM #)</html>",
								  	"<html>SCHEDULE (DAY/TIME)</html>",
								  	"<html>COURSE OFFERING THE SUBJECT</html>",
								  	"<html>MAX. NO. OF STUDENTS</html>",
								  	"<html>NO. OF STUDENTS ENROLLED</html>",
								  	"<html>STATUS</html>",
								  	"<html>SELECT</html>"};
	
	private Object[][] rowNames = new Object[20][7];
	
	private JTable schedTable = new JTable(rowNames, columnNames);
	
	private JScrollPane schedPane = new JScrollPane(schedTable);
	
	public Schedule() 
	{

		//title
		setTitle("Schedule");
		setLayout(null);

		//Layout size and visibility
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//designs
		proceedButton.setForeground(new Color(255, 255, 255));

		proceedButton.setBackground(new Color(40, 67, 181));
		
		//table design
		schedTable.setEnabled(true);
		schedTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		schedTable.getTableHeader().setReorderingAllowed(false);
		schedTable.getTableHeader().setResizingAllowed(false);
		
		TableColumn columnwid = schedTable.getColumnModel().getColumn(0);
		System.out.println(columnwid.getPreferredWidth());
		columnwid.setPreferredWidth(70);
		columnwid = schedTable.getColumnModel().getColumn(1);
		columnwid.setPreferredWidth(110);
		columnwid = schedTable.getColumnModel().getColumn(2);
		columnwid.setPreferredWidth(275);
		columnwid = schedTable.getColumnModel().getColumn(3);
		columnwid.setPreferredWidth(80);
		columnwid = schedTable.getColumnModel().getColumn(4);
		columnwid.setPreferredWidth(75);
		columnwid = schedTable.getColumnModel().getColumn(5);
		columnwid.setPreferredWidth(55);
		columnwid = schedTable.getColumnModel().getColumn(6);
		columnwid.setPreferredWidth(55);
		
		//changing header height
		schedTable.getTableHeader().setPreferredSize(new Dimension(schedPane.getWidth(), 50));
		
		//adding contents
		add(code);
		add(mycode);
		add(name);
		add(myname);
		add(units);
		add(myunits);
		add(proceedButton);
		add(schedPane);
		
		//content positions
		code.setBounds(20, 20, 100, 30);
		mycode.setBounds(55, 20, 100, 30);
		name.setBounds(300, 20, 100, 30);
		myname.setBounds(340, 20, 100, 30);
		units.setBounds(700, 20, 100, 30);
		myunits.setBounds(735, 20, 100, 30);
		proceedButton.setBounds(705, 65, 75, 30);
		schedPane.setBounds(20, 100, 760, 350);
		
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
		
		Schedule sched = new Schedule();
		sched.setVisible(true);
	}

}

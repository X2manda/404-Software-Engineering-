package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableColumn;

public class Enrolled extends JFrame
{
	private static final int HEIGHT = 500;
	private static final int WIDTH = 800;

	private JLabel term = new JLabel("ENROLLED SY-TERM:");
	private JLabel myterm = new JLabel("2017-2018-1st Semester");
	private JLabel maxunits = new JLabel("MAXIMUM UNITS FOR THIS SEMESTER :");
	private JLabel mymaxunits = new JLabel("25.0");
	private JLabel totalunits = new JLabel("TOTAL UNIT LOAD TAKEN :");
	private JLabel mytotalunits = new JLabel("25.0");
	
	private Object[] columnNames = {"<html>SUBJECT CODE</html>",
								  	"<html>SUBJECT TITLE</html>",
								  	"<html>LEC/LAB UNITS</html>",
								  	"<html>TOTAL UNITS</html>"};
	
	private Object[][] rowNames = new Object[20][4];
	
	private JTable schedTable = new JTable(rowNames, columnNames);
	
	private JScrollPane schedPane = new JScrollPane(schedTable);
	
	public Enrolled() 
	{

		//title
		setTitle("Enrolled");
		setLayout(null);

		//Layout size and visibility
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//designs
		term.setFont(new Font("Verdana", Font.BOLD, 20));
		myterm.setFont(new Font("Verdana", Font.BOLD, 20));
		
		//table design
		schedTable.setEnabled(true);
		schedTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		schedTable.getTableHeader().setReorderingAllowed(false);
		schedTable.getTableHeader().setResizingAllowed(false);
		
		TableColumn columnwid = schedTable.getColumnModel().getColumn(0);
		System.out.println(columnwid.getPreferredWidth());
		columnwid.setPreferredWidth(100);
		columnwid = schedTable.getColumnModel().getColumn(1);
		columnwid.setPreferredWidth(500);
		columnwid = schedTable.getColumnModel().getColumn(2);
		columnwid.setPreferredWidth(50);
		columnwid = schedTable.getColumnModel().getColumn(3);
		columnwid.setPreferredWidth(50);
		
		//changing header height
		schedTable.getTableHeader().setPreferredSize(new Dimension(schedPane.getWidth(), 50));
		
		//adding contents
		add(term);
		add(myterm);
		add(maxunits);
		add(mymaxunits);
		add(totalunits);
		add(mytotalunits);
		add(schedPane);
		
		//content positions
		term.setBounds(20, 20, 300, 30);
		myterm.setBounds(265, 20, 300, 30);
		maxunits.setBounds(20, 50, 250, 30);
		mymaxunits.setBounds(250, 50, 100, 30);
		totalunits.setBounds(595, 50, 250, 30);
		mytotalunits.setBounds(750, 50, 100, 30);
		schedPane.setBounds(20, 80, 760, 370);
		
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
		
		Enrolled enroll = new Enrolled();
		enroll.setVisible(true);
	}

}

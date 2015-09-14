package ee.student.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ee.student.model.Student;
import ee.student.model.StudentHandler;
import ee.student.parse.StudentParser;

public class StudentInfoSystemUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String[] columnNames = {"Name", "Grade averade"};
	
	private static JTable table;
	
	private static StudentHandler handler = new StudentHandler();
	
	public static void main(String[] args) {
		
		StudentInfoSystemUI system = new StudentInfoSystemUI();
		
		table = fillTable();
		
		JScrollPane scrollPane = new JScrollPane(table);
		system.add(scrollPane);
		system.setLayout(new BorderLayout());
		system.add(table.getTableHeader(), BorderLayout.PAGE_START);
		system.add(table, BorderLayout.CENTER);
		
		system.setDefaultCloseOperation(EXIT_ON_CLOSE);
		system.pack();
		system.setLocationRelativeTo(null);
		system.setVisible(true);
		
	}

	private static JTable fillTable() {
		handler.addAllStudents(StudentParser.getStudentsFromFile("resources/students_weighted.xml"));
		
		String[][] data = new String [handler.getStudents().size()][2];
		int i = 0;
		for (Student student : handler.getStudents())
		{
			data[i][0] = student.getName();
			data[i][1] = "" + handler.getAverageFor(student);
			i ++;
		}
		
		return new JTable (data, columnNames);
	}
	
}

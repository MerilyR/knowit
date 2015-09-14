package ee.student.parse;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ee.student.model.Student;

public class StudentParser {

	public static List<Student> getStudentsFromFile (String file)
	{
		List<Student> students = new ArrayList<Student>();
		
		try{
			File fXmlFile = new File(file);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
					
			doc.getDocumentElement().normalize();
	
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
					
			NodeList studentList = doc.getElementsByTagName("student");
					
			System.out.println("----------------------------");
	
			for (int i = 0; i < studentList.getLength(); i++) {
				Student newStudent = new Student();
				Node studentNode = studentList.item(i);
						
				System.out.println("\nCurrent Element :" + studentNode.getNodeName());
						
				if (studentNode.getNodeType() == Node.ELEMENT_NODE) {
	
					Element studentElement = (Element) studentNode;
					String name = studentElement.getElementsByTagName("name").item(0).getTextContent();
					newStudent.setName(name);
					
					System.out.println("Name : " + name);
					
					List<Integer> grades = new ArrayList<Integer>();
					NodeList gradeList = studentElement.getElementsByTagName("grade");
					
					for (int j = 0; j < gradeList.getLength(); j++ )
					{
						Element gradeElement = (Element) gradeList.item(j);
						int grade = Integer.parseInt(gradeElement.getTextContent());
						grades.add(grade);
						
						System.out.println("Grade : " + grade);
												
					}
					newStudent.setGrades(grades);	
				}
				students.add(newStudent);
			}
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
		
		return students;
	}
	
}

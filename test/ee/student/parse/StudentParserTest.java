package ee.student.parse;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import ee.student.model.Student;
import ee.student.model.StudentHandler;

public class StudentParserTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_1() {
		StudentHandler handler = new StudentHandler();
		List<Student> students = StudentParser.getStudentsFromFile("resources/student_grades_equal_test_1.xml");
		
		handler.addStudent(students.get(0));
		
		Student student = new Student();
		student.setName("Peeter");
				
		assertEquals (student.getName(), students.get(0).getName());
	}
	
	@Test
	public void test_2() {
		StudentHandler handler = new StudentHandler();
		List<Student> students = StudentParser.getStudentsFromFile("resources/student_grades_equal_test_2.xml");
		
		for (Student student : students)
			handler.addStudent(student);
				
		assertEquals (3, handler.getStudents().size());
	}

}

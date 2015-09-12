package ee.student.model;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StudentHandlerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		StudentHandler handler = new StudentHandler();
		
		Student first = new Student();
		first.setName("First");
		first.setGrades(Arrays.asList(5, 4, 3));
		
		Student second = new Student();
		second.setName("Second");
		second.setGrades(Arrays.asList(5, 4, 3));
		
		Student third = new Student();
		third.setName("First");
		third.setGrades(Arrays.asList(4, 4, 3));
		
		List<Student> students = handler.getStudents();
		
		handler.addStudent(first);
		assertTrue (students.indexOf(first) == 0);
		handler.addStudent(second);
		assertTrue (students.indexOf(first) == 0 && students.indexOf(second) == 1);
		handler.addStudent(third);
		assertTrue (students.indexOf(first) == 1 &&
					students.indexOf(second) == 2 &&
					students.indexOf(third) == 0 );
		
	}

}

package ee.student.model;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//		first.setGrades(Arrays.asList(5, 4, 3)); //old test
		Map<Integer, Integer> gradeMap = new HashMap<Integer, Integer>();
		gradeMap.put(5, 1);
		gradeMap.put(4, 1);
		gradeMap.put(3, 1);
		first.setGrades(gradeMap);
		
		Student second = new Student();
		second.setName("Second");
//		second.setGrades(Arrays.asList(5, 4, 3)); //old test
		gradeMap = new HashMap<Integer, Integer>();
		gradeMap.put(5, 1);
		gradeMap.put(4, 1);
		gradeMap.put(3, 1);
		second.setGrades(gradeMap);
		
		Student third = new Student();
		third.setName("First");
//		third.setGrades(Arrays.asList(4, 4, 3)); //old test
		gradeMap = new HashMap<Integer, Integer>();
		gradeMap.put(4, 1);
		gradeMap.put(4, 1);
		gradeMap.put(3, 1);
		third.setGrades(gradeMap);		
		
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

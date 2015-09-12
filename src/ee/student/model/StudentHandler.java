package ee.student.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ee.student.calculator.WeightedAverageCalculator;

public class StudentHandler {

	private List<Student> students = new ArrayList<Student>();
	private Comparator<Student> studentComparator = new Comparator<Student> () {
		
		@Override
		public int compare(Student first, Student second) {
			int firstAverage = WeightedAverageCalculator.getWeightedAverage(first.getGrades());
			int secondAverage = WeightedAverageCalculator.getWeightedAverage(second.getGrades());
			
			if (firstAverage != secondAverage)
				return Integer.compare (firstAverage, secondAverage);
			
			return first.getName().compareTo(second.getName());
		}
	};
	
	public List<Student> getStudents()
	{
		return students;
	}
	
	public void addStudent(Student newstudent)
	{
		students.add(newstudent);
		Collections.sort(students, studentComparator);
	}
	
}

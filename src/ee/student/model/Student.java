package ee.student.model;

import java.util.Map;

public class Student {
	private String name;
	
	private Map<Integer, Integer> grades;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Integer, Integer> getGrades() {
		return grades;
	}

	public void setGrades(Map<Integer, Integer> grades) {
		this.grades = grades;
	}
	
	
}

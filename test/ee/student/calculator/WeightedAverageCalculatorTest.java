package ee.student.calculator;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WeightedAverageCalculatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testList() {
		List<Integer> data = Arrays.asList(5, 5, 4, 4, 3, 3);
		int average = (5*2+4*2+3*2)/6;
		System.out.println("Test1.1: average = "+average);
		assertEquals (average, WeightedAverageCalculator.getWeightedAverage(data));
		
		data = Arrays.asList (5, 5, 5, 4, 4, 3);
		average = (5*3+4*2+3*1)/6;
		System.out.println("Test1.2: average = "+average);
		assertEquals (average, WeightedAverageCalculator.getWeightedAverage(data));
		
	}
	
	@Test
	public void testMap() {
		Map<Integer, Integer> data = new HashMap<Integer, Integer>();
		data.put(5, 25);
		data.put(4, 50);
		data.put(3, 25);
		int average = (5*25+4*50+3*25)/100;
		System.out.println("Test2.1: average = "+average);
		assertEquals (average, WeightedAverageCalculator.getWeightedAverage(data));
		
		data.clear();
		data.put(5, 25);
		data.put(4, 25);
		data.put(3, 50);
		average = (5*25+4*25+3*50)/100;
		System.out.println("Test2.2: average = "+average);
		assertEquals (average, WeightedAverageCalculator.getWeightedAverage(data));
		
	}

}

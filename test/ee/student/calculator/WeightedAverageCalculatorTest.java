package ee.student.calculator;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

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
	public void test() {
		List<Integer> data = Arrays.asList(5, 5, 4, 4, 3, 3);
		int average = (5*2+4*2+3*2)/6;
		assertEquals (WeightedAverageCalculator.getWeightedAverage(data),  average);
		
		data = Arrays.asList (5, 5, 5, 4, 4, 3);
		average = (5*3+4*2+3*1)/6;
		assertEquals (WeightedAverageCalculator.getWeightedAverage(data),  average);
		
	}

}

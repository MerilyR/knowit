package ee.student.calculator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedAverageCalculator {
	public static int getWeightedAverage (List<Integer> values) 
	{
		Map<Integer, Integer> valueMap = new HashMap<Integer, Integer>();
		
		/**
		 * Counting distinct values
		 * 
		 * if value appears for the first time, put value to map
		 * if not the first time, add to the weight
		 */
		for (int value : values) {
			if (!valueMap.containsKey(value))
				
				valueMap.put(value, 1);
			else
				valueMap.replace(value, valueMap.get(value)+1);
		}
		
//		/**
//		 * Check that the sum of weights equals to total weight
//		 * 
//		 * TODO> used only while constructing the calculating algorithm
//		 */
//		
//		int sumOfWeights = 0;
//		for (int weight : valueMap.values())
//			sumOfWeights += weight;
//		
//		System.out.println("sum "+sumOfWeights+
//							" == total "+ values.size()+
//							"--> "+(sumOfWeights==values.size()));
//		
		int average = 0;
		/**
		 * Average
		 * sum of ( each grade * weight ) 
		 * divided by total weight 
		 */
		
		int sum = 0;
		for (int grade : valueMap.keySet()) {
			int weight = valueMap.get(grade);
			sum += grade*weight;
		}
		
		average = sum / values.size();
		
		return average;
		
	}

}
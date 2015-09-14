package ee.student.calculator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedAverageCalculator {
	
	/**
	 * method calculates a weighted average for values with equal weight
	 * @param values
	 * @return weighted average
	 */
	
	public static double getWeightedAverage (List<Integer> values) 
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
		return getWeightedAverage(valueMap);
		
	}
	
	/**
	 * calculates a weighted average for values with different weight
	 * @param valueMap - map of values where key is value to be weighted and value is the weight
	 * @return weighted average
	 */
	
	public static double getWeightedAverage (Map<Integer, Integer> valueMap) {
		double average = 0;
		/**
		 * Average
		 * sum of ( each grade * weight ) 
		 * divided by total weight 
		 */
		
		double sum = 0;
		double totalweight = 0;
		for (int grade : valueMap.keySet()) {
			int weight = valueMap.get(grade);
			sum += grade*weight;
			totalweight += weight;
		}
		
		average = sum / totalweight;
		
		return average;
	}

}

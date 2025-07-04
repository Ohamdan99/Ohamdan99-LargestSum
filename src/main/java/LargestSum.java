import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class LargestSum {
    /**
     * Get the largest possible sum that can be obtained from a pair of values in the list.
     * A number can't be added to itself, unless there are duplicates.
     * 
     * @param nums a list of ints.
     * @return the largest possible sum of separate numbers from nums.
     */
    public int bigSum(List<Integer> nums) {
        if (nums == null || nums.size() < 2) {
            return 0;
        }
        
        // Count frequency of each number
        Map<Integer, Integer> frequency = new HashMap<>();
        for (Integer num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        
        int maxSum = Integer.MIN_VALUE;
        
        // Check all possible pairs
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                int num1 = nums.get(i);
                int num2 = nums.get(j);
                
                // If numbers are the same, check if we have duplicates
                if (num1 == num2) {
                    if (frequency.get(num1) >= 2) {
                        maxSum = Math.max(maxSum, num1 + num2);
                    }
                } else {
                    // Different numbers can always be added
                    maxSum = Math.max(maxSum, num1 + num2);
                }
            }
        }
        
        return maxSum == Integer.MIN_VALUE ? 0 : maxSum;
    }
}
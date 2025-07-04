import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

public class LargestSum {
    /**
     * Get the largest possible sum that can be obtained from a pair of values in the list. A number can't be added
     * to itself, unless there are duplicates.
     *
     * @param nums a list of ints.
     * @return the largest possible sum of separate numbers from nums.
     */
    public int bigSum(List<Integer> nums) {
        if (nums == null || nums.size() < 2) {
            return 0;
        }
        
        // Create a copy and sort in descending order
        List<Integer> sortedNums = new ArrayList<>(nums);
        Collections.sort(sortedNums, Collections.reverseOrder());
        
        // The largest sum will be the sum of the two largest numbers
        return sortedNums.get(0) + sortedNums.get(1);
    }
}
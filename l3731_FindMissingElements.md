# 3731. Find Missing Elements

**LeetCode Problem:** [Find Missing Elements](https://leetcode.com/problems/find-missing-elements/)

## Approach

The approach used in this solution involves finding the minimum and maximum values in the input array to determine the range of numbers, then iterating through this range to identify any missing elements. This is achieved by maintaining a set of numbers present in the array and checking for each number in the range if it exists in the set.

Here's a step-by-step breakdown of the logic:
1. **Step 1**: Initialize variables to keep track of the maximum and minimum values encountered in the array, and create an empty set to store unique numbers from the array.
2. **Step 2**: Iterate through the input array to find the maximum and minimum values and populate the set with numbers from the array.
3. **Step 3**: Create a result list to store missing elements and iterate through the range from the minimum to the maximum value found.
4. **Step 4**: For each number in the range, check if it is present in the set. If not, add it to the result list as a missing element.

- **Time Complexity**: The time complexity of this solution is O(n^2) due to the `contains` method used in the second loop, which has a linear time complexity. However, if a `HashSet` were used instead of an `ArrayList` for the set, the time complexity would improve to O(n) because `contains` in a `HashSet` is O(1) on average.
- **Space Complexity**: The space complexity is O(n) as in the worst-case scenario, all elements from the input array are stored in the set, and potentially all numbers in the range could be missing, leading to a result list of size n.

## Dry Run

Let's consider the input array `[0, 1, 3, 5]`. Here's how the execution would look:

| Step number | Current state of variables | Action taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `max = 0`, `min = 0`, `set = []` | Initialize variables and start iterating through the array | `max = 0`, `min = 0`, `set = [0]` |
| 2 | `max = 0`, `min = 0`, `set = [0]` | Iterate through the array, update `max` and `min`, and add to set | `max = 5`, `min = 0`, `set = [0, 1, 3, 5]` |
| 3 | `max = 5`, `min = 0`, `set = [0, 1, 3, 5]` | Initialize result list and start checking for missing numbers | `result = []` |
| 4 | `result = []` | Check for missing numbers from `min` to `max` | `result = [2, 4]` |

At the end of the execution, the result list contains the missing elements `[2, 4]`.
## Code
```java
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        ArrayList<Integer> set = new ArrayList<>();

        for(int i =0; i<nums.length; i++){
            if(nums[i] > max) max=nums[i];
            if(nums[i] < min) min=nums[i];
            set.add(nums[i]);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for(int i = min; i<max; i++){
            if(!set.contains(i)){
                result.add(i);
            }
        }
        return result;
    }
}
```
# 1. Two Sum

**LeetCode Problem:** [Two Sum](https://leetcode.com/problems/two-sum/)

## Approach
The approach to solving the "Two Sum" problem involves using a HashMap to store the numbers in the array as keys and their indices as values, allowing for efficient lookups of the complement of each number with respect to the target sum. This approach enables us to find the two numbers that add up to the target sum in a single pass through the array.

Here is a step-by-step breakdown of the logic:
1. **Step 1**: Initialize an empty HashMap to store the numbers and their indices.
2. **Step 2**: Iterate through the array, and for each number, calculate its complement with respect to the target sum.
3. **Step 3**: Check if the complement is already in the HashMap, indicating that we have found two numbers that add up to the target sum.
4. **Step 4**: If the complement is not in the HashMap, add the current number and its index to the HashMap.
5. **Step 5**: If the loop completes without finding a pair of numbers that add up to the target sum, return a default value indicating that no solution was found.

- **Time Complexity**: The time complexity of this approach is O(n), where n is the length of the input array, because we perform a constant amount of work for each element in the array.
- **Space Complexity**: The space complexity is also O(n), because in the worst case, we may need to store every element in the HashMap.

## Dry Run
Let's consider the example input `nums = [2, 7, 11, 15]` and `target = 9`. Here's how the algorithm would execute:

| Step number | Current state of variables | Action taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `map = {}`, `i = 0`, `nums[0] = 2` | Calculate complement: `9 - 2 = 7` | `map = {}` |
| 2 | `map = {}`, `i = 0`, `complement = 7` | Check if complement is in map: `map.containsKey(7) = false` | `map = {2=0}` |
| 3 | `map = {2=0}`, `i = 1`, `nums[1] = 7` | Calculate complement: `9 - 7 = 2` | `map = {2=0}` |
| 4 | `map = {2=0}`, `i = 1`, `complement = 2` | Check if complement is in map: `map.containsKey(2) = true` | `return [0, 1]` |

The algorithm returns `[0, 1]`, indicating that the numbers at indices 0 and 1 in the input array add up to the target sum.
## Code
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i =0; i<nums.length; i++){
            int memory = target - nums[i];

            if(map.containsKey(memory)){
                return new int[]{map.get(memory),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}
```
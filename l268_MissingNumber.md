# 268. Missing Number

**LeetCode Problem:** [Missing Number](https://leetcode.com/problems/missing-number/)

## Approach
The approach used to solve the "Missing Number" problem is based on the mathematical formula for the sum of an arithmetic series. By initializing the `missing` variable to `nums.length` and then adding the difference between each index `i` and the corresponding value `nums[i]`, we effectively calculate the missing number in the sequence.

Here's a step-by-step breakdown of the logic:
1. **Step 1**: Initialize the `missing` variable to `nums.length`, which represents the expected sum of the sequence if it were complete.
2. **Step 2**: Iterate over the input array `nums`, and for each index `i`, calculate the difference between `i` and the corresponding value `nums[i]`.
3. **Step 3**: Add the difference calculated in Step 2 to the `missing` variable, effectively accumulating the differences between the expected and actual values.
4. **Step 4**: After iterating over the entire array, return the final value of `missing`, which represents the missing number in the sequence.

- **Time Complexity**: The time complexity of this solution is O(n), where n is the length of the input array, since we only need to iterate over the array once.
- **Space Complexity**: The space complexity is O(1), as we only use a constant amount of space to store the `missing` variable and the loop index `i`.

## Dry Run
Let's take the input array `nums = [0, 1, 3]` as an example. The expected output is `2`, which is the missing number in the sequence.

| Step number | Current state of variables | Action taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `missing = 3`, `i = 0`, `nums = [0, 1, 3]` | Initialize `missing` to `nums.length` | `missing = 3` |
| 2 | `missing = 3`, `i = 0`, `nums[i] = 0` | Calculate `i - nums[i] = 0 - 0 = 0` and add to `missing` | `missing = 3 + 0 = 3` |
| 3 | `missing = 3`, `i = 1`, `nums[i] = 1` | Calculate `i - nums[i] = 1 - 1 = 0` and add to `missing` | `missing = 3 + 0 = 3` |
| 4 | `missing = 3`, `i = 2`, `nums[i] = 3` | Calculate `i - nums[i] = 2 - 3 = -1` and add to `missing` | `missing = 3 + (-1) = 2` |
| 5 | `missing = 2` | Return the final value of `missing` | `Output = 2` |
## Code
```java
class Solution {
    public int missingNumber(int[] nums) {
        int missing = nums.length;

        for(int i = 0; i < nums.length; i++){
            missing += i - nums[i];
        }

        return missing;
    }
}
```
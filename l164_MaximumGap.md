# 164. Maximum Gap

**LeetCode Problem:** [Maximum Gap](https://leetcode.com/problems/maximum-gap/)

## Approach

The approach to solving the "Maximum Gap" problem involves sorting the input array and then iterating through it to find the maximum difference between any two adjacent elements. This is a straightforward method that takes advantage of the fact that the maximum gap must occur between two elements in the sorted array.

Here's a step-by-step breakdown of the logic:
1. **Step 1**: Sort the input array in ascending order to ensure that adjacent elements are compared.
2. **Step 2**: Initialize a variable `max` to store the maximum gap found so far, starting with a value of 0.
3. **Step 3**: Iterate through the sorted array, starting from the second element (index 1).
4. **Step 4**: For each element, calculate the gap between the current element and the previous element.
5. **Step 5**: If the calculated gap is greater than the current `max`, update `max` with the new gap value.
6. **Step 6**: After iterating through the entire array, return the `max` value, which represents the maximum gap.

- **Time Complexity**: The time complexity of this approach is O(n log n) due to the sorting operation, where n is the number of elements in the input array.
- **Space Complexity**: The space complexity is O(1) if the sorting is done in-place, or O(n) if a new sorted array is created, depending on the implementation of the sorting algorithm.

## Dry Run

Let's consider an example input: `nums = [3, 6, 9, 1]`.

Here's the execution of the algorithm in a structured table format:

| Step Number | Current State of Variables | Action Taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `nums = [3, 6, 9, 1]` | Sort the array | `nums = [1, 3, 6, 9]` |
| 2 | `nums = [1, 3, 6, 9]`, `max = 0` | Initialize `max` | `max = 0` |
| 3 | `nums = [1, 3, 6, 9]`, `max = 0`, `i = 1` | Compare `nums[1]` and `nums[0]` | `gap = 2`, `max = 2` |
| 4 | `nums = [1, 3, 6, 9]`, `max = 2`, `i = 2` | Compare `nums[2]` and `nums[1]` | `gap = 3`, `max = 3` |
| 5 | `nums = [1, 3, 6, 9]`, `max = 3`, `i = 3` | Compare `nums[3]` and `nums[2]` | `gap = 3`, `max = 3` |
| 6 | `nums = [1, 3, 6, 9]`, `max = 3` | Return `max` | `max = 3` |

The final output is `3`, which is the maximum gap between any two adjacent elements in the sorted array.
## Code
```java
class Solution {
    public int maximumGap(int[] nums) {
        int max=0;
        Arrays.sort(nums);
        for(int i =1; i<nums.length; i++){
            if(max<nums[i]-nums[i-1]){
                max=nums[i]-nums[i-1];
            }
        }

        return max;
    }
}
```
# 561. Array Partition

**LeetCode Problem:** [Array Partition](https://leetcode.com/problems/array-partition/)

## Approach
The approach to solving the "Array Partition" problem involves sorting the input array and then summing up the smaller elements of each pair. This is based on the fact that the sum of the smaller elements of each pair is minimized when the array is sorted.

Here's a step-by-step breakdown of the logic:
1. **Step 1**: The input array is sorted in ascending order to arrange the elements in a way that the smaller elements are paired with the larger elements.
2. **Step 2**: Initialize a variable `result` to store the sum of the smaller elements of each pair, which is initially set to 0.
3. **Step 3**: Iterate through the sorted array with a step size of 2, starting from the first element (index 0).
4. **Step 4**: In each iteration, add the current element (which is the smaller element of the pair) to the `result`.

- **Time Complexity**: The time complexity of this solution is O(n log n) due to the sorting operation, where n is the number of elements in the input array.
- **Space Complexity**: The space complexity is O(1) if the sorting is done in-place, or O(n) if a new sorted array is created, where n is the number of elements in the input array.

## Dry Run
Let's take the example input `nums = [1, 4, 3, 2]`. Here's the step-by-step execution:

| Step number | Current state of variables | Action taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `nums = [1, 4, 3, 2]` | Sort the array | `nums = [1, 2, 3, 4]` |
| 2 | `nums = [1, 2, 3, 4]`, `result = 0` | Initialize `result` to 0 | `result = 0` |
| 3 | `nums = [1, 2, 3, 4]`, `result = 0`, `i = 0` | Add `nums[0]` to `result` | `result = 1` |
| 4 | `nums = [1, 2, 3, 4]`, `result = 1`, `i = 2` | Add `nums[2]` to `result` | `result = 1 + 3 = 4` |
| 5 | `nums = [1, 2, 3, 4]`, `result = 4` | Return `result` | `Output = 4` |

The final output is `4`, which is the sum of the smaller elements of each pair in the sorted array.
## Code
```java
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result=0;
        for(int i = 0;i<nums.length;i+=2)
        {
            result+=nums[i];
        }
        return result;
    }
}
```
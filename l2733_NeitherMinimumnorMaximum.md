# 2733. Neither Minimum nor Maximum

**LeetCode Problem:** [Neither Minimum nor Maximum](https://leetcode.com/problems/neither-minimum-nor-maximum/)

## Approach
The approach to solving the "Neither Minimum nor Maximum" problem involves checking each of the first three elements in the array to determine if it is neither the minimum nor the maximum of the three. This is done through a series of conditional statements that compare the values of the elements.

Here is a step-by-step breakdown of the logic:
1. **Step 1**: Check if the length of the input array is less than or equal to 2, in which case the function returns -1, as there are not enough elements to determine a value that is neither minimum nor maximum.
2. **Step 2**: Assign the values of the first three elements in the array to the variables `a`, `b`, and `c`.
3. **Step 3**: Compare the values of `a`, `b`, and `c` to determine if `a` is neither the minimum nor the maximum, and return `a` if this condition is met.
4. **Step 4**: If `a` is not neither the minimum nor the maximum, compare the values to determine if `b` is neither the minimum nor the maximum, and return `b` if this condition is met.
5. **Step 5**: If neither `a` nor `b` is neither the minimum nor the maximum, return `c`, as it must be neither the minimum nor the maximum by process of elimination.

- **Time Complexity**: The time complexity of this solution is O(1), as it only involves a constant number of operations, regardless of the size of the input array.
- **Space Complexity**: The space complexity of this solution is also O(1), as it only uses a constant amount of space to store the variables `a`, `b`, and `c`.

## Dry Run
Let's use the input array `[5, 3, 7]` as an example to demonstrate the algorithm.

| Step Number | Current State of Variables | Action Taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `nums = [5, 3, 7]` | Check if length of `nums` is less than or equal to 2 | Length is 3, proceed to next step |
| 2 | `nums = [5, 3, 7]` | Assign `a = 5`, `b = 3`, `c = 7` | `a = 5`, `b = 3`, `c = 7` |
| 3 | `a = 5`, `b = 3`, `c = 7` | Check if `a` is neither minimum nor maximum | `5` is neither `3` nor `7`, return `5` |
| 4 | `a = 5`, `b = 3`, `c = 7` | (Not reached, as `a` is returned in step 3) | - |
| 5 | `a = 5`, `b = 3`, `c = 7` | (Not reached, as `a` is returned in step 3) | - |

The output of the algorithm for the input array `[5, 3, 7]` is `5`, which is neither the minimum (`3`) nor the maximum (`7`) of the three elements.
## Code
```java
class Solution {
    public int findNonMinOrMax(int[] nums) {
        if(nums.length <= 2) return -1;

        int a = nums[0];
        int b = nums[1];
        int c = nums[2];

        if((a>b && a<c) || (a<b && a>c))
            return a;
        else if((b>a && b<c) || (b<a && b>c))
            return b;
        else
            return c;

    }
}
```
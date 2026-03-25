# 238. Product of Array Except Self

**LeetCode Problem:** [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)

## Approach

The approach used to solve the "Product of Array Except Self" problem involves calculating the product of all numbers to the right of each index and then multiplying it with the product of all numbers to the left. This is achieved in two passes: one from left to right to calculate the product of all numbers to the left, and another from right to left to calculate the product of all numbers to the right and update the result.

Here's a step-by-step breakdown of the logic:
1. **Step 1**: Initialize an array `right` of the same length as the input array `nums`, where `right[i]` will store the product of all numbers to the left of index `i`. The first element of `right` is set to 1, as there are no numbers to the left of the first index.
2. **Step 2**: Iterate through the `nums` array from left to right, updating the `right` array at each step. For each index `i`, calculate the product of all numbers to the left by multiplying the previous product (`right[i-1]`) with the number at the previous index (`nums[i-1]`).
3. **Step 3**: Initialize a variable `result` to 1, which will store the product of all numbers to the right of the current index.
4. **Step 4**: Iterate through the `nums` array from right to left, updating the `right` array at each step. For each index `i`, multiply the current product of all numbers to the left (`right[i]`) with the product of all numbers to the right (`result`), and update `result` by multiplying it with the number at the current index (`nums[i]`).

- **Time Complexity**: The time complexity of this solution is O(n), where n is the length of the input array, as it involves two passes through the array.
- **Space Complexity**: The space complexity of this solution is O(1), excluding the space required for the output array, as it only uses a constant amount of extra space to store the `result` variable and other variables.

## Dry Run

Let's take the example input `nums = [1, 2, 3, 4]`. Here's the step-by-step execution:

| Step number | Current state of variables | Action taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `n = 4`, `right = [0, 0, 0, 0]` | Initialize `right[0] = 1` | `right = [1, 0, 0, 0]` |
| 2 | `i = 1`, `right[0] = 1`, `nums[0] = 1` | Calculate `right[1] = right[0] * nums[0] = 1 * 1 = 1` | `right = [1, 1, 0, 0]` |
| 3 | `i = 2`, `right[1] = 1`, `nums[1] = 2` | Calculate `right[2] = right[1] * nums[1] = 1 * 2 = 2` | `right = [1, 1, 2, 0]` |
| 4 | `i = 3`, `right[2] = 2`, `nums[2] = 3` | Calculate `right[3] = right[2] * nums[2] = 2 * 3 = 6` | `right = [1, 1, 2, 6]` |
| 5 | `i = 3`, `result = 1`, `nums[3] = 4` | Initialize `result` and calculate `right[3] = right[3] * result = 6 * 1 = 6`, update `result = result * nums[3] = 1 * 4 = 4` | `right = [1, 1, 2, 6]`, `result = 4` |
| 6 | `i = 2`, `right[2] = 2`, `result = 4`, `nums[2] = 3` | Calculate `right[2] = right[2] * result = 2 * 4 = 8`, update `result = result * nums[2] = 4 * 3 = 12` | `right = [1, 1, 8, 6]`, `result = 12` |
| 7 | `i = 1`, `right[1] = 1`, `result = 12`, `nums[1] = 2` | Calculate `right[1] = right[1] * result = 1 * 12 = 12`, update `result = result * nums[1] = 12 * 2 = 24` | `right = [1, 12, 8, 6]`, `result = 24` |
| 8 | `i = 0`, `right[0] = 1`, `result = 24`, `nums[0] = 1` | Calculate `right[0] = right[0] * result = 1 * 24 = 24`, update `result = result * nums[0] = 24 * 1 = 24` | `right = [24, 12, 8, 6]`, `result = 24` |

The final output is `[24, 12, 8, 6]`, which is the product of all numbers in the input array except for each index.
## Code
```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] right = new int[n];
        right[0] = 1;
        for(int i=1; i<n; i++){
            right[i] = right[i-1]*nums[i-1];
        }
        int result = 1;
        for(int i = n-1; i>=0; i--){
            right[i] = right[i]*result;
            result=result*nums[i];
        }

        return right;
    }
}
```
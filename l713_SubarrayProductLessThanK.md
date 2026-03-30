# 713. Subarray Product Less Than K

**LeetCode Problem:** [Subarray Product Less Than K](https://leetcode.com/problems/subarray-product-less-than-k/)

## Approach
The approach to solving the "Subarray Product Less Than K" problem involves using a nested loop to generate all possible subarrays and checking if the product of each subarray is less than the given number K. This is achieved by maintaining a running product of the subarray elements and incrementing a count whenever the product is less than K.

Here's a step-by-step breakdown of the logic:
1. **Initialization**: Initialize variables to keep track of the product of the current subarray and the count of subarrays with a product less than K.
2. **Outer Loop**: Iterate over the array to consider each element as a potential starting point for a subarray.
3. **Inner Loop**: For each starting point, iterate over the remaining elements to generate all possible subarrays.
4. **Product Calculation**: Calculate the product of the current subarray by multiplying the current product with the next element.
5. **Condition Check**: Check if the product of the current subarray is less than K. If it is, increment the count; otherwise, break the inner loop as further multiplication will exceed K.
6. **Result**: Return the total count of subarrays with a product less than K.

- **Time Complexity**: The time complexity of this solution is O(n^2), where n is the number of elements in the array. This is because for each element, we potentially iterate over the rest of the array.
- **Space Complexity**: The space complexity is O(1), as we only use a constant amount of space to store the product and count variables, regardless of the input size.

## Dry Run
Let's consider an example input: `nums = [10, 5, 2, 6]` and `k = 100`.

| Step Number | Current State of Variables | Action Taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `i = 0`, `product = 1`, `count = 0` | Start outer loop from `i = 0` | `product = 10`, `count = 1` (10 < 100) |
| 2 | `i = 0`, `j = 1`, `product = 10` | Multiply `product` by `nums[j]` (50) | `product = 50`, `count = 2` (50 < 100) |
| 3 | `i = 0`, `j = 2`, `product = 50` | Multiply `product` by `nums[j]` (100) | `product = 100`, break inner loop (100 ≥ 100) |
| 4 | `i = 1`, `product = 1`, `count = 2` | Start inner loop from `j = 1` | `product = 5`, `count = 3` (5 < 100) |
| 5 | `i = 1`, `j = 2`, `product = 5` | Multiply `product` by `nums[j]` (10) | `product = 10`, `count = 4` (10 < 100) |
| 6 | `i = 1`, `j = 3`, `product = 10` | Multiply `product` by `nums[j]` (60) | `product = 60`, `count = 5` (60 < 100) |
| 7 | `i = 2`, `product = 1`, `count = 5` | Start inner loop from `j = 2` | `product = 2`, `count = 6` (2 < 100) |
| 8 | `i = 2`, `j = 3`, `product = 2` | Multiply `product` by `nums[j]` (12) | `product = 12`, `count = 7` (12 < 100) |
| 9 | `i = 3`, `product = 1`, `count = 7` | Start inner loop from `j = 3` | `product = 6`, `count = 8` (6 < 100) |

The final output for `nums = [10, 5, 2, 6]` and `k = 100` is `8`.
## Code
```java
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int product, count = 0;

        for(int i =0; i<nums.length; i++){
            product=1;
            for(int j = i; j<nums.length; j++){
                product*=nums[j];
                if(product<k)count++;
                else break;
            }
        }

        return count;
    }
}
```
# 628. Maximum Product of Three Numbers

**LeetCode Problem:** [Maximum Product of Three Numbers](https://leetcode.com/problems/maximum-product-of-three-numbers/)

## Approach

The approach to solving the "Maximum Product of Three Numbers" problem involves iterating through the array to find the three largest numbers and the two smallest numbers. This is because the maximum product of three numbers can be either the product of the three largest numbers or the product of the two smallest numbers (which could be negative and thus give a large product when multiplied together) and the largest number.

Here's a step-by-step breakdown of the logic:
1. **Step 1**: Initialize variables to store the maximum and minimum values encountered so far. We need three variables for the maximum values (`max1`, `max2`, `max3`) and two variables for the minimum values (`min1`, `min2`).
2. **Step 2**: Iterate through each number in the input array. For each number, check if it's greater than the current `max1`. If it is, update `max3` to be the old `max2`, `max2` to be the old `max1`, and `max1` to be the current number.
3. **Step 3**: If the current number is not greater than `max1` but is greater than `max2`, update `max3` to be the old `max2` and `max2` to be the current number.
4. **Step 4**: If the current number is not greater than `max2` but is greater than `max3`, update `max3` to be the current number.
5. **Step 5**: Perform similar checks and updates for the minimum values (`min1` and `min2`).
6. **Step 6**: After iterating through all numbers, calculate the maximum product by comparing the product of the three largest numbers (`max1*max2*max3`) with the product of the two smallest numbers and the largest number (`min1*min2*max1`).

- **Time Complexity**: The time complexity of this solution is O(n), where n is the number of elements in the input array, because we're doing a single pass through the array.
- **Space Complexity**: The space complexity is O(1), because we're using a constant amount of space to store our variables, regardless of the size of the input array.

## Dry Run

Let's consider the input array `[1, 2, 3, 4, -5, -6]`. Here's how the algorithm would execute:

| Step number | Current state of variables | Action taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `max1 = Integer.MIN_VALUE`, `max2 = Integer.MIN_VALUE`, `max3 = Integer.MIN_VALUE`, `min1 = Integer.MAX_VALUE`, `min2 = Integer.MAX_VALUE` | Initialize variables | - |
| 2 | `max1 = 1`, `max2 = Integer.MIN_VALUE`, `max3 = Integer.MIN_VALUE`, `min1 = 1`, `min2 = Integer.MAX_VALUE` | Process number 1 | - |
| 3 | `max1 = 2`, `max2 = 1`, `max3 = Integer.MIN_VALUE`, `min1 = 1`, `min2 = Integer.MAX_VALUE` | Process number 2 | - |
| 4 | `max1 = 3`, `max2 = 2`, `max3 = 1`, `min1 = 1`, `min2 = Integer.MAX_VALUE` | Process number 3 | - |
| 5 | `max1 = 4`, `max2 = 3`, `max3 = 2`, `min1 = 1`, `min2 = Integer.MAX_VALUE` | Process number 4 | - |
| 6 | `max1 = 4`, `max2 = 3`, `max3 = 2`, `min1 = -5`, `min2 = 1` | Process number -5 | - |
| 7 | `max1 = 4`, `max2 = 3`, `max3 = 2`, `min1 = -6`, `min2 = -5` | Process number -6 | - |
| 8 | `max1 = 4`, `max2 = 3`, `max3 = 2`, `min1 = -6`, `min2 = -5` | Calculate maximum product | `max(4*3*2, -6*-5*4) = max(24, 120) = 120` |

The final result is `120`, which is the maximum product of three numbers in the input array.
## Code
```java
class Solution {
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int num : nums){
            if(num > max1){
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if(num > max2){
                max3 = max2;
                max2 = num;
            } else if(num > max3){
                max3 = num;
            }

            if(num < min1){
                min2 = min1;
                min1 = num;
            } else if(num < min2){
                min2 = num;
            }
        }

        return Math.max(max1*max2*max3,min1*min2*max1);
    }
}
```
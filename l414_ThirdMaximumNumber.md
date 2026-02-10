# 414. Third Maximum Number

**LeetCode Problem:** [Third Maximum Number](https://leetcode.com/problems/third-maximum-number/)

## Approach

The approach to solving the "Third Maximum Number" problem involves iterating through the input array and maintaining three variables to track the maximum, second maximum, and third maximum values encountered so far. The algorithm updates these variables based on comparisons with the current number being processed.

Here's a step-by-step breakdown:
1. **Step 1**: Initialize three variables, `firstMax`, `secondMax`, and `thirdMax`, to store the maximum, second maximum, and third maximum values, respectively, with initial values set to `Long.MIN_VALUE`.
2. **Step 2**: Iterate through each number in the input array, comparing it with the current `firstMax`, `secondMax`, and `thirdMax` values.
3. **Step 3**: If the current number is greater than `firstMax`, update `thirdMax` to the old `secondMax`, update `secondMax` to the old `firstMax`, and update `firstMax` to the current number.
4. **Step 4**: If the current number is less than `firstMax` but greater than `secondMax`, update `thirdMax` to the old `secondMax` and update `secondMax` to the current number.
5. **Step 5**: If the current number is less than `secondMax` but greater than `thirdMax`, update `thirdMax` to the current number.
6. **Step 6**: After iterating through all numbers, check if `thirdMax` is still `Long.MIN_VALUE`. If it is, return `firstMax` as the third maximum number; otherwise, return `thirdMax`.

- **Time Complexity**: The time complexity of this algorithm is O(n), where n is the number of elements in the input array, because it involves a single pass through the array.
- **Space Complexity**: The space complexity is O(1), as it uses a constant amount of space to store the maximum, second maximum, and third maximum values.

## Dry Run

Let's consider the input array `[3, 2, 1]`. Here's how the algorithm would execute:

| Step Number | Current State of Variables | Action Taken | Result/Output |
| --- | --- | --- | --- |
| 1 | firstMax = Long.MIN_VALUE, secondMax = Long.MIN_VALUE, thirdMax = Long.MIN_VALUE | Initialize variables | - |
| 2 | firstMax = 3, secondMax = Long.MIN_VALUE, thirdMax = Long.MIN_VALUE | Update firstMax to 3 | - |
| 3 | firstMax = 3, secondMax = 2, thirdMax = Long.MIN_VALUE | Update secondMax to 2 | - |
| 4 | firstMax = 3, secondMax = 2, thirdMax = 1 | Update thirdMax to 1 | - |
| 5 | firstMax = 3, secondMax = 2, thirdMax = 1 | Finished iterating, thirdMax is not Long.MIN_VALUE | Return thirdMax = 1 |

In this example, the algorithm correctly identifies the third maximum number as 1.
## Code
```java
class Solution {
    public int thirdMax(int[] nums) {
        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;

        for(int num : nums){
            if(num > firstMax){
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax =  num;
            } else if(firstMax > num && num > secondMax){
                thirdMax = secondMax;
                secondMax = num;
            } else if(secondMax > num && num > thirdMax){
                thirdMax = num;
            }
        }

        return thirdMax != Long.MIN_VALUE ? (int) thirdMax : (int) firstMax;
    }
}
```
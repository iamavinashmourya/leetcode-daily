# 268. Missing Number

**LeetCode Problem:** [Missing Number](https://leetcode.com/problems/missing-number/)

## Approach
The approach to solving the "Missing Number" problem involves calculating the sum of all numbers in the array and then subtracting this sum from the sum of all numbers that should be in the array if it were complete. This difference gives us the missing number. The algorithm uses the formula for the sum of an arithmetic series to calculate the sum of all numbers that should be in the array.

Here's a step-by-step breakdown:
1. **Step 1**: Initialize a variable `sum` to store the sum of all numbers in the input array `arr`.
2. **Step 2**: Iterate through the input array `arr` and add each number to the `sum`.
3. **Step 3**: Calculate the sum of all numbers that should be in the array if it were complete, using the formula `n*(n+1)/2`, where `n` is the length of the input array.
4. **Step 4**: Calculate the missing number by subtracting the sum of the numbers in the array from the sum of all numbers that should be in the array.

- **Time Complexity**: The time complexity of this solution is O(n), where n is the length of the input array, because we are iterating through the array once.
- **Space Complexity**: The space complexity of this solution is O(1), because we are using a constant amount of space to store the sum and the missing number.

## Dry Run
Let's take the input array `[0, 1, 3]` as an example. Here's how the algorithm would execute:

| Step number | Current state of variables | Action taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `sum = 0`, `arr = [0, 1, 3]` | Initialize `sum` to 0 | `sum = 0` |
| 2 | `sum = 0`, `arr = [0, 1, 3]` | Iterate through `arr` and add each number to `sum` | `sum = 0 + 0 + 1 + 3 = 4` |
| 3 | `sum = 4`, `arr = [0, 1, 3]` | Calculate the sum of all numbers that should be in the array | `result = 3*(3+1)/2 = 6` |
| 4 | `sum = 4`, `result = 6` | Calculate the missing number by subtracting `sum` from `result` | `fin = 6 - 4 = 2` |

The final output of the algorithm would be `2`, which is the missing number in the input array `[0, 1, 3]`.
## Code
```java
class Solution {
    public int missingNumber(int[] arr) {
        
        int sum = 0;
        for(int i =0;i<arr.length;i++)
        {
            sum+=arr[i];
        }

        int n = arr.length;
        int result = n*(n+1)/2;
        int fin = result - sum;

        return fin;

    }
}
```
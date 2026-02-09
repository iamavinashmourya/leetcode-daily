# 263. Ugly Number

**LeetCode Problem:** [Ugly Number](https://leetcode.com/problems/ugly-number/)

## Approach
The approach involves iteratively dividing the input number by its prime factors (2, 3, and 5) until it is no longer divisible. This process checks if the number can be reduced to 1, which is the definition of an ugly number.

Here's a step-by-step breakdown:
1. **Step 1**: Initialize a loop that iterates over the prime factors 2, 3, and 5.
2. **Step 2**: For each prime factor, continuously divide the input number `n` as long as it is divisible by the current factor.
3. **Step 3**: After checking all prime factors, verify if the resulting number `n` is equal to 1.

- **Time Complexity**: The time complexity is O(log n) because in the worst-case scenario, we are dividing the number `n` by its smallest prime factor (2) until it is no longer divisible.
- **Space Complexity**: The space complexity is O(1) since we are only using a constant amount of space to store the variables.

## Dry Run
Let's consider the example input `n = 6`. Here's the execution in a structured table format:

| Step Number | Current State of Variables | Action Taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `n = 6`, `i = 2` | Check if `n` is divisible by `i` | `n` is divisible by `i` |
| 2 | `n = 6`, `i = 2` | Divide `n` by `i` | `n = 3` |
| 3 | `n = 3`, `i = 3` | Check if `n` is divisible by `i` | `n` is divisible by `i` |
| 4 | `n = 3`, `i = 3` | Divide `n` by `i` | `n = 1` |
| 5 | `n = 1`, `i = 4` | Loop ends because `i > 5` | - |
| 6 | `n = 1` | Check if `n` is equal to 1 | `n` is equal to 1, so the number is ugly |

The output of this dry run is `true`, indicating that the input number `6` is an ugly number.
## Code
```java
class Solution {
    public boolean isUgly(int n) {
        for(int i=2; i<=5 && n>1; i++){
            while(n % i == 0){
                n /= i;
            }
        }

        return n == 1;
    }
}
```
# 2520. Count the Digits That Divide a Number

**LeetCode Problem:** [Count the Digits That Divide a Number](https://leetcode.com/problems/count-the-digits-that-divide-a-number/)

## Approach

This solution solves the "Count the Digits That Divide a Number" problem.

**Time Complexity:** To be analyzed
**Space Complexity:** To be analyzed

*(AI explanation generation failed, please add details manually)*

## Code
```java
class Solution {
    public int countDigits(int num) {
        int count = 0;
        int n = num;

        while(n != 0){
            int val = n % 10;
            if(num % val == 0){
                count++;
            }
            n /= 10;
        }

        return count;
    }
}
```
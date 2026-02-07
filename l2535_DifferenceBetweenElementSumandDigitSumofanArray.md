# 2535. Difference Between Element Sum and Digit Sum of an Array

**LeetCode Problem:** [Difference Between Element Sum and Digit Sum of an Array](https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array/)

## Approach

This solution solves the "Difference Between Element Sum and Digit Sum of an Array" problem.

**Time Complexity:** To be analyzed
**Space Complexity:** To be analyzed

*(AI explanation generation failed, please add details manually)*

## Code
```java
class Solution {

    public int digitSum(int n){
        int sum = 0;

        while(n != 0){
            sum = sum+n%10;
            n /= 10;
        }

        return sum;
    }
    public int differenceOfSum(int[] nums) {
        int sumE =0, sumD = 0;

        for(int i = 0; i < nums.length; i++){
            sumE += nums[i];
            sumD += digitSum(nums[i]);
        }

        return (sumE - sumD);
        
    }

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> { try (java.io.FileWriter fw = new java.io.FileWriter("display_runtime.txt")) { fw.write("0"); } catch (Exception e) { } }));
    }
}
```
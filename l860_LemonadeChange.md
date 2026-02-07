# 860. Lemonade Change

**LeetCode Problem:** [Lemonade Change](https://leetcode.com/problems/lemonade-change/)

## Approach

This solution solves the "Lemonade Change" problem.

**Time Complexity:** To be analyzed
**Space Complexity:** To be analyzed

*(AI explanation generation failed, please add details manually)*

## Code
```java
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveCount = 0, tenCount = 0;

        for(int bill : bills){
            if(bill == 5){
                fiveCount++; 
            } else if(bill == 10){
                fiveCount--; tenCount++; 
            } else if(tenCount > 0){
                fiveCount--;
                tenCount--; 
            } else{
                fiveCount -= 3;
            }

            if(fiveCount < 0) return false;
        
        }

        return true;
    }
}
```
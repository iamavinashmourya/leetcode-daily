# 633. Sum of Square Numbers

**LeetCode Problem:** [Sum of Square Numbers](https://leetcode.com/problems/sum-of-square-numbers/)

## Approach

The approach used to solve the "Sum of Square Numbers" problem involves a two-pointer technique, where two pointers, `left` and `right`, are used to represent the potential square numbers that could sum up to the given number `c`. The algorithm iteratively adjusts the pointers based on the sum of their squares until it finds a pair that equals `c` or determines that no such pair exists.

Here's a step-by-step breakdown of the logic:
1. **Step 1**: Initialize two pointers, `left` and `right`, to 0 and the square root of `c`, respectively, to represent the range of potential square numbers.
2. **Step 2**: Calculate the sum of the squares of the values at the `left` and `right` pointers.
3. **Step 3**: Compare the calculated sum with the given number `c` and adjust the pointers accordingly: if the sum is less than `c`, increment `left`; if the sum is greater than `c`, decrement `right`.
4. **Step 4**: Repeat steps 2-3 until the sum equals `c` or the pointers cross each other (i.e., `left` exceeds `right`).

- **Time Complexity**: The time complexity of this algorithm is O(sqrt(c)) because in the worst-case scenario, the `right` pointer starts at the square root of `c` and decrements until it reaches 0.
- **Space Complexity**: The space complexity is O(1) because the algorithm only uses a constant amount of space to store the pointers and the sum, regardless of the input size.

## Dry Run

Let's consider the input `c = 5`. Here's the step-by-step execution of the algorithm:

| Step number | Current state of variables | Action taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `left = 0`, `right = 2` (because sqrt(5) is approximately 2.24) | Calculate sum: `0*0 + 2*2 = 4` | Sum is less than `c` |
| 2 | `left = 1`, `right = 2` | Calculate sum: `1*1 + 2*2 = 5` | Sum equals `c`, return `true` |

In this example, the algorithm finds a pair of square numbers (1 and 2) that sum up to the given number `c = 5` and returns `true` after just two iterations.
## Code
```java
class Solution {
    public boolean judgeSquareSum(int c) {
        long left = 0;
        long right = (long) Math.sqrt(c);

        while(left<=right){
            long sum = left * left + right * right;

            if(sum == c){
                return true;
            } else if (sum < c){
                left++;
            } else{
                right--;
            }
        }

        return false;
    }
}
```
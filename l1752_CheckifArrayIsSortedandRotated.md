# 1752. Check if Array Is Sorted and Rotated

**LeetCode Problem:** [Check if Array Is Sorted and Rotated](https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/)

## Approach

The approach to solving the "Check if Array Is Sorted and Rotated" problem involves iterating through the array to count the number of rotations, i.e., the number of times a larger number is followed by a smaller number. The algorithm checks for the number of rotations and determines if the array is sorted and rotated based on this count.

Here's a step-by-step breakdown of the logic:
1. **Step 1**: Initialize a counter variable `count` to keep track of the number of rotations in the array.
2. **Step 2**: Iterate through the array from the first element to the second last element, checking if the current element is greater than the next element. If it is, increment the `count` variable.
3. **Step 3**: After the loop, check if the last element of the array is greater than the first element. If it is, increment the `count` variable again.
4. **Step 4**: Finally, return `true` if the `count` is less than or equal to 1, indicating that the array is sorted and rotated, and `false` otherwise.

- **Time Complexity**: The time complexity of this algorithm is O(n), where n is the number of elements in the array, because it involves a single pass through the array.
- **Space Complexity**: The space complexity is O(1), as it uses a constant amount of space to store the `count` variable.

## Dry Run

Let's consider the example input `nums = [3, 4, 5, 1, 2]`. Here's the execution of the algorithm:

| Step number | Current state of variables | Action taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `count = 0`, `nums = [3, 4, 5, 1, 2]` | Initialize `count` to 0 | `count = 0` |
| 2 | `count = 0`, `nums = [3, 4, 5, 1, 2]` | Compare `nums[0]` and `nums[1]`, `3 < 4` | No action taken |
| 3 | `count = 0`, `nums = [3, 4, 5, 1, 2]` | Compare `nums[1]` and `nums[2]`, `4 < 5` | No action taken |
| 4 | `count = 0`, `nums = [3, 4, 5, 1, 2]` | Compare `nums[2]` and `nums[3]`, `5 > 1` | Increment `count` to 1 |
| 5 | `count = 1`, `nums = [3, 4, 5, 1, 2]` | Compare `nums[3]` and `nums[4]`, `1 < 2` | No action taken |
| 6 | `count = 1`, `nums = [3, 4, 5, 1, 2]` | Check if `nums[4]` is less than `nums[0]`, `2 < 3` | No action taken, `count` remains 1 |
| 7 | `count = 1`, `nums = [3, 4, 5, 1, 2]` | Return `true` because `count` is less than or equal to 1 | `true` |

The algorithm returns `true` for the input `nums = [3, 4, 5, 1, 2]`, indicating that the array is sorted and rotated.
## Code
```java
class Solution {
    public boolean check(int[] nums) {
        int count = 0;

        for(int i = 0; i < nums.length -1; i++){
            if(nums[i] > nums[i+1]){
                count++;
            }
        }

        if(nums[nums.length - 1] > nums[0]){
            count++;
        }

        return count <= 1;
    }
}
```
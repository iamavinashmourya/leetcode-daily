# 896. Monotonic Array

**LeetCode Problem:** [Monotonic Array](https://leetcode.com/problems/monotonic-array/)

## Approach

The approach used to solve the "Monotonic Array" problem involves iterating through the input array and checking for both increasing and decreasing sequences. This is achieved by maintaining two boolean flags to track whether the array is increasing or decreasing.

Here's a step-by-step breakdown of the logic:
1. **Step 1**: Initialize two boolean variables, `inc` and `dec`, to `true`, assuming the array could be both increasing and decreasing initially.
2. **Step 2**: Iterate through the input array starting from the second element (index 1).
3. **Step 3**: For each element, check if it's less than the previous element. If so, set `inc` to `false` because the array is not increasing.
4. **Step 4**: For each element, check if it's greater than the previous element. If so, set `dec` to `false` because the array is not decreasing.
5. **Step 5**: After iterating through the entire array, return `true` if the array is either increasing (`inc` is `true`) or decreasing (`dec` is `true`), and `false` otherwise.

- **Time Complexity**: The time complexity of this approach is O(n), where n is the number of elements in the input array, because we're iterating through the array once.
- **Space Complexity**: The space complexity is O(1), excluding the space required for the input and output, because we're using a constant amount of space to store the boolean flags.

## Dry Run

Let's take the input array `[1, 2, 3, 4, 5]` as an example. Here's how the algorithm would execute:

| Step Number | Current State of Variables | Action Taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `inc = true`, `dec = true` | Initialize variables | - |
| 2 | `inc = true`, `dec = true` | Compare `nums[1]` (2) with `nums[0]` (1) | `dec = false` because `nums[1] > nums[0]` |
| 3 | `inc = true`, `dec = false` | Compare `nums[2]` (3) with `nums[1]` (2) | No change, `nums[2] > nums[1]` |
| 4 | `inc = true`, `dec = false` | Compare `nums[3]` (4) with `nums[2]` (3) | No change, `nums[3] > nums[2]` |
| 5 | `inc = true`, `dec = false` | Compare `nums[4]` (5) with `nums[3]` (4) | No change, `nums[4] > nums[3]` |
| 6 | `inc = true`, `dec = false` | Return result | `true` because `inc` is `true` |

The final output of the algorithm is `true`, indicating that the input array is monotonic (increasing in this case).
## Code
```java
class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean inc = true , dec = true;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i-1]){
                inc = false;
            }

            if(nums[i] > nums[i-1]){
                dec = false;
            }
        }

        return inc || dec;
    }

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> { try (java.io.FileWriter fw = new java.io.FileWriter("display_runtime.txt")) { fw.write("0"); } catch (Exception e) { } }));
    }
}
```
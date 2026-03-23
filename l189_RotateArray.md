# 189. Rotate Array

**LeetCode Problem:** [Rotate Array](https://leetcode.com/problems/rotate-array/)

## Approach

The approach used to solve the "Rotate Array" problem involves a three-step reversal process to rotate the array by a specified number of positions. This is achieved by reversing the entire array, then reversing the first 'k' elements, and finally reversing the remaining elements.

Here's a step-by-step breakdown of the logic:
1. **Step 1**: Calculate the effective rotation positions by taking the modulus of 'k' with the length of the array, ensuring the rotation is within the bounds of the array length.
2. **Step 2**: Check if the array has only one element, in which case no rotation is needed.
3. **Step 3**: Reverse the entire array to set up for the rotation.
4. **Step 4**: Reverse the first 'k' elements of the reversed array to get the first part of the rotated array in place.
5. **Step 5**: Reverse the remaining elements (from 'k' to the end) to complete the rotation.

- **Time Complexity**: The time complexity of this solution is O(n), where 'n' is the length of the array, because each element is visited at most three times (once for each reversal).
- **Space Complexity**: The space complexity is O(1), as only a constant amount of space is used for variables, and no additional space that scales with input size is used.

## Dry Run

Let's use the example input `nums = [1, 2, 3, 4, 5, 6, 7]` and `k = 3`. The goal is to rotate the array 3 positions to the right.

| Step number | Current state of variables | Action taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `nums = [1, 2, 3, 4, 5, 6, 7]`, `k = 3` | Calculate effective rotation positions: `k %= nums.length` | `k = 3` |
| 2 | `nums = [1, 2, 3, 4, 5, 6, 7]`, `k = 3` | Check if array length is 1, which is not the case | Proceed to next step |
| 3 | `nums = [1, 2, 3, 4, 5, 6, 7]` | Reverse the entire array | `nums = [7, 6, 5, 4, 3, 2, 1]` |
| 4 | `nums = [7, 6, 5, 4, 3, 2, 1]`, `k = 3` | Reverse the first 'k' elements | `nums = [5, 6, 7, 4, 3, 2, 1]` |
| 5 | `nums = [5, 6, 7, 4, 3, 2, 1]` | Reverse the remaining elements | `nums = [5, 6, 7, 1, 2, 3, 4]` |

The final rotated array is `[5, 6, 7, 1, 2, 3, 4]`, which is the result of rotating the original array 3 positions to the right.
## Code
```java
class Solution {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
       // int abs = k % n;
        k%=nums.length;
        if(n==1) return;

        swap(nums, 0, n-1);
        swap(nums, 0, k-1);
        swap(nums, k, n-1);
       
        
    }

    public static void swap(int nums[], int left, int right){
        while(left<right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
```
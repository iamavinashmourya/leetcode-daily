# 922. Sort Array By Parity II

**LeetCode Problem:** [Sort Array By Parity II](https://leetcode.com/problems/sort-array-by-parity-ii/)

## Approach

The approach used in the solution is a two-pointer technique, where two pointers, `left` and `right`, are initialized to traverse the array and swap elements to maintain the required parity order. This technique allows for an efficient in-place sorting of the array by parity.

Here is a step-by-step breakdown of the logic:
1. **Step 1**: Initialize two pointers, `left` and `right`, to the first and second elements of the array, respectively.
2. **Step 2**: Check if the element at the `left` index is even. If it is, increment `left` by 2 to move to the next even-indexed element.
3. **Step 3**: Check if the element at the `right` index is odd. If it is not, swap the elements at the `left` and `right` indices and increment `right` by 2 to move to the next odd-indexed element.
4. **Step 4**: Repeat steps 2 and 3 until `left` and `right` reach the end of the array.

- **Time Complexity**: The time complexity of this solution is O(n), where n is the number of elements in the array, since each element is visited at most twice.
- **Space Complexity**: The space complexity of this solution is O(1), as it only uses a constant amount of space to store the two pointers and does not require any additional data structures.

## Dry Run

Let's consider the input array `[4, 2, 5, 7]`. Here's a step-by-step execution of the algorithm:

| Step Number | Current State of Variables | Action Taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `left = 0`, `right = 1`, `nums = [4, 2, 5, 7]` | Check `nums[left]` (4) and `nums[right]` (2) | `left` remains 0, `right` remains 1 |
| 2 | `left = 0`, `right = 1`, `nums = [4, 2, 5, 7]` | Swap `nums[left]` and `nums[right]` since `nums[right]` is even | `nums = [2, 4, 5, 7]`, `left` becomes 2, `right` becomes 3 |
| 3 | `left = 2`, `right = 3`, `nums = [2, 4, 5, 7]` | Check `nums[left]` (5) and `nums[right]` (7) | `left` remains 2, `right` remains 3 |
| 4 | `left = 2`, `right = 3`, `nums = [2, 4, 5, 7]` | No swap needed since `nums[right]` is odd and `left` has reached the end | Algorithm terminates |
| Final | `nums = [2, 4, 5, 7]` | - | `nums = [2, 4, 5, 7]` |

The final output is `[2, 4, 5, 7]`, which is the sorted array by parity.
## Code
```java
class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int left = 0;
        int right = 1;

        while(left < nums.length && right < nums.length){
            if(nums[left]%2==0){
                left+=2;
            }

            if(nums[right] %2!=0){
                right+=2;
            } else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }
}
```
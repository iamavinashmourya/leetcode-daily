# 704. Binary Search

**LeetCode Problem:** [Binary Search](https://leetcode.com/problems/binary-search/)

## Approach
The approach used to solve the "Binary Search" problem is a divide-and-conquer algorithm that repeatedly divides the search interval in half until the target element is found. This algorithm takes advantage of the fact that the input array is sorted, allowing for efficient searching.

Here's a step-by-step breakdown of the logic:
1. **Step 1**: Initialize two pointers, `left` and `right`, to the start and end of the array, respectively.
2. **Step 2**: Calculate the middle index `mid` of the current search interval.
3. **Step 3**: Compare the middle element `nums[mid]` to the target element `target`. If they are equal, return the middle index.
4. **Step 4**: If `nums[mid]` is greater than `target`, update the `right` pointer to `mid-1` to search the left half of the interval.
5. **Step 5**: If `nums[mid]` is less than `target`, update the `left` pointer to `mid+1` to search the right half of the interval.
6. **Step 6**: Repeat steps 2-5 until `left` is greater than `right`, at which point the target element is not found and return -1.

- **Time Complexity**: The time complexity of this algorithm is O(log n), where n is the number of elements in the array, because the search interval is halved at each step.
- **Space Complexity**: The space complexity is O(1), as only a constant amount of space is used to store the pointers and variables.

## Dry Run
Let's consider an example input: `nums = [1, 2, 3, 4, 5]` and `target = 3`. Here's the execution of the algorithm:

| Step number | Current state of variables | Action taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `left = 0`, `right = 4` | Initialize pointers | - |
| 2 | `left = 0`, `right = 4` | Calculate `mid = (0+4)/2 = 2` | `mid = 2` |
| 3 | `left = 0`, `right = 4`, `mid = 2` | Compare `nums[2] = 3` to `target = 3` | `nums[2] == target` |
| 4 | `left = 0`, `right = 4`, `mid = 2` | Return `mid = 2` because `nums[2] == target` | `return 2` |

In this example, the algorithm finds the target element `3` at index `2` in just one iteration.
## Code
```java
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                return mid;
            } else if(nums[mid] > target){
                right = mid-1;
            } else{
                left = mid+1;
            }
        }
        return -1;
    }
}
```
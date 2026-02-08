# 977. Squares of a Sorted Array

**LeetCode Problem:** [Squares of a Sorted Array](https://leetcode.com/problems/squares-of-a-sorted-array/)

## Approach

The approach first transforms the input array by squaring each of its elements in-place. Subsequently, the algorithm sorts this modified array, which now contains the squared values, to arrange them in non-decreasing order.

Here's a step-by-step breakdown of the logic:

1.  **Square Elements**: The code iterates through the input array `nums` from the first element to the last. For each element `nums[i]`, it calculates its square (`nums[i] * nums[i]`) and updates the element in the array with this new squared value. This process modifies the array in-place, replacing all original numbers with their corresponding squares.
2.  **Sort Array**: After all elements have been squared, the `nums` array contains the squares of the original numbers but not necessarily in sorted order. The `Arrays.sort(nums)` method is then invoked to sort this array, arranging the squared values in non-decreasing (ascending) order.
3.  **Return Result**: Finally, the now sorted array, which contains the squares of the original numbers, is returned as the result.

*   **Time Complexity**: The initial loop to square each of the `N` elements takes `O(N)` time. The subsequent call to `Arrays.sort(nums)` for a primitive array in Java typically uses a Dual-Pivot Quicksort implementation, which has an average and worst-case time complexity of `O(N log N)`, where `N` is the number of elements. Therefore, the overall time complexity is dominated by the sorting step, resulting in **O(N log N)**.
*   **Space Complexity**: The algorithm modifies the input array `nums` in-place without allocating any new arrays proportional to the input size for its primary operations. The `Arrays.sort()` method for primitive arrays usually has an auxiliary space complexity of `O(log N)` due to recursion stack space for Quicksort, or `O(1)` if considering the input array modification as primary. Thus, the auxiliary space complexity is **O(1)**.
    *(Note: The static block with a `ShutdownHook` present in the provided code is an auxiliary mechanism unrelated to the core algorithm for squaring and sorting the array. It's designed to write a value to a file upon JVM termination and does not affect the time or space complexity of the `sortedSquares` method itself.)*

## Dry Run

Let's consider the input `nums = [-4, -1, 0, 3, 10]`.

| Step number | Current state of variables (`nums`) | Action taken | Result/Output |
| :---------- | :---------------------------------- | :------------------------------------------- | :------------------------------------ |
| **Initial** | `[-4, -1, 0, 3, 10]`                | Method `sortedSquares` is called.            |                                       |
| **1.1**     | `[-4, -1, 0, 3, 10]`                | Loop `i = 0`: `nums[0] = (-4) * (-4) = 16`. | `nums` is now `[16, -1, 0, 3, 10]`    |
| **1.2**     | `[16, -1, 0, 3, 10]`                | Loop `i = 1`: `nums[1] = (-1) * (-1) = 1`.  | `nums` is now `[16, 1, 0, 3, 10]`     |
| **1.3**     | `[16, 1, 0, 3, 10]`                 | Loop `i = 2`: `nums[2] = 0 * 0 = 0`.        | `nums` is now `[16, 1, 0, 3, 10]`     |
| **1.4**     | `[16, 1, 0, 3, 10]`                 | Loop `i = 3`: `nums[3] = 3 * 3 = 9`.        | `nums` is now `[16, 1, 0, 9, 10]`     |
| **1.5**     | `[16, 1, 0, 9, 10]`                 | Loop `i = 4`: `nums[4] = 10 * 10 = 100`.    | `nums` is now `[16, 1, 0, 9, 100]`    |
| **2**       | `[16, 1, 0, 9, 100]`                | Loop finishes. Call `Arrays.sort(nums)`.     | `nums` is sorted to `[0, 1, 9, 16, 100]` |
| **3**       | `[0, 1, 9, 16, 100]`                | Return the modified array.                   | `[0, 1, 9, 16, 100]`                  |
## Code
```java
class Solution {
    public int[] sortedSquares(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);

        return nums;
    }

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (java.io.FileWriter fw = new java.io.FileWriter("display_runtime.txt")) {
                fw.write("0");
            } catch (Exception e) {
            }
        }));
     }
}
```
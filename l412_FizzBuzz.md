# 412. Fizz Buzz

**LeetCode Problem:** [Fizz Buzz](https://leetcode.com/problems/fizz-buzz/)

## Approach
The approach to solving the "Fizz Buzz" problem involves iterating over a range of numbers from 1 to n and checking each number for multiples of 3 and 5, appending the corresponding string to the result list. This is achieved through a simple for loop and conditional statements to handle the different cases.

Here is a step-by-step breakdown:
1. **Step 1**: Initialize an empty list `ans` to store the results and start a for loop from 1 to n (inclusive).
2. **Step 2**: For each number `i` in the loop, check if it is a multiple of 15 (i.e., `i%15==0`), and if so, append "FizzBuzz" to the list.
3. **Step 3**: If `i` is not a multiple of 15, check if it is a multiple of 5 (i.e., `i%5==0`), and if so, append "Buzz" to the list.
4. **Step 4**: If `i` is neither a multiple of 15 nor 5, check if it is a multiple of 3 (i.e., `i%3==0`), and if so, append "Fizz" to the list.
5. **Step 5**: If `i` is not a multiple of 3, 5, or 15, simply append the string representation of `i` to the list.
6. **Step 6**: After the loop completes, return the list `ans` containing the results.

- **Time Complexity**: The time complexity of this solution is O(n), where n is the input number, because we are performing a constant amount of work for each number in the range from 1 to n.
- **Space Complexity**: The space complexity is also O(n), as we are storing the results in a list of size n.

## Dry Run
Let's take the example input `n = 5`. Here's a step-by-step execution of the algorithm:

| Step number | Current state of variables | Action taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `i = 1`, `ans = []` | Check conditions, append "1" to `ans` | `ans = ["1"]` |
| 2 | `i = 2`, `ans = ["1"]` | Check conditions, append "2" to `ans` | `ans = ["1", "2"]` |
| 3 | `i = 3`, `ans = ["1", "2"]` | Check conditions, append "Fizz" to `ans` | `ans = ["1", "2", "Fizz"]` |
| 4 | `i = 4`, `ans = ["1", "2", "Fizz"]` | Check conditions, append "4" to `ans` | `ans = ["1", "2", "Fizz", "4"]` |
| 5 | `i = 5`, `ans = ["1", "2", "Fizz", "4"]` | Check conditions, append "Buzz" to `ans` | `ans = ["1", "2", "Fizz", "4", "Buzz"]` |

The final output is `["1", "2", "Fizz", "4", "Buzz"]`.
## Code
```java
class Solution {
    public List<String> fizzBuzz(int n) {
        List ans = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            ans.add(
            i%15==0 ? "FizzBuzz" :
            i%5==0 ? "Buzz" :
            i%3==0 ? "Fizz" :
            String.valueOf(i)
            );
        }
        return ans;
    }
}
```
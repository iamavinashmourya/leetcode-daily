# 2000. Reverse Prefix of Word

**LeetCode Problem:** [Reverse Prefix of Word](https://leetcode.com/problems/reverse-prefix-of-word/)

Here's a detailed explanation of your solution:

## Approach

The approach involves first locating the target character within the word. If found, the prefix up to and including that character is extracted and reversed. Finally, the remaining suffix of the word (if any) is appended to the reversed prefix to form the final result.

Here's a step-by-step breakdown of the logic:

1.  **Find Character**: The code first uses `word.indexOf(ch)` to find the index of the first occurrence of the character `ch` in the `word`.
2.  **Handle Not Found**: If `ch` is not found (i.e., `idx` is `-1`), the original `word` is returned as there's no prefix to reverse.
3.  **Extract and Reverse Prefix**: A `StringBuilder` is created by taking the substring of `word` from the beginning up to and including the character `ch` (i.e., `word.substring(0, idx + 1)`). This prefix `StringBuilder` is then immediately reversed using `.reverse()`.
4.  **Append Suffix**: The code then checks if there are any characters remaining in the `word` after `ch` (though the condition `idx < word.length()` is always true for a valid `idx`, `word.substring(idx + 1)` correctly extracts the suffix, which could be an empty string if `ch` was the last character). The substring from `idx + 1` to the end of the `word` is appended to the `StringBuilder` containing the reversed prefix.
5.  **Return Result**: Finally, the content of the `StringBuilder` is converted back to a `String` using `toString()` and returned.

-   **Time Complexity**: O(N), where N is the length of the `word`.
    *   `word.indexOf(ch)` takes O(N) time in the worst case (scanning the entire string).
    *   `word.substring(0, idx + 1)` creates a new string of length `idx + 1`, taking O(idx + 1) time.
    *   `StringBuilder` construction and `reverse()` operation on the prefix take O(idx + 1) time.
    *   `word.substring(idx + 1)` creates another new string of length `N - (idx + 1)`, taking O(N - (idx + 1)) time.
    *   `res.append(...)` takes O(N - (idx + 1)) time.
    *   `res.toString()` takes O(N) time.
    *   Overall, the operations are proportional to the length of the string.

-   **Space Complexity**: O(N), where N is the length of the `word`.
    *   The `StringBuilder` `res` stores up to N characters.
    *   Intermediate `substring` calls create new string objects, which in the worst case can be of length N.
    *   Therefore, the space used scales linearly with the input string length.

## Dry Run

Let's trace the execution with the input `word = "abcdefd"`, `ch = 'd'`.

| Step number | Current state of variables                                       | Action taken                                                                                                                                                                                                                                 | Result/Output                                         |
| :---------- | :--------------------------------------------------------------- | :----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | :---------------------------------------------------- |
| 1           | `word = "abcdefd"`, `ch = 'd'`, `idx = ?`, `res = ?`             | `idx = word.indexOf(ch);` finds the first occurrence of 'd'.                                                                                                                                                                                 | `idx = 3`                                             |
| 2           | `word = "abcdefd"`, `ch = 'd'`, `idx = 3`, `res = ?`             | `if(idx == -1)` check. (`3 == -1` is false).                                                                                                                                                                                                | Condition evaluated to `false`.                       |
| 3           | `word = "abcdefd"`, `ch = 'd'`, `idx = 3`, `res = ?`             | `word.substring(0, idx + 1)` becomes `word.substring(0, 4)`, which is `"abcd"`. This is passed to a new `StringBuilder` and then `.reverse()` is called on it.                                                                           | `res = StringBuilder("dcba")`                         |
| 4           | `word = "abcdefd"`, `ch = 'd'`, `idx = 3`, `res = "dcba"`        | `if(idx < word.length())` check. (`3 < 7` is true).                                                                                                                                                                                          | Condition evaluated to `true`.                        |
| 5           | `word = "abcdefd"`, `ch = 'd'`, `idx = 3`, `res = "dcba"`        | `word.substring(idx + 1)` becomes `word.substring(4)`, which is `"efd"`. This substring is appended to `res`.                                                                                                                               | `res` becomes `StringBuilder("dcbaefd")`              |
| 6           | `word = "abcdefd"`, `ch = 'd'`, `idx = 3`, `res = "dcbaefd"`     | `return res.toString();` converts the `StringBuilder` content to a `String`.                                                                                                                                                               | Returns `"dcbaefd"`                                   |
## Code
```java
class Solution {
    public String reversePrefix(String word, char ch) {
        int idx = word.indexOf(ch);
        if(idx == -1) {
            return word;
        }

        StringBuilder res = new StringBuilder(word.substring(0, idx + 1)).reverse();
        if(idx < word.length()) {
            res.append(word.substring(idx + 1));
        }

        return res.toString();
    }
}
```
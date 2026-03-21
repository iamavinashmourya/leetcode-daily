# 20. Valid Parentheses

**LeetCode Problem:** [Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)

## Approach
The approach to solving the "Valid Parentheses" problem involves using a stack data structure to keep track of the opening brackets encountered in the input string. The algorithm iterates through the string, pushing opening brackets onto the stack and popping them off when a matching closing bracket is encountered.

Here's a step-by-step breakdown of the logic:
1. **Step 1**: Initialize an empty stack to store the opening brackets.
2. **Step 2**: Iterate through each character in the input string, checking if it's an opening bracket. If it is, push it onto the stack.
3. **Step 3**: If the character is a closing bracket, check if the stack is empty. If it is, return false, as there's no matching opening bracket.
4. **Step 4**: If the stack is not empty, pop the top element (the most recently encountered opening bracket) and check if it matches the current closing bracket. If it doesn't, return false.
5. **Step 5**: After iterating through the entire string, check if the stack is empty. If it is, return true, indicating that all brackets were properly matched. If it's not empty, return false, as there are unmatched opening brackets.

- **Time Complexity**: The time complexity is O(n), where n is the length of the input string, as we're iterating through the string once.
- **Space Complexity**: The space complexity is O(n), as in the worst-case scenario (a string of all opening brackets), the stack will contain n elements.

## Dry Run
Let's use the input string "((()))" as an example.

| Step number | Current state of variables | Action taken | Result/Output |
| --- | --- | --- | --- |
| 1 | stack = [] | Initialize stack | stack = [] |
| 2 | stack = [] | Push '(' onto stack | stack = ['('] |
| 3 | stack = ['('] | Push '(' onto stack | stack = ['(', '('] |
| 4 | stack = ['(', '('] | Push '(' onto stack | stack = ['(', '(', '('] |
| 5 | stack = ['(', '(', '('] | Pop '(' from stack (matches ')') | stack = ['(', '('] |
| 6 | stack = ['(', '('] | Pop '(' from stack (matches ')') | stack = ['('] |
| 7 | stack = ['('] | Pop '(' from stack (matches ')') | stack = [] |
| 8 | stack = [] | Check if stack is empty | Returns true |

The final output is true, indicating that the input string has valid parentheses.
## Code
```java
import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()) {
            // Push opening brackets
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            // Handle closing brackets
            else {
                if(stack.isEmpty()) return false;

                char top = stack.pop();

                if((ch == ')' && top != '(') ||
                   (ch == '}' && top != '{') ||
                   (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
```
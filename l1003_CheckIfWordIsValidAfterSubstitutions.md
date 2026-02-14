# 1003. Check If Word Is Valid After Substitutions

**LeetCode Problem:** [Check If Word Is Valid After Substitutions](https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/)

## Approach
The approach to solving this problem involves using a stack to keep track of the characters in the string. When the character 'c' is encountered, the algorithm checks if the top two characters on the stack are 'a' and 'b' in that order, and if so, removes them from the stack.

Here is a step-by-step breakdown of the approach:
1. **Initialization**: Initialize an empty stack to store characters from the string.
2. **Iteration**: Iterate through each character in the input string.
3. **Character Check**: If the current character is 'c', check if the stack has at least two characters and the top two characters are 'a' and 'b' in that order.
4. **Stack Update**: If the top two characters are 'a' and 'b', remove them from the stack. Otherwise, return false.
5. **Stack Push**: If the current character is not 'c', push it onto the stack.
6. **Final Check**: After iterating through the entire string, check if the stack is empty. If it is, return true. Otherwise, return false.

- **Time Complexity**: The time complexity of this algorithm is O(n), where n is the length of the input string, because each character in the string is processed once.
- **Space Complexity**: The space complexity of this algorithm is O(n), where n is the length of the input string, because in the worst-case scenario, all characters in the string are pushed onto the stack.

## Dry Run

Let's use the input string "aabcbc" as an example.

| Step Number | Current State of Variables | Action Taken | Result/Output |
| --- | --- | --- | --- |
| 1 | Stack: [] | Push 'a' onto the stack | Stack: [a] |
| 2 | Stack: [a] | Push 'a' onto the stack | Stack: [a, a] |
| 3 | Stack: [a, a] | Push 'b' onto the stack | Stack: [a, a, b] |
| 4 | Stack: [a, a, b] | Push 'c' onto the stack, then pop 'b' and 'a' | Stack: [a] |
| 5 | Stack: [a] | Push 'b' onto the stack | Stack: [a, b] |
| 6 | Stack: [a, b] | Push 'c' onto the stack, then pop 'b' and 'a' | Stack: [] |
| 7 | Stack: [] | Check if the stack is empty | Return true |

In this example, the algorithm correctly checks if the string is valid after substitutions and returns true.
## Code
```java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == 'c'){
                if(stack.size() < 2) return false;
                if(stack.pop() != 'b') return false;
                if(stack.pop() != 'a') return false;
            } else{
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
```
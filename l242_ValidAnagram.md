# 242. Valid Anagram

**LeetCode Problem:** [Valid Anagram](https://leetcode.com/problems/valid-anagram/)

## Approach
The approach to solving the "Valid Anagram" problem involves checking if two input strings are anagrams of each other by sorting the characters in each string and comparing the results. This is done by first checking if the strings have the same length, then sorting the characters in each string, and finally comparing the sorted characters.

Here's a step-by-step breakdown of the logic:
1. **Step 1**: Check if the lengths of the two input strings are equal. If they are not, immediately return `false` because anagrams must have the same number of characters.
2. **Step 2**: Convert each string into a character array to prepare for sorting.
3. **Step 3**: Sort the characters in each array.
4. **Step 4**: Compare the sorted character arrays. If they are equal, return `true`, indicating that the original strings are anagrams of each other. Otherwise, return `false`.

- **Time Complexity**: The time complexity of this solution is O(n log n) due to the sorting operation, where n is the length of the input strings.
- **Space Complexity**: The space complexity is O(n) because we are creating character arrays of the same length as the input strings.

## Dry Run

Let's use the example input `s = "listen"` and `t = "silent"` to demonstrate the algorithm.

| Step number | Current state of variables | Action taken | Result/Output |
|-------------|----------------------------|--------------|---------------|
| 1           | `s = "listen"`, `t = "silent"` | Check if lengths of `s` and `t` are equal | `true` because both lengths are 6 |
| 2           | `s = "listen"`, `t = "silent"` | Convert `s` and `t` to character arrays `ch1` and `ch2` | `ch1 = ['l', 'i', 's', 't', 'e', 'n']`, `ch2 = ['s', 'i', 'l', 'e', 'n', 't']` |
| 3           | `ch1 = ['l', 'i', 's', 't', 'e', 'n']`, `ch2 = ['s', 'i', 'l', 'e', 'n', 't']` | Sort `ch1` and `ch2` | `ch1 = ['e', 'i', 'l', 'n', 's', 't']`, `ch2 = ['e', 'i', 'l', 'n', 's', 't']` |
| 4           | `ch1 = ['e', 'i', 'l', 'n', 's', 't']`, `ch2 = ['e', 'i', 'l', 'n', 's', 't']` | Compare sorted `ch1` and `ch2` | `true` because `ch1` and `ch2` are equal |

The final output is `true`, indicating that "listen" and "silent" are anagrams of each other.
## Code
```java
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        return Arrays.equals(ch1, ch2);


        
    }
}
```
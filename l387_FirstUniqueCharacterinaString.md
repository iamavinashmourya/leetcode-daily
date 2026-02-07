# 387. First Unique Character in a String

**LeetCode Problem:** [First Unique Character in a String](https://leetcode.com/problems/first-unique-character-in-a-string/)

This solution employs a two-pass approach to find the first unique character in a string. It first counts the occurrences of each character in the string and then iterates through the string again to find the first character with a count of one.

## Approach

The approach uses a frequency array to store the counts of each lowercase English character. It performs a first pass to populate this frequency map and a second pass to identify the first character in the original string that has a frequency of 1.

1.  **Initialize Frequency Array**: A fixed-size integer array `freq` of size 26 is created. Each index corresponds to a lowercase English letter (e.g., index 0 for 'a', index 1 for 'b', etc.), and its value will store the count of that character. All values are initialized to 0.
2.  **First Pass - Count Frequencies**: The code iterates through the input string `s` from left to right. For each character `c` encountered, it increments the count at the corresponding index in the `freq` array (`freq[c - 'a']++`). This pass populates the `freq` array with the total occurrences of each character in the string.
3.  **Second Pass - Find First Unique**: After the frequency array is fully populated, the code iterates through the string `s` a second time, again from left to right. For each character `c` at index `i`, it checks its frequency in the `freq` array (`freq[c - 'a']`).
4.  **Return Index**: If the frequency of the current character `c` is 1, it means this character is unique, and since we are iterating from left to right, it is the *first* unique character encountered. The index `i` is immediately returned.
5.  **Handle No Unique Character**: If the second loop completes without finding any character with a frequency of 1, it means there are no unique characters in the string. In this case, the function returns -1.

-   **Time Complexity**: O(N), where N is the length of the string `s`. This is because the algorithm makes two full passes over the string: one to build the frequency map and another to find the first unique character. Each pass takes O(N) time.
-   **Space Complexity**: O(1). The `freq` array is of a fixed size (26 integers) to store counts for all lowercase English letters, regardless of the input string's length.

## Dry Run

Let's trace the execution with the input `s = "leetcode"`:

**Initial State**:
`freq` array = `[0, 0, ..., 0]` (26 elements)

| Step | `i` | `s.charAt(i)` | `freq` state (relevant entries) | Action/Condition | Result |
| :--- | :-- | :------------ | :------------------------------ | :--------------- | :----- |
| **First Pass: Populate Frequencies** |
| 1    | 0   | 'l'           | `freq['l'-'a'] = 0`             | `freq['l'-'a']++` | `freq['l'-'a'] = 1` |
| 2    | 1   | 'e'           | `freq['e'-'a'] = 0`             | `freq['e'-'a']++` | `freq['e'-'a'] = 1` |
| 3    | 2   | 'e'           | `freq['e'-'a'] = 1`             | `freq['e'-'a']++` | `freq['e'-'a'] = 2` |
| 4    | 3   | 't'           | `freq['t'-'a'] = 0`             | `freq['t'-'a']++` | `freq['t'-'a'] = 1` |
| 5    | 4   | 'c'           | `freq['c'-'a'] = 0`             | `freq['c'-'a']++` | `freq['c'-'a'] = 1` |
| 6    | 5   | 'o'           | `freq['o'-'a'] = 0`             | `freq['o'-'a']++` | `freq['o'-'a'] = 1` |
| 7    | 6   | 'd'           | `freq['d'-'a'] = 0`             | `freq['d'-'a']++` | `freq['d'-'a'] = 1` |
| 8    | 7   | 'e'           | `freq['e'-'a'] = 2`             | `freq['e'-'a']++` | `freq['e'-'a'] = 3` |
| **End of First Pass**. `freq` state: `freq['l'-'a']=1`, `freq['e'-'a']=3`, `freq['t'-'a']=1`, `freq['c'-'a']=1`, `freq['o'-'a']=1`, `freq['d'-'a']=1`. Other entries are 0. |
| **Second Pass: Find First Unique Character** |
| 9    | 0   | 'l'           | `freq['l'-'a'] = 1`             | `freq['l'-'a'] == 1` is true. | Return `i` (0). |
## Code
```java
class Solution {
    public int firstUniqChar(String s) {
    int[] freq = new int[26];

    for(int i = 0; i< s.length(); i++){
    freq[s.charAt(i) - 'a']++;
    }
    
    for(int i = 0; i < s.length(); i++){
        if(freq[s.charAt(i) - 'a'] == 1){
            return i;
        }
    }
    return -1;
    }
}
```
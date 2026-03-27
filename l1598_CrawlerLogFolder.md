# 1598. Crawler Log Folder

**LeetCode Problem:** [Crawler Log Folder](https://leetcode.com/problems/crawler-log-folder/)

## Approach
The approach to solving the "Crawler Log Folder" problem involves simulating the directory navigation based on the given log operations. This is achieved by iterating through each log operation and updating the directory level accordingly.

Here's a step-by-step breakdown of the logic:
1. **Initialize Directory Level**: Start with a directory level of 0, representing the root directory.
2. **Iterate Through Logs**: For each log operation, check if it's a move up (`../`), move down (`./`), or enter a new directory (any other string).
3. **Update Directory Level**: If the log operation is `../` and the current directory level is greater than 0, decrement the directory level. If the log operation is `./`, do nothing. If the log operation is any other string, increment the directory level.
4. **Return Final Directory Level**: After iterating through all log operations, return the final directory level.

- **Time Complexity**: The time complexity of this solution is O(n), where n is the number of log operations, since we're iterating through each log operation once.
- **Space Complexity**: The space complexity of this solution is O(1), since we're only using a constant amount of space to store the directory level.

## Dry Run
Let's use the example input `logs = ["d1/","d2/","../","d21/","./"]` to demonstrate the algorithm.

| Step Number | Current State of Variables | Action Taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `size = 0` | Encounter "d1/" | `size = 1` |
| 2 | `size = 1` | Encounter "d2/" | `size = 2` |
| 3 | `size = 2` | Encounter "../" | `size = 1` |
| 4 | `size = 1` | Encounter "d21/" | `size = 2` |
| 5 | `size = 2` | Encounter "./" | `size = 2` |
| 6 | `size = 2` | End of iteration | Return `size = 2` |

The final output is `2`, which represents the number of directories in the final path.
## Code
```java
class Solution {
    public int minOperations(String[] logs) {
        int size = 0;
        for(String log : logs){
            if(log.equals("../")){
                if(size > 0)
                    size--;
            } else if(log.equals("./"))
                continue;
            else{
                size++;
            }
        }

        return size;
    }
}
```
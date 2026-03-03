# 234. Palindrome Linked List

**LeetCode Problem:** [Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/)

## Approach
The approach used to solve the "Palindrome Linked List" problem involves traversing the linked list, storing the node values in a list, and then checking if the list is a palindrome by comparing elements from the start and end. This is done by using two pointers, one at the beginning and one at the end of the list, and moving them towards each other while comparing the elements.

Here is a step-by-step breakdown of the logic:
1. **Step 1**: Traverse the linked list and store each node's value in a list (`valList`).
2. **Step 2**: Initialize two pointers, `i` and `j`, to the start and end of the `valList` respectively.
3. **Step 3**: Compare the elements at the current positions of `i` and `j`. If they are not equal, return `false`.
4. **Step 4**: If the elements are equal, increment `i` and decrement `j` to move the pointers towards the center of the list.
5. **Step 5**: Repeat steps 3 and 4 until `i` is no longer less than `j`.
6. **Step 6**: If the loop completes without returning `false`, the list is a palindrome, so return `true`.

- **Time Complexity**: The time complexity of this solution is O(n), where n is the number of nodes in the linked list, because we are traversing the list once to store the values and then potentially traversing the list of values once more to check if it's a palindrome.
- **Space Complexity**: The space complexity is also O(n), because in the worst case, we are storing all node values in the `valList`.

## Dry Run
Let's consider the linked list `1 -> 2 -> 3 -> 2 -> 1` as an example input.

| Step number | Current state of variables | Action taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `head` = `1 -> 2 -> 3 -> 2 -> 1`, `valList` = `[]` | Traverse the linked list, store node values in `valList` | `valList` = `[1, 2, 3, 2, 1]` |
| 2 | `valList` = `[1, 2, 3, 2, 1]`, `i` = 0, `j` = 4 | Initialize `i` and `j` | `i` = 0, `j` = 4 |
| 3 | `valList` = `[1, 2, 3, 2, 1]`, `i` = 0, `j` = 4 | Compare `valList.get(i)` and `valList.get(j)` | `valList.get(0)` = 1, `valList.get(4)` = 1, equal |
| 4 | `valList` = `[1, 2, 3, 2, 1]`, `i` = 0, `j` = 4 | Increment `i`, decrement `j` | `i` = 1, `j` = 3 |
| 5 | `valList` = `[1, 2, 3, 2, 1]`, `i` = 1, `j` = 3 | Compare `valList.get(i)` and `valList.get(j)` | `valList.get(1)` = 2, `valList.get(3)` = 2, equal |
| 6 | `valList` = `[1, 2, 3, 2, 1]`, `i` = 1, `j` = 3 | Increment `i`, decrement `j` | `i` = 2, `j` = 2 |
| 7 | `valList` = `[1, 2, 3, 2, 1]`, `i` = 2, `j` = 2 | Compare `valList.get(i)` and `valList.get(j)` | `valList.get(2)` = 3, `valList.get(2)` = 3, equal, but `i` is not less than `j`, so exit loop |
| 8 | `valList` = `[1, 2, 3, 2, 1]`, `i` = 2, `j` = 2 | Return `true` because the loop completed without finding unequal elements | Output: `true` |

The dry run demonstrates how the algorithm correctly identifies the linked list `1 -> 2 -> 3 -> 2 -> 1` as a palindrome.
## Code
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> valList = new ArrayList<>();

        while(head!=null){
            valList.add(head.val);
            head = head.next;
        }

        int i = 0; 
        int j = valList.size() -1;
        while(i<j){
            if(!valList.get(i).equals(valList.get(j))){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
```
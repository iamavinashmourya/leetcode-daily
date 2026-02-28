# 206. Reverse Linked List

**LeetCode Problem:** [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/)

## Approach
The approach to solving the "Reverse Linked List" problem involves iterating through the linked list and reversing the direction of the pointers. This is achieved by keeping track of the current, next, and previous nodes, and updating their pointers accordingly.

Here's a step-by-step breakdown of the logic:
1. **Step 1**: Initialize three pointers: `curr` to the head of the list, `next` to null, and `prev` to null.
2. **Step 2**: Traverse the linked list until `curr` becomes null.
3. **Step 3**: Inside the loop, store the next node in `next` before updating `curr.next` to `prev`, effectively reversing the link.
4. **Step 4**: Move `prev` and `curr` one step forward by updating `prev` to `curr` and `curr` to `next`.
5. **Step 5**: After the loop ends, `prev` will be pointing to the new head of the reversed linked list, which is then returned.

- **Time Complexity**: The time complexity of this solution is O(n), where n is the number of nodes in the linked list, since we are traversing the list once.
- **Space Complexity**: The space complexity is O(1), as we are using a constant amount of space to store the pointers.

## Dry Run

Let's consider the linked list `1 -> 2 -> 3 -> 4 -> 5` as an example input. Here's the dry run:

| Step Number | Current State of Variables | Action Taken | Result/Output |
| --- | --- | --- | --- |
| 1 | `curr = 1`, `next = null`, `prev = null` | Initialize pointers | - |
| 2 | `curr = 1`, `next = 2`, `prev = null` | Store next node, reverse link | `1 -> null` |
| 3 | `curr = 2`, `next = 3`, `prev = 1` | Update prev and curr | `1 -> null`, `2 -> 1` |
| 4 | `curr = 3`, `next = 4`, `prev = 2` | Update prev and curr | `1 -> null`, `2 -> 1`, `3 -> 2` |
| 5 | `curr = 4`, `next = 5`, `prev = 3` | Update prev and curr | `1 -> null`, `2 -> 1`, `3 -> 2`, `4 -> 3` |
| 6 | `curr = 5`, `next = null`, `prev = 4` | Update prev and curr | `1 -> null`, `2 -> 1`, `3 -> 2`, `4 -> 3`, `5 -> 4` |
| 7 | `curr = null`, `next = null`, `prev = 5` | Return prev (new head) | `5 -> 4 -> 3 -> 2 -> 1` |

The final output is the reversed linked list `5 -> 4 -> 3 -> 2 -> 1`.
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
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode next = null;
        ListNode prev = null;

        while(curr!=null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
    }
}
```
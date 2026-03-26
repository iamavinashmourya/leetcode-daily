# 83. Remove Duplicates from Sorted List

**LeetCode Problem:** [Remove Duplicates from Sorted List](https://leetcode.com/problems/remove-duplicates-from-sorted-list/)

## Approach

The approach involves traversing the sorted linked list and removing any duplicate nodes. This is achieved by checking each node's value with its next node's value and updating the `next` pointer accordingly.

Here is a step-by-step breakdown of the logic:
1. **Step 1**: Check if the head of the linked list is null, in which case the function returns the head as there are no nodes to process.
2. **Step 2**: Initialize a temporary pointer `temp` to the head of the linked list to keep track of the current node.
3. **Step 3**: Traverse the linked list using a while loop, checking each node's value with its next node's value.
4. **Step 4**: If the current node's value is equal to its next node's value, update the `next` pointer of the current node to skip the duplicate node.
5. **Step 5**: If the current node's value is not equal to its next node's value, move the temporary pointer to the next node.
6. **Step 6**: Repeat steps 3-5 until the end of the linked list is reached.
7. **Step 7**: Return the head of the modified linked list.

- **Time Complexity**: The time complexity of this solution is O(n), where n is the number of nodes in the linked list, since each node is visited once.
- **Space Complexity**: The space complexity of this solution is O(1), as only a constant amount of space is used to store the temporary pointer.

## Dry Run

Let's consider an example input: a sorted linked list with nodes having values 1, 1, 2, 3, 3, 3, 4.

Here's the execution of the algorithm in a step-by-step table format:

| Step number | Current state of variables | Action taken | Result/Output |
| --- | --- | --- | --- |
| 1 | head = 1, temp = null | Check if head is null | head is not null |
| 2 | head = 1, temp = 1 | Initialize temp to head | temp = 1 |
| 3 | temp = 1, temp.next = 1 | Check if temp.next is null | temp.next is not null |
| 4 | temp = 1, temp.next = 1 | Check if temp.val == temp.next.val | temp.val == temp.next.val |
| 5 | temp = 1, temp.next = 1 | Update temp.next to temp.next.next | temp.next = 2 |
| 6 | temp = 1, temp.next = 2 | Move temp to temp.next | temp = 2 |
| 7 | temp = 2, temp.next = 3 | Check if temp.next is null | temp.next is not null |
| 8 | temp = 2, temp.next = 3 | Check if temp.val == temp.next.val | temp.val != temp.next.val |
| 9 | temp = 2, temp.next = 3 | Move temp to temp.next | temp = 3 |
| 10 | temp = 3, temp.next = 3 | Check if temp.next is null | temp.next is not null |
| 11 | temp = 3, temp.next = 3 | Check if temp.val == temp.next.val | temp.val == temp.next.val |
| 12 | temp = 3, temp.next = 3 | Update temp.next to temp.next.next | temp.next = 3 |
| 13 | temp = 3, temp.next = 3 | Check if temp.val == temp.next.val | temp.val == temp.next.val |
| 14 | temp = 3, temp.next = 3 | Update temp.next to temp.next.next | temp.next = 4 |
| 15 | temp = 3, temp.next = 4 | Move temp to temp.next | temp = 4 |
| 16 | temp = 4, temp.next = null | Check if temp.next is null | temp.next is null |
| 17 | temp = 4, temp.next = null | Exit the loop |  |

The resulting linked list after removing duplicates is: 1, 2, 3, 4.
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return head;
        }

        ListNode temp = head;

        while(temp != null && temp.next != null){
            if(temp.val == temp.next.val){
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return head;
    }
}
```
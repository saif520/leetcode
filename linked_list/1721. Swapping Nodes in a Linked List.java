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
    public ListNode swapNodes(ListNode head, int k) {
        int len=findLength(head);
        int first=k;
        int last=len-k+1;
       
        int f=1;
        int l=1;
        ListNode firstnode=head;
        ListNode secondnode=head;
        while(f<first){
            firstnode=firstnode.next;
            f++;
        }
        while(l<last){
            secondnode=secondnode.next;
            l++;
        }

        int temp=firstnode.val;
        firstnode.val=secondnode.val;
        secondnode.val=temp;

        return head;
    }
    public int findLength(ListNode current){
        int len=0;
        while(current!=null){
            current=current.next;
            len++;
        }
        return len;
    }
}
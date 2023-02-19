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
    public int[] nextLargerNodes(ListNode head) {
        int n=findLength(head);
        head=reverseList(head);


        Stack<Integer> st=new Stack<>();
        int ans[]=new int[n];
        int i=n-1;
        while(head!=null&&i>=0){
            while(st.size()>0&&st.peek()<=head.val){
                st.pop();
            }
            ans[i]=st.size()>0?st.peek():0;
            st.push(head.val);
            head=head.next;
            i--;
        }
        return ans;
    }
    public ListNode reverseList(ListNode head){
        ListNode current=head;
        ListNode nextnode=head;
        ListNode prev=null;
        while(current!=null){
            nextnode=nextnode.next;
            current.next=prev;
            prev=current;
            current=nextnode;
        }
        head=prev;
        return head;
    }
    public int findLength(ListNode temp){
        int len=0;
        while(temp!=null){
            temp=temp.next;
            len++;
        }
        return len;
    }
}
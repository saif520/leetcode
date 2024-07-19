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
    public ListNode modifiedList(int[] nums, ListNode head) {
        
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        ListNode dummy=new ListNode(-1);
        System.out.println(dummy.val);
        ListNode temp=head;
        head=dummy;
        while(temp!=null){
            // System.out.println(temp.val);
            if(set.contains(temp.val)){
                // System.out.println(temp.val);
                // continue;
            }
            else{
                ListNode t=new ListNode(temp.val);
                System.out.println(t.val);
                dummy.next=t;
                dummy=dummy.next;
            }
            temp=temp.next;
        }
        
        return head.next;
        
    }
}
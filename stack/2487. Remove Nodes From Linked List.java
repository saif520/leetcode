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
    public ListNode removeNodes(ListNode head) {
        ListNode temp=head;
        ListNode curr=head;
        int n=0;
        while(curr!=null){
            n++;
            curr=curr.next;
        }
        int arr[]=new int[n];
        int p=0;
        while(temp!=null){
            arr[p]=temp.val;
            temp=temp.next;
            p++;
        }
        Stack<Integer>st=new Stack<>();
        int res[]=new int[n];
        for(int i=n-1;i>=0;i--){
            while(st.size()>0&&arr[st.peek()]<=arr[i]){
                st.pop();
            }
            res[i]=st.size()>0?st.peek():-1;
            st.push(i);
        }
        ArrayList<Integer>list1=new ArrayList<>();
        ArrayList<Integer>list2=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(res[i]!=-1){
                list1.add(i);
            }
            else{
                list2.add(i);
            }
        }
        int r1[]=new int[list1.size()];
        int r2[]=new int[list2.size()];
        for(int i=0;i<r1.length;i++){
            r1[i]=arr[list1.get(i)];
        }
        for(int i=0;i<r2.length;i++){
            r2[i]=arr[list2.get(i)];
        }
        
        ListNode dummy=new ListNode(-1);
        ListNode ans=dummy;
        for(int i=0;i<r2.length;i++){
            dummy.next=new ListNode(r2[i]);
            dummy=dummy.next;
        }
        return ans.next;
    }
   
}
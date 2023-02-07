class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st=new Stack<>();
        int ngr[]=new int[nums2.length];
        for(int i=nums2.length-1;i>=0;i--){
            while(st.size()>0&&st.peek()<nums2[i]){
                st.pop();
            }
            ngr[i]=st.size()>0?st.peek():-1;
            st.push(nums2[i]);
        }
        for(int i=0;i<ngr.length;i++){
            System.out.print(ngr[i]+" ");
        }
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],ngr[i]);
        }
        int ans[]=new int[nums1.length];
         for(int i=0;i<nums1.length;i++){
             ans[i]=map.get(nums1[i]);
         }
         return ans;
    }
}
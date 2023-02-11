class Solution {
    public int largestRectangleArea(int[] arr) {
        int n=arr.length;
        int []nseli = new int[n];
        int []nseri = new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            int ele=arr[i];
            while(st.size()>0&&arr[st.peek()]>ele){
                int idx=st.peek();
                nseli[idx]=i;
                st.pop();
                if(st.size()>0){
                    nseri[idx]=st.peek();
                }
                else{
                    nseri[idx]=n;
                }
            }
            st.push(i);
        }
        while(st.size()>0){
            int idx=st.peek();
            nseli[idx]=-1;
            st.pop();
            if(st.size()>0){
                nseri[idx]=st.peek();
            }
            else{
                nseri[idx]=n;
            }
        }
        int maximumArea=0;
        for(int i=0;i<n;i++){
            int height=arr[i];
            int width=nseri[i]-nseli[i]-1;
            int area=height*width;
            maximumArea=Math.max(maximumArea,area);
        }
        return maximumArea;
    }
}
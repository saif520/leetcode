class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len=temperatures.length;
        int ans[]=new int[len];

        Stack<Integer>st=new Stack<>();

        for(int i=0;i<len;i++){
            while(!st.empty()&&temperatures[st.peek()]<temperatures[i]){
                ans[st.peek()]=i-st.peek();
                st.pop();
            }
            st.push(i);
        }
        return ans;
    }
}
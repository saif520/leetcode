class Solution {
    public int minOperations(String[] logs) {
        Stack<String>st=new Stack<>();
        for(int i=0;i<logs.length;i++){
            if(logs[i].equals("../")){
                if(st.size()>0){
                    st.pop();
                }
            }
            else if(logs[i].equals("./")){
                continue;
            }
            else{
                st.push(logs[i]);
            }
        }
        System.out.println(st);
        return st.size();
    }
}
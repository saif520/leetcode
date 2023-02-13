class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1=new Stack<>();
        Stack<Character> st2=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='#'){
                st1.push(s.charAt(i));
            }
            else{
                if(st1.size()>0){
                    st1.pop();
                }
            }
        }
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)!='#'){
                st2.push(t.charAt(i));
            }
            else{
                if(st2.size()>0){
                    st2.pop();
                }
            }
        }
        if(st1.size()!=st2.size()){
            return false;
        }
        else{
            while(st1.size()!=0&&st2.size()!=0){
                if(st1.peek()==st2.peek()){
                    st1.pop();
                    st2.pop();
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
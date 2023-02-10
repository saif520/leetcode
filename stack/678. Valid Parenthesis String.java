class Solution {
    public boolean checkValidString(String str) {
        char s[]=str.toCharArray();
        int n=str.length();
        Stack<Integer> open=new Stack<>();
        Stack<Integer> star=new Stack<>();

        for(int i=0;i<n;i++){
            if(s[i]=='('){
                open.push(i);
            }
            else if(s[i]=='*'){
                star.push(i);
            }
            else{
                if(!open.empty()){
                    open.pop();
                }
                else if(!star.empty()){
                    star.pop();
                }
                else{
                    return false;
                }
            }
        }
        while(!open.empty()){
            if(star.empty()){
                return false;
            }
            else if(open.peek()<star.peek()){
                open.pop();
                star.pop();
            }
            else{
                return false;
            }
        }
        return true;
    }
}
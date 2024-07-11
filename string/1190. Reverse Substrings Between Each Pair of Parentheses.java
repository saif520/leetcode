class Solution {
    public String reverseParentheses(String s) {
        char[]str=s.toCharArray();

        for(int i=0;i<str.length;i++){
            if(str[i]==')'){
                String t="";
                int j=i;
                str[j]='0';
                j--;
                while(str[j]!='('){
                    t+=str[j];
                    j--;
                }
                str[j]='0';
                int p=0;
                j++;
                while(p<t.length()){
                    str[j]=t.charAt(p);
                    p++;
                    j++;
                }
            }
        }

        String ans="";
        for(int i=0;i<s.length();i++){
            if(str[i]!='0'){
                ans+=str[i];
            }
        }
        return ans;
    }
}
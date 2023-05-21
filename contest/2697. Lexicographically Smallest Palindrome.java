class Solution {
    public String makeSmallestPalindrome(String s) {
        StringBuilder st=new StringBuilder(s);
        int l=s.length();
        for(int i=0;i<l/2;i++){
            char c1=s.charAt(i);
            char c2=s.charAt(l-1-i);
            
            if(c1!=c2){
                c1=c1<=c2?c1:c2;
                st.setCharAt(i,c1);
                st.setCharAt(l-1-i,c1);
            }
        }
        return st.toString();
    }
}
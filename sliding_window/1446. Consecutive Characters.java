class Solution {
    public int maxPower(String s) {
        if(s.length()==1){
            return 1;
        }
        int i=1;
        int j=0;
        int ans=0;
        while(i<s.length()){
            if(s.charAt(i)!=s.charAt(i-1)){
                j=i;
            }
            ans=Math.max(ans,i-j+1);
            i++;
        }
        return ans;
    }
}
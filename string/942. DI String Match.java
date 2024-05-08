class Solution {
    public int[] diStringMatch(String s) {
        int[]ans=new int[s.length()+1];
        int high=s.length();
        int lo=0;
        int k=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='D'){
                ans[k++]=high--;
            }
            else{
                ans[k++]=lo++;
            }
        }
        ans[k++]=high;
        return ans;
    }
}
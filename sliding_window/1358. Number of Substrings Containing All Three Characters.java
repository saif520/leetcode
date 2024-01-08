class Solution {
    public int numberOfSubstrings(String s) {
        int ans=0;
        int count[]=new int[3];
        int start=0;
        for(int end=0;end<s.length();end++){
            count[s.charAt(end)-'a']++;
            while(count[0]>=1&&count[1]>=1&&count[2]>=1){
                ans+=s.length()-end;
                count[s.charAt(start)-'a']--;
                start++;
            }
        }
        return ans;
    }
}
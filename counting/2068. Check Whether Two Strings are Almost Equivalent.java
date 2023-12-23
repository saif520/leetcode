class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int n=word1.length();
        int count1[]=new int[26];
        int count2[]=new int[26];
        for(int i=0;i<n;i++){
            count1[word1.charAt(i)-'a']++;
            count2[word2.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(Math.abs(count1[i]-count2[i])>3){
                return false;
            }
        }
        return true;
    }
}
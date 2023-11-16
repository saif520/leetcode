class Solution {
    public int minTimeToType(String word) {
        int count=word.length();
        char pre='a';
        for(int i=0;i<word.length();i++){
            char cur=word.charAt(i);
            int diff=Math.abs(cur-pre);
            diff=Math.min(diff,26-diff);
            count+=diff;
            pre=cur;
        }
        return count;
    }
}
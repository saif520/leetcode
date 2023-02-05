class Solution {
    public int minDeletions(String s) {
        int delection=0;
        int [] freq=new int[26];
        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }
        Set<Integer> uniquefrequencies =new HashSet<Integer>();
        for(int count:freq){
            while(count>0 && uniquefrequencies.contains(count)){
                delection++;
                count--;
            }
            uniquefrequencies.add(count);
        }
        return delection;
    }
}
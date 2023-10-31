class Solution {
    public int countPrefixes(String[] words, String s) {
        int res=0;
        for(String word:words){
            System.out.println(word);
            if(s.indexOf(word)==0)
            {
                res++;
            }
        }
        return res;
    }
}
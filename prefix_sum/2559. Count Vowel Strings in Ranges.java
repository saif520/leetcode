class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int ans[]=new int[queries.length];
        int prefix[]=new int[words.length];
        HashSet<Character>set=new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        for(int i=0;i<words.length;i++){
            String temp=words[i];
            char first=temp.charAt(0);
            char last=temp.charAt(temp.length()-1);
            if(set.contains(first)&&set.contains(last)){
                prefix[i]=1;
            }
        }

        for(int i=1;i<prefix.length;i++){
            prefix[i]+=prefix[i-1];
        }
        int p=0;
        for(int[] q:queries){
            int start=q[0];
            int end=q[1];
            int score=prefix[end]-((start==0)?0:prefix[start-1]);
            ans[p]=score;
            p++;
        }

        return ans;
    }
}
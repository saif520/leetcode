class Solution {
    public int similarPairs(String[] words) {
        int count=0;
        for(int i=0;i<words.length-1;i++){
            TreeSet<Character>set1=new TreeSet<>();
            for(int p=0;p<words[i].length();p++){
                set1.add(words[i].charAt(p));
            }
            for(int j=i+1;j<words.length;j++){
                 TreeSet<Character>set2=new TreeSet<>();
                for(int p=0;p<words[j].length();p++){
                    set2.add(words[j].charAt(p));
                }
                if(set1.equals(set2)){
                    count++;
                }
            }
        }
        return count;
    }
}
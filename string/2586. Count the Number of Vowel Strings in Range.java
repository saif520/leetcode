class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        HashSet<Character>st=new HashSet<>();
        st.add('a');
        st.add('e');
        st.add('i');
        st.add('o');
        st.add('u');
        int count=0;
        for(int i=left;i<=right;i++){
            int si=0;
            int ei=words[i].length()-1;
            if(st.contains(words[i].charAt(si))&&st.contains(words[i].charAt(ei))){
                count++;
            }
        }
        return count;
    }
    
}
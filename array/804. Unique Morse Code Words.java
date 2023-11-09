class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String arr[]={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String ss="abcdefghijklmnopqrstuvwxyz";
        char[] ch = ss.toCharArray();
        HashMap<Character,String>set=new HashMap<>();
        for(int i=0;i<ch.length;i++){
            set.put(ch[i],arr[i]);
        }
        
        HashSet<String>ans=new HashSet<>();
        for(int i=0;i<words.length;i++){
            String str=words[i];
            String s="";
            int j=0;
            while(j<str.length()){
                s+=set.get(str.charAt(j));
                j++;
            }
            ans.add(s);
        }
        return ans.size();
    }
}
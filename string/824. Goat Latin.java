class Solution {
    public String toGoatLatin(String sentence) {
        String[]s=sentence.split(" ");
        String ans="";
        String temp="ma";
        HashSet<Character>set=new HashSet<>();
        String v="aeiouAEIOU";
        for(int i=0;i<v.length();i++){
            set.add(v.charAt(i));
        }
        for(int i=0;i<s.length;i++){
            String str=s[i];
            temp+="a";
            char firstChar=str.charAt(0);

            if(!set.contains(str.charAt(0))){
                String t=str.substring(1);
                str=t;
                str+=firstChar;
            }
            str+=temp;

            ans+=str;
            ans+=" ";

        }
        String finalAns=ans.substring(0,ans.length()-1);
        return finalAns;
    }
}
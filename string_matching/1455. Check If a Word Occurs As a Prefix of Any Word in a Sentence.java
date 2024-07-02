class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] word=sentence.split(" ");
        for(int i=0;i<word.length;i++){
            String str=word[i];

            if(str.length()>=searchWord.length()){
                int p=0;
                boolean flag=true;
                while(p<searchWord.length()){
                    if(str.charAt(p)!=searchWord.charAt(p)){
                        flag=false;
                        break;
                    }
                    p++;
                }
                if(flag==true){
                    return i+1;
                }
            }
        }
        
        return -1;
    }
}
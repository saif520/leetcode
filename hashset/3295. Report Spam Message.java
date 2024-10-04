class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        HashSet<String>set=new HashSet<>();
        for(int i=0;i<bannedWords.length;i++){
            set.add(bannedWords[i]);
        }
        int count=0;
        for(int i=0;i<message.length;i++){
            if(set.contains(message[i])){
                count++;
            }
        }
        System.out.println(count);
        return count>=2?true:false;
    }
}
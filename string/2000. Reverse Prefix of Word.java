class Solution {
    public String reversePrefix(String word, char ch) {
        Deque<Character>dq=new ArrayDeque<>();
        int count=0;
        for(int i=0;i<word.length();i++){
            dq.addFirst(word.charAt(i));
            if(word.charAt(i)==ch){
                break;
            }
            count++;
        }
        if(count==word.length()){
            return word;
        }
        StringBuilder sb=new StringBuilder();
        while(dq.size()!=0){
            sb.append(dq.removeFirst());
        }
        for(int i=count+1;i<word.length();i++){
            sb.append(word.charAt(i));
        }
        return sb.toString();
    }
}
class Solution {
    public String firstPalindrome(String[] words) {
        for(int i=0;i<words.length;i++){
            String str=words[i];
            int left=0;
            int right=str.length()-1;
            boolean flag=true;
            while(left<right){
                if(str.charAt(left)!=str.charAt(right)){
                    flag=false;
                    break;
                }
                left++;
                right--;
            }
            if(flag==true){
                return str;
            }
        }
        return "";
    }
}
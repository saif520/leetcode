class Solution {
    public int countSubstrings(String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            String str="";
            for(int j=i;j<s.length();j++){
                str+=s.charAt(j);
                if(checkPalindrome(str)){
                    count++;
                }
            }
        }
        return count;
    }
    public static boolean checkPalindrome(String str){
        char arr[]=str.toCharArray();
        int left=0;
        int right=arr.length-1;
        while(left<right){
            char temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
        String s = String.copyValueOf(arr);
        if(s.equals(str)){
            return true;
        }
        return false;
    }
}
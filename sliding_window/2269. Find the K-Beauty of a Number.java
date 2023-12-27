class Solution {
    public int divisorSubstrings(int num, int k) {
        String s=Integer.toString(num);
        StringBuilder str=new StringBuilder(s);
        int count=0;
        StringBuilder sum=new StringBuilder();
        for(int i=0;i<k;i++){
            sum.append(str.charAt(i));
        }
        String temp=sum.toString();
        int div=Integer.parseInt(temp);
        if(num%div==0){
            count++;
        }

        for(int i=k;i<str.length();i++){
            
            sum.deleteCharAt(0);
            sum.append(str.charAt(i));

            temp=sum.toString();
            div=Integer.parseInt(temp);

            if(div!=0&&num%div==0){
                count++;
            }
        }

        return count;
    }
}
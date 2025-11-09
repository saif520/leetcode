class Solution {
    public int countOperations(int num1, int num2) {
        int count=0;
        while(num1!=0&&num2!=0){
            int diff=Math.abs(num1-num2);
            if(num1<num2){
                num2=diff;
            }
            else if(num1>num2){
                num1=diff;
            }
            else{
                num2=diff;
            }
            count++;
        }
        return count;
    }
}
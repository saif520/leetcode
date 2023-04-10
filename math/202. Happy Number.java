class Solution {
    public boolean isHappy(int num) {
        if(num==1){
            return true;
        }
        if(num==89){
            return false;
        }

        int sumOfSquareDigits = 0;

        while(num>0){
            int rem = num%10;
            sumOfSquareDigits += rem*rem;

            num/=10;
        }

        boolean ans= isHappy(sumOfSquareDigits);
        return ans;
    }
}
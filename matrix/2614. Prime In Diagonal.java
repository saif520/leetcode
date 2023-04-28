class Solution {
    public int diagonalPrime(int[][] nums) {
        int r=nums.length;
        int c=nums[0].length;
        int max=0;
        for(int i=0;i<r;i++){
            for(int j=i;j<=i;j++){
                if(checkPrime(nums[i][j])==true){
                    if(nums[i][j]>max){
                        max=nums[i][j];
                    }
                }
                if(checkPrime(nums[i][c-i-1])==true){
                    if(nums[i][c-i-1]>max){
                        max=nums[i][c-i-1];
                    }
                }
            }
        }
        return max;
    }
    public boolean checkPrime(int num){
        if(num<=1){
            return false;
        }
        for(int i=2;i*i<=num;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}
class Solution {
    public int subtractProductAndSum(int n) {
        int sum=0;
        int mul=1;
        while(n>0){
            int r=n%10;
            mul=mul*r;
            sum=sum+r;
            n=n/10;
        }
        return mul-sum;
    }
}
class Solution {
    public int minSteps(int n) {
        int sum=0;
        int x=2;
        while(n>1){
            while(n%x==0){
                sum=sum+x;
                n=n/x;
            }
            x++;
        }
        return sum;
    }
}
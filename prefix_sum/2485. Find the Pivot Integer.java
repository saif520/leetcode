class Solution {
    private int getSum(int x){
        return (x*(x+1))/2;
    }
    public int pivotInteger(int n) {
        int ans=-1;
        for(int i=1;i<=n;i++){
            int s1=getSum(i);
            int s2=getSum(n)-getSum(i-1);
            if(s1==s2){
                return i;
            }
        }
        return ans;
    }
}
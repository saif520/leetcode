class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int res=0;
        for(int a:arr1){
            res++;
            for(int b:arr2){
                if(Math.abs(a-b)<=d){
                    res--;
                    break;
                }
            }
        }
        return res;
    }
}
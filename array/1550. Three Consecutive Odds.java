class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count=1;
        int max=Integer.MIN_VALUE;
        for(int i=1;i<arr.length;i++){
            if(arr[i]%2!=0&&arr[i-1]%2!=0){
                count++;
            }
            else{
                max=Math.max(max,count);
                count=1;
            }
        }
        max=Math.max(max,count);
        
        if(max>=3){
            return true;
        }
        return false;
    }
}
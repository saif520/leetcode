class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int arr[][]=new int[0][0];
        int c=3;
        int r=nums.length/3;
        int ans[][]=new int[r][c];
        
        Arrays.sort(nums);

        int p=0;
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                ans[i][j]=nums[p++];
            }
        }
        boolean flag=true;
        
        for(int i=0;i<r;i++){
            if(ans[i][c-1]-ans[i][0]>k){
                
                flag=false;
                break;
            }
        }
        if(flag==true){
            return ans;
        }
        return arr;
    }
}
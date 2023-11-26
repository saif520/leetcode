class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int temp[][]=new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                temp[i][j]=mat[i][j];
            }
        }
       
        for(int i=0;i<mat.length;i++){
            int arr[]=new int[mat[0].length];
            for(int j=0;j<mat[0].length;j++){
                arr[j]=mat[i][j];
            }
            
            if(i%2==0){
                leftRotate(arr,k);
            }
            else{
                rightRotate(arr,k);
            }
          
            for(int j=0;j<mat[0].length;j++){
                mat[i][j]=arr[j];
            }
        }
       
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]!=temp[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    public void leftRotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
    public void rightRotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        reverse(nums,0,n-1);
        reverse(nums,k,n-1);
        reverse(nums,0,k-1);
    }
    public void reverse(int[] nums,int start,int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}
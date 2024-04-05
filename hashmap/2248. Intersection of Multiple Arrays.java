class Solution {
    public List<Integer> intersection(int[][] nums) {
        ArrayList<Integer>ans=new ArrayList<>();
        int arr[]=new int[10001];

        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                int temp=nums[i][j];
    
                arr[nums[i][j]]++;
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]==nums.length){
                ans.add(i);
            }
        }
        return ans;
    }
}
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        Map<Integer,Integer>map=new HashMap<>();
        
        int len =arr.length;
        for(int i=0;i<len;i++){
            map.put(arr[i],i);
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int currMinIndex=Integer.MIN_VALUE;
            for(int j=0;j<m;j++){
                currMinIndex=Math.max(currMinIndex,map.get(mat[i][j]));
            }
            ans=Math.min(ans,currMinIndex);
        }
        
        for(int j=0;j<m;j++){
            int currMinIndex=Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                currMinIndex=Math.max(currMinIndex,map.get(mat[i][j]));
            }
            ans=Math.min(ans,currMinIndex);
        }
        return ans;
    }
}
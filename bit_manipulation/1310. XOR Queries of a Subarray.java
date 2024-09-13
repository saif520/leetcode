class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int ans[]=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int left=queries[i][0];
            int right=queries[i][1];
            System.out.println(left+" "+right);
            int x=arr[left];
            left++;
            while(left<=right){
                x^=arr[left];
                left++;
            }
            ans[i]=x;
        }
        return ans;
    }
}
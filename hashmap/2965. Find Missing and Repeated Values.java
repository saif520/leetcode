class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int ans[]=new int[2];
        int n=grid.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map.put(grid[i][j],map.get(grid[i][j])==null?1:map.get(grid[i][j])+1);
            }
        }
        
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            if((int)e.getValue()==2){
                ans[0]=(int)e.getKey();
            }
        }
        
        
        for(int i=1;i<=n*n;i++){
            if(map.containsKey(i)){
                continue;
            }
            else{
                
                ans[1]=i;
                break;
            }
        }
        
        return ans;
    }
}
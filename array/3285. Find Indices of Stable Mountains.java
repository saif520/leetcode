class Solution {
    public List<Integer> stableMountains(int[] height, int threshold) {
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=1;i<height.length;i++){
            if(height[i-1]>threshold){
                ans.add(i);
            }
        }
        return ans;
    }
}
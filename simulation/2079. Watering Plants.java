class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int n=plants.length;
        int co=0;
        int curr=capacity;
        co++;
        for(int i=0;i<n-1;i++){
            curr-=plants[i];
            if(curr>=plants[i+1]){
                co++;
                continue;
            }
            else{
                co+=2*(i+1);
                curr=capacity;
                co++;
            }
        }
        return co;
    }
}
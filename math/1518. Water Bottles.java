class Solution {
    public int numWaterBottles(int nb, int ne) {
        
        int ans=nb;

        while(nb>=ne){
            int t=nb/ne;
            int r=nb%ne;
            ans+=t;
            nb=t+r;
        }       
        return ans;
    }
}
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total_gas=0;
        for(int g : gas){
            total_gas+=g;
        }
        int total_cost=0;
        for(int c : cost){
            total_cost+=c;
        }
        if(total_cost>total_gas){
            return -1;
        }
        int start = 0;
        int remaining_gas = 0;
        for(int i=0;i<cost.length;i++){
            remaining_gas+=gas[i];

            if(remaining_gas>=cost[i]){
                remaining_gas-=cost[i];
            }
            else{
                start=i+1;
                remaining_gas=0;
            }
        }
        return start;
    }
}
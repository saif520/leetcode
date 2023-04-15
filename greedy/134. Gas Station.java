class Solution {
    public int canCompleteCircuit(int[] pick, int[] spend) {
        int totalPick=0;
        int totalSpend=0;
        int n=pick.length;
        for(int i=0;i<n;i++){
            totalPick+=pick[i];
            totalSpend+=spend[i];
        }
        if(totalPick<totalSpend) return -1;
        int tank=0;
        int sp=-1;

        for(int i=0;i<n;i++){
            tank+=pick[i];
            tank-=spend[i];
            if(tank<0){
                tank=0;
                sp=-1;
            }
            else{
                if(sp==-1)sp=i;
            }
        }
        return sp;
    }
}
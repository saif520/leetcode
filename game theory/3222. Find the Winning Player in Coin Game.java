class Solution {
    public String losingPlayer(int x, int y) {
        int count=0;
        while(x>=1&&y>=4){
            x=x-1;
            y=y-4;
            count++;
        }
        if(count%2!=0){
            return "Alice";
        }
        return "Bob";
    }
}
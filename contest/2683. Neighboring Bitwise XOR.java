class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int countone=0;
        for(int i=0;i<derived.length;i++){
            if(derived[i]==1){
                countone++;
            }
        }
        if(countone%2==0){
            return true;
        }
        else{
            return false;
        }
    }
}
class Solution {
    public List<Integer> lexicalOrder(int n) {
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=1;i<=9;i++){
            util(i,n,ans);
        }
        return ans;
    }
    void util(int i,int n,ArrayList<Integer>ans){
        if(i>n){
            return;
        }
        ans.add(i);
        for(int j=0;j<10;j++){
            util(i*10+j,n,ans);
        }
    }
}
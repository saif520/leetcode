class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String>op=new ArrayList<>();
        int i=1;
        for(int num:target){
            while(i<num){
                op.add("Push");
                op.add("Pop");
                i++;
            }
            op.add("Push");
            i++;
        }
        return op;
    }
}
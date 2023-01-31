class Solution {
    public void duplicateZeros(int[] arr) {
        ArrayList<Integer> a=new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                a.add(0);
                a.add(0);
            }
            else{
                a.add(arr[i]);
            }
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=a.get(i);
        }
    }
}
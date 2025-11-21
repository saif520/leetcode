class Solution {
    public int distributeCandies(int[] candyType) {
        int n=candyType.length;
        HashSet<Integer>set=new HashSet<>();
        for(int c:candyType){
            set.add(c);
        }
        System.out.println(set);
        if(set.size()<=n/2){
            return set.size();
        }
        return n/2;
    }
}
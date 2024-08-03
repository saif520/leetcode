class Solution {
    private List<Integer>sieveOfEratosthenes(int limit){
        boolean[] isPrime=new boolean[limit+1];
        Arrays.fill(isPrime,true);
        isPrime[0]=false;
        isPrime[1]=false;

        for(int i=2;i*i<=limit;i++){
            if(isPrime[i]){
                for(int j=i*i;j<=limit;j+=i){
                    isPrime[j]=false;
                }
            }
        }
        List<Integer>primes=new ArrayList<>();
        for(int i=2;i<=limit;i++){
            if(isPrime[i]){
                primes.add(i);
            }
        }
        return primes;
    }
    public int nonSpecialCount(int l, int r) {
        int total=r-l+1;
        int count=0;

        int sqrtR=(int)Math.sqrt(r);
        List<Integer>primes=sieveOfEratosthenes(sqrtR);
        for(int prime:primes){
            int square=prime*prime;
            if(square>=l&&square<=r){
                count++;
            }
        }
        return total-count;
    }
}
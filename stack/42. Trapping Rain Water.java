class Solution {
    public int trap(int[] arr) {
        int n=arr.length;
        int maxHeight=0;
		int []lmax=new int[n];
		for(int i=0;i<n;i++){
			if(arr[i]<=maxHeight){
				lmax[i]=maxHeight;
			}
			else{
				maxHeight=arr[i];
				lmax[i]=arr[i];
			}
		}
		maxHeight=0;
		int []rmax=new int[n];
		for(int i=n-1;i>=0;i--){
			if(arr[i]<=maxHeight){
				rmax[i]=maxHeight;
			}
			else{
				maxHeight=arr[i];
				rmax[i]=arr[i];
			}
		}
		int totalWaterStored=0;
		for(int i=0;i<n;i++){
			int heightTillWaterCanGo=Math.min(lmax[i],rmax[i]);
			int height=heightTillWaterCanGo-arr[i];
			int waterStoredAboveMe=height*1;
			totalWaterStored+=waterStoredAboveMe;
		}
		return totalWaterStored;
    }
}
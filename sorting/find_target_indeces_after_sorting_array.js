/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
 var targetIndices = function(arr, target) {
    let n=arr.length;
    quickSort(arr,0,n-1);
	let index=(binarySearch(arr,n,target));
    while(index>=0&&index<n){
        if(arr[index-1]==arr[index]){
            index--;
        }
        else{
            break;
        }
    }
    let bag=[];
    if(index==undefined){
        return bag;
    }
    bag.push(index);
    while(index<n){
        if(arr[index]==arr[index+1]){
            bag.push(index+1);
        }
        else{
            break;
        }
        index++;
    }
    return bag;
};

function quickSort(arr,lb,ub){
	if(lb<ub){
		let loc=partition(arr,lb,ub);
		quickSort(arr,lb,loc-1);
		quickSort(arr,loc+1,ub);
	}
}

function partition(arr,lb,ub){
	let pivot=arr[lb];
	let start=lb;
	let end=ub;
	while(start<end){
		while(arr[start]<=pivot){
			start++;
		}
		while(arr[end]>pivot){
			end--;
		}
		if(start<end){
			let temp=arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
		}
	}
	let temp=arr[lb];
	arr[lb]=arr[end];
	arr[end]=temp;
	return end;
}

function binarySearch(arr,n,target){
	let left=0;
	let right=n-1;
	while(left<=right){
		let mid=Math.floor((left+right)/2);
		if(arr[mid]==target){
			return mid;
		}
		else if(arr[mid]>target){
			right--;
		}
		else{
			left++;
		}
	}
}

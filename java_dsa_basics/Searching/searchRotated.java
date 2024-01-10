public class Main
{
    public static void quicSort(int[] arr, int si, int ei){
        if(si >= ei) return;
        int pIdx = partition(arr,si,ei);
        quicSort(arr, si, pIdx-1);
        quicSort(arr, pIdx+1, ei);
    }
    
    public static int partition(int[] arr, int si, int ei){
        int pivot = arr[ei];
        int i = si-1;
        for (int j=si; j<ei; j++){
            if(arr[j] <= pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }
    
    public static void printArr(int[] arr){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        } 
        System.out.println();
    }
    
    public static int searchRotated(int[] arr, int si, int ei, int target){
        if(si > ei) return -1;
        int mid = si +(ei-si)/2;
        if(target == arr[mid]) return mid;
        if(arr[si] <= arr[mid]){// line 1
            if(arr[si] <= target && target <= arr[mid]){//left of l1
                return searchRotated(arr,si, mid-1, target);
            }
            else{//right
                return searchRotated(arr, mid+1, ei, target);
            }
        }
        else{// line 2
            if(arr[mid] <= target && target <= arr[ei]){//right of l2
                return searchRotated(arr, mid+1, ei, target);
            }
            else{//left
                return searchRotated(arr, si, mid-1, target);
            }
        }
        
    }
    
	public static void main(String[] args) {
	    int arr[] = {4,5,6,7,0,1,2};
// 		quicSort(arr, 0, arr.length-1);
		printArr(arr);
		System.out.println("taget is at "+searchRotated(arr,0,arr.length-1, 0));
	}
}

public class Main
{
    public static void bubbleSort(int arr[]){
        int n = arr.length;
        for(int i=0; i<n; i++){
            for(int j=1; j<n-i; j++){
                if(arr[j] > arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }
    
    public static void selectionSort(int arr[]){
        for(int i=0; i<arr.length; i++){
            int max = i;
            
            for(int j=i+1; j<arr.length; j++){
                if(arr[max] < arr[j]){
                    max = j;
                }
            }
            int temp = arr[max];
            arr[max] = arr[i];
            arr[i] = temp;
        }
    }
    
    public static void insertionSort(int arr[]){
        for(int i=1; i<arr.length; i++){
            int curr = arr[i];
            int prev = i-1;
            while(prev>=0 && arr[prev] < curr){
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = curr;
        }
    }
    
    public static void countSort(int arr[]){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
        }
        int freq[] = new int[max+1];
        for(int i=0; i<arr.length; i++){
            freq[arr[i]]++;
        }
        int j = 0;
        for(int i=freq.length-1; i >=0; i--){
            while(freq[i] > 0){
                arr[j++] = i;
                freq[i]--;
            }
        }
    }
    
	public static void main(String[] args) {
		int arr[] = {3,6,2,1,8,7,4,5,3,1};
// 		bubbleSort(arr);
        // selectionSort(arr);
        // insertionSort(arr);
        countSort(arr);

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
	}
}

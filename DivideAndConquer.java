public class DivideAndConquer {

    public static void printArray(int arr[]) {
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void mergeSort(int arr[], int si, int ei) {
        //base case
        if(si >= ei){
            return;
        }
        // kaam 
        int mid = si + (ei-si)/2;   // (si+ei)/2
        mergeSort(arr, si, mid);     // left part
        mergeSort(arr, mid+1, ei);   // right part
        merge(arr, si, mid, ei);
    }
    public static void merge(int arr[], int si, int mid, int ei) {    // function made for merge sort
        // left(0,3)=4  right(4,6)=3   -> 6-0+1
        int temp[] = new int[ei-si+1];
        int i = si;  // iterator for left part
        int j = mid+1;  // iterator for right part
        int k = 0;  // iterator for temp array

        while(i <= mid && j <= ei){
            if(arr[i]<arr[j]){
                temp[k] = arr[i];
                i++; 
            } else {
                temp[k] = arr[j];
                j++; 
            }
            k++;
        }

        //It may be possible that one of the array is not completed
        //copy the remaining elemnts
        // left part
        while(i <= mid){
            temp[k++] = arr[i++];
        }

        // rigth part
        while(j <= ei){
            temp[k++] = arr[j++];
        }

        // copy temp to original array
        for(int h=0, a= si; h<temp.length;h++, a++){
            arr[a] = temp[h];
        }
    }

    public static void quickSort(int arr[], int si, int ei) {
        // base case
        if(si >= ei){
            return;
        }
        // last elemet -pivot
        int pIndex = partition(arr, si, ei);
        quickSort(arr, si,pIndex-1);  // left
        quickSort(arr, pIndex+1, ei);   // right
    }

    public static int partition(int arr[], int si, int ei) {            // function made for merge sort
        int pivot = arr[ei];
        int i = si-1;   // to make place for elements less than pivot  // i is an iterator  

        for(int j=si;j<ei;j++){
            if(arr[j] <= pivot){
                i++;
                // swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
            i++;
            // swap
            int temp = pivot;
            arr[ei] = arr[i];
            arr[i] = temp;
            return i;
    }

    public static int searchInRotatedSortedArray(int arr[], int target, int si, int ei) {
        if(si>ei){
            return -1;
        }
        // kaam
        int mid = si + (ei-si)/2;

        // case FOUND
        if(arr[mid] == target){
            return mid;
        }

        // mid on Line 1
        if(arr[si] <= arr[mid]){
            // case a : left 
            if(arr[si] <= target && target <= arr[mid]){
                return searchInRotatedSortedArray(arr, target, si, mid-1);
            } else {
                // case b : right
                return searchInRotatedSortedArray(arr, target, mid+1, ei);
            }
        }

        // mid on Line 2
        else {
            // case c : right 
            if(arr[mid] <= target && target <= arr[ei]){
                return searchInRotatedSortedArray(arr, target, mid+1, ei);
            } else {
                // case d : left
                return searchInRotatedSortedArray(arr, target, si, mid-1);
            }
        }
    }


    public static void main(String[] args) {
        // merge sort
        // int arr[] = {6, 3, 9, 5, 2, 8, -2};
        // mergeSort(arr, 0, arr.length-1);
        // printArray(arr);

        // quick sort
        // int arr[] = {6, 3, 9, 5, 2, 8};
        // quickSort(arr, 0, arr.length-1);
        // printArray(arr);

        // search in rotated sorted array
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;   // output -> 4
        System.out.println(searchInRotatedSortedArray(arr, target, 0, arr.length-1)); 

    }
}

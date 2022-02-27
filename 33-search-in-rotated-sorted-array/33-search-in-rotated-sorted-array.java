class Solution {
    public int search(int[] arr, int target) {
       int pivot = findPivot(arr);
        int ind = -1;
        if(pivot!=-1) {
             if(target == arr[pivot])
                return pivot;
            else if(target >= arr[0])
                return findTarget(arr, target, 0,pivot-1);
            else
                return findTarget(arr, target, pivot+1, arr.length-1);
        }
       
        else
            return findTarget(arr, target, 0, arr.length-1);
       // System.out.println(ind + " :: "+arr[ind]);
    }
   private static int findTarget(int[] arr, int target, int start,int end) {
        while (start <= end){
            int mid = start+(end-start)/2;
            if(target > arr[mid])
                start = mid+1;
            else if (target < arr[mid])
                end = mid-1;
            else
                return mid;
        }
        return -1;
    }

    private static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if( mid <end && arr[mid] > arr[mid+1]){
                return mid;
            }
            else if(mid > start && arr[mid]<arr[mid-1]){
                return mid-1;
            }
            else if(arr[mid] <= arr[start]){
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }
        return -1;
    }
}
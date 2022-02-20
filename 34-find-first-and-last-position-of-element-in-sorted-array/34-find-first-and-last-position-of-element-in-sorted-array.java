class Solution {
    public int[] searchRange(int[] arr, int target) {
        int firstOccur = findFirstOccur(arr,target);
        int lastOccur = findLastOccur(arr,target);
        return new int[]{firstOccur,lastOccur};
    }
    private static int findFirstOccur(int[] arr, int target) {
        int start = 0;
        int end=arr.length-1;
        int result = -1;
        while(start<=end){
            int mid = start+(end-start)/2;

             if(target>arr[mid])
            {
                start= mid+1;
            }
            else if(target < arr[mid]){
                 end=mid-1;
            }else if(target == arr[mid]) {
                 result = mid;
                 end = mid-1;
             }

        }
        return result;
    }
    private static int findLastOccur(int[] arr, int target) {
        int start = 0;
        int end=arr.length-1;
        int result = -1;
        while(start<=end){
            int mid = start+(end-start)/2;

            if(target>arr[mid])
            {
                start= mid+1;
            }
            else if(target < arr[mid]){
                end=mid-1;
            }else if(target == arr[mid]) {
                result = mid;
                start = mid+1;
            }
        }
        return result;
    }
}
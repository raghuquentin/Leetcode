/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakIndex = findPeakIndex(mountainArr);
       // System.out.println("index ::" + peakIndex + " value:: " + arr[peakIndex]);
        int firstHalf = findElement(mountainArr, target, 0, peakIndex,true);
        if (firstHalf != -1)
            return firstHalf;
        else
            return findElement(mountainArr, target, peakIndex, mountainArr.length()-1,false);
       
    }
     private static int findElement(MountainArray mountainArr, int target, int start, int end,boolean ignosticOrder) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midele = mountainArr.get(mid);
            if (target < midele){
                if(ignosticOrder)
                    end = mid - 1;
                else
                    start = mid+1;
            }
            else if (target > midele){
                 if(ignosticOrder)
                    start = mid + 1;
                else
                    end=mid-1;
            }
            else
                return mid;
        }
        return -1;
    }

    private static int findPeakIndex(MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length()-1;
       
        while(start<=end){
            int mid = start+(end-start)/2;
             int mid1 =mountainArr.get(mid); 
             int mid1ele=mountainArr.get(mid+1);
            if(start == end)
                return start;
            if(mid1<mid1ele)
                start = mid+1;
            else if(mid1>mid1ele)
                end = mid;

        }
        return -1;
    }
}
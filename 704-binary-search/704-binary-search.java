class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0)
            return -1;
        if(nums.length ==1 && nums[0] == target){
            return 0;
        }
        int start = 0;
        int end = nums.length -1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(target > nums[mid])
                start=mid+1;
            else if(target < nums[mid])
                end=mid-1;
            else
                return mid;
        }
         return -1;
    }
}
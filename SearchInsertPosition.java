//https://www.youtube.com/watch?v=-X4NW1m7Z74&ab_channel=HackerHeap

class Solution {
    private static int searchInsert(int[] nums, int target) {
        
        int low = 0, high = nums.length -1;
        
        
        while(low<=high)
        {
            int  mid = low + (high-low)/2 ;//updating mid in every iteration

            
            if(target == nums[mid])
                return mid;
            else if(target > nums[mid])
            {
                low = mid+1;
            }
            
            else if(target < nums[mid])
                high = mid -1;
            
            
        }
        
        return high;
        
    }
    
    public static void main(String[] args) {
        int nums[] = {1,3,5,7};
        int target = 3;

        System.out.println(searchInsert(nums,target));
    }
}        
    
    
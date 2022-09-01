//https://takeuforward.org/data-structure/next_permutation-find-next-lexicographically-greater-permutation/
//https://www.youtube.com/watch?v=LuLCLgMElus&t=3s&ab_channel=takeUforward

//Brute force approach : O(N!*N)
/*In this approach, we find out every possible permutation of list formed by the elements of the given array and find out the permutation which is just larger than the given one.
*/


//Single pass approach | Time complextity: O(n) since two while loops
class NextPermutation {
    public void nextPermutation(int[] nums) {

        if(nums == null || nums.length <= 1) // return if array is null or containing only one 
            return;

        int i = nums.length - 2; //start reverse iteration from second last element
        while(i >= 0 && nums[i] >= nums[i + 1])  //stay in loop until your first  decrasing element is found
            i--; // thus you see through this loop you get the index for first decreasing element

        //i>=0 means its checking whether you got the index of first decreasing element or not    
        if(i >= 0) {                      
            int j = nums.length - 1; //In this iteration we will be travelling from the end to check for the element just greater than nums[i]             
            while(nums[j] <= nums[i]) 
                j--;      // j is the index of the element just greater than nums[i]
            swap(nums, i, j);    // Now swap i and j th index                
        }
        reverse(nums, i + 1, nums.length - 1); // reverse the subarray just after i that is i+1
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int[] nums, int i, int j) {
        while(i < j) 
            swap(nums, i++, j--);
    }
}

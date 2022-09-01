/*Resources:
 * https://www.youtube.com/watch?v=tHNsZHXnYd4&ab_channel=CodeLibrary-byYogesh%26Shailesh : video
 * https://leetcode.com/problems/maximum-product-subarray/discuss/48230/Possibly-simplest-solution-with-O(n)-time-complexity : code
 * https://www.geeksforgeeks.org/maximum-product-subarray/: GFg
 */
public class MaxProductSubarray {

    //Brute force:Traverse every contiguous subarray , find the product of each of the subarrays and return the maximum product of all : TC: O(n2) and Sc: o(1)
    
    /*optimal approach: Tc: O(n) and Sc: O(1)
     * Heart of the problem lies in the ambiguity that next element encountered will be positive or negative.
     * Therefore we divide our pathways into two depending on whether we are optimistic or not
     * So we maintain two subarrays one which we always want to be big ie max_Endinghere and other which we always want to be least or negative min_Endinghere
     */

    
    static int MaxProd(int[] nums){

        int result, max_Endinghere, min_Endinghere;
        result = max_Endinghere = min_Endinghere = nums[0];

        for(int i = 0; i< nums.length; i++){

            if(nums[i] < 0){ // multiplying a negative no. with max_Ending will make it less but it wants to be more bigger similarly min_Ending wants to be more negative but it will become positive.Therefore to avoid this we swap the subarrays
                int temp = max_Endinghere;
                max_Endinghere = min_Endinghere;
                min_Endinghere = temp;
            }

            // nums[i] is for starting new array whereas max_Endinghere*nums[i] will add another element in subarary
            max_Endinghere = Math.max(nums[i], max_Endinghere*nums[i]);
            min_Endinghere = Math.min(nums[i], min_Endinghere*nums[i]);

            result = Math.max(result,max_Endinghere);// keep updating the final result
        }

        return result;
    }
    public static void main(String[] args){

        int nums[] = {1,2,-3,4,5,-8};

        System.out.println("The maximum product subarray is: "+MaxProd(nums));
    }
}

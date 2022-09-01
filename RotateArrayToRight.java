/*Reources
 *https://youtu.be/BHr381Guz3Y -- Neetcode
 *https://youtu.be/gmu0RA5_zxs -- NickWhite
 *https://leetcode.com/problems/rotate-array/discuss/54250/Easy-to-read-Java-solution- code
 https://www.geeksforgeeks.org/array-rotation/ -- GFG
*/


/*Brute force approach 1: Rotate one element one by one k times:code to be written
Therefore , Tc = O(n.k) and Sc- o(1) -- code likhna baaki hai*/

/*Brute force approach 2: Using a temp array: tc and sc: O(n)
 * Create a temp array
 * last k places in original array will become  first k places of temp array
 * Store the first k places of original array at the end of temp array
 * Copy back the elements of temp array to the original array
*/


/*Optimal Approach: Tc-O(n) and Sc - O(1)
*By partly reversing the array */
import java.util.Arrays;
import java.util.Scanner;


public class RotateArrayToRight {
   

    public static int[] rotateArray(int[] nums, int k){

        k = k%nums.length; // to ensure k is always less than length of array

        reverse(nums,0,nums.length-1);// reverse the whole array
        reverse(nums,0,k-1);// reverse the first k elements
        reverse(nums,k,nums.length-1);// reverse the remaining (n-k) elements

        return nums;

    }

    public static void reverse(int[] nums,int low, int high){  // common reverse function for the reverse function calls above

        while(low<=high){

            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] =  temp;
            low++;
            high--;
        }
        

    }
    public static void main(String[] args) {
        
        int[] nums = {1,3,5,4,7};
        System.out.println("Enter no. of places with which array must be rotated");
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.close();
        System.out.println("rotated array is "+Arrays.toString(rotateArray(nums,k)));
    }

}

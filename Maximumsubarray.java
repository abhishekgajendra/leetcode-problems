//https://www.youtube.com/watch?v=HCL4_bOd3-4&ab_channel=AnujBhaiya

//Brute force approach will be to find all subarrays and then check which subarray sum will be the greatest
//Tc: O(n3) and sc: o(1)


//Kadane's algorithm
/*keep the subarrays as long as its sum is positive and discard it (i.e make current sum =0 ) when it becomes negative */

/*important observation */
//1. When all the numbers in array are positive max subarray will be the sum of all elements
//2. When all the numbers in array are negative max subarray will be the greatest number or the negative number with least magnitude
//3. When the numbers are both positive and negative, then we need to apply algo 


/*Below code is valid whether the elements are fully negative, positive or both*/
//Time complexity: O(n) and Space complexity: O(1)
import java.util.Scanner;
public class Maximumsubarray {
    
    public static int maxSubarray(int[] nums) {
        
        int currentSum = 0;

        //important!
        int maxSum = Integer.MIN_VALUE;// or you can keep it nums[0]
        //but dont keep it 0 because suppose if array contains only negative no.s then maxSum will become always greater than current sum since 0> all negative no.s

        for (int i = 0; i < nums.length; i++) {
            
            currentSum = currentSum + nums[i];
            
            //update maxsum if current sum becomes greater than maxsum
            if (currentSum>maxSum) {
                maxSum = currentSum;
            }

            //discarding the subarray as soon as its sum becomes negative
            if (currentSum<0) {
                currentSum = 0;
            }
        }
        return maxSum;

    }

    public static void main(String[] args) {
        
        System.out.println("Enter number of elements: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
       
        int nums[]=new int[n];

        System.out.println("Now, enter the elements: ");

        for(int i = 0; i< nums.length; i++){

            nums[i] = sc.nextInt();
        }

        sc.close();

        System.out.println("max subarray is "+ maxSubarray(nums));

        

        
    }
}

/*RESOURCES:
*https://youtu.be/nIVW4P8b1VA -- NEETCODE
*https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/solution/ -- LEETCODE SOLUTION
*/

// !!! Elements in right sorted array are always greater than elements in right sorted array

/*Brute force: Tc and Sc: O(n) and O(1) is to do use linear search: Initialise a variable min with first element of the array
 * Iterate and if any ele is less than update min with that element
 * If no element is found, this means that first element is actually our min element in the array so return nums[0]
*/

//Optimal approach: By binary search: tc and sc: O(logn) and O(1)
public class MinInRotatedSortedArray {
    
    //Brute force:Linear search
    static int linearsearch(int[] nums){

        int min  = nums[0];
        for(int i = 0; i<nums.length; i++){

            if(nums[i]<min){

                min = nums[i];  
                return min ;             
            }
        }

        return nums[0];
    }

    //Binary search:
    static int minElement(int[] nums){

        int low = 0;
        int high = nums.length -1 ;

        if(nums.length == 1) //some checks before we actually deep dive into binary search
            return nums[0];
            
        if(nums[high]>nums[low]) // In a sorted array or array which is rotated by the length of array itself last element is always greater than first element. Thus we are checking here if the array is unrotated or rotated by the length of array
            return nums[0];    

        while(low<=high){

            int mid = low + (high - low)/2;
            // !!!!Important: Base condition is satisfied only by the point of inflection
            if(nums[mid]>nums[mid+1])// Base condition
                return nums[mid+1];

            if(nums[mid-1]>nums[mid])// Base condition
                return nums[mid];
            
            //search starts: Concept is we are checking whether we are in left or right sorted array
            if(nums[mid]>nums[0])  //means we are in left sorted array and our min element will always be present in right sorted array so move right by setting low = mid+1;
                low = mid + 1;  
            else
                high = mid -1;// means we are in right sorted array therefore our min element will always be present in left sorted array
        }  
        
        return -1;
    }
    
   
    public static void main(String[] args){
        
        int arr[] = {4,5,6,7,8,2,3};
        System.out.println("min element by linear search is " + linearsearch(arr));
        System.out.println("min element by binary search is " + minElement(arr));
        
    }
    
}    
        
        
    

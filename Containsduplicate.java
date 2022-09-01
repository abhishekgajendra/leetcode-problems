//https://youtu.be/4oZsPXG9B94--: using hashset
//other solns developed by me

import java.util.HashSet;
import java.util.HashMap;
import java.util.Arrays;
class Containsduplicate{

    //Brute force: O(n2) 
    public static boolean bruteForce(int[] nums) {
      for (int i = 0; i < nums.length; i++) {
        
        for (int j = i+1; j < nums.length; j++) {
           if(nums[j] == nums[i])
               return true;
        }
     } 
     
     return false;
    }

    //by sorting: o(nlogn)
    public static boolean bysorting(int[] nums) {
      Arrays.sort(nums);
      int i = 0;
      while(i<=nums.length-2 && nums[i+1]!=nums[i]){
          
          i++;
      }
      
      if(i<=nums.length-2)
        return true;
      
      else
        return false;
      
    }
         
      
    
  
      //Soln using hashset: O(n)
      public static boolean containsDuplicate(int[] nums) {
          
          HashSet<Integer> numbers = new HashSet<>();
          
          for(int i = 0; i< nums.length; i++){
              
            if(numbers.contains(nums[i]))//Checking while moving elements to a  hashset, is there a duplicate value
              return true; 
              
            numbers.add(nums[i]); //if no duplicate then keep adding them in hashset
          }
          
        return false; //This statement will be reached when no duplicates are found and therefore our hashset is filled with allelements of array
          
      }    
  
  
  
      //Soln using hashmap: O(n)
  
      public static boolean containsDuplicate2(int[] nums) {
              
          HashMap<Integer, Integer> map  = new HashMap<>();
          
          for(int i = 0; i<nums.length;i++){
              
              if(map.containsKey(nums[i]))
                  return true;
              
              else
                  map.put(nums[i],i);
          }
      
          
      return false; 
      }    
  
  
      public static void main(String[] args) {
          int nums1[] = {1,2,3,4};
          int nums2[] = {1,2,3,4,4,5};
  
          System.out.println(Arrays.toString(containsDuplicate(nums1)));
          System.out.println(containsDuplicate(nums2));
          System.out.println(containsDuplicate2(nums1));
          System.out.println(containsDuplicate2(nums2));
          System.out.println(bruteForce(nums1));
          System.out.println(bruteForce(nums2));
          System.out.println(bysorting(nums1));
          System.out.println(bysorting(nums2));
      }
  }        
         
        
      
          
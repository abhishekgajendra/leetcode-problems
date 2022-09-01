//https://www.youtube.com/watch?v=2iG04aXKBAQ&ab_channel=PedroTech

//Brute force approach ; O(N2)
/*
 * class Solution {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == target - nums[i]) {
                        return new int[] { i, j };
                    }
                }
            }
        // In case there is no solution, we'll just return null
        return null;
        }
    }
 */

 //Using hashmaps: o(n)
import java.util.HashMap;
class Solution {
    public static int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        //filling hashmap
        for(int i= 0 ; i<nums.length; i++){

            map.put(nums[i],i);
            
        }
        
        //finidng other key with which sum = target 
        for(int i =0;i<nums.length; i++)
        {
            int difference = target - nums[i];
            if(map.containsKey(difference) && map.get(difference)!= i)
                return new int[]{i, map.get(difference)};// return indices in form of array
        }
        
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        int target = 5;

        System.out.println(twoSum(nums,target));
    }
}   
    
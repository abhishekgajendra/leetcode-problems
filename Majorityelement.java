/* Brute force approach
public class Majorityelement {
    public static int majorityElement(int[] nums) {
       
        for(int i = 0; i< nums.length; i++){
            int count = 0;
            for(int j = 0;j< nums.length; j++){
                
                if(nums[i]==nums[j])
                    count++;
               
                    
            }
             if(count>(nums.length)/2)
                        return nums[i];
        }
        
        return -1;
            
    }

    public static void main(String[] args) {
        int[] nums = {1,3,3,3,1};

        System.out.println("majority element is"+" "+majorityElement(nums));
    }
}

*/

// https://stackoverflow.com/questions/46898/how-do-i-efficiently-iterate-over-each-entry-in-a-java-map

//using Hashmaps

import java.util.Map;



import java.util.Arrays;
import java.util.HashMap;
class Majorityelement {

    //lets associate the elements with their counts by using hashmap
    private static Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            }
            else {
                counts.replace(num, counts.get(num)+1);
            }
        }
        return counts;
    }

    //Now lets check the entries of hashmap to determine which has the largest key value
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);

        Map.Entry<Integer, Integer> majorityEntry = null;

        //from java 11 you can use var entry : counts.entrySet() for iteration
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }

        return majorityEntry.getKey();
    }

    //by sorting the array (O(NlogN))
    public static int sort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];

    }

    //using boyer moore's voting algorithm:  O(n)
    public static int boyer(int[] nums) {

        int count = 0;
        Integer candidate = null;

        for(int element: nums){

            if(count == 0)
                candidate = element;
            
            if (candidate == element) 
                    count++;
            else{
                    count--;
            }
            
                
                
        }

        return candidate;
        
    }

    public static void main(String[] args) {
        int nums[] = {1,1,1,2,3,1,4};
        System.out.println("majele using hashmaps is  " + majorityElement(nums));
        System.out.println("majorityele using sorting is "+ sort(nums));
        System.out.println("majority element using boyer moore's voting algo is "+ boyer(nums));
    }
}


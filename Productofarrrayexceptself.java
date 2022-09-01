import java.util.Arrays;

public class Productofarrrayexceptself {

    //Brute force approach
    public static int[] product1(int[] nums) {
        
        int product = 1;
        int answer[] = new int[nums.length]; 
        
      
        for(int i = 0; i<nums.length; i++){
            product = 1;
            for(int j = 0; j< nums.length ; j++){
                if(i == j)
                    continue;
                product = product*nums[j];
            }
            answer[i] = product;
        }
        
        return answer;
            
    }
    
    //my appraoch
    public static int[] product(int[] nums) {


        int product = 1;
        int count = 0;
        int[] answer = new int[nums.length];

        //for loop for calculating our product
        for (int i = 0; i < nums.length; i++) {
            
            if(nums[i] == 0){
                count++;
                if(count>1)
                    return answer;
                continue;    
            }

            else
                product = product*nums[i];
        }

        //another for loop for filling our answer array
        for (int j = 0; j < answer.length; j++) {
            if(count == 1){
                if(nums[j] == 0)
                    answer[j] = product;
                else    
                    answer[j] = 0;
            }

            else{
                answer[j] = product/nums[j];
            }
        }

        return answer;
        
    }

    

    public static void main(String args[]){

        int arr[] = {1,0,4,5,6};
        int arr1[] = {1,2,3,4,5};
        int arr2[] = {1,2,0,0,4};

        System.out.println(Arrays.toString(product1(arr)));
        System.out.println(Arrays.toString(product1(arr1)));
        System.out.println(Arrays.toString(product1(arr2)));

    }
}

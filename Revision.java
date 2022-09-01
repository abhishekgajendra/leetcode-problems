class Solution{

   public static void main(String[] args){
      int[] nums = {1,3,-1,-3,5};

      System.out.println(maxArr(nums));
   }

   static int maxArr(int[] nums){

      int currentSum = 0;
      int maxSum = Integer.MIN_VALUE;

      for(int i = 0; i<nums.length; i++){
         
         currentSum = currentSum + nums[i];

         
         if(maxSum<currentSum)
            maxSum = currentSum;
         
            if(currentSum<0){
               currentSum = 0;
         }     

      }
      return maxSum;   
   }
}
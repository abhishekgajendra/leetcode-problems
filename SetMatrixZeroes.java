/*Optimal approach: https://leetcode.com/problems/set-matrix-zeroes/discuss/26008/My-AC-java-O(1)-solution-(easy-to-read)
*Hashset method see leetcode soln
*/
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;



public class SetMatrixZeroes{
    //Dummy array approach
    public static int[][] dummyArray(int[][] matrix){

        int[] dummy1 = new int[matrix[0].length];
        int[] dummy2 = new int[matrix.length];
        
        Arrays.fill(dummy1, -1);
        Arrays.fill(dummy2, -1);
        
        for(int i = 0; i< matrix.length;i++){
            for(int j = 0; j< matrix[0].length; j++){
                
                if(matrix[i][j] == 0){
                    
                    dummy1[j] =0;
                    dummy2[i] = 0;
                    
                }
            }
        }
        
        for(int i = 0; i< matrix.length; i++)
        {
            for(int j = 0; j<matrix[0].length; j++){
                
                if(dummy2[i] == 0 || dummy1[j] == 0){
                    
                  matrix[i][j] = 0;
                }
            }
        }

        return matrix;

    }

    
    //Optimised approach: tc: O(mn) and space complexity: O(n)
    public static int[][] optimal(int[][] matrix){
        //first row and first column will be used as markers
        boolean frow = false, fcol = false; // lets assume by default that there is no zero in first row and first column

        //First for loop will traverse the whole array and mark the rows and colums which are to be made zero
        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j< matrix[0]. length; j++){

                if(matrix[i][j] == 0){

                    if(i == 0)
                        frow = true; //set frow as true means firstrow contains a zero therefore remember it to make this row zero for future
                    if(j == 0)
                        fcol = true; // //set fcol as true means firstcol contains a zero therefore remember it to make this col zero for future
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        //Second for loop is for making the rows and columns zero which are present in markers.
    
        for(int i = 1; i< matrix.length; i++){ //We will not be traversing first row and first column because we are already using seperate markers frow and fcol for them

            for(int j=1; j<matrix[0].length; j++){

                if(matrix[0][j] == 0 || matrix[i][0] == 0)// [0][j] will help you iterate over first row Similarly [i][0] will help you iterate over first column
                    matrix[i][j] = 0;
            }
        }

        if(frow) // make first row as zero if it contains zero
        {
            for(int i = 0; i<matrix[0].length; i++)
                matrix[0][i] = 0;
                
        }    
        if(fcol) // make first column as zero if it contains zero
        {
            for(int i = 0; i<matrix.length; i++)
                matrix[0][i] = 0;

        }    
                    
        return matrix;             
    }



    //By using additional memory: time compl: O(mn) and space complexity:O(m+n)
    public static int[][] setZeroes(int[][] matrix){

            //Store the row no.s and col no.s which contians zero in set
            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();

            for(int i = 0; i< matrix.length; i++){ //Traverse through the array to find out the elements that are zero and store their respective  row nos and col nos in a hashset 
                for (int j = 0; j < matrix[0].length; j++) {
                    
                    if(matrix[i][j] == 0){

                        row.add(i);
                        col.add(j);
                    }
                }
            }

            for (int i = 0; i < matrix.length; i++) { // loop for making the rows and columns in hashsets as zero
                for (int j = 0; j < matrix[0].length; j++) {
                    
                    if(row.contains(i) || col.contains(j)){ // when row containing zero or col containing zero is found make the whole row and column = 0
                        matrix[i][j] = 0;
                    }
                }
            }

            return matrix;
    }

    public static void main(String[] args) {
        
        int[][] matrix = {{1,2,3,1},{1,0,7,3},{2,2,4,0}};
        int[][] matrix1 = {{1,2,3,1},{1,0,7,3},{2,2,4,0}};
        int[][] matrix2 = {{1,2,3,1},{1,0,7,3},{2,2,4,0}};

        setZeroes(matrix);

        System.out.println("Set matrix is :");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");

            }
            System.out.println("");
        }

        optimal(matrix1);
        System.out.println("Set matrix is :");
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                System.out.print(matrix1[i][j]+" ");

            }
            System.out.println("");
        }

        dummyArray(matrix2);
        System.out.println("Set matrix is :");
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                System.out.print(matrix2[i][j]+" ");

            }
            System.out.println("");

       
    }
}
}


//https://takeuforward.org/data-structure/rotate-image-by-90-degree/

public class RotateImage {

    /*Brute force appraoch would be to use another matrix temp and assigning its first row as last column, second row as second last column and so on : Since we are using another matrix of n*n
    * therfore both  time complexity and space complexity of this appraoch will be : O(n2)
    */
    public static int[][] rotate(int[][] matrix){

        int n = matrix.length;
        int[][] temp = new int[n][n];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++){
                temp[j][n-i-1] = matrix[i][j];
            }
        }

        return temp;

    }

    //OPTIMAL APPROACH:
    /*By observation, we found that after finding the transpose of matrix, if we reverse each of its row then that will be equal to rotated matrix */
    public static int[][] rotate1(int[][] matrix){
        
        int n = matrix.length;
        for(int i = 0; i<n; i++) { // for loop for finding transpose of matrix
            for (int j = i; j < matrix[0].length; j++) {
                
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < matrix.length; i++) { // fpr loop for reversing each of its row
            for (int j = 0; j < matrix.length/2; j++) {
                
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j -1];
                matrix[i][matrix.length-j-1] = temp;
            }
        }

        return matrix;
    }
    public static void main(String[] args){
        int matrix[][] = {{1,4,5},{2,5,6},{5,6,7}};
        System.out.println("Original matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

        int rotated[][] = rotate(matrix); // brute force approach
        int rotated1[][] = rotate1(matrix);// optimal approach

        System.out.println("rotated image by bfs is: ");
        
        for (int i = 0; i < rotated.length; i++) {
            for (int j = 0; j < rotated.length; j++) {
                System.out.print(rotated[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println("rotated image by optimal approach is: ");
        
        for (int i = 0; i < rotated1.length; i++) {
            for (int j = 0; j < rotated1.length; j++) {
                System.out.print(rotated1[i][j]+ " ");
            }
            System.out.println();
        }


    }

    
}

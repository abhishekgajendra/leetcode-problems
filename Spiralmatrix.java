//https://youtu.be/BJnMZNwUk1M -- Neetcode
//https://youtu.be/3joo9yAZVh8 -- NickWhite

//Time complexity: O(mn) and O(1) 
import java.util.ArrayList;
import java.util.List;

public class Spiralmatrix {

    private static List<Integer> spiralOrder(int[][] matrix) {
        
        int rowBegin = 0, rowEnd = matrix.length-1;
        int colBegin = 0, colEnd = matrix[0].length-1;
        List<Integer> res = new ArrayList<>();

        if(matrix.length == 0)
            return res;

        while(rowBegin<=rowEnd && colBegin<=colEnd){
            
            //Traverse right from colBegin to colEnd
            for(int i = colBegin; i<= colEnd; i++){
                res.add(matrix[rowBegin][i]);
            }

            rowBegin++; //lets shift down one row so that while traversing in last column matrix[rowBegin-1][colEnd-1] does not again get counted
            
            //Traverse downwards in the last column 
            for(int i = rowBegin; i<=rowEnd; i++ )
                res.add(matrix[i][colEnd]);

            colEnd--;

            if (rowBegin <= rowEnd) { //checkpoint1:to check whether the row or col still exists to prevent duplicates 

                //traverse towards left from colEnd to colStart
                for(int i = colEnd; i>=colBegin; i--)
                    res.add(matrix[rowEnd][i]);

            }    

            rowEnd--;
            if (colBegin<=colEnd) { //checkpoint2:to check whether the row or col still exists to prevent duplicates 

                //traverse towards up in first column
                for(int i = rowEnd; i>=rowBegin; i--)
                res.add(matrix[i][colBegin]);
            }
            
            
            colBegin++;
        }

        return res;
    
    }
        public static void main(String[] args) {
            
            int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    
            System.out.println("Spiral order traversal: ");
            System.out.println(spiralOrder(matrix));
        }
}

            
            
            





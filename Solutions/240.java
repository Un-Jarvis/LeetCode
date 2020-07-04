/* 和#74一起看 */

/* 
 * Binary Search 最优解
 * Time Complexity: O(#Rows + #Columns)
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Return false if matrix is empty
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
       
        int rowIndex = 0, colIndex = matrix[0].length - 1;
        
        while(rowIndex < matrix.length && colIndex >= 0) {
            if (matrix[rowIndex][colIndex] == target) 
                return true;
            
            if(matrix[rowIndex][colIndex] < target)
                rowIndex++;
            else
                colIndex--;
        }
        
        return false;
    }    
}

/* 每一行用Binary Search */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Return false if matrix is empty
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;

        int height = matrix.length - 1, width = matrix[0].length - 1;

        // Return false if target is out of range of matrix
        if (target < matrix[0][0] || target > matrix[height][width]) return false;

        for (int i = 0; i <= height; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][width]) {
                if (searchRow(matrix[i], target) >= 0) return true; 
            }
        }

        return false;
    }

    public int searchRow(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (right - left > 1) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < target) left = mid;
            else if (arr[mid] > target) right = mid;
            else return mid;
        }

        if (arr[left] == target) return left;
        else if (arr[right] == target) return right;
        else return -1;
    }
}
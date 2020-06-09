class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length > 0 && matrix[i][0] <= target && matrix[i][matrix[i].length - 1] >= target) {
                int left = 0, mid = 0, right = matrix[i].length - 1;

                do {
                    mid = (left + right) / 2;

                    if (matrix[i][mid] == target || matrix[i][left] == target || matrix[i][right] == target) {
                        return true;
                    } else if (matrix[i][mid] < target) {
                        left = mid + 1;
                    } else if (matrix[i][mid] > target) {
                        right = mid;
                    }
                } while (left < right);
            }
        }
        return false;
    }
}
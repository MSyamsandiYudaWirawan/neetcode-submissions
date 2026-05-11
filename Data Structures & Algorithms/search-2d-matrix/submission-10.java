class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        final int ROWS = matrix.length;
        final int COLS = matrix[0].length;

        int top = 0;
        int bot = ROWS - 1;
        int mid = 0;
        while(top<=bot){
            mid = top + (bot-top)/2;
            if(matrix[mid][0] > target){
                bot = mid - 1;
            }else if(matrix[mid][COLS - 1] < target){
                top = mid + 1;
            }else{
                break;
            }
        }
        int l = 0;
        int r = COLS - 1;
        while(l<=r){
            int m = l + (r-l)/2;
            if(matrix[mid][m] < target){
                l = m + 1;
            }else if(matrix[mid][m] > target){
                r = m - 1;
            }else{
                return true;
            }
        }
        return false;
    }
}

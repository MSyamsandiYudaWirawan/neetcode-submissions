class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int top = 0;
        int bot = ROWS - 1;
        int row = -1;
        while(top<=bot){
            int mid = (bot-top)/2 + top;
            if(target > matrix[mid][COLS - 1]){
                top = mid + 1;
            }else if(target < matrix[mid][0]){
                bot = mid - 1;
            }else {
                row = mid;
                break;
            }
        }
        if(row == -1){
            return false;
        }

        int l=0,r=COLS-1;
        while(l<=r){
            int m = (r-l)/2 + l;
            if(target > matrix[row][m]){
                l = m + 1;
            } else if(target < matrix[row][m]){
                r = m - 1;
            }else {
                return true;
            }
        }
        return false;
        
    }
}

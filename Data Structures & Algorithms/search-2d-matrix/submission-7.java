class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROW = matrix.length;
        int COL = matrix[0].length;

        int top = 0;
        int bot = ROW - 1;
        int mid = 0;
        while(top <= bot){
            mid = (bot - top)/2 + top;
            if(matrix[mid][0] > target){
                bot = mid - 1;
            }else if(matrix[mid][COL - 1] < target){
                top = mid + 1;
            }else {
                break;
            }
        }
        int l = 0;
        int r = COL - 1;
        while(l<=r){
            int m = (r-l)/2 + l;
            if(matrix[mid][m] < target){
                l = m + 1;
            }else if(matrix[mid][m] > target) {
                r = m - 1;
            }
            else {
                return true;
            }
        }
        return false;
    }
}

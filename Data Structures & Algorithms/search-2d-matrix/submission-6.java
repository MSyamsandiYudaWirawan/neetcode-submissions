class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROW = matrix.length;
        int COL = matrix[0].length;

        int top = 0;
        int bot = ROW - 1;
        int mid=0;
        while(top <= bot){
            mid = (bot-top)/2 + top;
            if(target > matrix[mid][COL - 1]){
                top = mid + 1;
            }else if(target < matrix[mid][0]){
                bot = mid - 1;
            }else{
                break;
            }
        }
        int l = 0;
        int r = COL - 1;
        while(l<=r){
            int m = (r-l)/2 + l;
            if(target > matrix[mid][m]){
                l = m + 1;
            }else if(target < matrix[mid][m]){
                r = m - 1;
            }
            else {
                return true;
            }
        }
        return false;

    }
}

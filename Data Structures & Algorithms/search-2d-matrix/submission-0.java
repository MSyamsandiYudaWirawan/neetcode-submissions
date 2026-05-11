class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int t = 0;
        int b = rows-1;

        while(t<=b){
            int  row = (t+b)/ 2;
            if(target < matrix[row][0]){
                b = row-1;
            }
            else if( target > matrix[row][cols-1]){
                t = row+1;
            } else {
                break;
            }
        }
        if(!(t<=b)){
            return false;
        }
        int l=0; 
        int row = (t+b)/2;
        int r = cols-1;
        while(l<=r){
            int m = l + (r-l)/2;
            if(target > matrix[row][m]){
                l = m + 1;
            }
            else if(target < matrix[row][m]){
               r = m - 1;
            }
            else{
                return true;
            }
        }
        return false;

    }
}

public class Solution {
    public int maxArea(int[] heights) {
        int res = 0;
        int l=0;
        int r=heights.length-1;
        while(l<r){
            int area = (r-l) * Math.min(heights[r],heights[l]);
            res = Math.max(res,area);
            if(heights[l]>heights[r]){
                r--;
            }
            else{
                l++;
            }
        }
        return res;
    }
}

class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int res = 0;
        int l=0;
        int r=n-1;

        while(l<r){
            int area = Math.min(heights[l],heights[r]) * (r-l);
            res = Math.max(res,area);

            if(heights[l]<heights[r]){
                l++;
            }else{
                r--;
            }
        }
        return res;
    }
}

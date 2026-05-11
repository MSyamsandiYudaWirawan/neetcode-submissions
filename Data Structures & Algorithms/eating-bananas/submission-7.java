class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 0;
        int r = getMax(piles);
        int min = r;
        while(l<=r){
            int m = (r-l)/2 + l;
            int time = 0;
            for(int p:piles){
                time += Math.ceil((double) p/m);
            }
            if(time <= h){
                min = Math.min(min,m);
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        return min;
        
    }
    private int getMax(int[] arr){
        int max = arr[0];
        for(int n:arr){
            if(max < n){
                max = n;
            }
        }
        return max;
    }
}

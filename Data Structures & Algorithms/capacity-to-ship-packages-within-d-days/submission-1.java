class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0;
        int r = 0;
        for(int w:weights){
            l = Math.max(l,w);
            r = r + w;
        }

        while(l<r){
            int cap = l + (r-l)/2;
            int remaining = cap;
            int daysCount = 1;

            for(int w:weights){
                if(w > remaining){
                    // next day and reset remaining
                    daysCount++;
                    remaining = cap;
                }
                remaining  = remaining - w;
            }
            if(daysCount > days){
                l = cap + 1;
            }else{
                r = cap;
            }
        }
        return l;
    }
}
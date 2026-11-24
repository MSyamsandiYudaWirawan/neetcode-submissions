class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        record Data(int p, int c) {}
        List<Data> datas = new ArrayList<>();
        for (int i = 0; i < capital.length; i++) {
            datas.add(new Data(profits[i], capital[i]));
        }

        datas.sort((a, b) -> a.c - b.c);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int res = w;
        int i = 0;

        while (k > 0) {
            while (i < datas.size() && res >= datas.get(i).c) {
                pq.add(datas.get(i).p);
                i++;
            }
            if(pq.isEmpty()){
                break;
            }
            res += pq.poll();
            k--;
        }
        return res;
    }
}
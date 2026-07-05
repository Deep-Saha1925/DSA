class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int n: barcodes){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for(int k: map.keySet()){
            pq.offer(new int[]{k, map.get(k)});
        }

        int[] ans = new int[barcodes.length];
        int idx = 0;

        while(pq.size() >= 2){
            int[] f = pq.poll();
            int[] s = pq.poll();

            ans[idx++] = f[0];
            ans[idx++] = s[0];

            f[1]--;
            s[1]--;

            if(f[1] > 0){
                pq.offer(f);
            }

            if(s[1] > 0){
                pq.offer(s);
            }
        }

        if(!pq.isEmpty()){
            ans[idx] = pq.poll()[0];
        }

        return ans;
    }
}
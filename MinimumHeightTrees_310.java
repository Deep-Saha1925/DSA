import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if(n == 1) {
            ans.add(0);
            return ans;
        }

        List<Set<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }

        for(int[] e : edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            if(graph.get(i).size() == 1){
                q.offer(i);
            }
        }

        int remaining = n;

        while(remaining > 2){
            int size = q.size();
            remaining -= size;

            for(int i=0; i<size; i++){
                int l = q.poll();
                int neightbour = graph.get(l).iterator().next();
                graph.get(neightbour).remove(l);

                if(graph.get(neightbour).size() == 1){
                    q.offer(neightbour);
                }
            }
        }

        while(!q.isEmpty()){
            ans.add(q.poll());
        }
        return ans;
    }
}
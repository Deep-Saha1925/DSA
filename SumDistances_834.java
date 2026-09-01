import java.util.ArrayList;

class Solution {

    List<Integer>[] tree;
    int[] ans, count;
    int n;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n = n;
        tree = new ArrayList[n];

        for(int i=0; i<n; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int[] e: edges){
            tree[e[0]].add(e[1]);
            tree[e[1]].add(e[0]);
        }

        ans = new int[n];
        count = new int[n];

        dfs1(0, -1);
        dfs2(0, -1);

        return ans;
    }

    void dfs1(int node, int parent){
        count[node] = 1;

        for(int next: tree[node]){
            if(next == parent) continue;

            dfs1(next, node);
            count[node] += count[next];
            ans[node] += ans[next] + count[next];
        }
    }

    void dfs2(int node, int parent){
        for(int next: tree[node]){
            if(next == parent) continue;

            ans[next] = ans[node] - count[next] + (n - count[next]);
            dfs2(next, node);
        }
    }
}
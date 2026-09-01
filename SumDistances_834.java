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

        

        return ans;
    }
}
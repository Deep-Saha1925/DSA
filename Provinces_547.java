class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        boolean[] vis = new boolean[n];

        int provinces = 0;

        for(int i=0; i<n; i++){
            if(!vis[i]){
                provinces++;

                dfs(i, isConnected, vis);
            }
        }

        return provinces;
    }
}
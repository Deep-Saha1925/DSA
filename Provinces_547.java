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

    private void dfs(int city, int[][] graph, boolean[] vis){
        vis[city] = true;

        for(int j=0; j<graph.length; j++){
            if(graph[city][j] == 1 && !vis[j]){
                dfs(j, graph, vis);
            }
        }
    }
}
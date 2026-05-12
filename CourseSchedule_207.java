import java.util.*;
class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }

        // graph
        for(int[] p : prerequisites){
            graph.get(p[1]).add(p[0]);
        }

        int vis[] = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            if(dfs(graph, vis, i))
                return false;
        }

        return true;
    }

    private boolean dfs(ArrayList<ArrayList<Integer>> graph, int[] vis, int node){
        if(vis[node] == 1)
            return true;

        if(vis[node] == 2)
            return false;

        vis[node] = 1;

        for(int nei : graph.get(node)){
            if(dfs(graph, vis, nei))
                return true;
        }

        vis[node] = 2;

        return false;
    }
}
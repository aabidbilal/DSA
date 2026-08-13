class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i = i + 1){
            adj.add(new ArrayList<>());
        }    
        for(int i = 0; i < prerequisites.length; i = i + 1){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            adj.get(a).add(b);
        }
        int indegree[] = new int[numCourses];
        for(int i = 0; i < numCourses; i = i + 1){
            for( int it : adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i = i + 1){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        ArrayList<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.remove();
            topo.add(node);

            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        if(topo.size() == numCourses)return true;
        return false;

    }

}
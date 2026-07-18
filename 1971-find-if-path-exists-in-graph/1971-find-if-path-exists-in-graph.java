class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination)
            return true;
        boolean[] visited = new boolean[n];
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i = i + 1) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i = i + 1) {
            int a = edges[i][0], b = edges[i][1];

            list.get(a).add(b);
            list.get(b).add(a);
        }
        // BFS(source, visited, list);
        DFS(source, visited, list);

        return visited[destination];
    }

    public void DFS(int source, boolean[] visited, List<List<Integer>> list) {

        visited[source] = true;

        for (int val : list.get(source)) {
            if (!visited[val]) {
              DFS(val, visited, list);
            }
        }
    }

    // public void BFS(int source, boolean[] visited, List<List<Integer>> list) {

    //     visited[source] = true;
    //     Queue<Integer> q = new LinkedList<>();
    //     q.add(source);

    //     while (q.size() > 0) {
    //         int front = q.remove();
    //         for (int val : list.get(front)) {
    //             if (!visited[val]) {
    //                 q.add(val);
    //                 visited[val] = true;
    //             }
    //         }
    //     }
    // }
}
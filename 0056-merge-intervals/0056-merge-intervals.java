class Solution {
    public boolean isOverlap( int[] last, int[] curr){
        return curr[0] <= last[1] && curr[1] >= last[0];
    }
    public int[][] merge(int[][] intervals) {
        boolean isMerged = true;
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            list.add(interval);
        }
        while (isMerged) {
            isMerged = false;
            for (int i = 0; i < list.size(); i = i + 1) {
                int j = i + 1;
                while (j < list.size()) {
                    int[] last = list.get(i);
                    int[] curr = list.get(j);

                    if (isOverlap(last, curr)) {
                        last[0] = Math.min(last[0], curr[0]);
                        last[1] = Math.max(last[1], curr[1]);

                        list.remove(j);
                        isMerged = true;
                    } else {
                        j = j + 1;
                    }
                }
            }
        }
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i = i + 1){
            ans[i] = list.get(i);
        }
        return ans;
    }
}
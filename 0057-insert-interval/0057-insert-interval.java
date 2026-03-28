class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        ArrayList<int[]> list = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && newInterval[0] > intervals[i][1]) {
            list.add(intervals[i]);
            i = i + 1;
        }
        
        while (i < intervals.length  &&newInterval[0] <= intervals[i][1] && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i = i + 1;
        }
        list.add(newInterval);
        while( i < intervals.length){
            list.add(intervals[i]);
            i = i + 1;
        }
        int[][] ans = new int[list.size()][2];
        for ( int j = 0; j < list.size(); j = j + 1){
            ans[j] = list.get(j);
        }
        return ans;

    }
}
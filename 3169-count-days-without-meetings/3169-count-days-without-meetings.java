class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> list = new ArrayList<>();

        list.add(meetings[0]);

        for ( int i = 0; i < meetings.length; i = i + 1){

          int[] prev = list.get(list.size() - 1);
          int[] curr = meetings[i];

          if ( curr[0] <= prev[1] ){
            prev[0] = Math.min(prev[0], curr[0]);
            prev[1] = Math.max(prev[1], curr[1]);
          }else{
            list.add(meetings[i]);
          }
        }

        int gap = 0;
        for ( int i = 1; i < list.size(); i = i + 1){
            gap += list.get(i)[0] - list.get(i - 1)[1] - 1;
        }
        gap += list.get(0)[0] - 1;
        gap += days - list.get(list.size() - 1)[1];

    return gap;
    }
}
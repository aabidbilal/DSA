class Solution {

    public boolean isEligible(int[] last, int[] curr) {
        return curr[0] <= last[1] && last[0] <= curr[1];
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < firstList.length; i = i + 1) {

            for (int j = 0; j < secondList.length; j = j + 1) {
                int[] last = firstList[i];
                int[] curr = secondList[j];

                if (isEligible(last, curr)) {
                     int[] ans = new int[2];
                ans[0] = Math.max(last[0], curr[0]);
                ans[1] = Math.min(last[1], curr[1]);

                list.add(ans);
                }
            }
        }
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i = i + 1) {
            result[i] = list.get(i);
        }
        return result;

    }
}
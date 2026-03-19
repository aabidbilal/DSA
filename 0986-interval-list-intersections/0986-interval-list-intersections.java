class Solution {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> list = new ArrayList<>();
        int i = 0,
                j = 0;
        while (i < firstList.length && j < secondList.length) {

            int s1 = firstList[i][0],
                    e1 = firstList[i][1],
                    s2 = secondList[j][0],
                    e2 = secondList[j][1];
            if (e1 >= s2 && e2 >= s1) {
                list.add(new int[] {
                        Math.max(s1, s2),
                        Math.min(e1, e2)
                });  
            }
             if (e1 < e2) {
                    i = i + 1;
                } else {
                    j = j + 1;
                }
        }
        int[][] result = new int[list.size()][2];
        for (int k = 0; k < list.size(); k = k + 1) {
            result[k] = list.get(k);
        }
        return result;

    }
}
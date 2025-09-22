class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        
        for(int i=0;i<image.length;i++){
            int len = image[i].length-1;
            for (int j=0;j<=len/2;j++){
                int temp=image[i][j];
                image[i][j]=(image[i][len-j])^1;
                image[i][len-j]=(temp)^1;

            }
        }
        return image;
    }
}
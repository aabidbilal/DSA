class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
    int count = 0;
    for ( int i = 0; i <= arr.length - k; i = i + 1){
        int sum = 0;
        for(int j = i; j < i + k; j = j + 1){
            sum = sum + arr[j];
        }
        int avg = sum / k;
        if(avg >= threshold){
            count = count + 1;
        }
    }
    return count;        
    }
}
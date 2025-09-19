class Solution {
    public List<Boolean> kidsWithCandies(int[] arr, int k) {
        ArrayList<Boolean> ans=new ArrayList<>();
        
        for(int i=0;i<arr.length;i++){
            boolean check = true;
           int currentcandies= arr[i]+k;
            for(int j=0;j<arr.length;j++){
                if(currentcandies<arr[j]){
                    check=false;
                    break;
            }}
            if(check){
                ans.add(true);
            }else{
                ans.add(false);
            }
            
            
        }
        return ans;

    }
}
class NumArray {
    
    int n;
    int[] segTree;

    public void buildtree(int i, int l, int r, int[] nums){
        if(l == r){
            segTree[i] = nums[l];
            return;
        }
        int mid = (l + r) / 2;

        buildtree(2 * i + 1, l , mid, nums);
        buildtree(2 * i + 2, mid + 1, r, nums);

        segTree[i] = segTree[2 * i + 1] + segTree[2 * i + 2];
    }
    public void updateTree(int idx, int val, int i, int l, int r){

        if(l == r){
            segTree[i] = val;
            return;
        }
        int mid = (l + r) / 2;
        if(idx <= mid)
            updateTree(idx, val, 2 * i + 1, l, mid);
        else
            updateTree(idx, val, 2 * i + 2, mid + 1, r);
        
        segTree[i] = segTree[2 * i + 1] + segTree[2 * i + 2];
    }
    public int Query(int start, int end, int i, int l, int r){

        if(l > end || r < start){
            return 0;
        }

        if(l >= start && r <= end){
            return segTree[i];
        }
        else{
            int mid = (l + r) / 2;
            
            return Query(start, end, 2 * i + 1, l, mid) + Query(start, end, 2 * i + 2, mid + 1, r);
             

            
        }
    }
    public NumArray(int[] nums) {

        n = nums.length;
        segTree = new int[4 * n];

        buildtree(0, 0, n - 1, nums);
    }
    
    
    public void update(int index, int val) {
       updateTree(index, val, 0, 0, n - 1); 
    }
    
    
    public int sumRange(int left, int right) {
        return Query(left, right, 0, 0, n - 1);
    }
    
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
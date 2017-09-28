
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */

class NumArray {

    int[] bit;
    int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        this.bit = new int[ nums.length + 1 ];
        for (int i = 0; i < nums.length; i++) {
            insert( i + 1, nums[ i ] );
        }
    }

    void insert( int i , int val ){
        while ( i < bit.length ){
            bit[ i ] += val;
            i+=(i&-i);
        }
    }


    /**
     * 更新相当与插入一个与当前现有值的差值进去
     * @param i
     * @param val
     */
    public void update(int i, int val) {
        int temp = val - nums[ i ];
        nums[ i ] = val;
        i++;
       insert( i, temp );
    }

    int getSum( int i ){
        int sum = 0;
        while ( i > 0 ){
            sum += bit[ i ];
            i -= (i&-i);
        }

        return sum;
    }

    public int sumRange(int i, int j) {
        return getSum( j+1 ) - getSum( i );
    }

}

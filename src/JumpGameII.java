public class JumpGameII {

    /**
     * 如果还在当前的边界内
     *      如果当前可以跳的比之前的最优解大就把这个更新成当前的最优解
     * 如果出了边界
     *      跳的步数+1
     * @param nums
     * @return
     */
    public int jump(int[] nums) {

        if ( nums.length == 1 ) return 0;

        int ans = 0;
        int currentBound = nums[ 0 ];
        int nextBound = -1;
        for (int i = 1; i < nums.length; i++) {

            if ( i > currentBound ){
                ans++;
                currentBound = nextBound;
                nextBound = -1;
            }
            if ( i <= currentBound ){
                if ( i + nums[ i ] > nextBound ) nextBound = i + nums[ i ];
            }
        }

        return ans+1;

    }

}

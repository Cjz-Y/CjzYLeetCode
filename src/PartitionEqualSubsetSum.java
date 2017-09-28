public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }

        if ( sum % 2 == 1 ) return false;

        boolean[] f = new boolean[ sum + 1 ];
        f[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j >= nums[i]; j--) {
                if ( f[ j - nums[ i ] ] ) f[ j ] = true;
            }
        }

        return f[ sum / 2 ];
    }
}

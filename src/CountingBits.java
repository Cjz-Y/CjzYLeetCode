public class CountingBits {

    /**
     * dp[0] = 0;
     *
     * dp[1] = dp[0] + 1;
     *
     * dp[2] = dp[0] + 1;
     *
     * dp[3] = dp[1] +1;
     *
     * dp[4] = dp[0] + 1;
     *
     * dp[5] = dp[1] + 1;
     *
     * dp[6] = dp[2] + 1;
     *
     * dp[7] = dp[3] + 1;
     *
     * dp[8] = dp[0] + 1;
     *
     * -------------------------------
     *dp[0] = 0;
     *
     * dp[1] = dp[1-1] + 1;
     *
     * dp[2] = dp[2-2] + 1;
     *
     * dp[3] = dp[3-2] +1;
     *
     * dp[4] = dp[4-4] + 1;
     *
     *dp[5] = dp[5-4] + 1;
     *
     *dp[6] = dp[6-4] + 1;
     *
     *dp[7] = dp[7-4] + 1;
     * @param num
     * @return
     */
    public int[] countBits(int num) {

        int[] f = new int[ num + 1 ];
        int offset = 1;
        for (int i = 1; i < num + 1; i++) {
            if ( offset * 2 == i )  offset *= 2;
            f[i] = f[ i - offset ] + 1;
        }

        return f;
    }
}

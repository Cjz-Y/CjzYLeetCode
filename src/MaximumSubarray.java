/**
 * Created by CjzY on 2017/7/11.
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {

        int[] f = new int[ nums.length ];

        int ans = Integer.MIN_VALUE;
        for ( int i = 0; i < nums.length; i++ ){

            if ( i == 0 ) f[ i ] = nums[ i ];
            else    f[ i ] = f[ i - 1 ] + nums[ i ];

            if ( f[ i ] > ans ) ans = f[ i ];

        }




        for ( int i = 0; i < nums.length; i++ ){

            for ( int j = 0; j < i; j++ ){

                if ( f[i] - f[ j ] > ans )    ans = f[i]-f[j];

            }
        }

        return ans;
    }

    public static void main(String[] args) {
         MaximumSubarray m = new MaximumSubarray();
         int[] test = { -2,1,-3,4,-1,2,1,-5,4 };

        System.out.println( m.maxSubArray( test ) );
    }
}

/**
 * Created by CjzY on 2017/7/13.
 */
public class HouseRobberII {

    public int rob(int[] nums) {

        if ( nums.length == 0 ) return 0;


        int ans = Integer.MIN_VALUE;

        int[] f = new int[ nums.length ];
        for (int i = 0; i < nums.length - 1; i++) {
            f[ i ] = nums[ i ];
            if ( i - 2 >= 0 && f[ i - 2 ] + nums[ i ] > f[ i ] ) f[ i ] = f[ i - 2 ] + nums[ i ];
            if ( i - 3 >= 0 && f[ i - 3 ] + nums[ i ] > f[ i ] ) f[ i ] = f[ i - 3 ] + nums[ i ];
            if ( f[ i ] > ans ) ans = f[ i ];

        }

        f = new int[ nums.length ];
        for (int i = 1; i < nums.length; i++) {
            f[ i ] = nums[ i ];
            if ( i - 2 >= 0 && f[ i - 2 ] + nums[ i ] > f[ i ] ) f[ i ] = f[ i - 2 ] + nums[ i ];
            if ( i - 3 >= 0 && f[ i - 3 ] + nums[ i ] > f[ i ] ) f[ i ] = f[ i - 3 ] + nums[ i ];
            if ( f[ i ] > ans ) ans = f[ i ];

        }

        return ans;
    }

    public static void main(String[] args) {
        HouseRobberII h = new HouseRobberII();
        int[] a = { 1, 2, 3 };
        h.rob( a );
    }
}

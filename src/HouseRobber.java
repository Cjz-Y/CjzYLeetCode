/**
 * 转移状态也可以由f[i,1]f[i,0]来表示，f[i,1]表示取了i的最优解，f[i,0]表示不取i的最优解
 * Created by CjzY on 2017/7/13.
 */
public class HouseRobber {

    public int rob(int[] nums) {

        if ( nums.length == 0 ) return 0;


        int ans = Integer.MIN_VALUE;

        int[] f = new int[ nums.length ];
        for (int i = 0; i < nums.length; i++) {
            f[ i ] = nums[ i ];
            if ( i - 2 >= 0 && f[ i - 2 ] + nums[ i ] > f[ i ] ) f[ i ] = f[ i - 2 ] + nums[ i ];
            if ( i - 3 >= 0 && f[ i - 3 ] + nums[ i ] > f[ i ] ) f[ i ] = f[ i - 3 ] + nums[ i ];
            if ( f[ i ] > ans ) ans = f[ i ];

        }



        return ans;
    }
}

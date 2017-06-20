/**
 * Created by CJZ.Y on 2017/6/13 0013.
 */
public class MinimumMovesEqualArrayElements {

    public int minMoves(int[] nums) {

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if ( nums[ i ] < min ) min = nums[ i ];
        }

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {

            ans = ans + nums[ i ] - min;

        }

        return ans;

    }
}

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContinuousSubarraySum {

    public boolean checkSubarraySum1(int[] nums, int k) {

        int[] sum = new int[ nums.length + 1 ];
        for (int i = 1; i < nums.length + 1; i++) {
            sum[ i ] = sum[ i - 1 ] + nums[ i - 1 ];
        }

        boolean can = false;
        for (int i = 1; i < sum.length - 1; i++) {

            for (int j = i + 1; j < sum.length; j++) {
                if ( k == 0 && sum[ j ] - sum[ i - 1 ] == 0 ){
                    can = true;
                    break;
                }   else    if ( k != 0 && ( sum[ j ] - sum[ i - 1 ] ) % k == 0 ) {
                    can = true;
                    break;
                }
            }
            if ( can ) break;
        }

        return can;

    }

    public boolean checkSubarraySum(int[] nums, int k) {

        int sum = 0;
        Map< Integer, Integer > map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[ i ];
            if ( k != 0 ) sum %= k;
           if ( map.get( sum ) != null ){
               if ( i - map.get( sum ) > 1 )    return true;
           }    else map.put( sum , i );
        }

        return false;

    }
}

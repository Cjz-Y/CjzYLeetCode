import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by CJZ.Y on 2017/6/13 0013.
 */
public class SumII4 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        int ans = 0;

        Map< Long, Integer > one = new HashMap<>();

        for (int i = 0; i < A.length; i++) {

            for (int j = 0; j < B.length; j++) {

                long tempKey = (long)( A[ i ] + B[ j ] );

                if ( one.containsKey( tempKey ) ){

                    int temp = one.get( tempKey );
                    one.put( tempKey, temp + 1 );
                }   else one.put( tempKey, 1 );
            }
        }


        Map< Long, Integer > two = new HashMap<>();
        for (int i = 0; i < C.length; i++) {

            for (int j = 0; j < D.length; j++) {

                long tempKey = (long)( C[ i ] + D[ j ] );

                if ( two.containsKey( tempKey ) ){

                    int temp = two.get( tempKey );
                    two.put( tempKey, temp + 1 );
                }   else two.put( tempKey, 1 );
            }
        }

        Iterator iter = one.entrySet().iterator();

        while ( iter.hasNext() ){

            Map.Entry entry = ( Map.Entry ) iter.next();

            long key = ( long ) entry.getKey();

            if ( two.containsKey( -key ) ){

                System.out.println( "key = " + key + " " + ( int )entry.getValue() + " " + two.get( -key ) );
                ans = ans + ( int )entry.getValue() * two.get( -key );
            }

        }

        return ans;

    }

    public static void main(String[] args) {

        SumII4 s = new SumII4();

        int[] A = {-1, -1};
        int[] B = {-1, 1};
        int[] C = {-1, 1};
        int[] D = {1, -1};

        s.fourSumCount( A, B, C, D );

    }
}

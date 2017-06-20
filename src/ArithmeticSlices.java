/**
 * Created by CJZ.Y on 2017/6/9 0009.
 */
public class ArithmeticSlices {

    public boolean test( int i, int[] a ){

        if ( a[ i + 2 ] - a[ i + 1 ] == a[ i + 1 ] - a[ i ] )   return true;
        return false;
    }

    public int numberOfArithmeticSlices(int[] A) {

        if ( A.length < 3 ) return 0;

        int[][] ans = new int[ A.length ][ A.length ];
        boolean[][] can = new boolean[ A.length ][ A.length ];

        for (int size = 3; size <= A.length; size++) {

            for (int i = 0; i < A.length - size + 1 ; i++) {

                if ( size == 3 ){

                    if ( test( i, A ) )  {

                        ans[ i ][ i+size-1 ]++;
                        can[ i ][ i+size-1 ] = true;
                    }   else    can[ i ][ i+size-1 ] = false;

                }   else    {

                    ans[ i ][ i + size - 1 ] = ans[ i ][ i+size-2 ] + ans[ i+1 ][ i+size-1 ];

                    if ( can[ i ][ i+size-2 ] && can[ i+1 ][ i+size-1 ] ){
                        ans[ i ][ i + size - 1 ]++;
                        can[ i ][ i + size - 1 ] = true;
                    }   else    can[ i ][ i + size - 1 ] = false;
                }

            }

        }


        return ans[0][ ans.length-1 ];
    }

}

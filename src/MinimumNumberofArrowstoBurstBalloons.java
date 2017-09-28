import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinimumNumberofArrowstoBurstBalloons {

    public int findMinArrowShots1(int[][] points) {

        int ans = 0;
        List< int[] > bound = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {

            boolean merged = false;

            for (int j = 0; j < bound.size(); j++) {
                if ( points[ i ][ 0 ] >= bound.get( j )[ 0 ] && points[ i ][ 0 ] <= bound.get( j )[ 1 ] ){

                    merged = true;
                    bound.get( j )[ 0 ] = points[ i ][ 0 ];
                    bound.get( j )[ 1 ] = bound.get( j )[ 1 ] > points[ i ][ 1 ] ? points[ i ][ 1 ] : bound.get( j )[ 1 ];
                }   else if ( points[ i ][ 1 ] >= bound.get( j )[ 0 ] && points[ i ][ 1 ] <= bound.get( j )[ 1 ] ){

                    merged = true;
                    bound.get( j )[ 0 ] = bound.get( j )[ 0 ] > points[ i ][ 0 ] ? bound.get( j )[ 0 ] : points[ i ][ 0 ];
                    bound.get( j )[ 1 ] = points[ i ][ 1 ];
                }   else if ( points[ i ][ 0 ] < bound.get( j )[ 0 ] && points[ i ][ 1 ] > bound.get( j )[ 1 ] ){
                    merged = true;
                }
                if ( merged )break;
            }

            if ( !merged ) {
                ans++;
                bound.add( points[ i ] );
            }
        }

        return ans;
    }

    //对这种数据又边界的题，都可以先考虑给边界排个序，然后在处理
    public int findMinArrowShots(int[][] points) {

        if( points.length == 0 )    return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if ( o1[ 0 ] == o2[ 0 ] )return o1[1]-o2[1];
                else    return o1[0]-o2[ 0 ];
            }
        });

        int ans = 1;
        int nowBound = points[0][1];
        for (int i = 1; i < points.length; i++) {

            if ( points[ i ][ 0 ] <= nowBound ){
                nowBound = Math.min( nowBound, points[ i ][ 1 ] );
            }   else    {
                ans++;
                nowBound = points[ i ][1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumNumberofArrowstoBurstBalloons m = new MinimumNumberofArrowstoBurstBalloons();
        int[][] test = new int[][]{ {10,16}, {2,8}, {1,6}, {7,12} };
        System.out.println( m.findMinArrowShots( test ) );
    }
}

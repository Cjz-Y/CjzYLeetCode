/**
 * Created by CJZ.Y on 2017/5/22 0022.
 */
public class DistributeCandies {

    int[] a = new int[ 200001 ];

    public int distributeCandies(int[] candies) {

        int ans = 0;

        for ( int b : candies ){

            if ( a[ b + 100000 ] == 0 ) ans++;

            a[ b + 100000 ] ++;

        }

        return candies.length / 2 > ans ? ans : candies.length /2 ;

    }

}

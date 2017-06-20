/**
 * Created by CJZ.Y on 2017/5/24 0024.
 */
public class ConstructTheRectangle {

    public int[] constructRectangle(int area) {

        int[] ans = new int[ 2 ];

        double m = Math.sqrt( area );

        for ( int i = new Double( Math.floor( m ) ).intValue(); i > 0; i-- ){

            if ( area % i == 0 ){

                ans[ 0 ] = i;
                ans[ 1 ] = area / i;

                return ans;
            }
        }

        int i =+ ans[ 0 ];

        return null;

    }
}

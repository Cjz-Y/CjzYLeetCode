/**
 * Created by CjzY on 2017/7/16.
 */
public class Program {

    int[][] data = {    { 0, 25, 8, 49, 13, 10, 17, 41, 4, 2 },
                                { 57, 0, 87, 98, 461, 58, 115, 35, 4, 2 },
                                { 46, 386, 0, 113, 217, 113, 23, 15, 6, 3 },
                                { 82, 148, 360, 0, 54, 19, 13, 9, 8, 4 },
                                { 94, 239, 337, 131, 0, 51, 15, 24, 7, 15 },
                                { 61, 36, 67, 22, 119, 0, 17, 30, 17, 6 },
                                { 15, 5, 59, 15, 15, 28, 0, 9, 16, 10 },
                                { 3, 3, 6, 9, 9, 15, 9, 0, 12, 8 },
                                { 3, 3, 36, 9, 9, 25, 3, 5, 0, 5 },
                                { 1, 1, 11, 3, 3, 11, 9, 2, 3, 0} };

    int sum;
    int[][] dataSum = new int[ data.length ][ data[ 0 ].length ];

    public  void caculateSum(){
        sum = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[ 0 ].length; j++) {
                sum+=data[ i ][ j ];
            }
        }

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[ 0 ].length; j++) {
                dataSum[ i ][ j ] = data[ i ][ j ];
                if ( i == 0 && j > 0 )   dataSum[ i ][ j ] += dataSum[ i ][ j -1 ];
                else if ( j == 0 && i > 0 ) dataSum[ i ][ j ] += dataSum[ i -1 ][ j ];
                else if ( i !=0 && j != 0 ){

                    dataSum[ i ][ j ] = dataSum[ i ][ j ] + dataSum[ i -1 ][ j ] + dataSum[ i ][ j -1 ] - dataSum[ i - 1 ][ j -1 ];
                }

            }
        }

        System.out.println( sum );
        System.out.println( dataSum[ data.length - 1 ][ data[0].length - 1 ] );
    }

    public void caculateF(){

        float cMin = Float.MAX_VALUE;
        int f = 0;
        for (int i = 10; i <= 40; i++) {

            float temp = ( 3*sum/i ) + ( 32*i );

            if ( temp < cMin ){
                cMin = temp;
                f = i;
            }

        }

        System.out.println( "cMin  = " + cMin + " f = " + f );
        System.out.println( "c1 = " + ( 3*sum/f / 0.6 )  + " c2 = " + ( 32*f / 0.4) );
    }

    public void caculateDoubleF(){

        float cMin = Float.MAX_VALUE;
        int ansSum = 0;
        int s1 = 0;
        int s2 = 0;
        int fa = 0;
        int fb = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 5; j < data[ 0 ].length; j++) {

                int tempSum = dataSum[ j ][ j ] - dataSum[ i ][ j ] - dataSum[ j ][ i ] + dataSum[ i ][ i ];

                for (int k = 10; k <= 40; k++) {
                    for (int l = 10; l <= 40; l++) {
                        float temp = (float) ( 0.6 * ( ( 5 * tempSum / ( k+l ) ) + ( ( sum - tempSum ) / k ) ) + 0.4* ( 10 * ( k * 8 + l * ( 8 / 9 * ( j - i ) ) ) ) );

                        if ( temp < cMin ){

                            cMin = temp;
                            ansSum = tempSum;
                            s1 = i;
                            s2 = j;
                            fa = k;
                            fb = l;
                        }

                    }

                }

            }
        }

        System.out.println( "fa = " + fa + " fb = " + fb  + " cMin = " + cMin );
        System.out.println( "c1 = " + ( ( 5 * ansSum / ( fa+fb ) ) + ( ( sum - ansSum ) / fa ) ) + " c2 = " + ( 10 * ( fa * 8 + fb * ( 8 / 9 * ( s2 - s1 ) ) ) ) );
        System.out.println( "s1 = " + s1 + "  s2 = " + s2 );

    }

    public static void main(String[] args) {
        Program p = new Program();
        p.caculateSum();
        p.caculateF();
        p.caculateDoubleF();
    }
}

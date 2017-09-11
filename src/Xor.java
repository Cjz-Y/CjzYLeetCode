public class Xor {


    public int solution( int n, int[] nums ){

        int[] xor = new int[ n ];
        for (int i = 0; i < n; i++) {

            if ( i == 0 ){
                xor[ i ] = nums[ i ];
                continue;
            }   else    {

                if ( nums[ i - 1 ] == 0 ){
                    xor[ i ] = nums[ i ];
                }   else if ( nums[ i ] != 0 ){
                    xor[ i ] = xor[ i -1 ]^nums[ i ];
                }

            }

        }

        for (int i = 0; i < n; i++) {
            System.out.println( i + " = " + xor[ i ] );
        }

return 0;
    }
}

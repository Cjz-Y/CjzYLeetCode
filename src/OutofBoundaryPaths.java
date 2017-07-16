/**
 * Created by CjzY on 2017/7/16.
 */
public class OutofBoundaryPaths {


    public int findPaths(int m, int n, int N, int i, int j) {

        if ( N == 0 )   return 0;
        int ans = 0;
        System.out.println( Integer.MAX_VALUE );
        int mod = (int) Math.pow( 10, 9 ) + 7;
        System.out.println( mod );
        int[][][] f = new int[ m ][ n ][ N ];
        f[ i ][ j ][ 0 ] = 1;

        if ( i == 0 ){
            ans+=f[i][j][0];
            ans = ans % (mod);
        }
        if ( i == m - 1 ){
            ans+=f[i][j][0];
            ans = ans % (mod);
        }
        if ( j == 0 ){
            ans+=f[i][j][0];
            ans = ans % (mod);
        }
        if ( j == n - 1 ){
            ans+=f[i][j][0];
            ans = ans % (mod);
        }

        for (int k = 1; k < N; k++) {
            for (int l = 0; l < m; l++) {
                for (int o = 0; o < n; o++) {
                    if ( l - 1 >= 0 )  {
                        f[ l ][ o ][ k ] += f[ l -1 ][ o ][ k - 1 ];
                        f[ l ][ o ][ k ] = f[ l ][ o ][ k ] % mod;
                    }
                    if ( o - 1 >= 0 ) {
                        f[ l ][ o ][ k ] += f[ l ][ o -1 ][ k - 1 ];
                        f[ l ][ o ][ k ] = f[ l ][ o ][ k ] % mod;
                    }
                    if ( l + 1 < m  ) {
                        f[ l ][ o ][ k ] += f[ l + 1 ][ o ][ k - 1 ];
                        f[ l ][ o ][ k ] = f[ l ][ o ][ k ] % mod;
                    }
                    if ( o + 1 < n ){
                        f[ l ][ o ][ k ] += f[ l ][ o + 1 ][ k - 1 ];
                        f[ l ][ o ][ k ] = f[ l ][ o ][ k ] % mod;
                    }



                    System.out.println( " l = " + l + " o = " + o + " k = " + k + " f = " + f[ l ][ o ][ k ] );

                    if ( l == 0 ){
                        ans+=f[l][o][k];
                        ans = ans % (mod);
                    }
                    if( l == m - 1 ){
                        ans+=f[l][o][k];
                        ans = ans % (mod);
                    }

                    if ( o == 0 ){
                        ans+=f[l][o][k];
                        ans = ans % (mod);
                    }
                    if ( o == n - 1 ){
                        ans+=f[l][o][k];
                        ans = ans % (mod);
                    }
                    System.out.println( "ans = " + ans );
                }

            }
        }

        return ans;

    }

    public static void main(String[] args) {
        OutofBoundaryPaths o = new OutofBoundaryPaths();
        System.out.println( o.findPaths( 8,50, 23, 5,26 ) );
    }
}

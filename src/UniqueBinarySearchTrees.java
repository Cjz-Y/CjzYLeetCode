/**
 * Created by CjzY on 2017/7/24.
 */
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {

        if ( n == 1 ) return 1;
        if ( n == 2 ) return 2;

        int[] f = new int[ n+1 ];
        f[ 0 ] = 1;
        f[ 1 ] = 1;
        f[ 2 ] = 2;

        for (int i = 3; i <= n; i++) {

            for (int j = 1; j <= i/2; j++) {
                f[ i ] = f[ i ] + f[ j-1 ]*f[ i - j ];
            }
            f[ i ] = f[ i ]*2;
            if ( i % 2 != 0 ) f[ i ] = f[ i ] + f[ i/2 ]*f[ i/2 ];
        }

        return f[n];
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees u = new UniqueBinarySearchTrees();
        for (int i = 1; i < 10; i++) {
            System.out.println( u.numTrees( i ) );

        }
    }
}

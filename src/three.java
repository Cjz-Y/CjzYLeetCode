public class three {

    public static void main(String[] args) {


        String str = "abcdabdca";

        int a = 0;

        int[][] ans = new int[ str.length() ][ str.length() ];
        for (int i = 0; i < str.length()-1; i++) {

            for (int j = i + 1; j < str.length(); j++) {

                int temp = 0;
                if ( str.charAt( i ) == str.charAt( j ) ){
                    temp=2;
                    ans[ i ][ j ] = 2;
                }

                if ( j - 1 >= 0 ){ ans[i][j] = Math.max( ans[ i ][ j ], ans[i][ j - 1 ] ); }
                if ( i - 1 >= 0 ){ ans[ i ][ j ] = Math.max( ans[i][j], ans[i-1][ j ] ); }
                if ( i-1>=0 && j-1>=0 && j-1 > i ) ans[i][j] = Math.max( ans[ i - 1 ][ j - 1 ] + temp, ans[ i ][ j ] );

                System.out.println( " i" + i + " j" + j +  " = " + ans[ i ][ j ] );

                a = Math.max( ans[ i ][ j ], a );
            }
        }

        System.out.println( a );
    }
}

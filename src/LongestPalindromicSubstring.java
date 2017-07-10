/**
 * Created by CjzY on 2017/7/4.
 */
public class LongestPalindromicSubstring {
    //转移当中会有状态丢失
    public String longestPalindrome1( String s ) {

        String ans  = null;
        int ansLen = 0;
        int ansIndex = 0;

        int[] f = new int[ s.length() ];
        int[] g = new int[ s.length() ];

        for (int i = 0; i < s.length(); i++) {

            f[ i ] = 1;
            g[ i ] = 1;

            if ( i > 0 ){

                if ( s.charAt( i ) == s.charAt( i-1 ) ){
                    g[ i ] = g[ i -1 ] + 1;
                }
                if ( i - 2 >= 0 && s.charAt( i ) == s.charAt( i-2 ) ) f[ i ] = 3;

                if ( ( i - f[ i-1 ] - 1 ) >= 0 && s.charAt( i ) == s.charAt( i - f[ i-1 ] - 1 ) ){

                    f[ i ] = f[ i-1 ] + 2;

                }

                if ( ( i-1-g[ i-1] >= 0 && s.charAt( i ) == s.charAt( i-1-g[ i-1 ] ) && g[ i-1 ] + 2 > f[ i ] ) ){

                    f[ i ] = g[ i-1 ] + 2;
                }

            }
            System.out.println( i + " = " + f[ i ] );
            if ( f[ i ] > ansLen ){
                ansLen = f[ i ];
                ansIndex = i;
            }

            if( g[ i ] > ansLen ){
                ansLen = g[ i ];
                ansIndex = i;
            }
        }

       System.out.println( "ansLen = " + ansLen + " ansIndex = " + ansIndex );

        ans = s.substring( ansIndex - ansLen + 1, ansIndex + 1 );


        return ans;
    }

    public String longestPalindrome(String s) {

        String ans = null;
        int ansLen = 0;
        int ansIndex = 0;

        boolean[][] f = new boolean[ s.length() ][ s.length() + 3 ];
        int[] g = new int[ s.length() ];

        for (int i = 0; i < s.length(); i++) {
            g[ i ] = 1;
            if ( i -1 >= 0 && s.charAt( i-1 ) ==s.charAt( i ) ) g[ i ] = g[ i - 1 ] + 1;
        }

        for (int i = 0; i < s.length(); i++) {

            for (int j = 1; j < i + 3; j++ ) {

                f[ i ][ j ] = false;

                if ( j == g[ i ] ||
                        ( i - 1 >= 0 && j -2 >= 0 && f[ i - 1 ][ j - 2 ] && ( i-j+1 >= 0 ) && s.charAt( i-j+1 ) ==s.charAt( i ) ) ){

                    f[ i ][ j ] = true;
                    if ( j > ansLen ){
                        ansLen = j;
                        ansIndex = i;
                    }
                }
            }
        }

        System.out.println( "ansLen = " + ansLen + " ansIndex = " + ansIndex );

        ans = s.substring( ansIndex - ansLen + 1, ansIndex + 1 );

        return ans;

    }




    public static void main(String[] args) {

        LongestPalindromicSubstring l = new LongestPalindromicSubstring();

        System.out.println( l.longestPalindrome( "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa" ) );
    }


}



public class RomantoInteger {


    public int romanToInt(String s) {

        int[] roman = new int[ 27 ];
        roman[ 'M' - 'A' ] = 1000;
        roman[ 'D' - 'A' ]  = 500;
        roman[ 'C' - 'A' ] = 100;
        roman[ 'L' - 'A' ] = 50;
        roman[ 'X' - 'A' ] = 10;
        roman[ 'V' - 'A' ] = 5;
        roman[ 'I' - 'A' ]  = 1;

        int ans = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if ( roman[ s.charAt( i ) - 'A' ] >= roman[ s.charAt( i+1 ) - 'A' ] ) ans += roman[ s.charAt( i ) - 'A' ];
            else    ans -= roman[ s.charAt( i ) - 'A' ];
        }
        ans+=roman[ s.charAt( s.length() - 1 ) - 'A' ];

        return ans;
    }
}

/**
 * Created by CjzY on 2017/7/4.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length == 0)    return "";

        String temp = null;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < strs.length; i++) {

            if ( strs[ i ].length() < min ){
                min = strs[ i ].length();
                temp = strs[ i ];
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {

            int tempans = 0;

            if ( temp != null )
            for (int j = 0; j < temp.length(); j++) {
                if ( temp.charAt( j ) != strs[i].charAt( j ) )  break;
                tempans++;
                if ( tempans > ans ){   break;  }
            }
            if ( tempans < ans )    { ans = tempans;    }
        }

        if ( ans == 0 || ans == Integer.MAX_VALUE ) return "";

        return temp.substring( 0, ans );

    }

    public static void main(String[] args) {

        String[] a = new String[ 1 ];
        a[ 0 ] = "a";

        LongestCommonPrefix l = new LongestCommonPrefix();
        System.out.println( l.longestCommonPrefix( a ) );
    }

}

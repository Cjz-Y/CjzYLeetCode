import java.util.HashMap;
import java.util.Map;

public class UniqueSubstringsinWraparoundString {

    /**
     * 每个独特的子序列可以用最后一位来区分，如果符合s的子序列必然是连续的，所以只要看以特定的字母结尾的连续序列最长是多少，然后吧每个字母的加起来就好
     * @param p
     * @return
     */
    public int findSubstringInWraproundString(String p) {

        Map< Character, Integer > map = new HashMap<>();

        int current = 0;
        int pre = 0;

        for (int i = 0; i < p.length(); i++) {
            if ( i > 0 && ( ( p.charAt( i - 1 ) - 'a' == p.charAt( i ) - 'a' - 1 ) || ( p.charAt( i ) == 'a' && p.charAt( i - 1) == 'z' ) ) ){
                current = pre + 1;
            }   else    {
                current = 1;
            }

            if ( !map.containsKey( p.charAt( i ) ) || map.get( p.charAt( i ) ) < current ){
                map.put( p.charAt( i ), current );
            }
            pre = current;
        }

        int ans = 0;
        for ( Character i = 'a'; i <= 'z' ; i++) {
            if ( map.get( i ) != null ) ans+=map.get( i );
        }

        return ans;
    }

    public static void main(String[] args) {
        UniqueSubstringsinWraparoundString u = new UniqueSubstringsinWraparoundString();
        System.out.println( u.findSubstringInWraproundString( "zab" ) );
    }
}

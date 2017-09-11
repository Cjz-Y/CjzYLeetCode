import java.util.*;


public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        Set set = new HashSet< Integer >();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            set.add( nums[ i ] );
        }

        while ( !set.isEmpty() ){

            Iterator iterator = set.iterator();
            int a = ( int ) iterator.next();
            set.remove( a );
            System.out.println( a );

            int count = 1;
            int pre = a-1;
            while ( set.contains( pre ) ){
//                System.out.println( "pre is " + pre );
                count++;
                set.remove( pre );
                pre = pre - 1;

            }

            int forward = a + 1;
            while ( set.contains( forward ) ){
//                System.out.println( "forward is " + forward );
                count++;
                set.remove( forward );
                forward++;
            }

            ans = Math.max( ans, count );
        }

        return ans;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence l = new LongestConsecutiveSequence();

        int[] a = new int[]{ 100, 2, 200, 1, 3, 4 };

        System.out.println( l.longestConsecutive( a ) );
    }

}

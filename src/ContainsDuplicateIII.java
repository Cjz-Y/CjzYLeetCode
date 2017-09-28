import java.util.TreeSet;

public class ContainsDuplicateIII {

    /**
     * 注意会有超出整型范围的错误，思路是利用java中的红黑树数据结构
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        TreeSet< Integer > tree = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {

            Integer bottom = tree.floor( nums[ i ] );
            Integer top = tree.ceiling( nums[ i ] );
            if ( bottom != null && nums[ i ] <= t + bottom )  {
                return true;
            }
            if ( top != null && top <= t + nums[ i ] ) {
                return true;
            }

            tree.add( nums[ i ] );

            if ( i >= k ){ tree.remove( nums[ i - k ] ); }

        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateIII c = new ContainsDuplicateIII();
        int[] test = new int[]{ -1, 2147483647 };
        System.out.println( c.containsNearbyAlmostDuplicate( test, 1, 2147483647 ) );
    }
}




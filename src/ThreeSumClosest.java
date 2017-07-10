import java.util.HashSet;
import java.util.Set;

/**
 * Created by CjzY on 2017/7/4.
 */
public class ThreeSumClosest {

    Set< Integer > set = new HashSet<>();

    public int threeSumClosest1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < i; j++) {

                for (int k = 0; k < j; k++) {

                    set.add( nums[ i ] + nums[ j ] + nums[ k ] );

                }
            }
        }

        int index = 0;
        while ( !set.contains( target + index ) && !set.contains(target - index) ){
            index++;
        }

        return set.contains(target + index) ? target + index : target - index;

    }

    public void qsort( int head, int tail, int[] nums ){

        if ( head > tail ) return;

        int i = head;
        int j = tail;
        int temp = nums[ head ];

        while ( i < j ){

            while ( nums[ j ] >= temp && i < j ) j--;
            while ( nums[ i ] <= temp && i < j ) i++;

            if ( i < j ){
                int a = nums[ i ];
                nums[ i ] = nums[ j ];
                nums[ j ] = a;
            }
        }

        nums[ head ] = nums[ i ];
        nums[ i ] = temp;

        qsort( head, i - 1, nums );
        qsort( i + 1, tail, nums );


    }

    public int threeSumClosest2(int[] nums, int target) {

        int pre = nums[ 0 ] + nums[ 1 ] + nums[ 2 ];

        qsort( 0 , nums.length - 1, nums );
        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < i; j++) {

                for (int k = 0; k < j; k++) {

                    int current = nums[ i ] + nums[ j ] + nums[ k ];

                    System.out.println( "sum = " + current );

                    if (  current >= target ){

                        return Math.abs( current- target ) > Math.abs( pre - target ) ? pre : current;
                    }

                    pre = current;
                }
            }
        }

        return pre;

    }

    public int threeSumClosest3(int[] nums, int target) {

        int index = 0;
        int[] sum = new int[ nums.length * nums.length * nums.length ];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < j; k++) {
                    sum[ index ] = nums[ i ] + nums[ j ] + nums[ k ];
                    index++;
                }
            }
        }

        qsort( 0, index - 1, sum );

        int pre = sum[ 0 ];
        for (int i = 1; i < index; i++) {

            System.out.println( "sum = " + sum[ i ] );

            if (  sum[ i ] >= target ){

                return Math.abs( sum[ i ]- target ) > Math.abs( pre - target ) ? pre : sum[ i ];
            }

            pre = sum[ i ];


        }

        return pre;
    }

    //直接模拟逻辑，先排序，然后每次取出      一定取当前数的最优解         排除掉无用的解
    public int threeSumClosest(int[] nums, int target) {

        int ans = nums[ 0 ] + nums[ 1 ] + nums[ 2 ];

        qsort( 0 , nums.length - 1, nums );

        for (int i = 0; i < nums.length; i++) {

            int head = i + 1;
            int tail = nums.length - 1;

            while ( head <  tail ){

                int sum = nums[ i ] + nums[ head ] + nums[ tail ];
                if ( sum > target ) tail--;
                                else      head++;

                if ( Math.abs( sum - target ) < Math.abs( ans- target) )    ans = sum;

            }
        }

        return ans;

    }



    public static void main(String[] args) {

        ThreeSumClosest t = new ThreeSumClosest();
        int[] test = {-55,-24,-18,-11,-7,-3,4,5,6,9,11,23,33};
        System.out.println( t.threeSumClosest( test, 0 ) );
    }
}

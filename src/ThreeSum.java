import java.util.*;

/**
 * Created by CjzY on 2017/7/5.
 */
public class ThreeSum {

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

    public List<List<Integer>> threeSum1(int[] nums) {

        List< List< Integer > > ans = new ArrayList<>();

        Map< Integer, Integer > a = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            a.put( nums[ i ], i );
        }

        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < i; j++) {

                boolean flag = a.containsKey( -( nums[ i ] + nums[ j ] ) );
                int b = 0;
                if ( flag ) b = a.get( -( nums[ i ] + nums[ j ] )  );

                if ( flag && b !=i && b != j ){

                    List< Integer > temp = new ArrayList<>();
                    temp.add( nums[ i ] );
                    temp.add( nums[ j ] );
                    temp.add( -( nums[ i ] + nums[ j ] ) );

                    ans.add( temp );
                }

            }
        }

        return ans;
    }

    public List< List< Integer > > threeSum( int[] nums ){
        List< List< Integer> > ans = new ArrayList<>();

        qsort( 0, nums.length - 1, nums );

        for (int i = 0; i < nums.length - 2; i++) {

            if ( i > 0 && nums[ i ] == nums[ i -1 ] )   continue;

            int head = i + 1;
            int tail = nums.length - 1;
            while ( head < tail  ){

                int sum = nums[ i ] + nums[ head ] + nums[ tail ];

                if ( sum == 0  ){

                    ans.add( Arrays.asList( nums[ i ], nums[ head], nums[ tail ] ) );
                    head++;
                    tail--;

                    while ( head < tail && nums[ tail ] == nums[ tail + 1 ] ) tail--;
                    while ( head < tail && nums[ head ] == nums[ head - 1 ] ) head++;
                }

                else if ( sum > 0 )  {
                    tail--;
                }
                else if ( sum < 0 ) {
                    head++;
                }

            }
        }

        return ans;
    }

    public static void main(String[] args) {

        ThreeSum t = new ThreeSum();

        int[] nums = { -4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6 };

        System.out.println( t.threeSum( nums ) );
    }
}

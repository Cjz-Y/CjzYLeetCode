import java.util.ArrayList;
import java.util.List;

public class LargestDivisibleSubset {

    void qsort( int head, int tail, int[] arr ){

        if ( head > tail ) return;
        int i = head;
        int j = tail;
        int temp = arr[ head ];

        while ( i < j  ){
            while ( temp <= arr[ j ] && i < j ) j--;
            while ( temp >= arr[ i ] && i < j  ) i++;
            if ( i < j ){
                int swap = arr[ i ];
                arr[ i ] = arr[ j ];
                arr[ j ] = swap;
            }
        }

        arr[ head ] = arr[ i ];
        arr[ i ] = temp;

        qsort( i+1, tail, arr );
        qsort( head, i - 1, arr );
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {

        if ( nums.length == 0 ) return new ArrayList< Integer >();

        qsort( 0, nums.length-1, nums );

//        for (int i = 0; i < nums.length; i++) {
//            System.out.println( nums[ i ] );
//        }
        int ans = 0;
        int ansIndex = -1;

        int[] pre = new int[ nums.length ];
        int[] f = new int[ nums.length ];
        for (int i = 0; i < nums.length; i++) {

            f[ i ] = 1;
            pre[ i ] = -1;
            for (int j = 0; j < i; j++) {
                if ( nums[i] % nums[ j ] == 0 )
                    if ( f[ j ] + 1 > f[ i ] ){
                        f[ i ] = f[ j ] + 1;
                        pre[ i ] = j;
                    }
            }
            if ( f[ i ] > ans ){
                ans = f[ i ];
                ansIndex = i;
            }
        }

        ArrayList< Integer > ansList = new ArrayList<>();
        while ( pre[ ansIndex ] != -1 ){
            ansList.add( nums[ ansIndex ] );
            ansIndex = pre[ ansIndex ];
        }

        ansList.add( nums[ ansIndex ] );
        return ansList;
    }

    public static void main(String[] args) {
        LargestDivisibleSubset l = new LargestDivisibleSubset();
        int[] test = { 1,4,3,2 };

        System.out.println( l.largestDivisibleSubset( test ) );
    }
}

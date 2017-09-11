public class TaskScheduler {


    void qsort( int l, int r, int[] arr ){

        if ( l > r ) return;
        int i = l, j = r;
        int temp = arr[ i ];


        while ( i <  j ){
//            System.out.println( " i  =" + i + " j =" + j );

            while ( temp >= arr[ j ] && i < j ) j--;
            while ( temp <= arr[ i ] && i < j ) i++;

            if( i < j ){
                int swap = arr[ i ];
                arr[ i ] = arr[ j ];
                arr[ j ] = swap;
            }
        }

        arr[ l ] = arr[ i ];
        arr[ i ] = temp;

        qsort( l, i-1, arr );
        qsort( i+1, r, arr );


    }

    public int leastInterval(char[] tasks, int n) {

        if ( n == 0 )return tasks.length;

        int[] col = new int[ 27 ];
        for (int i = 0; i < tasks.length; i++) {
            col[ tasks[ i ] - 'A' ]++;
        }

        qsort( 0, 26, col );
        int ans = 0;
        for (int i = 1; i < 27; i++) {
            if ( col[ i ] == col[ i -1 ] )ans++;
            else    break;
        }

        int temp = ( col[ 0 ] - 1 ) * n + col[ 0 ];
        System.out.println(ans);
        System.out.println(temp);
        if ( temp + ans > tasks.length )  return temp + ans;
            else return tasks.length;

    }

    public static void main(String[] args) {
        TaskScheduler t = new TaskScheduler();
        char[] tasks = new char[]{ 'A', 'B', 'A', 'B' };

        System.out.println( t.leastInterval( tasks, 2) );
    }
}

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CJZ.Y on 2017/6/9 0009.
 */
public class QueueReconstructionbyHeight {

    public void qsort( int l, int r, int[][] arr ){

        if ( l > r )    return;

        int i = l, j = r;
        int[] temp = arr[ l ];

        while ( i < j ){

            while ( ( arr[ j ][ 0 ] > temp[0] || ( arr[ j ][ 0 ] == temp[ 0 ] && arr[ j ][ 1 ] >= temp[ 1 ] ) ) && i < j ) j--;
            while ( ( arr[ i ][ 0 ] < temp[0] || ( arr[ i ][ 0 ] == temp[ 0 ] && arr[ i ][ 1 ] <= temp[ 1 ] ) ) && i < j ) i++;

            if ( i < j ){
                int[] tempA = arr[i];
                arr[ i ] = arr[ j ];
                arr[ j ] = tempA;
            }
        }

        arr[ l ] = arr[ i ];
        arr[ i ] = temp;

        qsort( l, i-1, arr );
        qsort( i+1, r, arr );


    }

    public int[][] reconstructQueue(int[][] people) {

        qsort( 0,people.length - 1, people );

        List< int[] > arr = new ArrayList< int[] >( people.length + 1 );

        for (int i = 0; i < people.length; i++) {
            arr.add( people[ i ] );
        }
        for ( int i = people.length-1; i >= 0; i-- ) {

            int precced = 0;

            for ( int j = i-1; j >= 0 ; j-- ) {

                if ( people[ j ][ 0 ] < people[ i ][ 0 ] ) break;
                precced++;

            }

            int index = i + ( people[ i ][ 1 ] - precced );

            if ( index != i ){

                arr.remove( i );
                arr.add( index, people[ i ] );
            }

        }


        for (int i = 0; i < people.length; i++) {
            people[ i ] = arr.get( i );

        }




        return people;
    }

    public static void main(String[] args) {
        QueueReconstructionbyHeight q = new QueueReconstructionbyHeight();

        int[][] temp = { {7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2} };

        q.reconstructQueue( temp );

    }
}

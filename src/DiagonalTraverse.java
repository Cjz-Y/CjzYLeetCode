/**
 * Created by CJZ.Y on 2017/6/19 0019.
 */
public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] matrix) {


        if ( matrix.length == 0 ) return new int[0];
        System.out.println( matrix.length * matrix[ 0 ].length );

        int[] ans = new int[ matrix.length * matrix[ 0 ].length ];

        int index = 0;

        int x = 0, y = 0;

        int dx = -1, dy = 1;

        boolean up = true;

        while ( index < ans.length ){

            while ( ( x < matrix.length && x >= 0 ) && ( y < matrix[ 0 ].length && y >= 0 ) ){

                ans[ index ] = matrix[ x ][ y ];
                index++;

                x = x+dx; y = y+dy;

            }

            dx = -dx; dy = -dy;

            if ( up ){

                x = x + 1;

                if ( y == matrix[ 0 ].length ) { x = x+dx; y = y+dy; }

                if ( !(( x < matrix.length && x >= 0 ) && ( y < matrix[ 0 ].length && y >= 0 ))){ break; }

            }   else    {

                y = y + 1;

                if ( x == matrix.length ){ x = x+dx; y = y+dy; }

                if ( !(( x < matrix.length && x >= 0 ) && ( y < matrix[ 0 ].length && y >= 0 ))){ break; }
            }

            up = !up;
        }

        for (int i = 0; i < ans.length; i++) {
            System.out.println( ans[ i ] );
        }


        return ans;

    }

    public static void main(String[] args) {

        DiagonalTraverse d = new DiagonalTraverse();

        int[][] a = { {1,2,3}, {4,5,6}, {7,8,9} };

        int[][] b = {};

        //d.findDiagonalOrder( a );

        d.findDiagonalOrder( b );
    }
}

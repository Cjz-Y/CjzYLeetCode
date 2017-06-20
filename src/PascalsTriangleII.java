import java.util.ArrayList;
import java.util.List;

/**
 * Created by CJZ.Y on 2017/6/5 0005.
 */
public class PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {

        int[] ans = new int[ rowIndex + 2 ];

        ans[ 0 ] = 1;

        for (int i = 0; i < rowIndex; i++) {

            int preValue = 0;

            for (int j = 0; j < i+2; j++) {

                int temp = ans[ j ];

                ans[ j ] = ans[ j ] + preValue;

                preValue = temp;

            }

        }

        List< Integer > ansList = new ArrayList<>();
        for (int i = 0; i < rowIndex + 2; i++) {

            if ( ans[ i ] != 0 ) ansList.add( ans[ i ] );

        }

        return ansList;


    }

    public static void main(String[] args) {

        PascalsTriangleII p = new PascalsTriangleII();

        List< Integer > a = p.getRow( 1 );

        for (int i = 0; i < a.size(); i++) {

            System.out.print( ( int ) a.get( i ) );
            System.out.print( " " );

        }
    }



}

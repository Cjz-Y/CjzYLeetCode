import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CJZ.Y on 2017/5/31 0031.
 */
public class MinimumIndexSumOfTwoLists {

    public String[] findRestaurant(String[] list1, String[] list2) {

        List< String > ans = new ArrayList<>();

        int ansIndex = 2000;

        Map< String, Integer > map1 = new HashMap<>();

        for ( int i = 0; i < list1.length; i++ ) {

            map1.put( list1[ i ], i );
        }

        for ( int i = 0; i < list2.length; i++ ) {

            if ( map1.containsKey( list2[ i ] ) ){

                if ( map1.get( list2[ i ] ) + i == ansIndex ){  ans.add( list2[ i ] );  }

                if ( map1.get( list2[ i ] ) + i < ansIndex ){

                    ans.clear();
                    ansIndex = map1.get( list2[ i ] ) + i;
                    ans.add( list2[ i ] );
                }
            }

        }

        return ( String[] )ans.toArray( new String[ ans.size() ] );

    }


    public static void main(String[] args) {

        MinimumIndexSumOfTwoLists m = new MinimumIndexSumOfTwoLists();

        String[] list1 = { "Shogun","Tapioca Express","Burger King","KFC" };
        String[] list2 = { "Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun" };

        System.out.println( m.findRestaurant( list1, list2 ) );
    }
}

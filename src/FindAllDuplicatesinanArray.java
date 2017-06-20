import java.util.ArrayList;
import java.util.List;

/**
 * Created by CJZ.Y on 2017/6/19 0019.
 */
public class FindAllDuplicatesinanArray {

    public List<Integer> findDuplicates(int[] nums) {                                                       //在不改变其内容的情况下，用正负来代表状态

        List< Integer > ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            int a = Math.abs( nums[ i ] );

            if ( nums[ a - 1 ] < 0 ) {

                 ans.add( a );
            }

            nums[ a - 1 ] = -nums[ a - 1 ];

        }

        return ans;

    }
}

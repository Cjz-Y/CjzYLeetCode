import java.util.ArrayList;
import java.util.List;

/**
 * Created by CJZ.Y on 2017/5/31 0031.
 */
public class MinimumAbsoluteDifferenceinBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List< Integer > temp = new ArrayList<>();

    public void buildList( TreeNode  root ){

        if ( root.left != null ) buildList( root.left );

        temp.add( root.val );

        if ( root.right != null ) buildList( root.right );

    }

    public int getMinimumDifference( TreeNode root ) {

        buildList( root );

        Integer[] tempInt = ( Integer[] )temp.toArray( new Integer[ temp.size() ] );

        int ans = Integer.MAX_VALUE;

        for ( int i = 1; i < tempInt.length; i++ ) {

            if ( tempInt[ i ] - tempInt[ i - 1 ] < ans ) ans = tempInt[ i ] - tempInt[ i - 1 ];
        }

        return ans;

    }




}



/**
 * Created by CJZ.Y on 2017/6/22 0022.
 */
public class ConvertSortedArraytoBinarySearchTree {

    public class TreeNode{

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode( int x ){ val = x; }
    }

    public TreeNode makeNode( int[] list, int start, int end ){

        if ( start == end ){

            return  new TreeNode( list[ start ] );
        }

        System.out.println( start + " " + end + " " + start + ( end- start + 1 ) / 2 );

        int tempIndex = start + ( end- start + 1 ) / 2;


        TreeNode temp = new TreeNode( list[ tempIndex ] );
        temp.left = makeNode( list, start, ( tempIndex -1 ) >= 0 ? tempIndex-1:0  );
        temp.right = makeNode( list, (tempIndex + 1) < list.length ? tempIndex + 1: list.length-1, end );

        return temp;
    }

    public TreeNode sortedArrayToBST( int[] nums ) {

        if ( nums.length == 0 )return null;

        return makeNode( nums, 0, nums.length - 1 );

    }
}

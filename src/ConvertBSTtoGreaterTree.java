/**
 * Created by CJZ.Y on 2017/6/20 0020.
 */
public class ConvertBSTtoGreaterTree {

    public class TreeNode{

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode( int x ){ val = x; }
    }

    int sum = 0;

    public void serch( TreeNode root ){

        if ( root == null )  return;

        serch( root.right );

        int temp = root.val;
        root.val = root.val + sum;
        sum = sum + temp;

        serch( root.left );

    }

    public TreeNode convertBST(TreeNode root) {

        TreeNode ans = root;

        serch( root );


        return ans;

    }

}
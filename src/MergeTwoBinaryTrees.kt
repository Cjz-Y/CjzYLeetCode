/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class MergeTwoBinaryTrees {
    fun mergeTrees( t1: TreeNode?, t2: TreeNode? ): TreeNode? {
        if ( t1 == null  && t2 == null )    return null

        var node = TreeNode( 0 )
        if ( t1 == null ) node.`val` = t2!!.`val`
        else if ( t2== null ) node.`val` = t1!!.`val`
        else node.`val` = t1!!.`val` + t2!!.`val`

        node.left = mergeTrees( t1?.left, t2?.left )
        node.right = mergeTrees( t1?.right, t2?.right )

        return node
    }

    inner class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
package io.groud.leetcode.algo.tree.binary_tree


/** https://leetcode-cn.com/problems/binary-tree-right-side-view/
  *
  * @author Li.Wei by 2020/4/22
  */
object _199_SCALA_二叉树的右视图 {


  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = _
    var right: TreeNode = _
  }

  object Solution {
    def rightSideView(root: TreeNode): List[Int] = {
      if (root == null) return List()
      import java.util
      val deque = new util.LinkedList[TreeNode]
      deque.addFirst(root)
      val ans = Seq.newBuilder[Int]
      while (!deque.isEmpty) {
        val last = deque.pollLast
        ans.addOne(last.value)
        for (_ <- deque.size until 0 by -1) {
          val curr: TreeNode = deque.pollLast
          if (curr.right != null) deque.addFirst(curr.right)
          if (curr.left != null) deque.addFirst(curr.left)
        }
        if (last.left != null) deque.addLast(last.left)
        if (last.right != null) deque.addLast(last.right)
      }
      ans.result().toList
    }
  }

  // 耗时较短答案
  object Solution1 {
    def rightSideView(root: TreeNode): List[Int] = {
      var ans = List[Int]()
      if (root == null) {
        return ans
      }
      val queue = collection.mutable.Queue[TreeNode](root)
      while (queue.nonEmpty) {
        val len: Int = queue.length
        var tmp: Int = -1
        for (_ <- 0 until len) {
          val node: TreeNode = queue.dequeue()
          tmp = node.value
          if (node.left != null) {
            queue.enqueue(node.left)
          }
          if (node.right != null) {
            queue.enqueue(node.right)
          }
        }
        ans :+= tmp
      }
      ans
    }
  }

}

package io.groud.leetcode.algo.dfs_bfs

/** https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
  * TODO 编译不通过
  *
  * @author Li.Wei by 2020/4/17
  */
object _103_SCALA_二叉树的锯齿形层次遍历 {

  private case class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = _
    var right: TreeNode = _
  }

  object Solution {
    def zigzagLevelOrder(root: TreeNode): List[List[Int]] = {
      if (root == null) return List()
      import scala.collection.mutable
      var ans = mutable.Seq[List[Int]]()
      var level = 1
      val deque = mutable.ArrayDeque[TreeNode]()
      deque.addOne(root)
      while (deque.nonEmpty) {
        var one: mutable.Seq[Int] = mutable.Seq[Int]()
        deque.removeAll().foreach(f => {
          one = one.:+(f.value)
          if (f.left != null) deque.addOne(f.left)
          if (f.right != null) deque.addOne(f.right)
        })
        if ((level & 1) == 0) one.reverse
        ans = ans.:+(one)
        level += 1
      }
      ans.toList
    }
  }

  def main(args: Array[String]): Unit = {
    val t9 = TreeNode(9)
    val t3 = TreeNode(3)
    t3.left = t9
    Solution.zigzagLevelOrder(t3)
  }

}

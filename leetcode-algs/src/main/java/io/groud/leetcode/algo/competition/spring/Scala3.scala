package io.groud.leetcode.algo.competition.spring


/**
  * @author Li.Wei by 2020/4/18
  */
object Scala3 {

  object SolutionBak {

    case class Node(var count: Int, var index: Int) {}

    def minJump(jump: Array[Int]): Int = {
      import java.util
      if (jump == null || jump.length == 0) return 0
      val r = jump.length - 1 // 一直右跳次数
      val deque = new util.LinkedList[Node]
      deque.addFirst(Node(1, 0))
      var ans = r // 最小次数
      while ( {
        !deque.isEmpty
      }) for (_ <- deque.size until 0 by -1) {
        val node = deque.pollLast
        val index = node.index
        val next = jump(index) // 跳到的位置对应步数
        if (index - next >= 0 && node.count < ans) deque.addFirst(Node(node.count + 1, index - next)) // 左边
        if (index + next >= r) { // 成功
          ans = Math.min(ans, node.count)
        }
        else deque.addFirst(Node(node.count + 1, index + next)) // 右边
      }
      ans
    }
  }

  object Solution {
    def minJump(jump: Array[Int]): Int = {
      import java.util
      if (jump == null || jump.length == 0) return 0
      val r = jump.length - 1 // 一直右跳次数
      val deque = new util.LinkedList[(Int, Int)]
      deque.addFirst((1, 0))
      var ans = r // 最小次数
      while (!deque.isEmpty)
        for (_ <- deque.size until 0 by -1) {
          val node = deque.pollLast()
          val index = node._2
          val next = jump(index) // 跳到的位置对应步数
          if (index - next >= 0 && node._1 < ans) deque.addFirst((node._1 + 1, index - next)) // 左边
          if (index + next >= r) ans = Math.min(ans, node._1) else deque.addFirst((node._1 + 1, index + next)) // 右边
        }

      ans
    }
  }

}

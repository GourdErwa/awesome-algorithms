package io.groud.leetcode.algo.intervals

/**
  * @author Li.Wei by 2020/4/16
  */
object _56_SCALA_合并区间 {

  object Solution {
    def merge(intervals: Array[Array[Int]]): Array[Array[Int]] = {
      intervals.sortWith((o1, o2) => o1(0) > o2(0))
      for (a <- 1 until intervals.length) {
        val prev = intervals(a - 1)
        var curr = intervals(a)
        if (curr(0) <= prev(1)) { // 重叠
          curr.update(0, prev(0))
          intervals(a - 1) = null
        }
      }
      intervals.dropWhile(_ == null)
    }
  }

  def main(args: Array[String]): Unit = {
    println(
      Solution.merge(Array(
        Array(1, 3), Array(2, 6),
      ))
    )
  }
}

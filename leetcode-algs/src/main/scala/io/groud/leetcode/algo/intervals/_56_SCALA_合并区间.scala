package io.groud.leetcode.algo.intervals

/**
  * @author Li.Wei by 2020/4/16
  */
object _56_SCALA_合并区间 {

  object Solution {
    def merge(intervals: Array[Array[Int]]): Array[Array[Int]] = {
      val array = intervals.sortWith((o1, o2) => o1(0) < o2(0))
      for (a <- 1 until array.length) {
        val prev = array(a - 1)
        val curr = array(a)
        if (curr(0) <= prev(1)) { // 重叠
          array(a) = Array(prev(0), Math.max(prev(1), curr(1)))
          array(a - 1) = null
        }
      }
      array.filterNot(_ == null)
    }
  }

  // scala 耗时较短题解
  object Solution1 {
    def merge(intervals: Array[Array[Int]]): Array[Array[Int]] = {

      if (intervals.length <= 1) {
        return intervals
      }
      val builder = Array.newBuilder[Array[Int]]
      val array = intervals.sortBy(array => array(0)) // 按区间左起点排序
      var (a, b): (Int, Int) = (array(0)(0), array(0)(1)) // prev

      for (i <- 1 until array.length) {
        val (p, q): (Int, Int) = (array(i)(0), array(i)(1)) // curr
        if (p <= b) {
          a = math.min(a, p)
          b = math.max(b, q)
        } else {
          builder.addOne(Array[Int](a, b))
          a = p
          b = q
        }
      }
      builder.addOne(Array[Int](a, b)).result()
    }
  }

  def main(args: Array[String]): Unit = {
    println(
      Solution.merge(Array(
        Array(1, 4), Array(0, 4),
      )).toSeq.mkString(",")
    )
  }
}

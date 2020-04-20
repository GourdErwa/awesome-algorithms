package io.groud.leetcode.algo.lcp

/**
  * @author Li.Wei by 2020/4/20
  */
object _LCP_06_SCALA_拿硬币 {

  object Solution {
    def minCount(coins: Array[Int]): Int = {
      var ans = 0
      for (elem <- coins) {
        ans += ((elem + 1) >> 1)
      }
      ans
    }
  }

}

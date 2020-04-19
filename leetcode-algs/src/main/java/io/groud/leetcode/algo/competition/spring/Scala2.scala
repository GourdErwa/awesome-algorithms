package io.groud.leetcode.algo.competition.spring


/**
  * @author Li.Wei by 2020/4/18
  */
object Scala2 {

  object Solution {
    def getTriggerTime(increase: Array[Array[Int]], requirements: Array[Array[Int]]): Array[Int] = {
      val reqLength = requirements.length
      val ans = new Array[Int](reqLength) // 返回数据
      import java.util
      util.Arrays.fill(ans, -1)
      var c = 0
      var r = 0
      var h = 0
      for (i1 <- 0 until reqLength) {
        val requirement = requirements(i1)
        if (ans(i1) == -1 && requirement(0) <= c && requirement(1) <= r && requirement(2) <= h) ans(i1) = 0
      }

      for (i <- increase.indices) {
        val curr = increase(i)
        c += curr(0)
        r += curr(1)
        h += curr(2)
        for (i1 <- 0 until reqLength) {
          val requirement = requirements(i1)
          if (ans(i1) == -1 && requirement(0) <= c && requirement(1) <= r && requirement(2) <= h) ans(i1) = i + 1
        }
      }
      ans
    }
  }

}

package io.groud.leetcode.algo.array

/**
  * @author Li.Wei by 2020/4/17
  */
object _55_SCALA_跳跃游戏 {

  object Solution {
    def canJump(nums: Array[Int]): Boolean = {
      val length = nums.length;
      var max = 0;
      for (i <- 0 until length) {
        if (i <= max) {
          max = Math.max(nums(i) + i, max)
          if (max >= length - 1) return true;
        }
      }
      max >= length - 1
    }
  }

}

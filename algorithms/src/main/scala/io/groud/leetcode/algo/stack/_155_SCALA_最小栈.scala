package io.groud.leetcode.algo.stack

import scala.collection.mutable

/**
  * https://leetcode-cn.com/problems/min-stack/
  *
  * @author Li.Wei by 2020/2/28
  */
object _155_SCALA_最小栈 {

  /**
    * 当前堆中存放元素规则为
    *
    * data-4
    * data-3-min
    * data-3
    * data-2-min
    * data-2
    * data-1-min
    * data-1
    *
    * data-4 出栈后，将 data-3-min 设为 data-3 的最小值。
    */
  class MinStack() {
    private val stack = new mutable.Stack[(Int, Int)]
    private var min = Integer.MAX_VALUE

    def push(x: Int): Unit = {
      min = Math.min(min, x)
      stack.push(x -> min)
    }

    def pop(): Unit = {
      stack.pop()
      min = stack.top._2
    }

    def top: Int = stack.top._1

    def getMin: Int = min
  }

}

package io.groud.leetcode.algo.queue

/** https://leetcode-cn.com/problems/moving-average-from-data-stream/
  *
  * @author Li.Wei by 2020/2/27
  */
object _346_SCALA_数据流中的移动平均值 {

  // 忽略合法性校验。if (_size < 1) return 0D // 保证数据的合法性
  class MovingAverage(_size: Int) {

    val queue = scala.collection.mutable.Queue[Int]() // 可变队列，仅保留数据流最大长度
    var sum = 0D // 当前队列数字总和，为了保证除法计算小数位不丢失精确，声明为 double

    def next(`val`: Int): Double = {
      if (queue.lengthCompare(_size) >= 0) sum -= queue.dequeue() // 超过最大长度，移除
      sum += `val`
      queue.enqueue(`val`)
      sum / queue.size
    }
  }

  def main(args: Array[String]): Unit = {
    val o = new MovingAverage(3)
    println(o.next(1))
    println(o.next(10))
    println(o.next(3))
    println(o.next(5))
    println(o.next(6))
  }
}
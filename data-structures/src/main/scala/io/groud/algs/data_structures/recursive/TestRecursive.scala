package io.groud.algs.data_structures.recursive

/**
  * @author Li.Wei by 2020/2/21
  */
object TestRecursive {

  @scala.annotation.tailrec
  def addHelp(n: Int, sum: Int): Int = {
    if (n == 1) return sum + 1
    addHelp(n - 1, sum + n)
  }

  def add(n: Int): Int = {
    if (n == 1) return 1
    n + add(n - 1)
  }

  def main(args: Array[String]): Unit = {
    println(addHelp(1, 0))
  }
}

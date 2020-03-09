package io.groud.leetcode.algo.linkedlist

/**
  * @author Li.Wei by 2020/2/21
  */
object TestRecursive {

  @scala.annotation.tailrec
  def addHelp(n: Int, sum: Int): Int = {
    if (n == 1) return sum + 1
    addHelp(n - 1, sum + n)
  }

  /*  public int addHelp(int n, int sum) {
      while (true) {
        if (n == 1)
          return sum + 1;
        sum += n;
        n--;
      }
    }*/
  def add(n: Int): Int = {
    if (n == 1) return 1
    n + add(n - 1)
  }

  /**
    * 10 + sum(9)
    * 10 + 9 + sum(8)
    * 10 + 9 + 8 + sum(7)
    */
  def sum(n: Int): Int = {
    if (n < 2) return n
    n + sum(n - 1)
  }

  @scala.annotation.tailrec
  def sum2(n: Int, sum: Int): Int = {
    if (n < 2) return sum + n
    sum2(n - 1, sum + n)
  }
}

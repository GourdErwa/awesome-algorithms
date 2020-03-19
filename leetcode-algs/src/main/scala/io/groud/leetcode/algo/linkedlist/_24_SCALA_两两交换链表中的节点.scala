package io.groud.leetcode.algo.linkedlist

/** https://leetcode-cn.com/problems/swap-nodes-in-pairs/
  *
  * @author Li.Wei by 2020/2/21
  */
object _24_SCALA_两两交换链表中的节点 {

  class ListNode(var _x: Int = 0) {
    var next: ListNode = _
    var x: Int = _x
  }

  // 终止条件 后驱节点为 null
  // 递归参数，交换了节点的节点。 例如 1->2 交换后为 2->1 ，传递 1节点给递归函数。
  def swapPairs(head: ListNode): ListNode = {
    if (head == null || head.next == null) return null
    val newHead = new ListNode(0)
    newHead.next = head
    helper(newHead, head)
    newHead.next
  }

  @scala.annotation.tailrec
  def helper(prev: ListNode, curr: ListNode): Unit = {
    if (curr == null || curr.next == null) return
    val nextNext = curr.next.next
    prev.next = curr.next
    curr.next.next = curr
    curr.next = nextNext
    helper(curr, nextNext)
  }

  @scala.annotation.tailrec
  def helper2(prev: ListNode): Unit = {
    if (prev.next == null || prev.next.next == null) return
    val curr = prev.next // 交换节点 1
    val nextNext = curr.next.next // 交换节点 2
    prev.next = curr.next
    curr.next.next = curr
    curr.next = nextNext

    println("111")

    helper2(curr)
  }
}

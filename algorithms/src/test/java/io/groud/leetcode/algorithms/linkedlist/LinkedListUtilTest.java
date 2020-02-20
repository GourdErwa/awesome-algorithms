package io.groud.leetcode.algorithms.linkedlist;

import io.groud.leetcode.algorithms.linkedlist.LinkedListUtil.ListNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Li.Wei by 2020/2/19
 */
class LinkedListUtilTest {
    private final LinkedListUtil o = new LinkedListUtil();

    // 1->-2->3->4>->5
    private final ListNode testG1N5 = new ListNode(5, null);
    private final ListNode testG1N4 = new ListNode(4, testG1N5);
    private final ListNode testG1N3 = new ListNode(3, testG1N4);
    private final ListNode testG1N2 = new ListNode(2, testG1N3);
    private final ListNode testG1N1 = new ListNode(1, testG1N2);

    // 1->-2->3->4
    private final ListNode testG3N4 = new ListNode(4, null);
    private final ListNode testG3N3 = new ListNode(3, testG3N4);
    private final ListNode testG2N2 = new ListNode(2, testG3N3);
    private final ListNode testG2N1 = new ListNode(1, testG2N2);

    // 1->-2
    private final ListNode testG3N2 = new ListNode(2, null);
    private final ListNode testG3N1 = new ListNode(1, testG3N2);

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void reverseList() {
        assertNull(o.reverseList(null));

        assertEquals(testG1N5, o.reverseList(testG1N1));

        assertEquals(testG3N4, o.reverseList(testG2N1));

        assertEquals(testG3N2, o.reverseList(testG3N1));
    }

    @Test
    void findMiddleNode() {
        assertNull(o.findMiddleNode(null));

        assertEquals(testG1N3, o.findMiddleNode(testG1N1));

        assertEquals(testG3N3, o.findMiddleNode(testG2N1));

        assertEquals(testG3N2, o.findMiddleNode(testG3N1));
    }
}
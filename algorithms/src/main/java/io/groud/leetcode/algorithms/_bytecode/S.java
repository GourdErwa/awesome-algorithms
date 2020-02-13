package io.groud.leetcode.algorithms._bytecode;

/**
 * @author Li.Wei by 2020/2/8
 */
public class S {
    int index = 0;

    /**
     * Code:
     * stack=3, locals=1, args_size=1
     * 0: aload_0
     * 1: aload_0
     * 2: getfield      #2                  // Field index:I
     * 5: iconst_1
     * 6: iadd
     * 7: bipush        10
     * 9: irem
     * 10: putfield      #2                  // Field index:I
     * 13: return
     * LineNumberTable:
     * line 10: 0
     * line 11: 13
     * LocalVariableTable:
     * Start  Length  Slot  Name   Signature
     * 0      14     0  this   Lio/groud/leetcode/algorithms/_bytecode/S;
     */
    public void mo() {
        index = (index + 1) % 10;
    }

    /**
     * Code:
     * stack=3, locals=1, args_size=1
     * 0: aload_0
     * 1: aload_0
     * 2: getfield      #2                  // Field index:I
     * 5: iconst_1
     * 6: iadd
     * 7: bipush        10
     * 9: if_icmple     16
     * 12: iconst_0
     * 13: goto          20
     * 16: aload_0
     * 17: getfield      #2                  // Field index:I
     * 20: putfield      #2                  // Field index:I
     * 23: return
     * LineNumberTable:
     * line 14: 0
     * line 15: 23
     * LocalVariableTable:
     * Start  Length  Slot  Name   Signature
     * 0      24     0  this   Lio/groud/leetcode/algorithms/_bytecode/S;
     */
    public void con() {
        index = ++index > 10 ? 0 : index;
    }
}

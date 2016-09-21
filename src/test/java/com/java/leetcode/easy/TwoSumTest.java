package com.java.leetcode.easy;

import junit.framework.Assert;
import org.junit.Test;

/**
 * @author haoqi.thq
 * @version $Id: TwoSumTest.java, v 0.1 16/9/21 下午9:23 JinQi Exp $
 */
public class TwoSumTest {

    @Test
    public void testTwoSum() throws Exception {
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(new int[]{1,2,3,4},3);
        Assert.assertEquals(result[0],1);
        Assert.assertEquals(result[1],2);
    }
}

package com.infinitechnic.util;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberUtilTest {
    @Test
    public void isNumber() {
        // True cases
        Assert.assertTrue(NumberUtil.isNumber("0"));
        Assert.assertTrue(NumberUtil.isNumber("0.1"));
        Assert.assertTrue(NumberUtil.isNumber("0.0001"));
        Assert.assertTrue(NumberUtil.isNumber("10"));
        Assert.assertTrue(NumberUtil.isNumber("1,000"));
        Assert.assertTrue(NumberUtil.isNumber("1,000,000"));
        Assert.assertTrue(NumberUtil.isNumber("1,000,000.00"));
        Assert.assertTrue(NumberUtil.isNumber("1,000,000.001"));
        Assert.assertTrue(NumberUtil.isNumber("-0"));
        Assert.assertTrue(NumberUtil.isNumber("-0.1"));
        Assert.assertTrue(NumberUtil.isNumber("-0.0001"));
        Assert.assertTrue(NumberUtil.isNumber("-10"));
        Assert.assertTrue(NumberUtil.isNumber("-1,000"));
        Assert.assertTrue(NumberUtil.isNumber("-1,000,000"));
        Assert.assertTrue(NumberUtil.isNumber("-1,000,000.00"));
        Assert.assertTrue(NumberUtil.isNumber("-1,000,000.001"));

        // False cases
        Assert.assertFalse(NumberUtil.isNumber("O"));
        Assert.assertFalse(NumberUtil.isNumber("1,0000,00"));
        Assert.assertFalse(NumberUtil.isNumber("1000,000"));
    }
}

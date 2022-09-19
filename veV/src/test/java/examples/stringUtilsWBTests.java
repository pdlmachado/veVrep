package examples;

import org.junit.jupiter.api.Test;

class stringUtilsWBTests {

    public static boolean debug = false;

    @Test
    public void test01() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test01");
        examples.stringUtils stringUtils0 = new examples.stringUtils();
        java.lang.Class<?> wildcardClass1 = stringUtils0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass1);
    }

    @Test
    public void test02() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test02");
        java.lang.String[] strArray3 = examples.stringUtils.substringBetween("hi!", "hi!", "");
        org.junit.Assert.assertNull(strArray3);
    }

    @Test
    public void test03() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test03");
        java.lang.String[] strArray3 = examples.stringUtils.substringBetween("hi!", "", "");
        org.junit.Assert.assertNull(strArray3);
    }

    @Test
    public void test04() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test04");
        java.lang.String[] strArray3 = examples.stringUtils.substringBetween("", "hi!", "");
        org.junit.Assert.assertNull(strArray3);
    }

    @Test
    public void test05() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test05");
        java.lang.String[] strArray3 = examples.stringUtils.substringBetween("hi!", "", "hi!");
        org.junit.Assert.assertNull(strArray3);
    }

    @Test
    public void test06() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test06");
        java.lang.String[] strArray3 = examples.stringUtils.substringBetween("", "hi!", "hi!");
        java.lang.Class<?> wildcardClass4 = strArray3.getClass();
        org.junit.Assert.assertNotNull(strArray3);
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test07() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test07");
        java.lang.String[] strArray3 = examples.stringUtils.substringBetween("", "", "");
        org.junit.Assert.assertNull(strArray3);
    }

    @Test
    public void test08() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test08");
        java.lang.String[] strArray3 = examples.stringUtils.substringBetween("", "", "hi!");
        org.junit.Assert.assertNull(strArray3);
    }

    @Test
    public void test09() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test09");
        java.lang.Object obj0 = new java.lang.Object();
        java.lang.Class<?> wildcardClass1 = obj0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass1);
    }

    @Test
    public void test10() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test10");
        java.lang.String[] strArray3 = examples.stringUtils.substringBetween("hi!", "hi!", "hi!");
        org.junit.Assert.assertNull(strArray3);
    }

}

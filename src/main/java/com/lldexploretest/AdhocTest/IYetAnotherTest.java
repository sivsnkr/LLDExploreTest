package com.lldexploretest.AdhocTest;

public interface IYetAnotherTest extends ITest {
    default void testmethod() {
        System.out.println("default implementation of test method");
    }

    static void testStatic() {

    }

    private void privateTest() {}

//    void testmethod();
}

package com.lldexploretest.AccessModiferAndConstructors;

import com.lldexploretest.AdhocTest.ITest;

public abstract class TopLevelClass {

    public int val;

    private TopLevelClass() {
        this.val = 1;
    }

    public TopLevelClass(int val) {
        this();
        this.val = val;
        run();
    }

//    public TopLevelClass(int val) {
//        this.val = val;
//    }

    protected void run() {
        System.out.println("run in TopLevel");
    }

    public void test() {
        run();
    }

//    @Override
//    public void testmethod() {
//
//    }
//
//    @Override
//    public void main() {
//        System.out.println("Test in main of ITest");
//    }
}

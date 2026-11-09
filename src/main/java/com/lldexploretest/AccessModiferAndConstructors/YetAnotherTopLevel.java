package com.lldexploretest.AccessModiferAndConstructors;

import com.lldexploretest.AdhocTest.ITest;
import com.lldexploretest.AdhocTest.IYetAnotherTest;

public class YetAnotherTopLevel extends TopLevelClass implements IYetAnotherTest, ITest {
    public YetAnotherTopLevel(int val) {
        super(val);
    }

    public void yetAnotherTest() {
        super.test();
    }

    @Override
    public void testmethod() {
        System.out.println("overridden in YetAnotherTest class");
    }

    public class TestInnerClass {
        public void innerRun() {
            YetAnotherTopLevel outerInstance = YetAnotherTopLevel.this;
            run();
        }
    }

    @Override
    protected void run() {
        System.out.println("run in YetAnotherTopLevel");
    }

    @Override
    public void test() {
        super.test();
    }
}

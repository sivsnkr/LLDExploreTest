package com.lldexploretest.AdhocTest;

import com.lldexploretest.AccessModiferAndConstructors.TopLevelClass;
import com.lldexploretest.AccessModiferAndConstructors.YetAnotherTopLevel;

public class Test extends YetAnotherTopLevel {

    static  {
        System.out.println("ran in static, it's so cool");
    }

    public class Test1 {
        public void run() {
            System.out.println(val1);
            Test.this.run();
        }
    }

    public static class Test2 {

        private int val;

        public Test2(int val) {
            this.val = val;
        }

        public void run() {
            System.out.println("inner static : " + val);
        }
    }

    private int val1;

    public Test(int val) {
        super(val);
        this.val1 = val;
    }

    public static void teststatic(Test test) {
        System.out.println(test.val1);
    }

//    public Test(int val1, int val) {
//        this(val);
//        this.val1 = val1;
//    }

    @Override
    public void run() {
        System.out.println("overridden run in test");
    }

//    @Override
//    public void test() {
//        run();
//    }
}

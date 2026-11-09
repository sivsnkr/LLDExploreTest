package com.lldexploretest.AccessModiferAndConstructors;

import com.lldexploretest.AdhocTest.IYetAnotherTest;

public class Client {
    public static void main(String[] args) {
        YetAnotherTopLevel topLevelClass = new YetAnotherTopLevel(2);
//        IYetAnotherTest yetAnotherTopLevel = new YetAnotherTopLevel(2);
//        yetAnotherTopLevel.testmethod();

        System.out.println(topLevelClass.val);
    }
}

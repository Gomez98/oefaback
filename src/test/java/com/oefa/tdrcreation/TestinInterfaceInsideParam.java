package com.oefa.tdrcreation;

public class TestinInterfaceInsideParam {

    static void tryingToSumBy(InterfaceTest1 test){
        int res = test.sum(1,2);
        System.out.println("res = " + res);
    }

    static void tryingToRes(InterfaceTest1 test){
        int res = test.res(1,2);
        System.out.println("res = " + res);
    }
    public static void main(String[] args) {
        tryingToSumBy(new InterfaceTest1Impl());
        tryingToRes(new InterfaceTest1Impl());
    }

}

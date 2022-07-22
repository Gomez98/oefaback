package com.oefa.tdrcreation;

public class InterfaceTest1Impl implements InterfaceTest1{
    @Override
    public int sum(int a, int b) {
        return a + b;
    }

    @Override
    public int res(int a, int b) {
        return b - a;
    }
}

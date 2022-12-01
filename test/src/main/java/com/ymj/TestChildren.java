package com.ymj;

public class TestChildren extends Test{
    public TestChildren(){
//        System.out.println(super.getFinalword());
        this.show();
        super.show();
        super.setTest("x");
        System.out.println(super.getTest());
    }

    public void show(){
        System.out.println(2);
    }

    public static void main(String[] args) {
        TestChildren testChildren = new TestChildren();
    }
}

package com.ymj.spqms;

public class AdapterImpl implements Adapter{
    OneOneV oneOneV;

    @Override
    public void use() {
        oneOneV = new OneOneImpl();
        oneOneV.use110();
    }

    public static void main(String[] args) {
        TwoTwoV twoTwoV = new TwoTwoImpl();
        twoTwoV.user220();
        twoTwoV.user110();
    }
}

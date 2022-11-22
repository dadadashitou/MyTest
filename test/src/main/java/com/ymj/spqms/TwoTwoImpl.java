package com.ymj.spqms;

public class TwoTwoImpl implements TwoTwoV{
    Adapter adapter;

    @Override
    public void user220() {
        System.out.println("220");
    }

    @Override
    public void user110() {
        adapter = new AdapterImpl();
        adapter.use();
    }
}

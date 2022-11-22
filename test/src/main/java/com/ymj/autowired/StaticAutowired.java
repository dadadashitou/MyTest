package com.ymj.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StaticAutowired {

    public static final String name = "jkl";

    public void init(){
        System.out.println(name);
    }
}

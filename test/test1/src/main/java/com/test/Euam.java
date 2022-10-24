package com.test;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum Euam {
    SPRING("xx"),SUMMER("xxxx");

    private String name;

    Euam(String name){
        this.name = name;
    }

    public String toString(){
        return "Season :{ name =  " + name + "}";
    }

    public static void main(String[] args) {
        System.out.println(Euam.valueOf("SPRING"));
//        System.out.println(Euam.SUMMER);
    }
}

package com.ymj;

@FunctionalInterface
public interface Lambda<T,R> {
    R x(T a,T b);

    default String getAll(){
        return "a";
    }

    static String getALll(){
        return "b";
    }
}

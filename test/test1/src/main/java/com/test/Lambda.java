package com.test;

@FunctionalInterface
public interface Lambda<T,R> {
    R x(T a,T b);
}

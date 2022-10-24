package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test {
    
    private Test(){};

    public void show(){
        System.out.println(1);
    }
    
    public static void main(String[] args) {
        Test test = new Test();
        test.show();

        Lambda<Integer,Integer> lambda = (t1,t2) -> t1+t2;

        Integer a = lambda.x(5,5);
        System.out.println(a);


        Lambda<String,Integer> lambda1 = (t1,t2) -> Integer.parseInt(t1) + Integer.parseInt(t2);
        Integer b = lambda1.x("5","5");
        System.out.println(b);

        Lambda<String,Boolean> lambda2 = (t1,t2) -> {
            return t1.equals(t2);
        };
        Boolean c = lambda2.x("xx","xx");
        System.out.println(c);

        List<String> list = Arrays.asList("1","2","3");
        //<R> Stream<R> map(Function<? super T, ? extends R> mapper)
        //map中传入Function,Function的new的方式,可以采用
        Function<String, Collection<String>> function = t -> {
          List<String> listx = new ArrayList<>();
          listx.add(t);
          return listx;
        };

        Predicate<Integer> predicate = e -> e==1;

        System.out.println(list.stream().map(e -> Integer.parseInt(e) + 1).collect(Collectors.toMap(e -> e, e-> e.toString())));
        System.out.println(list.stream().collect(Collectors.groupingBy(e -> e.equals("1"))));
    }
}

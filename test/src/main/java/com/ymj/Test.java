package com.ymj;

import lombok.Data;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
public class Test {
    private String test;
    private String xx;

    public Test(String test,String xx){
        this.test = test;
        this.xx = xx;
    }

    public Test(){};

    public void show(){
        System.out.println(1);
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.show();

        //自定义函数接口
//        Lambda<Integer,Integer> lambda = (t1,t2) -> t1+t2;

        Lambda<Integer,Integer> lambda = ((t1,t2) -> {
            return t1+t2;
        });

        Integer a = lambda.x(5,5);
        System.out.println(a);

        //--------------------------------------------------------------------------------------------------
        Lambda<String,Integer> lambda1 = (t1,t2) -> Integer.parseInt(t1) + Integer.parseInt(t2);
        Integer b = lambda1.x("5","5");
        System.out.println(b);

        Lambda<String,Boolean> lambda2 = (t1,t2) -> {
            return t1.equals(t2);
        };
        Boolean c = lambda2.x("xx","xx");
        System.out.println(c);

        //-----------------------------------------------------------------------------------------------------
        List<String> list = Arrays.asList("1","2","3");
        //<R> Stream<R> map(Function<? super T, ? extends R> mapper)
        //map中传入Function,Function的new的方式,可以采用
        Function<String, List<String>> function1 = t -> {
            List<String> listx = new ArrayList<>();
            listx.add(t+t);
            return listx;
        };

        Function<List<String>,String> function2 = t->{
            return t.get(0)+t.get(0);
        };

        String apply = function1.andThen(function2).apply("1");
        System.out.println(apply);

        Predicate<Integer> predicate = e -> e==1;

        //-----------------------------------------------------------------------------------------------------------------------
        System.out.println("@@@@@@@@@@@@@@@@@@@@"+list.stream().map(e -> Integer.parseInt(e) + 1).collect(Collectors.toMap(e -> e, e-> e.toString())));
        System.out.println(list.stream().collect(Collectors.groupingBy(e -> e.equals("1"))));

        //-----------------------------------------------------------------------------------------------------------------------
        Map<String,Object> map = new HashMap<>();
        map.put("xx","xx");
        map.put("xxx","xx22");
        map.put("xxxxx","xxxxx22");
        map.forEach((k,v) ->{
            if(k.equals(v)){
                System.out.println(true);
            }
        });
        //------------------------------------------------------------------------------------------------------------------------
        List<Test> listxx = new ArrayList<>();
        listxx.add(new Test("nn","ll"));
        listxx.add(new Test("aa","bb"));
        listxx.add(new Test("cc","dd"));
        listxx.add(new Test("ee","ff"));
        List<String> aa = listxx.stream().map(e -> {
            if (e.getTest().equals("aa")) {
                return e.getXx();
            }
            return null;
        }).filter(e -> null != e).collect(Collectors.toList());

        //转Map
        Map<String, String> collect = listxx.stream().collect(Collectors.toMap(e -> e.getXx(), e -> e.getTest()));
        System.out.println("QQQQQQQQQQQQQQQQQQQQ"+collect);
    }
}

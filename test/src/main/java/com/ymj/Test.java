package com.ymj;

import lombok.Data;
import org.apache.logging.log4j.util.PropertySource;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
public class Test {
    private String test;
    private String xx;
    private Integer length;

    public Test(String test,String xx,Integer length){
        this.test = test;
        this.xx = xx;
        this.length = length;
    }

    public Test(){};

    public void show(){
        System.out.println(1);
    }

    static BiFunction<String,String,Boolean> biFunction = (a,b) -> {
        if(a.equals(b)){
            return true;
        }
        return false;
    };

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
        System.out.println("map               "+list.stream().map(e -> Integer.parseInt(e) + 1).collect(Collectors.toMap(e -> e, e-> e.toString())));
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
        listxx.add(new Test("nnnnn","ll","nnnnn".getBytes().length));
        listxx.add(new Test("aa","bb","aa".getBytes().length));
        listxx.add(new Test("ccc","dd","ccc".getBytes().length));
        listxx.add(new Test("eeee","ff","eeee".getBytes().length));
        List<String> aa = listxx.stream().map(e -> {
            if (e.getTest().equals("aa")) {
                return e.getXx();
            }
            return null;
        }).filter(e -> null != e).collect(Collectors.toList());
        System.out.println("map filter              "+aa);
        //转Map
        Map<String, String> collect = listxx.stream().collect(Collectors.toMap(e -> e.getXx(), e -> e.getTest()));
        System.out.println("toMap                      "+collect);

        //-----------------------------------------------------------------------------------------------------------
        Comparable<Test> comparable = (t) -> {
            if(t.getTest().equals("aa")){
                return 1;
            }else{
                return 0;
            }
        };
        //采用new接口方式,直接重写抽象方法
//        Comparator<Test> comparator = new Comparator<Test>() {
//            @Override
//            public int compare(Test o1, Test o2) {
//                if(o1.getTest().getBytes().length > o2.getTest().getBytes().length){
//                    return 1;
//                }else if(o1.getTest().getBytes().length < o2.getTest().getBytes().length){
//                    return -1;
//                }
//                return 0;
//            }
//        }.reversed();
        //lambda表达式,
        Comparator<Test> comparator = (o1,o2) -> {
            if(o1.getLength() > o2.getLength()){
                    return 1;
                }else if(o1.getLength() < o2.getLength()){
                    return -1;
                }
                return 0;
        };
        int compare = comparator.compare(new Test("aa", "bb", 1), new Test("bb", "cc", 2));
        System.out.println("compare            "+compare);
        Collections.sort(listxx,comparator.reversed());
        System.out.println("Comparator              " + listxx);

        Boolean apply1 = biFunction.apply("a", "b");
        System.out.println("biFunction              "+apply1);
    }
}

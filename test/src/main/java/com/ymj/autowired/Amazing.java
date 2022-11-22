package com.ymj.autowired;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Amazing {

    public static void main(String[] args) {
        System.out.print(fuckNum(-9223372032922960524L));
        System.out.print(fuckNum(-9223372036787291500L));
        System.out.print(fuckNum(-9223372026102924407L));
        System.out.print(fuckNum(-9223372036837784436L));
        System.out.print(fuckNum(-9223372036854746307L));
        System.out.print(fuckNum(-9223372034258670792L));
    }

    public static String fuckNum(long i) {
        Random ran = new Random(i);
        StringBuilder sb = new StringBuilder();
        while (true) {
            int k = ran.nextInt(78);
            if (k == 0) {
                break;
            }
            sb.append((char) ('-' + k));
        }
        return sb.toString();
    }
}

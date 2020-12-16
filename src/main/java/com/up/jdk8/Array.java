package com.up.jdk8;

import cn.hutool.core.util.ArrayUtil;
import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * @author songdaxin
 */
public class Array {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 4, 3, 1};
        OptionalInt max = Arrays.stream(arr).max();
        System.out.println(max.getAsInt());
        System.out.println(ArrayUtil.max(arr));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Arrays.sort(arr);
        stopWatch.stop();
        System.out.println(Arrays.toString(arr) + "耗时："+stopWatch.getTotalTimeMillis());
    }
}

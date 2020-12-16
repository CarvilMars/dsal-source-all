package com.up.lagou;

import cn.hutool.core.util.ArrayUtil;
import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author songdaxin
 */
public class Chapter01 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 3, 4, 1, 3};
        reverseArr(arr);
        int[] arr1 = new int[]{-5, -2, -1, -5};
        max(arr1);
        maxTimes(arr);
        String seq = "aabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaaaabccccaaa";
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        calcTimes(seq);
        stopWatch.stop();
        System.out.println("字符串长度:" + seq.length() + ",耗时：" + stopWatch.getTotalTimeMillis());
        System.out.println("============");

        StopWatch stopWatch1 = new StopWatch();
        stopWatch1.start();
        int[] arr2 = ArrayUtil.range(0, 101);
        calcMin(arr2);
        stopWatch1.stop();
        System.out.println("耗时：" + stopWatch.getTotalTimeMillis());
        union();
    }

    /**
     * 某个尝试登录用户的ID去核实是否合法
     */
    public static boolean checkUser(String username, String password) {
        // 模拟从数据库中获取海量数据
        // 校验用户是否在用户群中（查找），可能涉及用户去重判断
        // 在程序中实现SQL select * from user where username = 'username' and password = 'password';
        // 方法一：对数据库数据进行排序，进行二分查找
        return true;
    }

    /**
     * 对于输入的数组，输出与之逆序的数组输入
     * a=[1,2,3,4,5]，输出 [5,4,3,2,1]
     */
    public static void reverseArr(int[] arr) {
        // 空间复杂度O(n),时间复杂度O(n)
        reverseArr01(arr);
        System.out.println("============");
        // 空间复杂度O(1),时间复杂度O(n)
        reverseArr02(arr);
        System.out.println("============");
        // 使用hutool.ArrayUtil.reverse 空间复杂度O(1),时间复杂度O(n)
        reverse(arr, 0, 2);
    }

    /**
     * 定义了一个数组 a = [1, 4, 3]，查找数组 a 中的最大值
     *
     * @param arr 数组
     */

    public static void max(int[] arr) {
        int max = -1;
        for (int j : arr) {
            if (j > max) {
                max = j;
            }
        }
        System.out.println(max);
    }

    /**
     * 定义了一个数组 a = [1, 3, 4, 3, 4, 1, 3]，在这个数组中查找出现次数最多的那个数字
     *
     * @param arr
     */
    public static void maxTimes(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>(16);
        int maxTimes = 0;
        int maxTimesValue = -1;
        for (int i : arr) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                if (maxTimes < map.get(i) + 1) {
                    maxTimes = map.get(i) + 1;
                    maxTimesValue = i;
                }
                map.put(maxTimesValue, maxTimes);
            }
        }
        System.out.println(maxTimesValue);
    }

    /**
     * 给定由普通英文字母组成的非空字符串s1，要求将连续出现的字符压缩成字符和该字符连续出现的次数，并返回新的字符串s2。s1字符串的长度不超过100。
     * <p>
     * 输入描述:
     * 全部由普通英文字符组成的长度不超过100的字符串 。
     * 输出描述:
     * 由英文字符和数字组成的字符串，其中数字表示它前面的字符在输入字符串中连续 出现的次数。
     * 示例
     * 输入：
     * aabccccaaa
     * 输出：
     * a2bc4a3
     *
     * @param paramIn
     */

    public static void calcTimes(String paramIn) {
        char[] chars = paramIn.toCharArray();
        Arrays.sort(chars);
        Map<Character, Integer> map = new HashMap<>(16);
        for (char aChar : chars) {
            if (!map.containsKey(aChar)) {
                map.put(aChar, 1);
            } else {
                map.put(aChar, map.get(aChar) + 1);
            }
        }
        StringBuilder stringBuilder = new StringBuilder(16);
        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            stringBuilder.append(characterIntegerEntry.getKey()).append(characterIntegerEntry.getValue());
        }
        System.out.println(stringBuilder.toString());
    }

    /**
     * 100 以内的正整数中，找到同时满足以下两个条件的最小数字：(暴力破解法)
     * 能被 3 整除,除 5 余 2。
     *
     * @param arr 0-100
     */
    public static void calcMin(int[] arr) {
        Arrays.sort(arr);
        int minValue = 0;
        for (int i : arr) {
            if (i % 3 == 0 && i % 5 == 2) {
                minValue = i;
            }
        }
        System.out.println(minValue);
    }

    public static void reverseArr01(int[] arr) {
        int[] arr1 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = arr[arr.length - i - 1];
        }
        System.out.println(Arrays.toString(arr1));
    }

    public static void reverseArr02(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length / 2; i++) {
            // 交换首尾
            temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 翻转指定位置上的元素,Hutool实现
     *
     * @param array
     * @param startIndexInclusive
     * @param endIndexExclusive
     * @return
     */
    public static int[] reverse(int[] array, int startIndexInclusive, int endIndexExclusive) {
        if (!isEmpty(array)) {
            int i = Math.max(startIndexInclusive, 0);
            for (int j = Math.min(array.length, endIndexExclusive) - 1; j > i; ++i) {
                int tmp = array[j];
                array[j] = array[i];
                array[i] = tmp;
                --j;
            }
        }
        System.out.println(Arrays.toString(array));
        return array;
    }

    /**
     * 有任意多张面额为 2 元、3 元、7 元的货币，现要用它们凑出 100 元，求总共有多少种可能性
     * 类似的鸡兔同笼问题
     *
     * @return
     */
    public static void union() {
        // 可能性种类
        int count = 0;
        for (int i = 0; i < 100 / 7; i++) {
            for (int j = 0; j < 100 / 3; j++) {
                if ((100 - i * 7 - j * 3 >= 0) && ((100 - i * 7 - j * 3) % 2 == 0)) {
                    count += 1;
                }
            }
        }
        System.out.println(count);
    }

    public static boolean isEmpty(int[] array) {
        return array == null || array.length == 0;
    }
}

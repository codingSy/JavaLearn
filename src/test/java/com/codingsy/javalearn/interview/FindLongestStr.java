/*
 *
 * Created by 1129798381@qq.com on 2020/4/20.
 */

package com.codingsy.javalearn.interview;

/**
 * 找出字符串中没有重复字符的最长子串.
 *
 * @author 112798381@qq.com
 */
public class FindLongestStr {

    public static void main(String[] args) {
        String s = find("abdabd12344567890qwertyty");
        System.out.println("find longest str: " + s);
    }

    public static String find(String text) {
        char[] chars = text.toCharArray();
        String s = "";
        String result = "";
        for (int i = 0; i < chars.length; i++) {
            char m = chars[i];
            if (result.indexOf(m) > -1) {
                s = s.length() > result.length() ? s : result;
                result = result.substring(result.indexOf(m));
            }
            result = result + m;
        }
        return s.length() > result.length() ? s : result;
    }

}

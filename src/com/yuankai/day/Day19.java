package com.yuankai.day;

/**
 * @author yuankai
 * @since 2020-05-10
 */
public class Day19 {

    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length -1;
        while (i < j) {
            int temp = s[i] ^ s[j];
            s[i] = (char) (s[i] ^ temp);
            s[j] = (char) (s[j] ^ temp);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        new Day19().reverseString(chars);
        System.out.println(chars);
    }
}

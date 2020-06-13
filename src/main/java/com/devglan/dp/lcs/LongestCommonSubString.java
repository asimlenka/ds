package com.devglan.dp.lcs;

public class LongestCommonSubString {

    public static int lcs(String s1, String s2, int l1, int l2, int count){
        if (l1 == 0 || l2 == 0){
            return count;
        }
        if (s1.charAt(l1 -1) == s2.charAt(l2 - 1)){
            count = lcs(s1, s2, l1 -1, l2 -1, count + 1);
        }else {
            count = Math.max(count, Math.max(lcs(s1, s2, l1, l2 - 1, 0), lcs(s1, s2, l1 - 1, l2, 0)));
        }
        return count;
    }

    public static void main(String[] args) {
        int n, m;
        String s1 = "abcdexyz";
        String s2 = "xyzabcde";

        n = s1.length();
        m = s2.length();
        System.out.println(LongestCommonSubString.lcs(s1, s2, n, m, 0));
    }
}

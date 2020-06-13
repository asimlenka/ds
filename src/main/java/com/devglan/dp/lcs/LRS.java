package com.devglan.dp.lcs;

//Longest repeating subsequence
public class LRS {

    public static int lrs(String s1, String s2, int l1, int l2){
        if (l1 == 0 || l2 == 0){
            return 0;
        }
        if (s1.charAt(l1 -1) == s2.charAt(l2 -1) && (l1 - 1 != l2 - 1)){
            return 1 + lrs(s1, s2, l1 -1, l2 - 1);
        }else {
            return Math.max(lrs(s1, s2, l1 - 1, l2), lrs(s1, s2, l1, l2 -1));
        }
        //return lcs(s1, s2, l1 -1, l2 -1);
    }
}

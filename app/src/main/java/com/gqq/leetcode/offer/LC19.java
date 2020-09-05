package com.gqq.leetcode.offer;

public class LC19 {
    public boolean isMatch(String s, String p) {
        char[] a = s.toCharArray();
        char[] b = p.toCharArray();
        char[] c = ".".toCharArray();
        char[] d = "*".toCharArray();
        int j = 0;

        for (int i = 0; i < a.length; i++) {
            if(b.length<j) return false;

            if (a[i]==b[j]){
                j++;
            }else {
                if (b[j]==c[0]){
                    j++;
                }else if (b[j]==d[0]){
                    if (j>0){
                        if (a[i]!=b[j-1]){
                            return false;
                        }
                    }else {
                        return false;
                    }
                }else {

                    if (j+2<b.length){
                        if (b[j+1]==d[0]&&b[j+2]==a[i]){
                            j=j+2;
                        }
                    }else {
                        return false;
                    }

                }


            }

        }

        return true;

    }
}

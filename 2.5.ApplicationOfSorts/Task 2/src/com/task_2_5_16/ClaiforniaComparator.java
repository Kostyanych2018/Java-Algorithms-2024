package com.task_2_5_16;

public class ClaiforniaComparator {
    private static String s = "RWQOJMVAHBSGZXNTCIEKUPDYFL";

    public int compare(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        for (int i = 0; i < Math.min(len1, len2); i++) {
            int pos1 = s.indexOf(s1.charAt(i));
            int pos2 = s.indexOf(s2.charAt(i));
            if (pos1 != pos2) {
                return pos1 - pos2;
            }
        }

        if (len1 < len2) {
            return -1;
        } else if (len1 > len2) {
            return 1;
        }
        
        return 0;
    }
}

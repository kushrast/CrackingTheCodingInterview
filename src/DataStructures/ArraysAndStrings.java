package DataStructures;

import java.util.HashSet;
import java.util.Hashtable;

public class ArraysAndStrings {
    public static boolean uniqueStringSets(String str) {
        HashSet<Character> set = new HashSet<>();
        for (Character e : str.toCharArray()) {
            if (set.contains(Character.toLowerCase(e))) {
                return false;
            } else {
                set.add(e);
            }
        }

        return true;
    }

    public static boolean uniqueStringArray(String str) {
        boolean[] set = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            Character e = str.charAt(i);
            if (set[e]) {
                return false;
            } else {
                set[e] = true;
            }
        }
        return true;
    }

    public static boolean uniqueStringBits(String str) {
        int set = 0;
        for (int i = 0; i < str.length(); ++i) {
            int e = str.charAt(i) - 'a';
            if ((set & (1 << e)) > 0) {
                return false;
            } else {
                set = set | (1 << e);
            }
        }
        return true;
    }

    public static char[] URLify(char[] str, int len) {
        int free = str.length - 1;
        //Advance to the first non-space character in the back.
        int back_c = len-1;
        //Move word to the free-space until you hit a space
        while (back_c > -1) {
            if (str[back_c] != ' ') {
                str[free] = str[back_c];
                free--;
            } else {
                str[free] = '0';
                str[free-1] = '2';
                str[free-2] = '%';
                free -= 3;
            }
            back_c--;
        }
        return str;
    }

    public static boolean palindromePermutation(String str) {
        Hashtable<Character, Integer> items = new Hashtable<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != ' ') {
                if (items.containsKey(c)) {
                    items.put(c, items.get(c) + 1);
                } else {
                    items.put(c, 1);
                }
            }
        }
        int oneItem = 0;
        for (Character key: items.keySet()) {
            int item = items.get(key);
            if (item % 2 != 0) {
                if (item == 1 && oneItem == 0) {
                    oneItem += 1;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static String reverseCStringStringBuilder(String str) {
        StringBuilder sb = new StringBuilder();

        for(int i = str.length() - 2; i > -1; i--) {
            sb.append(str.charAt(i));
        }
        sb.append(str.charAt(str.length()-1));
        return sb.toString();
    }

    public static boolean oneAway(String first, String second) {
        return oneAwayHelper(first, second, 0, 0, 0);
    }

    private static boolean oneAwayHelper(String a, String b, int i, int j, int edit) {
        if (edit > 1) {
            return false;
        }
        if (i >= a.length() && j >= b.length()) {
            return true;
        } else if (i >= a.length()) {
            return oneAwayHelper(a, b, i, j+1, edit+1);
        } else if (j > a.length()) {
            return oneAwayHelper(a, b, i+1, j, edit+1);
        }

        if (a.charAt(i) != b.charAt(j)) {
            //replace
            //insert
            //delete
        }
    }

    public static void testUniqueString() {
//        System.out.println(uniqueStringSets("Moreland") == true);
//        System.out.println(uniqueStringSets("Berkeley") == false);
//        System.out.println(uniqueStringArray("Moreland") == true);
//        System.out.println(uniqueStringArray("Berkeley") == false);
//        System.out.println(uniqueStringBits("Moreland") == true);
//        System.out.println(uniqueStringBits("Berkeley") == false);
//        System.out.println("--");
//        System.out.println(reverseCStringStringBuilder("Berkeley$"));
//        System.out.println(URLify("MR JOHN SMITH    ".toCharArray(), 13));
        System.out.println(palindromePermutation("daa"));
    }

    public static void main(String[] args) {
        testUniqueString();
    }
}

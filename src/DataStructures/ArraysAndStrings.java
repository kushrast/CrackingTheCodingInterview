package DataStructures;

import java.util.HashSet;

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

    public static void testUniqueString() {
        System.out.println(uniqueStringSets("Moreland") == true);
        System.out.println(uniqueStringSets("Berkeley") == false);
        System.out.println(uniqueStringArray("Moreland") == true);
        System.out.println(uniqueStringArray("Berkeley") == false);
        System.out.println(uniqueStringBits("Moreland") == true);
        System.out.println(uniqueStringBits("Berkeley") == false);
    }

    public static void main(String[] args) {
        testUniqueString();
    }
}

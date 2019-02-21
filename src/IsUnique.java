import java.util.HashSet;
import java.util.Set;

public class IsUnique {

    //check if a string has all unique characters
    //brute force
    //O(n2)
    public static boolean isUnique1(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    // hashmap
    // O(n), space: O(n), but the space is at most 128, if the charset is ascii

    public static boolean isUnique2(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                return false;
            } else {
                set.add(s.charAt(i));
            }
        }
        return true;
    }

    // use an array instead of hashset
    // O(n), space: O(n), but the space is at most 128, if the charset is ascii

    public static boolean isUnique3(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        // assume the charset is ASCII
        // int[] set = new int[128];
        // using boolean array can save much more space

        boolean[] set = new boolean[128];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set[c]) {
                return false;
            } else {
                set[c] = true;
            }
        }
        return true;
    }

    // use bit vector to save space
    // assume all the letters are lowercase
    // we can use one int to represent all 26 letters

    public static boolean isUnique4(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int bitMap = 0;


        for (int i = 1; i <= s.length(); i++) {
            char c = s.charAt(i);

        }
        return true;
    }

    public static void main(String[] args) {
        String s = "1234567890-`';:.,%$#@!^*(){}[]|ASDFGHJKLOIUYa";
        System.out.println(IsUnique.isUnique3(s));
    }
}

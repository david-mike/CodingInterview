import java.util.HashMap;
import java.util.Map;

public class StringsAndArrays {


    boolean checkPermutation(String s1, String s2) {
        // given two string, check if one is a permutation of the other


        if (s1 == null && s2 == null) {
            return true;
        }
        if (s1 == null || s2 == null) {
            return false;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s2.length(); i++) {
            if (!map.containsKey(s2.charAt(i))) {
                return false;
            } else {
                int count = map.get(s2.charAt(i));
                count--;
                map.put(s2.charAt(i), count);
                if (count < 0) {
                    return false;
                }
            }
        }

        return true;
    }


    // 1.3 URLify
    // Java Strings have a length(). In C, strings are zero-terminated, but not in Java.
    // But we need a symbol to make the end of the url
    void relaceSpace(char[] str, int trueLength) {
        int spaceCount = 0, index, i = 0;
        for (i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        index = trueLength + spaceCount * 2;
        if (index < str.length) str[index] = '\0';
        for (i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index -= 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }


    public static void main(String[] args) {
        StringsAndArrays sa = new StringsAndArrays();

        //System.out.println(sa.checkPermutation("hh", "HH"));
        char[] url = {'J', 'o', 'h', 'n', 'S', 'm', 'i', 't', 'h', ' ',' ', ' ', ' ',' ', ' ', ' '};
        sa.relaceSpace(url, 10);
        for (char c : url) {
            if (c != '\0') {
                System.out.print(c);
            } else {
                break;
            }
        }
    }
}

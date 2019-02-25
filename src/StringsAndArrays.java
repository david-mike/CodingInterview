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

    // 1.4
    boolean isPermuationOfPalindrome(String str) {
        int[] map = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
                map[c - 'a']++;
            }

        }
        int even = 0, odd = 0;

        for (int i : map) {
            if (i % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        return odd <= 1;
    }

    // assume all the letters are lowercase
    String generatePalindrome(String str) {
        int[] map = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
                map[c - 'a']++;
            }

        }
        int even = 0, odd = 0;

        for (int i : map) {
            if (i % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        if (odd > 1) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        int oddIdx = 0;
        for (int i = 0; i < map.length; i++) {
            int k = map[i];
            if (k % 2 == 0) {
                for (int j = 1; j <= k / 2; j++) {
                    char c =  (char)('a' + i);
                    sb.append(c);
                }
            } else {
                oddIdx = i;
            }
        }

        String lastPart = sb.reverse().toString();
        sb.reverse();
        for (int i = 0; i < map[oddIdx]; i++) {
            sb.append((char)('a' + i));
        }
        sb.append(lastPart);
        return sb.toString();
    }

    //follow-up generate all the palindromes?
    

    public static void main(String[] args) {
        StringsAndArrays sa = new StringsAndArrays();

        //System.out.println(sa.checkPermutation("hh", "HH"));
//        char[] url = {'J', 'o', 'h', 'n', 'S', 'm', 'i', 't', 'h', ' ',' ', ' ', ' ',' ', ' ', ' '};
//        sa.relaceSpace(url, 10);
//        for (char c : url) {
//            if (c != '\0') {
//                System.out.print(c);
//            } else {
//                break;
//            }
//        }
//        String s = "aha   rghaa";
//        System.out.println(s + " is a permutaion of palindrome: " + sa.isPermuationOfPalindrome(s));


        System.out.println(sa.generatePalindrome("hehea"));
    }
}

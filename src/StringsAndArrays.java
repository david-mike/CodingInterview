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

    public static void main(String[] args) {
        StringsAndArrays sa = new StringsAndArrays();

        System.out.println(sa.checkPermutation("hh", "HH"));
    }
}

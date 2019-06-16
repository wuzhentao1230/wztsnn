package leetcode.three;

import java.util.ArrayList;

public class Main {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int result = 0;

        for (int i = 0; i < chars.length; i++) {
            ArrayList<Character> characters = new ArrayList<>();
            characters.add(chars[i]);
            for (int j = i + 1; j < chars.length; j++) {
                if (!characters.contains(chars[j])) {
                    characters.add(chars[j]);
                }else {
                    break;
                }
            }
            if (characters.size() > result){
                result = characters.size();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Main().lengthOfLongestSubstring("abcabcbb"));
    }
}

import java.util.ArrayList;
import java.util.List;

public class LengthOfLogestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for (int j = 0; j < s.length(); j++) {
            int length = 0;
            List previousChars = new ArrayList<>();
            for (int i = j; i < s.length(); i++) {
                char currentChar = s.charAt(i);
                if (!previousChars.contains(String.valueOf(currentChar))) {
                    previousChars.add(String.valueOf(currentChar));
                    length++;
                } else {
                    if (length > maxLength) {
                        maxLength = length;
                    }
                    break;
                }
            }
        }
        return maxLength;
    }
}

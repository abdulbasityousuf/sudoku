import junit.framework.TestCase;
import org.junit.Test;

public class LengthOfLogestSubstringTest extends TestCase {

    @Test
    public void test() {
        String s = "abcabcbb";
        LengthOfLogestSubstring lengthOfLogestSubstring = new LengthOfLogestSubstring();
        int i = lengthOfLogestSubstring.lengthOfLongestSubstring(s);
        assertEquals(3, i);

        s = "bbbb";
        i = lengthOfLogestSubstring.lengthOfLongestSubstring(s);
        assertEquals(1, i);

        s = "pwwkew";
        i = lengthOfLogestSubstring.lengthOfLongestSubstring(s);
        assertEquals(3, i);
    }

}
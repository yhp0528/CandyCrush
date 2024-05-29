package cn.yhp.candy;

import org.junit.Assert;
import org.junit.Test;

/**
 * For a given string that only contains alphabet characters a-z, if 3 or more consecutive
 * characters are identical, remove them from the string. Repeat this process until
 * there is no more than 3 identical characters sitting besides each other.
 * Example:
 * Input: aabcccbbad
 * Output:
 * -> aabbbad
 * -> aaad
 * -> d
 * #Stage 2 - advanced requirement
 * Instead of removing the consecutively identical characters, replace them with a
 * single character that comes before it alphabetically.
 * Example:
 * ccc -> b
 * bbb -> a
 * Input: abcccbad
 * Output:
 * -> abbbad, ccc is replaced by b
 * -> aaad, bbb is replaced by a
 * -> d
 * @author yhp
 * @date 2024/5/28
 */
public class CandyCrushTest {

    @Test
    public void test_candyCrush() {
//        String input="aabcccbbad";
//        String input="bbaaccchkdddd";
        CandyCrush stage1=new CandyCrushStageOne();
        CandyCrush stage2=new CandyCrushStageTwo();
//        System.out.println("stage1(只删除不填充前面的字符串)===>result:"+stage1.candyCrush(input));
//        System.out.println("stage2(删除且填充前面的字符串)===>result:"+stage2.candyCrush(input));

        String input="aabcccbbad";
        String expected="d";
        Assert.assertEquals(expected,stage1.candyCrush(input));
        Assert.assertEquals(expected,stage2.candyCrush(input));

        input=repeat("aaaccccbbb",50000);
        expected="";
        Assert.assertEquals(expected,stage1.candyCrush(input));
        Assert.assertEquals(expected,stage2.candyCrush(input));

        input=repeat("abcdefghijklmnopqrstuvwxyz",10000);
        expected=repeat("abcdefghijklmnopqrstuvwxyz",10000);
        Assert.assertEquals(expected,stage1.candyCrush(input));
        Assert.assertEquals(expected,stage2.candyCrush(input));

        input=repeat("a",100000)+"b";
        expected="b";
        Assert.assertEquals(expected,stage1.candyCrush(input));
        Assert.assertEquals(expected,stage2.candyCrush(input));

        input=repeat("aaadccce",10000);
        expected=repeat("ddee",9999)+"dde";
        Assert.assertEquals(repeat("de",10000),stage1.candyCrush(input));
        Assert.assertEquals(expected,stage2.candyCrush(input));


    }

    private String repeat(String str, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}

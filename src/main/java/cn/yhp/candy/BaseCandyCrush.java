package cn.yhp.candy;

import java.util.stream.IntStream;

/**
 * @author yhp
 * @date 2024/5/28
 */
public abstract class BaseCandyCrush implements CandyCrush{


    @Override
    public String candyCrush(String input) {
        if (input == null || input.length() < 3) {
            return input;
        }

        StringBuilder sb = new StringBuilder(input);
        // 第一个字符连续出现的开始和结束索引
        int[] indices = findFirstConsecutiveChars(sb);

        if (indices[0] != -1) {
            // 删除连续字符
            sb.delete(indices[0], indices[1]);
            // 如果开始索引大于0，说明前面还有字符，直接在后面插入同一个字符【第2个要求】
            differentStageProcess(sb,indices[0]);
            // 递归
            return candyCrush(sb.toString());
        }

        return sb.toString();
    }

    private  int[] findFirstConsecutiveChars(StringBuilder sb) {
        int[] result = {-1, -1};
        // 找出第一个连续出现次数大于等于3的字符
        IntStream.range(0, sb.length() - 2)
                // 过滤第一个出现次数等于3的连续字符
                .filter(i -> sb.charAt(i) == sb.charAt(i + 1) && sb.charAt(i) == sb.charAt(i + 2))
                .findFirst()
                .ifPresent(i -> {
                    // 双指针法，找到第一个字符连续出现的开始和结束索引
                    int j = i + 2;
                    while (j < sb.length() && sb.charAt(i) == sb.charAt(j)) {
                        j++;
                    }
                    result[0] = i;
                    result[1] = j;
                });

        return result;
    }

    /**
     * 不同阶段的处理
     * @param sb 需处理的字符串
     * @param idx 处理的位置
     */
    abstract void differentStageProcess(StringBuilder sb, int idx);
}

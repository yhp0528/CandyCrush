package cn.yhp.candy;

/**
 * 删除连续出现次数大于等于3的字符串,然后填充一个前面的一个字符串（如果有）
 * @author yhp
 * @date 2024/5/28
 */
public class CandyCrushStageTwo extends BaseCandyCrush{

    @Override
    void differentStageProcess(StringBuilder sb, int idx) {
        if (idx > 0) {
            sb.insert(idx, sb.charAt(idx - 1));
        }
    }
}
